package com.example.service;

import com.example.pojo.Emp;
import com.example.pojo.PageResult;

public interface EmpService {
     PageResult<Emp> page(Integer page, Integer pageSize);
}
