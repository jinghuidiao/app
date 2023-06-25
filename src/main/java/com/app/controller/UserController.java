package com.app.controller;

import com.app.common.CommonException;
import com.app.common.R;
import com.app.dao.Money;
import com.app.dao.MoneyDetail;
import com.app.dao.Shopping;
import com.app.dao.User;
import com.app.service.MoneyDetailService;
import com.app.service.MoneyService;
import com.app.service.ShoppingService;
import com.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
   private MoneyService moneyService;
    @Autowired
    private ShoppingService shoppingService;
    @Autowired
    private MoneyDetailService moneyDetailService;

    @GetMapping("/get/{id}")
    public R get(@PathVariable Integer id){
        User user = userService.getById(id);
        int balance = moneyService.getBanlance(user.getId());
        return R.ok(user.getName()+"余额为:"+balance);
    }

    @Transactional
    @GetMapping("/consume/{userId}/{shoppingId}")
    public R consume(@PathVariable Integer userId, @PathVariable Integer shoppingId){
        Shopping shopping =  shoppingService.addBanlance(shoppingId);
        User user = userService.getById(userId);
        Money money = moneyService.getMoney(user.getId());
        if (money.getBalance() < shopping.getBalance()){
            throw new CommonException(user.getName()+"账户余额不足");
        }else {
            if (shopping.getCount() > 0) {
                //修改商品金额
                Money money1 = new Money();
                money1.setBalance(money.getBalance() - shopping.getBalance());
                money1.setUserId(userId);
                money1.setId(money.getId());
                moneyService.updateById(money1);
                //修改商品库存
                int i = shopping.getCount() - 1;
                shopping.setCount(i);
                shoppingService.updateById(shopping);
                //添加金额明细
                MoneyDetail moneyDetail = new MoneyDetail();
                moneyDetail.setMoneyId(money1.getId());
                moneyDetail.setDetail(user.getName()+"消费"+shopping.getBalance()+"元");
                moneyDetailService.save(moneyDetail);
                return R.ok(user.getName()+"消费"+shopping.getBalance()+"元");
            }else {
                throw new CommonException("该商品库存不足");
            }
        }
    }


    @GetMapping("/refund/{userId}/{shoppingId}")
    public R refund(@PathVariable Integer userId,@PathVariable Integer shoppingId){
        //修改商品的库存
        Shopping shopping = shoppingService.getById(shoppingId);
        int i = shopping.getCount() + 1;
        shopping.setCount(i);
        shoppingService.updateById(shopping);
        //修改账户的余额
        User user = userService.getById(userId);
        Money money = moneyService.getMoney(user.getId());
        money.setBalance(shopping.getBalance()+money.getBalance());
        moneyService.updateById(money);
        //添加描述信息
        MoneyDetail moneyDetail = new MoneyDetail();
        moneyDetail.setMoneyId(money.getId());
        moneyDetail.setDetail(user.getName()+"退款成功，余额增加"+shopping.getBalance());
        moneyDetailService.save(moneyDetail);
        return R.ok(user.getName()+"退款成功");
    }



}
