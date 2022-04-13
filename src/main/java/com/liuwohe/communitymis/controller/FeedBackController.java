package com.liuwohe.communitymis.controller;


import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Feedback;
import com.liuwohe.communitymis.service.FeedbackService;
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
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        feedback.setFeedbackDate(format.format(new Date()));
        boolean b = feedbackService.save(feedback);
        if(!b){
            return Result.failed("反馈意见提交失败！");
        }
        return Result.success("反馈意见已发送！");
    }

}
