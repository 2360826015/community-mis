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
 * @TableName resident_feedback
 */
@TableName(value ="resident_feedback")
@Data
public class Feedback implements Serializable {
    /**
     * 反馈编号
     */
    @TableId(type = IdType.UUID)
    private String feedbackId;

    /**
     * 主题
     */
    private String theme;

    /**
     * 反馈时间
     */
    private String feedbackDate;

    /**
     * 内容
     */
    private String text;

    /**
     * 状态
     * */
    private String status;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}