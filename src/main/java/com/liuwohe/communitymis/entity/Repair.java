package com.liuwohe.communitymis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName resident_repair
 */
@TableName(value ="resident_repair")
@Data
public class Repair implements Serializable {
    /**
     * 报修编号
     */
    @TableId
    private String repairId;

    /**
     * 住户编号
     */
    private String userId;

    /**
     * 报修时间
     */
    private Date repairDate;

    /**
     * 内容
     */
    private String text;

    /**
     * 联系电话
     */
    private Integer phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}