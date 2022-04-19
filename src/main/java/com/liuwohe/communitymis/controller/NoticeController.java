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


    /*查询通知公告列表*/
    @GetMapping("/get")
    public Result getNotice() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Notice> list = noticeService.list(null);
        list.forEach(l->{
            int res=l.getOverTime().compareTo(format.format(new Date()));
            if(res<0){
                l.setStatus("已过期");
            }else{
                l.setStatus("未过期");
            }
        });
        return Result.success(list);
    }


    /**
     * @desc 添加通知公告
     * */
    @PostMapping("/add")
    public Result addNotice(@RequestBody Notice notice){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        notice.setSendDate(format.format(new Date()));
        boolean b = noticeService.save(notice);
        if(!b){
            return Result.failed("通知公告添加失败！");
        }
        return Result.success("通知公告发布成功！");
    }

    /**
     * @desc 删除通知公告
     * */
    @GetMapping("/delete")
    public Result deleteNotice(@RequestParam("noticeId") String noticeId) {
        boolean b = noticeService.removeById(noticeId);
        if(!b){
            return Result.failed("通知公告删除失败！");
        }
        return Result.success("通知公告删除成功！");
    }

    /**
     * @desc 批量删除通知公告
     * */
    @PostMapping("/deleteList")
    public Result deleteNoticeList(@RequestBody List<String> noticeIdList) {
        boolean b = noticeService.removeByIds(noticeIdList);
        if(!b){
            return Result.failed("通知公告删除失败！");
        }
        return Result.success("通知公告删除成功！");
    }


}
