package com.liuwohe.communitymis.controller;


import com.baomidou.mybatisplus.extension.api.R;
import com.liuwohe.communitymis.Constant.Constant;
import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.User;
import com.liuwohe.communitymis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/login")
public class LoginRegisterController {

    @Autowired
    private UserService userService;
    /**
     * @desc 用户登录接口
     * @param params 账号密码
     * @return 用户对象
     * */
    @PostMapping("/user")
    public Result userLogin(@RequestBody Map<String,Object> params){
        try{
            User user=userService.queryByUsername(params);
            return Result.success(user);
        }catch (Exception e){
            return Result.failed("登录失败,请检查用户名是否正确");
        }
    }

    /**
     * @desc 用户注册接口
     * @param params 账号、密码、角色
     * @return 用户对象
     * */
    @PostMapping("/register")
    public Result userRegister(@RequestBody User params){
        try{
            String msg=userService.insertUser(params);
            return Result.success(msg);
        }catch (Exception e){
            return Result.failed("注册失败,请确认您的输入是否正确！");
        }
    }

    /**
     * @desc  获取用户列表
     * @return 用户列表
     * */
    @GetMapping("/manage")
    public Result getUserList(){
        return Result.success(userService.listMaps(null));
    }

}
