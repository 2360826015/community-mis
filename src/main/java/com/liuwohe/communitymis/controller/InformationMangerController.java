package com.liuwohe.communitymis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Information;
import com.liuwohe.communitymis.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;


/*住户信息管理控制层*/
@RestController
@RequestMapping("/information")
public class InformationMangerController {

    @Autowired
    private InformationService informationService;


    /**
     * @desc 获取业主信息列表
     * @return 查询出的业主信息列表
     * */
    @GetMapping("/list")
    public Result getInformationList(@RequestParam("userId") String userId,@RequestParam("userRoleId")String userRoleId,@RequestParam("pageNum") Integer num,@RequestParam("pageSize") Integer size){
        QueryWrapper<Information> qw = new QueryWrapper<>();
        //默认分页判断
        int pageNum = num  == null ? 1 : num;
        int pageSize = size  == null ? 10 : size;
        PageHelper.startPage(pageNum, pageSize);
        /*判断用户角色*/
        /*管理员用户能获取所有住户信息*/
        if("2".equals(userRoleId)){
            /*普通用户则只查询本用户下的住户信息*/
            qw.eq("user_id",userId);
        }
        List<Information> list = informationService.list(qw);
        PageInfo<Information> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
    }

    /**
     * @desc 新增业主信息
     * @param information 住户信息
     * @return 操作提示
     * */
    @PostMapping("/add")
    public Result addInformation(@RequestBody Information information){
        System.out.println(information);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        /*设置系统录入时间*/
        information.setSaveDate(dateFormat.format(new Date()));
        try{
        boolean b = informationService.save(information);
        if(!b){
            return Result.failed("住户信息添加失败！");
        }
            return Result.success("添加住户信息成功！");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Result.failed("添加失败！"+e.getMessage());
        }

    }

    /**
     * @desc 修改业主信息
     * @param information 住户信息
     * @return 操作提示
     * */
    @PostMapping("/modify")
    public Result modifyInformation(@RequestBody Information information){
        boolean b = informationService.updateById(information);
        if(!b){
            return Result.failed("住户信息更新失败！");
        }
        return Result.success("更新住户信息成功！");
    }

    /**
     * @desc 删除业主信息
     * @param houseId 住户信息编号
     * @return 操作提示
     * */
    @GetMapping("/delete")
    public Result modifyInformation(@RequestParam("houseId") String houseId){
        boolean b = informationService.removeById(houseId);
        if(!b){
            return Result.failed("住户信息删除失败！");
        }
        return Result.success("删除住户信息成功！");
    }

    /**
     * @desc 批量删除业主信息
     * @param houseIdList 住户信息编号
     * @return 操作提示
     * */
    @GetMapping("/deleteList")
    public Result modifyInformation(@RequestParam("houseIdList") List<String> houseIdList){
        boolean b = informationService.removeByIds(houseIdList);
        if(!b){
            return Result.failed("批量删除失败！");
        }
        return Result.success("批量删除成功！");
    }

    /**
     * @desc 条件查询住户信息
     * @param params 查询条件
     * @return 查询结果
     * */
    @PostMapping("/select")
    public Result selectInformation(@RequestBody Map<String,Object> params){
        List<Information> iList=informationService.queryByParams(params);
        return Result.success(iList);
    }
}
