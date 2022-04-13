package com.liuwohe.communitymis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName resident_role
 */
@TableName(value ="resident_role")
@Data
public class Role implements Serializable {
    /**
     * 角色编号
     */
    @TableId
    private String roleId;

    /**
     * 角色名
     */
    private String name;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}