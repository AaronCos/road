package com.sswh.model.pattern;

/**
 * Created by mirac on 2019/6/14
 * @author mirac
 */
public enum GrztEnum {
    /**
     * 生育
     */
    B101("生育收养1",1),B2("生育收养2",2),B3("生育收养3",3),B4("生育收养4",4),B5("生育收养5",5);

    private String name;
    private int index;
    GrztEnum(String name,int index){
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "GrztEnum{" +
                "name='" + name + '\'' +
                ", index=" + index +
                '}';
    }
}
