package com.app.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("money_detail")
public class MoneyDetail {
    Integer id;
    int moneyId;
    String detail;
}
