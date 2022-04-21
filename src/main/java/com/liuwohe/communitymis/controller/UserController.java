package com.liuwohe.communitymis.controller;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.User;
import com.liuwohe.communitymis.service.UserService;
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
        boolean b=userService.saveOrUpdate(user);
        if(!b){
            return Result.failed("添加失败");
        }
        return Result.success("添加成功");
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
