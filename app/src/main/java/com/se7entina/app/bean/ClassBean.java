package com.se7entina.app.bean;

/**
 * Class:
 * Created by se7enTina on 2016/4/23.
 * Description:
 */
public class ClassBean {
    private String name;
    private String sex; //性别
    private String grade; //评分
    private String education; //学历
    private String category;  //教授课程类别

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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
