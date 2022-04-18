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
 * @TableName resident_notice
 */
@TableName(value ="resident_notice")
@Data
public class Notice implements Serializable {
    /**
     * 通知编号
     */
    @TableId(type = IdType.AUTO)
    private String noticeId;

    /**
     * 主题
     */
    private String theme;

    /**
     * 发布时间
     */
    private String sendDate;

    /**
     * 正文
     */
    private String text;

    /**
     * 状态
     * */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}