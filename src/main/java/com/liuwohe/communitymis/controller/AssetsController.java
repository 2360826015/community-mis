package com.liuwohe.communitymis.controller;

import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Assets;
import com.liuwohe.communitymis.service.AssetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/assets")
public class AssetsController {

    @Autowired
    private AssetsService assetsService;

    /**
     * @desc 获取设备列表
     * @return 设备列表
     * */
    @GetMapping("/list")
    public Result getAssetsList(){
        List<Assets> list = assetsService.list(null);
        return Result.success(list);
    }

    /**
     * @desc  添加设备
     * @return 设备列表
     * */
    @PostMapping("/add")
    public Result addAssets(@RequestBody Assets assets){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try{
            assets.setIntTime(format.format(new Date()));
            boolean b = assetsService.save(assets);
            if(!b){
                return Result.failed("设备信息添加失败！");
            }
            return Result.success("设备信息添加成功！");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Result.failed("添加失败！");
        }
    }

    /**
     * @desc 删除设备列表
     * @return 设备列表
     * */
    @GetMapping("/del")
    public Result delAssets(@RequestParam("assetsId") String id){
        try{
            boolean b = assetsService.removeById(id);
            if(!b){
                return Result.failed("删除失败！");
            }
            return Result.success("资产设备删除成功！");
        }catch (Exception e){
            System.out.println(e.getMessage());
            return Result.failed("操作失败！");
        }
    }


}
