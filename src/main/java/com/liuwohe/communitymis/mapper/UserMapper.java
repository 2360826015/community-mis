package com.liuwohe.communitymis.mapper;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.liuwohe.communitymis.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Administrator
* @description 针对表【resident_user】的数据库操作Mapper
* @createDate 2022-04-09 16:59:45
* @Entity com.liuwohe.communitymis.entity.User
*/
public interface UserMapper extends BaseMapper<User> {

    List<Map<String,Object>> selectList();

    User selectByUsername(@Param("username") String username);
}




