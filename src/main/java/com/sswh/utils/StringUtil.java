package com.sswh.utils;

import org.apache.shiro.crypto.hash.Md5Hash;

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
     *
     * @param numString
     * @return List<Integer>
     */
    public static List<Integer> strToNumList(String numString) {
        if (isEmpty(numString)) {
            return null;
        }
        ArrayList<Integer> iids = new ArrayList<Integer>();
        String[] split = numString.split(",");
        for (int i = 0; i < split.length; i++) {
            iids.add(Integer.valueOf(split[i]));
        }
        return iids;
    }

    public static boolean isNotEmpty(String param) {
        boolean isNotEmpty = false;
        if (param != null) {
            String result = param.trim();
            if (!result.equals("")) {
                isNotEmpty = true;
            }
        }
        return isNotEmpty;
    }

    public static boolean isEmpty(String param) {
        boolean isEmpty = true;
        if (param != null) {
            String result = param.trim();
            if (!result.equals("")) {
                isEmpty = false;
            }
        }
        return isEmpty;
    }

    public static boolean isEqual(String param1, String param2) {
        boolean equal = false;
        if (param1 == null || param2 == null) {
            equal = false;
        } else {
            if (param1.equals(param2)) {
                equal = true;
            }
        }
        return equal;
    }


    /**
     * 获取UUID
     *
     * @return
     */
    public static String uuid() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
    //得到加盐的md5加密值
    public static String md5Util(String source,String salt){
        if (source.isEmpty())
            source = "123456";
        if (salt.isEmpty())
            salt = "123456";
        return new Md5Hash(source,salt).toString();
    }

}
