package com.lzz.middleware.mapper;

import com.lzz.middleware.entity.StudentDO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
@Mapper
public interface StudentMapper {

	@Insert("insert into student(sno, sname, ssex, score) values(#{sno},#{name},#{sex},#{score})")
	int add(StudentDO student);
	
	@Update("update student set sname=#{name},ssex=#{sex},score=#{score} where sno=#{sno}")
    int update(StudentDO student);
	
	@Delete("delete from student where sno=#{sno}")
    int deleteBysno(String sno);
	
	@Select("select * from student where sno=#{sno}")
	@Results(id = "student",value= {
		 @Result(property = "sno", column = "sno", javaType = String.class),
         @Result(property = "name", column = "sname", javaType = String.class),
         @Result(property = "sex", column = "ssex", javaType = String.class),
         @Result(property = "score", column = "score", javaType = BigDecimal.class)
	})
	StudentDO queryStudentBySno(String sno);

}
