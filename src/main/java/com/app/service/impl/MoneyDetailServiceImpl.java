package com.app.service.impl;

import com.app.dao.MoneyDetail;
import com.app.mapper.MoneyDetailMapper;
import com.app.service.MoneyDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MoneyDetailServiceImpl extends ServiceImpl<MoneyDetailMapper, MoneyDetail> implements MoneyDetailService {
    @Override
    public List<String> selectList() {
        List<MoneyDetail> moneyDetails = this.baseMapper.selectList(null);
        List<String> list = new ArrayList<>();
        for (MoneyDetail moneyDetail : moneyDetails){
            list.add(moneyDetail.getDetail());
        }
        return list;
    }
}
