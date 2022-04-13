package com.liuwohe.communitymis.controller;

import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Notice;
import com.liuwohe.communitymis.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @PostMapping("/add")
    public Result addNotice(@RequestBody Notice notice){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        notice.setSendDate(format.format(new Date()));
        boolean b = noticeService.save(notice);
        if(!b){
            return Result.failed("通知公告添加失败！");
        }
        return Result.success("通知公告发布成功！");
    }

    @GetMapping("/get")
    public Result getNotice() {
        List<Notice> list = noticeService.list(null);
        return Result.success(list);
    }
}
