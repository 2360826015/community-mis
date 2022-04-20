package com.liuwohe.communitymis.controller;


import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Feedback;
import com.liuwohe.communitymis.service.FeedbackService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedbackService feedbackService;

    /**
     * @desc 获取反馈意见
     * @return 反馈意见list集合
     * */
    @GetMapping("/get")
    public Result getFeedBack(){
        List<Feedback> list = feedbackService.list(null);
        return Result.success(list);
    }

    /**
     * @desc 添加反馈意见
     * @return 操作提示
     * */
    @PostMapping("/add")
    public Result addFeedback(@RequestBody Feedback feedback){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        feedback.setFeedbackDate(format.format(new Date()));
        feedback.setStatus("未读");
        boolean b = feedbackService.save(feedback);
        if(!b){
            return Result.failed("反馈意见提交失败！");
        }
        return Result.success("反馈意见已发送！");
    }

    /**
     * @desc 更新反馈意见状态
     * @return 操作提示
     * */
    @PostMapping("/status")
    public Result feedbackStatus(@RequestBody Feedback feedback){
        feedback.setStatus("已读");
        boolean b = feedbackService.updateById(feedback);
        if(!b){
            return Result.failed("状态更新失败！");
        }
        return Result.success("状态更新成功！");
    }

    /**
     * @desc 批量删除反馈意见建议
     * */
    @PostMapping("/deleteList")
    public Result deleteNoticeList(@RequestBody List<String> noticeIdList) {
        boolean b = feedbackService.removeByIds(noticeIdList);
        if(!b){
            return Result.failed("删除失败！");
        }
        return Result.success("删除成功！");
    }

}
