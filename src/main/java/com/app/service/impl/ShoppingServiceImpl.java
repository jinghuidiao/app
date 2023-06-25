package com.app.service.impl;

import com.app.dao.Shopping;
import com.app.mapper.ShoppingMapper;
import com.app.service.ShoppingService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingServiceImpl extends ServiceImpl<ShoppingMapper, Shopping> implements ShoppingService {

    @Autowired
    private ShoppingMapper shoppingMapper;

    @Override
    public Shopping addBanlance(Integer shoppingId){
        LambdaQueryWrapper<Shopping> lqw = new LambdaQueryWrapper<>();
        lqw.eq(Shopping::getId,shoppingId);
        return shoppingMapper.selectOne(lqw);
    }
}
