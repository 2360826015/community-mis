package com.liuwohe.communitymis.service.impl;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwohe.communitymis.entity.User;
import com.liuwohe.communitymis.service.UserService;
import com.liuwohe.communitymis.mapper.UserMapper;
import com.liuwohe.communitymis.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【resident_user】的数据库操作Service实现
* @createDate 2022-04-09 16:59:45
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Map<String,Object>> getList() {
        return userMapper.selectUserList();
    }

    @Override
    public User queryByUsername(Map<String, Object> params) {
        MD5Util md5Util = new MD5Util();
        String username = (String) params.get("username");
        String password = (String) params.get("password");
        /*判断账号密码是否为空*/
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password)) {
            User user = userMapper.selectByUsername(username);
            /*判断密码是否正确*/
            if (md5Util.checkpassword(password, user.getPassword())) {
                return user;
            }
            /*账号或密码为空，返回空对象*/
            return new User();
        }
        return new User();
    }

    @Override
    public String insertUser(User params) {
        MD5Util md5Util = new MD5Util();
        if (StringUtils.isNotEmpty(params.getPassword())){
            /*设置默认用户类型*/
            params.setUserRoleId("2");
            /*设置主键id*/
            params.setUserId(params.getUsername()+params.getUserRoleId());
            /*加密密码*/
            params.setPassword(md5Util.EncoderByMd5(params.getPassword()));
            int i = userMapper.insert(params);
            return "注册成功";
        }
        return "密码为空，注册失败！";
    }
}




