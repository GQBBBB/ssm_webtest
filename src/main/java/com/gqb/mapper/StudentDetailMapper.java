package com.gqb.mapper;


import com.gqb.pojo.StudentDetail;
import org.apache.ibatis.annotations.Param;

public interface StudentDetailMapper {

    StudentDetail selectByID(@Param("id") int id);

}
