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
        QueryWrapper<Information> qw = new QueryWrapper<>();
        List<Object> labels = new ArrayList<>();
        List<Object> data = new ArrayList<>();
        List<Object> dataList = new ArrayList<>();
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> dataMap = new HashMap<>();
        Integer infoCount = informationMapper.selectCount(null);
        map.put("infoCount",infoCount);
        Integer noticeCount = noticeMapper.selectCount(null);
        Integer feedbackCount = feedbackMapper.selectCount(null);
        map.put("msgCount",noticeCount+feedbackCount);
        Integer userCount = userMapper.selectCount(null);
        map.put("userCount",userCount);

        List<Map<String, Object>> slist=informationMapper.statistics();
        slist.forEach(s->{
            labels.add(s.get("unit_name"));
            data.add(s.get("total"));
        });
        map.put("labels",labels);
        dataMap.put("label","居住人数");
        dataMap.put("data",data);
        dataList.add(dataMap);
        map.put("dataList",dataList);
        return map;
    }
}
