package com.example.service.impl;

import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize)
//    {
//        Long total = empMapper.count();
//        Integer start = (page-1)*pageSize;
//        List<Emp> rows = empMapper.rows(start, pageSize);
//
//
//
//        return new PageResult<Emp>(total, rows);
//    }
    //pagehelper
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end)
//    {
//        PageHelper.startPage(page, pageSize);
//        List<Emp> rows = empMapper.rows(name, gender, begin, end);
//        Page<Emp> p = (Page<Emp>) rows;
//        return new PageResult<Emp>(p.getTotal(),p.getResult());
//    }
@Override
public PageResult<Emp> page(EmpQueryParam empQueryParam)
{
    PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
    List<Emp> rows = empMapper.rows(empQueryParam);
    Page<Emp> p = (Page<Emp>) rows;
    return new PageResult<Emp>(p.getTotal(),p.getResult());
}

    @Override
    public void save(Emp emp) {
        emp.setCreateDate(LocalDateTime.now());
        emp.setUpdateDate(LocalDateTime.now());

        empMapper.insert(emp);
    }

}
