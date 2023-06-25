package com.app.dao;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("money")
public class Money {
    Integer id;
    int userId;
    int balance;
}
