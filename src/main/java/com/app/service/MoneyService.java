package com.app.service;

import com.app.dao.Money;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;


public interface MoneyService extends IService<Money> {
    int getBanlance(int id);

    Money getMoney(Integer id);
}
