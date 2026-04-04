package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

//      @Results({
//          @Result(column = "create_time",property = "createTime"),
//           @Result(column = "update_time",property = "updateTime"),
//           @Result(column = "dept_id",property = "deptId"),
//           @Result(column = "entry_time",property = "entryDate")
//   })

//    @Select("select count(*) from emp left join dept on emp.dept_id = dept.id")
//    public Long count();


//   @Results({
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime"),
//            @Result(column = "dept_id",property = "deptId"),
//            @Result(column = "entry_time",property = "entryDate")
//    })
//    @Select("select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id order by emp.create_time desc limit #{start},#{pageSize}")
//    public List<Emp> rows(Integer start, Integer pageSize);
//    ----------------------------------------------------------------------------------------
    //@Select("select emp.*,dept.name deptName from emp left join dept on emp.dept_id = dept.id
     //       where emp.name like '%#{name}%' and emp.gender = #{gender} and emp.entry_date between #{begin} and #{end}
      //      order by emp.create_time desc")
    //public List<Emp> rows(String name, Integer gender, LocalDate begin, LocalDate end);
        public List<Emp> rows(EmpQueryParam empQueryParam);
}
