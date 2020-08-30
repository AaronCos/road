package com.sswh.utils.core;


import cn.hutool.core.util.NumberUtil;

import java.util.*;

/**
 * 自定义字符串工具包
 * @author nuanfeng
 * @date 2020/8/30 14:38
 */
public  class StrUtil {

    /**
     * 获取随机32位的uuid
     * @return
     */
    public static String getUuid(){
            String s = UUID.randomUUID().toString();
            return s.replace("-", "");
        }

    /**
     * 调用对象的toString方法，null会返回“null”
     *
     * @param obj 对象
     * @return 字符串
     * @since 4.1.3
     */
    public static String toString(Object obj) {
        return null == obj ? null : obj.toString();
    }

    /**
     * 字符串转list
     * @param ids id串
     * @param splitChar 分隔符
     * @return id的列表
     */
    public static List<Integer> idsToList(String ids,String splitChar){
        Set<Integer> integers = new HashSet<>();
        List<Integer> list = null;
        int i = 0;
        if (!ids.isEmpty()) {
            String[] split =  ids.split("\\\\"+splitChar);
            if (split != null && split.length>0) {
                for (String s : split) {
                    integers.add(NumberUtil.parseInt(s));
                }
            }
            list = new ArrayList<>(integers);
        }
        return list;
    }



}
