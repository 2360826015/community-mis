package com.liuwohe.communitymis.controller;

import com.liuwohe.communitymis.data.Result;
import com.liuwohe.communitymis.entity.User;
import com.liuwohe.communitymis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public Result Home(){
         List<User> userList=userService.getList();
        return Result.success();
    }
}
