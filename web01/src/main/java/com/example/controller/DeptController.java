package com.example.controller;

import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.DptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/depts")
@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DptService dptService;
    //@RequestMapping(value = "/depts")
    @GetMapping
        public Result list(){
        log.info("查询部门信息");
        List<Dept> deptList = dptService.findAll();

        return Result.success(deptList);
        }
        @DeleteMapping
        public Result delete(Integer id){

        log.info("删除部门信息 {}" , id);
        dptService.deleteById(id);

        return Result.success();
        }
        @PostMapping
    public Result add(@RequestBody Dept dept){
        log.info("添加部门信息 {}" , dept);
        dptService.add(dept);
        return Result.success();
        }
        @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("查询部门信息 {}" , id);
        Dept dept = dptService.getById(id);
        return Result.success(dept);
        }
        @PutMapping
    public Result update(@RequestBody Dept dept){
        log.info("修改部门信息 {}" , dept);
        dptService.update(dept);
        return Result.success();
        }
}
