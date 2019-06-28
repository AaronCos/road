package com.sswh.model.servlet;

/**
 * Created by wangchengcheng on 2019/6/27
 */
public class DogEntity {
    private Integer iid;
    private String name;
    private String age;

    public DogEntity(String name) {
        this.name = name;
    }

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "DogEntity{" +
                "iid=" + iid +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
