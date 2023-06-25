package com.app.service.impl;

import com.app.dao.Money;
import com.app.mapper.MoneyMapper;
import com.app.service.MoneyService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyServiceImpl extends ServiceImpl<MoneyMapper,Money> implements MoneyService {

    @Autowired
    private MoneyMapper moneyMapper;

    @Override
    public int getBanlance(int id) {
        LambdaQueryWrapper<Money> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Money::getUserId,id);
        return moneyMapper.selectOne(lqw).getBalance();
    }

    @Override
    public Money getMoney(Integer id) {
        LambdaQueryWrapper<Money> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Money::getUserId,id);
        return moneyMapper.selectOne(lqw);
    }
}
