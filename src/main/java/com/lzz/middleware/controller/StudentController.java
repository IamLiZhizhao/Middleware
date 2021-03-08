package com.lzz.middleware.controller;

import com.lzz.middleware.dto.StudentDTO;
import com.lzz.middleware.entity.StudentDO;
import com.lzz.middleware.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * http://localhost:8080/student/get?sno=1
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public StudentDO get(String sno) {
        return studentService.queryStudentBySno(sno);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public StudentDO update(@RequestBody StudentDTO student) {
        return studentService.update(student);
    }

    /**
     * http://localhost:8080/student/1
     */
    @GetMapping("/{sno}")
    public ResponseEntity<StudentDO> student(@PathVariable(value = "sno") String sno){
        return new ResponseEntity<>(studentService.queryStudentBySno(sno), HttpStatus.OK);
    }

}
