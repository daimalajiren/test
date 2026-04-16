package com.example.controller;


import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.pojo.Result;
import com.example.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RequestMapping("/emps")
@ResponseBody
@RestController
public class EmpController {

    @Autowired
    private EmpService EmpService;
//    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize
//    , String name, Integer gender, @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat (pattern = "yyyy-MM-dd") LocalDate end) {
//        log.info("分页查询，参数：page={}，pageSize={},name={},gender={},begin={},end={}  ", page, pageSize, name, gender, begin, end);
//        PageResult<Emp> pageResult = EmpService.page(page, pageSize,name, gender, begin, end);
//        return Result.success(pageResult);
//    }
@GetMapping
public Result page(EmpQueryParam empQueryParam) {
    log.info("分页查询，参数：empQueryParam={} ", empQueryParam);
    PageResult<Emp> pageResult = EmpService.page(empQueryParam);
    return Result.success(pageResult);
}

@PostMapping
    public Result save(@RequestBody Emp emp) {
        log.info("新增员工，数据：{}", emp);
        EmpService.save(emp);
        return Result.success();
    }
    @DeleteMapping
    public Result delete( @RequestParam List< Integer> ids) {
        log.info("删除员工，ids：{}", ids);
        EmpService.delete(ids);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result show(@PathVariable Integer id) {
        log.info("回显员工，数据：{}", id);
        Emp emp = EmpService.showById(id);
        return Result.success(emp);
    }
    @PutMapping
    public Result update(@RequestBody Emp emp) {
    log.info("修改员工，数据：{}", emp);
    EmpService.update(emp);
    return Result.success();
    }
}
