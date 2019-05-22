package com.gqb;

import com.gqb.mapper.StudentMapper;
import com.gqb.pojo.Student;
import com.gqb.pojo.StudentWithDetail;
import com.gqb.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

//MyBatis
public class Test1 {
    @Test
    public void m1(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student stu = new Student();
        stu.setName("gqb4");

        mapper.insert(stu);

        sqlSession.commit();

        sqlSession.close();

    }

    @Test
    public void m2(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        Student stu = mapper.selectByID(2);
        System.out.println(stu.getName());
        sqlSession.close();

    }

    @Test
    public void m3(){
        SqlSession sqlSession = MybatisUtil.getSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        //StudentWithDetail stu = mapper.queryByID(1);
        StudentWithDetail stu = mapper.queryByIDStep(1);
        System.out.println(stu);
        sqlSession.close();
    }

}
