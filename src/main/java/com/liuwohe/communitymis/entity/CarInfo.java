package com.liuwohe.communitymis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName resident_car_info
 */
@TableName(value ="resident_car_info")
@Data
public class CarInfo implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.UUID)
    private String carInfoId;

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 车主姓名
     */
    private String carowner;

    /**
     * 车牌号
     */
    private String numPlate;

    /**
     * 车辆型号
     */
    private String type;

    /**
     * 车辆颜色
     */
    private String color;

    /**
     * 联系电话
     */
    private String phone;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}