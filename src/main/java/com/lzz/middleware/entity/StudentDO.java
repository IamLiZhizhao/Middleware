package com.lzz.middleware.entity;

import java.math.BigDecimal;

public class StudentDO {

    private String sno; // 学号
    /**
     * 姓名、性别、成绩
     */
    private String name;
    private String sex;
    private BigDecimal score;

    public StudentDO(){
    }

    public StudentDO(String sno,String name,String sex,BigDecimal score) {
        this.sno = sno;
        this.name = name;
        this.sex = sex;
        this.score = score;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }
}