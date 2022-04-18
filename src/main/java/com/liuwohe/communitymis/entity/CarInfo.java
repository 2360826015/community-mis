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
    @TableId
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

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CarInfo other = (CarInfo) that;
        return (this.getCarInfoId() == null ? other.getCarInfoId() == null : this.getCarInfoId().equals(other.getCarInfoId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getCarowner() == null ? other.getCarowner() == null : this.getCarowner().equals(other.getCarowner()))
            && (this.getNumPlate() == null ? other.getNumPlate() == null : this.getNumPlate().equals(other.getNumPlate()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getColor() == null ? other.getColor() == null : this.getColor().equals(other.getColor()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarInfoId() == null) ? 0 : getCarInfoId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getCarowner() == null) ? 0 : getCarowner().hashCode());
        result = prime * result + ((getNumPlate() == null) ? 0 : getNumPlate().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getColor() == null) ? 0 : getColor().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", carInfoId=").append(carInfoId);
        sb.append(", userId=").append(userId);
        sb.append(", carowner=").append(carowner);
        sb.append(", numPlate=").append(numPlate);
        sb.append(", type=").append(type);
        sb.append(", color=").append(color);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}