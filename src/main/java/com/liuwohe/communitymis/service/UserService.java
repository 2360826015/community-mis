package com.liuwohe.communitymis.service;

import com.liuwohe.communitymis.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【resident_user】的数据库操作Service
* @createDate 2022-04-09 16:59:45
*/
public interface UserService extends IService<User> {
    List<User> getList();

    User queryByUsername(Map<String, Object> params);

    String insertUser(User params);
}
