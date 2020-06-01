package com.lp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_user")
public class User {
    /**
     * 用户id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 登录名，不可改
     */
    @TableField(value = "user_name")
    private String userName;
    /**
     * 用户昵称，可改
     */
    @TableField(value = "nick_name")
    private String nickName;
    /**
     * 已加密的登录密码
     */
    private String password;
    /**
     * 加密盐值
     */
    private String salt;
    /**
     * 禁用状态
     */
    @TableField(value = "forbidden_status")
    private Boolean forbiddenStatus;
    /**
     * 创建时间
     */
    private Date ct;
    /**
     * 修改时间
     */
    private Date mt;
}
