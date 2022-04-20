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
 * @TableName resident_assets
 */
@TableName(value ="resident_assets")
@Data
public class Assets implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.UUID)
    private String assetsid;

    /**
     * 资产名称
     */
    private String assetsName;

    /**
     * 品牌
     */
    private String brand;

    /**
     * 价值
     */
    private Double value;

    /**
     * 数量
     */
    private String num;

    /**
     * 入库时间
     */
    private String intTime;

    /**
     * 设备编号
     */
    private String assetsNum;

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
        Assets other = (Assets) that;
        return (this.getAssetsid() == null ? other.getAssetsid() == null : this.getAssetsid().equals(other.getAssetsid()))
            && (this.getAssetsName() == null ? other.getAssetsName() == null : this.getAssetsName().equals(other.getAssetsName()))
            && (this.getBrand() == null ? other.getBrand() == null : this.getBrand().equals(other.getBrand()))
            && (this.getValue() == null ? other.getValue() == null : this.getValue().equals(other.getValue()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getIntTime() == null ? other.getIntTime() == null : this.getIntTime().equals(other.getIntTime()))
            && (this.getAssetsNum() == null ? other.getAssetsNum() == null : this.getAssetsNum().equals(other.getAssetsNum()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAssetsid() == null) ? 0 : getAssetsid().hashCode());
        result = prime * result + ((getAssetsName() == null) ? 0 : getAssetsName().hashCode());
        result = prime * result + ((getBrand() == null) ? 0 : getBrand().hashCode());
        result = prime * result + ((getValue() == null) ? 0 : getValue().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getIntTime() == null) ? 0 : getIntTime().hashCode());
        result = prime * result + ((getAssetsNum() == null) ? 0 : getAssetsNum().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", assetsid=").append(assetsid);
        sb.append(", assetsName=").append(assetsName);
        sb.append(", brand=").append(brand);
        sb.append(", value=").append(value);
        sb.append(", num=").append(num);
        sb.append(", intTime=").append(intTime);
        sb.append(", assetsNum=").append(assetsNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}