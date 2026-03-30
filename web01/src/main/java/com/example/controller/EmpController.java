package com.example.controller;


import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequestMapping("/emps")
@ResponseBody
@RestController
public class EmpController {

    @Autowired
    private EmpService EmpService;
    @GetMapping
    public Result page(Integer page, Integer pageSize) {
        log.info("分页查询，参数：page={}，pageSize={}", page, pageSize);
        PageResult<Emp> pageResult = EmpService.page(page, pageSize);
        return Result.success(pageResult);
    }
}
