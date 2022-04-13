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
 * @TableName resident_information
 */
@TableName(value ="resident_information")
@Data
public class Information implements Serializable {
    /**
     * 住户编号(由单元编号+门牌号组成)
     */
    @TableId
    private String houseId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 房主
     */
    private String homeowner;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idcard;

    /**
     * 常住人口数
     */
    private Integer liveNum;

    /**
     * 民族
     */
    private String nation;

    /**
     * 单元编号
     */
    private String unitId;

    /**
     * 门牌号
     */
    private String houseNum;

    /**
     * 登记日期
     */
    private String saveDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}