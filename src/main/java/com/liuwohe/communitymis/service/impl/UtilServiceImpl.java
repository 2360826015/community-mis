package com.liuwohe.communitymis.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.liuwohe.communitymis.entity.Information;
import com.liuwohe.communitymis.mapper.FeedbackMapper;
import com.liuwohe.communitymis.mapper.InformationMapper;
import com.liuwohe.communitymis.mapper.NoticeMapper;
import com.liuwohe.communitymis.mapper.UserMapper;
import com.liuwohe.communitymis.service.UtilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UtilServiceImpl implements UtilService {
    @Autowired
    private InformationMapper informationMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private NoticeMapper noticeMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Override
    public Map<String, Object> getInfo() {
        List<Object> labels = new ArrayList<>();
        List<Object> data = new ArrayList<>();
        List<Object> dataList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        /*调用mapper接口映射查询住户信息总条数*/
        Integer infoCount = informationMapper.selectCount(null);
        /*存入map中*/
        map.put("infoCount",infoCount);
        /*统计服务信息数据总条数并将结果存入map*/
        map.put("msgCount",noticeMapper.selectCount(null)+feedbackMapper.selectCount(null));
        /*查询系统所有用户账号数量*/
        map.put("userCount",userMapper.selectCount(null));
        /*查询所有住户信息，并按照单元号进行返回*/
        List<Map<String, Object>> slist=informationMapper.statistics();
        slist.forEach(s->{
            /*遍历结果，将单元名称和统计数据分别放入不同的集合中*/
            labels.add(s.get("unit_name"));
            data.add(s.get("total"));
        });
      /* 将集合放入map中，便于前端展示数据*/
        map.put("labels",labels);
        dataMap.put("label","居住人数");
        dataMap.put("data",data);
        dataList.add(dataMap);
        map.put("dataList",dataList);
        return map;
    }
}
