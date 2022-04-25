package com.liuwohe.communitymis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwohe.communitymis.entity.Information;
import com.liuwohe.communitymis.entity.User;
import com.liuwohe.communitymis.mapper.UserMapper;
import com.liuwohe.communitymis.service.InformationService;
import com.liuwohe.communitymis.mapper.InformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【resident_information】的数据库操作Service实现
* @createDate 2022-04-09 16:59:45
*/
@Service
public class InformationServiceImpl extends ServiceImpl<InformationMapper, Information>
    implements InformationService{

    @Autowired
    private InformationMapper informationMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Information> queryByParams(Map<String, Object> params) {
        QueryWrapper<Information> qw = new QueryWrapper<>();
        /*判断用户角色*/
        /*管理员用户能获取所有信息*/
        User user = userMapper.selectById((String)params.get("userId"));
        if("2".equals(user.getUserRoleId())){
            /*普通用户则只查询本用户下的信息*/
            qw.eq("user_id",params.get("userId"));
        }
        qw.eq(StringUtils.isNotEmpty((String)params.get("houseId")),"house_id",params.get("houseId"))
        .like(StringUtils.isNotEmpty((String)params.get("homeowner")),"homeowner",params.get("homeowner"))
        .eq(StringUtils.isNotEmpty((String)params.get("unitId")),"unit_id",params.get("unitId"))
        .like(StringUtils.isNotEmpty((String)params.get("houseNum")),"house_num",params.get("houseNum"));
        return informationMapper.selectList(qw);
    }
}




