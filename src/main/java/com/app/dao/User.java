package com.app.dao;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("user")
public class User {
    Integer id;
    String name;
    int age;
    String phone;
    String email;
    @TableField("create_time")
    Date createTime;
}
