package com.example.service.impl;

import com.example.mapper.EmpExprMapper;
import com.example.mapper.EmpMapper;
import com.example.pojo.Emp;
import com.example.pojo.EmpExpr;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import com.example.service.EmpService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.beans.Transient;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;

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

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void save(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());

        empMapper.insert(emp);
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList))
        {
            exprList.forEach(expr -> {
                expr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void delete(List<Integer> ids) {

        empMapper.deleteByIds(ids);


        empExprMapper.deleteExprByEmpIds(ids);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public Emp showById(Integer id) {
        Emp emp = empMapper.showById(id);
        emp.setExprList(empExprMapper.getExprByEmpId(id));
        return emp;

    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.updateById(emp);
//        员工经历先删后加
        empExprMapper.deleteExprByEmpIds(Arrays.asList(emp.getId()));
        List<EmpExpr> exprList = emp.getExprList();
        if(!CollectionUtils.isEmpty(exprList))
        {
            exprList.forEach(expr -> {
                expr.setEmpId(emp.getId());
            });
            empExprMapper.insertBatch(exprList);
        }


    }

}
