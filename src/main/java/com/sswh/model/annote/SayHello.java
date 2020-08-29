package com.sswh.model.annote;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * 自定义注解案例
 * @author nuanfeng
 * @date 2020/8/24 22:11
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SayHello {
    public String sayHello() default "no say";

}
class WangChent{
    private String name;
    private int age;
    private int grade;
    public WangChent() {
    }
    @SayHello
    public String earnMoney(){
        String mount = "a lot of money";
        return mount;
    }

}
class MainClass{
    public static void main(String[] args) {
        WangChent wangChent = new WangChent();
        Class<?> aClass = wangChent.getClass();
        Method[] methods = aClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(SayHello.class)) {
                SayHello annotation = method.getAnnotation(SayHello.class);
                String s = method.toGenericString();
                String s1 = annotation.sayHello();
                System.out.println(s+";s1:"+s1);
            }
        }
        String s = wangChent.earnMoney();
        System.out.println(s);
    }
}
