package com.liuwohe.communitymis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName resident_user
 */
@TableName(value ="resident_user")
@Data
public class User implements Serializable {
    /**
     * 用户编号（用户编号由用户名+角色编号组成）
     */
    @TableId
    private String userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 角色编号
     */
    private String userRoleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}