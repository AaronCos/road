package com.sswh.model.pattern;

import java.util.Observable;

/**
 * Created by wangchengcheng on 2019/6/14
 */
public class SubjectObservable extends Observable {

    private String data = "";

    public String getData() {
        return data;
    }

    public void setData(String data) {
        if (!this.data.equals(data)){
            this.data = data;
            setChanged();    //改变通知者的状态
        }
        notifyObservers();    //调用父类Observable方法，通知所有观察者
    }
}
