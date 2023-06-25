package com.app.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("shopping")
public class Shopping {
    Integer id;
    String name;
    int balance;
    int count;
}
