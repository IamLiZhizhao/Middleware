package com.lzz.middleware.service;

import com.lzz.middleware.dto.StudentDTO;
import com.lzz.middleware.entity.StudentDO;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = "student")
@Repository
public interface StudentService {

	int add(StudentDO student);

    @CachePut(key = "#p0.sno")
    StudentDO update(StudentDTO student);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteBySno(String sno);

    @Cacheable(key = "#p0")
    StudentDO queryStudentBySno(String sno);

}
