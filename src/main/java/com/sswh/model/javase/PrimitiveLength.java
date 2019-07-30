package com.sswh.model.javase;

/**
 * Created by wangchengcheng on 2019/7/29
 */
public class PrimitiveLength {

    public static void main(String[] args) {
        System.out.printf("%d - %d%n",Byte.MIN_VALUE,Byte.MAX_VALUE);
        System.out.printf("%d - %d%n",Short.MIN_VALUE,Short.MAX_VALUE);
        System.out.printf("%d - %d%n",Integer.MIN_VALUE,Integer.MAX_VALUE);
        System.out.printf("%d - %d%n",Long.MIN_VALUE,Long.MAX_VALUE);
        System.out.printf("%d - %d%n",Float.MIN_EXPONENT,Float.MAX_EXPONENT);
        System.out.printf("%d - %d%n",Double.MIN_EXPONENT,Double.MAX_EXPONENT);
        System.out.printf("%h - %h%n",Character.MIN_VALUE,Character.MAX_VALUE);
        System.out.printf("%b - %b%n",Boolean.TRUE,Boolean.FALSE);
        System.out.println("-----------");
        System.out.println("\u0048\u0049");
        System.out.println("\123");
        System.out.println(0 ^ 1);
        System.out.println(0 ^ 0);
        System.out.println(111 ^ 005);

        // System.out.printf("%X",new MyHashMap<>());
    }
}
