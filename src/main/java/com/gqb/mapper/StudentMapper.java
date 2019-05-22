package com.gqb.mapper;

import com.gqb.pojo.Student;
import com.gqb.pojo.StudentWithDetail;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {
    int insert(Student student);

    Student selectByID(int id);

    StudentWithDetail queryByID(@Param("id") int id);

    StudentWithDetail queryByIDStep(@Param("id") int id);

}
