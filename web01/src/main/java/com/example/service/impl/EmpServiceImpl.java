package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Override
    public PageResult<Emp> page(Integer start, Integer pageSize)
    {
        Long total = empMapper.count();
        Integer page = (start-1)*pageSize;
        List<Emp> rows = empMapper.rows(page, pageSize);



        return new PageResult<Emp>(total, rows);
    }
}
