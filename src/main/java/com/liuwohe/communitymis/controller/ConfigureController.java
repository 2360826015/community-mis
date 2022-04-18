package com.liuwohe.communitymis.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.Role;
import com.liuwohe.communitymis.entity.Unit;
import com.liuwohe.communitymis.service.RoleService;
import com.liuwohe.communitymis.service.UnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/configure")
public class ConfigureController {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UnitService unitService;

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
     * @desc 添加住户角色配置
     * */
    @PostMapping("/addRole")
    public Result addRole(@RequestBody Role role){
      try{
          role.setType("live_role");
          boolean b = roleService.save(role);
          return Result.success("添加角色配置成功！");

        }catch (Exception e){
          return Result.failed("添加错误！");
      }
    }

    /**
     * @desc 添加用户角色配置
     * */
    @PostMapping("/addRoleUser")
    public Result addRoleUser(@RequestBody Role role){
        try{
            role.setType("user");
            boolean b = roleService.save(role);
            return Result.success("添加角色配置成功！");

        }catch (Exception e){
            return Result.failed("添加错误！");
        }
    }

    /**
     * @desc 根据编号删除角色数据
     * */
    @GetMapping("/deleteRole")
    public Result deleteRole(@RequestParam("roleId")String roleId){
        try{
            boolean b = roleService.removeById(roleId);
            return Result.failed("删除失败！");
        }catch (Exception e){
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
            boolean b = unitService.save(unit);
            return Result.success("添加单元配置成功！");

        }catch (Exception e){
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
            return Result.failed("删除失败！");
        }
    }

}
