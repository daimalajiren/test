package com.example.mapper;

import com.example.pojo.Emp;
import com.example.pojo.EmpQueryParam;
import com.example.pojo.PageResult;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

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
        @Options(useGeneratedKeys = true,keyProperty = "id")
        @Insert("insert into emp(username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
        void insert(Emp emp);

        void deleteByIds(List<Integer> ids);

        @Select("select emp.* from emp where id = #{id}")
        Emp showById(Integer id);

        //@Update("update emp set username = #{username},name = #{name},gender = #{gender},phone = #{phone},job = #{job},salary = #{salary},image = #{image},entry_date = #{entryDate},dept_id = #{deptId},update_time = #{updateTime} where id = #{id}")
        void updateById(Emp emp);

        List<Map<String,Object>> countEmpJobData();

        List<Map<String, Object>> countEmpGenderData();

        @Select("select id,username,name from emp where username = #{username} and password = #{password}")
        Emp selectByUsernameAndPassword(Emp emp);
}
