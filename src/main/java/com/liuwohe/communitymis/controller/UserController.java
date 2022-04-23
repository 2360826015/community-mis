package com.liuwohe.communitymis.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.User;
import com.liuwohe.communitymis.service.UserService;
import com.liuwohe.communitymis.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*获取用户列表*/
    @GetMapping("/getUserList")
    public Result getUserList(){
        List<Map<String,Object>> userList=userService.getList();
        return Result.success(userList);
    }


    /*添加或更新用户*/
    @PostMapping("/addUser")
    public Result addUser(@RequestBody User user){
        if(StringUtils.isEmpty(user.getUserId())){
            user.setUserId(user.getUserId()+user.getUserRoleId());
        }
        MD5Util md5Util = new MD5Util();
        /*加密密码*/
        user.setPassword(md5Util.EncoderByMd5(user.getPassword()));
        boolean b=userService.saveOrUpdate(user);
        if(!b){
            return Result.failed("保存失败");
        }
        return Result.success("保存成功");
    }

    /*删除用户*/
    @GetMapping("/deleteUser")
    public Result deleteUser(@RequestParam String id){
        boolean b=userService.removeById(id);
        if(!b){
            return Result.failed("删除失败");
        }
        return Result.success("删除成功");
    }

}
