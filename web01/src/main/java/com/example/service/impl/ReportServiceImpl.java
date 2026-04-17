package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.jobOption;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service

public class ReportServiceImpl implements ReportService {

@Autowired
private EmpMapper empMapper;
    @Override
    public jobOption getEmpJobData() {
        List<Map<String,Object>> list = empMapper.countEmpJobData();
        List<Object> jobList = list.stream().map(m -> m.get("pos")).toList();
        List<Object> dataList = list.stream().map(m -> m.get("num")).toList();
        return new jobOption(jobList,dataList);
    }

    @Override
    public List<Map<String, Object>> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
