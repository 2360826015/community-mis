package com.liuwohe.communitymis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName resident_role_type
 */
@TableName(value ="resident_role_type")
@Data
public class RoleType implements Serializable {
    /**
     * 角色类型名称
     */
    @TableId
    private String type;

    /**
     * 描述
     */
    private String descs;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}