package com.example.controller;


import com.example.pojo.Result;
import com.example.pojo.jobOption;
import com.example.service.EmpService;
import com.example.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@Slf4j
@RequestMapping("/report")
@RestController
public class ReportController {

    @Autowired
    ReportService reportService;
    @GetMapping("/empJobData")
    public Result getEmpJobData(){
        jobOption jobOption = reportService.getEmpJobData();
        log.info("员工职位统计结果：{}", jobOption);

        return Result.success(jobOption);
    }
    @GetMapping("/empGenderData")
    public Result getEmpGenderData(){
        List<Map<String,Object>> list = reportService.getEmpGenderData();
        log.info("员工性别统计结果：{}", list);

        return Result.success(list);
    }

}
