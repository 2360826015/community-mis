package com.liuwohe.communitymis.service;

import com.liuwohe.communitymis.entity.Information;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
* @author Administrator
* @description 针对表【resident_information】的数据库操作Service
* @createDate 2022-04-09 16:59:45
*/
public interface InformationService extends IService<Information> {

    List<Information> queryByParams(Map<String, Object> params);
}
