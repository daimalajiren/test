package com.example.mapper;

import com.example.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void insertBatch(List<EmpExpr> exprList);


    void deleteExprByEmpIds(List<Integer> empIds);



    List<EmpExpr> getExprByEmpId(Integer empId);

}
