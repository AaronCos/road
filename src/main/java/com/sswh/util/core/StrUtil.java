package com.sswh.util.core;

import java.io.File;
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
    public static String generateUuid(){
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
     * 字符串转list-不保证顺序-不重复
     * @param ids id串
     * @param splitChar 分隔符
     * @return id的列表
     */
    public static List<Integer> idsToList(String ids, String splitChar){
        Set<Integer> integers = new HashSet<>();
        List<Integer> list = null;
        int i = 0;
        if (!ids.isEmpty()) {
            String[] split =  ids.split("\\\\"+splitChar);
            if (split.length>0) {
                for (String s : split) {
                    integers.add(Integer.parseInt(s));
                }
            }
            list = new ArrayList<>(integers);
        }
        return list;
    }
    /**
     * 字符串转list-保证顺序-可重复
     * @param ids id串
     * @param splitChar 分隔符
     * @return id的列表
     */
    public static List<Integer> idsToSortList(String ids, String splitChar){
        List<Integer> list = null;
        int i = 0;
        if (!ids.isEmpty()) {
            String[] split =  ids.split("\\\\"+splitChar);
            if (split != null && split.length>0) {
                list = new ArrayList<>(split.length);
                for (String s : split) {
                    list.add(Integer.parseInt(s));
                }
            }
        }
        return list;
    }

    /**
     * 获取-WEB-INF的路径
     * @return
     */
    /**
     *
     * @param clazz 在方法中使用this.getClass
     * @param lastBox WEB-INF下的直接文件夹名称 WEB-INF/model 则lastBox=model
     * @return lastBox所在文件系统绝对路径
     */
    public static String webInfRouter(Class clazz, String lastBox){
        if (lastBox == null || lastBox.equals("")) {
            lastBox = "template";
        }
        return clazz.getClassLoader().getResource(File.separator).getPath().replace("classes", lastBox);
    }



}
