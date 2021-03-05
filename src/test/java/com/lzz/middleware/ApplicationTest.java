package com.lzz.middleware;

import com.lzz.middleware.entity.StudentDO;
import com.lzz.middleware.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {

    @Autowired
    private StudentService studentService;
    
    @Test
    public void test() throws Exception {
        StudentDO student1 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student1.getSno() + "的学生姓名为：" + student1.getName());

        StudentDO student2 = this.studentService.queryStudentBySno("001");
        System.out.println("学号" + student2.getSno() + "的学生姓名为：" + student2.getName());
    }
}