package com.liuwohe.communitymis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Role;
import com.liuwohe.communitymis.entity.RoleType;
import com.liuwohe.communitymis.entity.Unit;
import com.liuwohe.communitymis.service.RoleService;
import com.liuwohe.communitymis.service.RoleTypeService;
import com.liuwohe.communitymis.service.UnitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/configure")
@Transactional
public class ConfigureController {

    private static final Logger logger = LoggerFactory.getLogger(ConfigureController.class);

    @Autowired
    private RoleService roleService;
    @Autowired
    private UnitService unitService;
    @Autowired
    private RoleTypeService roleTypeService;

    /**获取配置信息列表*/
    @GetMapping("/getList")
    public Result getList(){
        List<Role> list=roleService.list(null);
        return Result.success(list);
    }

    /**
     * @desc 获取住户角色码表
     * */
    @GetMapping("/getRole")
    public Result getRole(){
        QueryWrapper<Role> qw = new QueryWrapper<>();
        qw.eq("type","live_role");
        List<Role> list = roleService.list(qw);
        return Result.success(list);
    }

    /**
     * @desc 获取用户角色码表
     * */
    @GetMapping("/getRoleUser")
    public Result getRoleUser(){
        QueryWrapper<Role> qw = new QueryWrapper<>();
        qw.eq("type","user");
        List<Role> list = roleService.list(qw);
        return Result.success(list);
    }


    /**
     * @desc 添加角色配置
     * */
    @PostMapping("/addConfig")
    public Result addRoleUser(@RequestBody Role role){
        try{
            boolean b = roleService.saveOrUpdate(role);
            if(!b){
                return Result.failed("操作失败!");
            }
            return Result.success("操作成功！");

        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.failed("操作错误！");
        }
    }

    /**
     * @desc 根据编号删除角色数据
     * */
    @GetMapping("/deleteRole")
    public Result deleteRole(@RequestParam("roleId")String roleId){
        try{
            boolean b = roleService.removeById(roleId);
            if(!b){
                return Result.failed("删除失败");
            }
            return Result.success("删除成功");
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.success("角色删除成功！");
        }
    }


    /**
     * @desc 获取单元码表
     * */
    @GetMapping("/getUnit")
    public Result getUnit(){
        List<Unit> list = unitService.list(null);
        return Result.success(list);
    }

    /**
     * @desc 添加单元配置
     * */
    @PostMapping("/addUnit")
    public Result addUnit(@RequestBody Unit unit){
        try{
            boolean b = unitService.saveOrUpdate(unit);
            if(!b){
                return Result.failed("保存失败！");
            }
            return Result.success("保存单元配置成功！");

        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.failed("##添加错误！");
        }
    }

    /**
     * @desc 根据编号删除单元数据
     * */
    @GetMapping("/deleteUnit")
    public Result deleteUnit(@RequestParam("unitId")String unitId){
        try{
            boolean b = unitService.removeById(unitId);
            return Result.success("单元删除成功！");
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return Result.failed("删除失败！");
        }
    }


    /**
     * @desc 获取配置类型码表
     * */
    @GetMapping("/getType")
    public Result getTypeList(){
        List<RoleType> list=roleTypeService.list(null);
        return Result.success(list);
    }

    /**
     * @desc 添加配置类型
     * */
    @PostMapping("/addType")
    public Result addType(@RequestBody RoleType roleType){
        boolean b=roleTypeService.saveOrUpdate(roleType);
        if(!b){
            return Result.failed("保存失败");
        }
        return Result.success("保存成功");
    }

    /**
     * @desc 删除配置类型
     * */
    @GetMapping("/delType")
    public Result delType(@RequestParam("typeId") String typeId){
        boolean b=roleTypeService.removeById(typeId);
        if(!b){
            return Result.failed("操作失败");
        }
        return Result.success("删除成功");
    }

}
