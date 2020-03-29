package com.sswh.model.pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * @author nuanfeng
 */
public class InfoObserverWang implements Observer {
    public InfoObserverWang() {
    }

    /**
     *@description
     * @param o
 * @param arg
     *@return void
     *@author mirac
     *@date 2020/3/22 15:18
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("wang收到通知:" + ((SubjectObservable) o).getData());

    }
}
