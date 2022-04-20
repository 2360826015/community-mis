package com.liuwohe.communitymis.service;

import com.liuwohe.communitymis.entity.CarInfo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author 23608
* @description 针对表【resident_car_info】的数据库操作Service
* @createDate 2022-04-18 15:29:37
*/
public interface CarInfoService extends IService<CarInfo> {

    List<CarInfo> queryByParams(Map<String, Object> params);
}
