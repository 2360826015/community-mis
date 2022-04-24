package com.liuwohe.communitymis.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.CarInfo;
import com.liuwohe.communitymis.entity.Information;
import com.liuwohe.communitymis.service.CarInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/*住户车辆信息控制层*/
@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarInfoService carInfoService;

    /**
     * @desc 获取车辆信息列表
     * @return 查询出的车辆信息列表
     * */
    @GetMapping("/list")
    public Result getCarInfo(@RequestParam("userId") String userId, @RequestParam("userRoleId")String userRoleId, @RequestParam("pageNum") Integer num, @RequestParam("pageSize") Integer size){
        QueryWrapper<CarInfo> qw = new QueryWrapper<>();
        //默认分页判断
        int pageNum = num  == null ? 1 : num;
        int pageSize = size  == null ? 10 : size;
        PageHelper.startPage(pageNum, pageSize);
        /*判断用户角色*/
        /*管理员用户能获取所有车辆信息*/
        if("2".equals(userRoleId)){
            /*普通用户则只查询本用户下的车辆信息*/
            qw.eq("user_id",userId);
        }
        List<CarInfo> list = carInfoService.list(qw);
        PageInfo<CarInfo> pageInfo = new PageInfo<>(list);
        return Result.success(pageInfo);
    }

    /**
     * @desc 新增车辆信息
     * @param carInfo 车辆信息
     * @return 操作提示
     * */
    @PostMapping("/add")
    public Result addInformation(@RequestBody CarInfo carInfo){
        System.out.println(carInfo);
        try{
            boolean b = carInfoService.save(carInfo);
            if(!b){
                return Result.failed("车辆信息添加失败！");
            }
            return Result.success("车辆信息添加成功！");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Result.failed("添加失败！"+e.getMessage());
        }

    }

    /**
     * @desc 修改车辆信息
     * @param carInfo 车辆信息
     * @return 操作提示
     * */
    @PostMapping("/modify")
    public Result modifyInformation(@RequestBody CarInfo carInfo){
        boolean b = carInfoService.updateById(carInfo);
        if(!b){
            return Result.failed("车辆信息更新失败！");
        }
        return Result.success("更新车辆信息成功！");
    }

    /**
     * @desc 删除车辆信息
     * @param carInfoId 车辆信息编号
     * @return 操作提示
     * */
    @GetMapping("/delete")
    public Result modifyInformation(@RequestParam("carInfoId") String carInfoId){
        boolean b = carInfoService.removeById(carInfoId);
        if(!b){
            return Result.failed("车辆信息删除失败！");
        }
        return Result.success("删除车辆信息成功！");
    }

    /**
     * @desc 批量删除车辆信息
     * @param carInfoIdList 车辆信息编号
     * @return 操作提示
     * */
    @GetMapping("/deleteList")
    public Result modifyInformation(@RequestParam("carInfoIdList") List<String> carInfoIdList){
        boolean b = carInfoService.removeByIds(carInfoIdList);
        if(!b){
            return Result.failed("批量删除失败！");
        }
        return Result.success("批量删除成功！");
    }

    /**
     * @desc 条件查询车辆信息
     * @param params 查询条件
     * @return 查询结果
     * */
    @PostMapping("/select")
    public Result selectInformation(@RequestBody Map<String,Object> params){
        List<CarInfo> iList=carInfoService.queryByParams(params);
        return Result.success(iList);
    }
}
