package com.app.service;

import com.app.dao.MoneyDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MoneyDetailService extends IService<MoneyDetail> {
    List<String> selectList();
}
