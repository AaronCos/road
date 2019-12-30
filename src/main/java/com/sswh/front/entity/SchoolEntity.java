package com.sswh.front.entity;

import java.io.Serializable;

/**
 * @Author: WangChengCheng
 * @Description:
 * @Date Created in 15:57 2019/12/17
 * @Modeified by:
 */
public class SchoolEntity  implements Serializable {
    private int id;
    private String title;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
