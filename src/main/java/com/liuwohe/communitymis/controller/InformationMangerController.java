package com.liuwohe.communitymis.controller;


import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Information;
import com.liuwohe.communitymis.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public Result getInformationList(){
        List<Map<String, Object>> list = informationService.listMaps(null);
        return Result.success(list);
    }

    /**
     * @desc 新增业主信息
     * @param information 住户信息
     * @return 操作提示
     * */
    @PostMapping("/add")
    public Result addInformation(@RequestBody Information information){
        information.setHouseId(information.getUnitId()+information.getHouseNum());
        boolean b = informationService.save(information);
        if(!b){
            return Result.failed("住户信息添加失败！");
        }
        return Result.success("添加住户信息成功！");
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
