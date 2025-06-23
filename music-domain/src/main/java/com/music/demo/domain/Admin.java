package com.music.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class Admin {

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_username")
    private String username;

    @TableField("user_password")
    private String password;

    @TableField("user_name")
    private String name;


    @TableField("user_phone")
    private String phone;

    @TableField("user_avatar")
    private String avatar;

    @TableField("user_updateby")
    private String updateby;

    @TableField("user_update_time")
    private Date updateTime;

    @TableField("user_email")
    private String email;

    @TableField("user_role")
    private String role;
}
