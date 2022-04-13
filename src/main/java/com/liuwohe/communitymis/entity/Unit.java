package com.liuwohe.communitymis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName resident_unit
 */
@TableName(value ="resident_unit")
@Data
public class Unit implements Serializable {
    /**
     * 单元号
     */
    @TableId
    private String unitId;

    /**
     * 单元名
     */
    private String unitName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}