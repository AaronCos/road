package com.sswh.model.pattern;

import java.util.Observable;
import java.util.Observer;

/**
 * @author mirac
 */
public class InfoObserverLi implements Observer {

    public InfoObserverLi() {

    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Li收到通知:" + ((SubjectObservable)o).getData());
    }
}
