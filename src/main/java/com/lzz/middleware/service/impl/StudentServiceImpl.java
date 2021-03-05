package com.lzz.middleware.service.impl;

import com.lzz.middleware.dto.StudentDTO;
import com.lzz.middleware.entity.StudentDO;
import com.lzz.middleware.mapper.StudentMapper;
import com.lzz.middleware.service.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 学生服务实现类
 *
 * @author lizhizhao
 * @since 2021-03-03 17:59
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int add(StudentDO student) {
        return studentMapper.add(student);
    }

    @Override
    public StudentDO update(@RequestBody StudentDTO studentDTO) {
        StudentDO student = new StudentDO();
        BeanUtils.copyProperties(studentDTO, student);

        this.studentMapper.update(student);
        return this.studentMapper.queryStudentBySno(student.getSno());
    }

    @Override
    public void deleteBysno(String sno) {
        studentMapper.deleteBysno(sno);
    }

    @Override
    public StudentDO queryStudentBySno(String sno) {
        return studentMapper.queryStudentBySno(sno);
    }
}
