package com.sswh.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 各类字符串的处理
 * Created by wangchengcheng on 2019/2/14
 */
public class StringUtil {
    /**
     * 数字字符串转化为整型list
     * @param numString
     * @return List<Integer>
     */
    public static List<Integer> strToNumList(String numString){
        if(isEmpty(numString)){
            return null;
        }
        ArrayList<Integer> iids = new ArrayList<>();
        String[] split = numString.split(",");
        for (int i = 0; i < split.length; i++) {
            iids.add(Integer.valueOf(split[i]));
        }
        return iids;
    }

    public static boolean isNotEmpty(String param){
        boolean isNotEmpty = false;
        if(param != null){
            String result = param.trim();
            if(result != ""){
                isNotEmpty = true;
            }
        }
        return isNotEmpty;
    }
    public static boolean isEmpty(String param){
        boolean isEmpty = true;
        if(param != null){
            String result = param.trim();
            if(result != ""){
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    /**
     * 获取UUID
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

}
