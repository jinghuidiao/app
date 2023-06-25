package com.app.service;


import com.app.dao.Shopping;
import com.baomidou.mybatisplus.extension.service.IService;

public interface ShoppingService extends IService<Shopping> {
    Shopping addBanlance(Integer shoppingId);
}
