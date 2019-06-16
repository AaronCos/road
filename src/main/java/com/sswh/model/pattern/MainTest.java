package com.sswh.model.pattern;

/**
 * Created by wangchengcheng on 2019/6/14
 */
public class MainTest {
 /*   public static void main(String[] args) {
        SubjectObservable so = new SubjectObservable();
        InfoObserverLi infoObserverLi = new InfoObserverLi();
        InfoObserverWang infoObserverWang = new InfoObserverWang();
        so.addObserver(infoObserverLi);
        so.addObserver(infoObserverWang);
        so.setData("hello,World");
    }*/
 public static void main(String[] args) {
     for (GrztEnum e:GrztEnum.values()){
         System.out.println(e);
     }
     System.out.println("lll:"+GrztEnum.B2.getIndex()+":"+GrztEnum.B2.getName());
 }
}
