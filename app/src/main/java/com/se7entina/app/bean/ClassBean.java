package com.se7entina.app.bean;

import java.util.List;

/**
 * Class:
 * Created by se7enTina on 2016/4/23.
 * Description:
 */
public class ClassBean {
    private String name;
    private String sex; //性别
    private String pricePerHour; //价格
    private String education; //学历
    private List<String> category;  //教授课程类别
    private String perLike; //人气

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

    public String getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(String pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public String getPerLike() {
        return perLike;
    }

    public void setPerLike(String perLike) {
        this.perLike = perLike;
    }
}
