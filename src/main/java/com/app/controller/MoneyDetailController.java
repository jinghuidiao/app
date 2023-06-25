package com.app.controller;

import com.app.common.R;
import com.app.dao.MoneyDetail;
import com.app.service.MoneyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MoneyDetailController {

    @Autowired
    private MoneyDetailService moneyDetailService;

    @GetMapping("/list")
    public R list(){
        List<String> list = moneyDetailService.selectList();
        Map<String,List<String>> map = new HashMap<>();
        map.put("金额描述",list);
        return R.ok(String.valueOf(map));
    }
}
