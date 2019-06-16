package com.sswh.model.pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by wangchengcheng on 2019/6/14
 */
public class InfoObserverWang implements Observer {
    public InfoObserverWang() {
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("wang收到通知:" + ((SubjectObservable) o).getData());

    }
}
