package com.liuwohe.communitymis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Notice;
import com.liuwohe.communitymis.service.NoticeService;
import com.liuwohe.communitymis.service.UtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/dashboard")
public class DashBoardController {

    private static final Logger logger = LoggerFactory.getLogger(DashBoardController.class);

    @Autowired
    private UtilService utilService;
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/getInfo")
    public Result getInfo(){
        return Result.success(utilService.getInfo());
    }

    @GetMapping("/getMsgCount")
    public Result getMsgCount(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        QueryWrapper<Notice> qw = new QueryWrapper<>();
        qw.gt("over_time",format.format(new Date()));
        return Result.success(noticeService.count(qw));
    }

}
