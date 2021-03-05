package com.lzz.middleware.controller;

import com.lzz.middleware.dto.StudentDTO;
import com.lzz.middleware.entity.StudentDO;
import com.lzz.middleware.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lizhizhao
 * @since 2020-06-01 16:48
 */
@RequestMapping("student")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public StudentDO get(String sno) {
        return studentService.queryStudentBySno(sno);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public StudentDO update(@RequestBody StudentDTO student) {
        return studentService.update(student);
    }

}
