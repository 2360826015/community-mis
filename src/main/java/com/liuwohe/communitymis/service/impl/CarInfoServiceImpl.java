package com.liuwohe.communitymis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuwohe.communitymis.entity.CarInfo;
import com.liuwohe.communitymis.service.CarInfoService;
import com.liuwohe.communitymis.mapper.CarInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author 23608
* @description 针对表【resident_car_info】的数据库操作Service实现
* @createDate 2022-04-18 15:29:37
*/
@Service
public class CarInfoServiceImpl extends ServiceImpl<CarInfoMapper, CarInfo>
    implements CarInfoService{

    @Autowired
    private CarInfoMapper carInfoMapper;

    @Override
    public List<CarInfo> queryByParams(Map<String, Object> params) {
        QueryWrapper<CarInfo> qw = new QueryWrapper<>();
        /*判断用户角色*/
        /*管理员用户能获取所有车辆信息*/
        if("2".equals(params.get("userRoleId"))){
            /*普通用户则只查询本用户下的车辆信息*/
            qw.eq("user_id",params.get("userId"));
        }
         qw.like(StringUtils.isNotEmpty((String)params.get("numPlate")),"num_plate",params.get("numPlate"))
         .like(StringUtils.isNotEmpty((String)params.get("carowner")),"carowner",params.get("carowner"));
        return carInfoMapper.selectList(qw);
    }
}




