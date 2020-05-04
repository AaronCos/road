package com.sswh.noraml;

import com.alibaba.fastjson.JSONArray;
import org.junit.Test;

import java.util.*;

/**
 * @author Aaron
 * @date 2020/3/8 9:12
 */
public class AlthTest {


    @Test
    public void mapTest(){
       Map<Integer, String> map = new HashMap<>();
        map.put(5,"wang");
        map.put(4,"hello");
        map.put(3,"hello");
        map.put(1,"wang");
        map.put(2,"hello");
        map.put(7,"o");

        Iterator<Integer> iter = map.keySet().iterator();
        while (iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    @Test
    public void testTreeMap(){
        TreeMap<Integer, Integer> integerIntegerTreeMap = new TreeMap<>();
        integerIntegerTreeMap.put(5,6);
        integerIntegerTreeMap.put(4,3);
        integerIntegerTreeMap.put(3,6);
        integerIntegerTreeMap.put(2,6);
        integerIntegerTreeMap.put(1,2);
        integerIntegerTreeMap.put(6,1);
        Iterator<Integer> iterator = integerIntegerTreeMap.keySet().iterator();
        while (iterator.hasNext()){
            System.out.println(integerIntegerTreeMap.get(iterator.next()));
        }
    }

    @Test
    public void testLinekedHashMap(){
        LinkedHashMap<Integer, Integer> link = new LinkedHashMap<>();
        link.put(1,4);
        link.put(2,3);
        link.put(4,2);
        link.put(3,2);
        link.put(5,2);
        Iterator<Integer> iterator = link.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void testJsonArray(){
        HashMap<String, String> map = new HashMap<>();
        map.put("name","wangchengcheng");
        map.put("age","32");
        map.put("hobby","reading");

        HashMap<String, String> map1= new HashMap<>();
        map1.put("name","wangchengcheng1");
        map1.put("age","33");
        map1.put("hobby","run");
        JSONArray array = new JSONArray();
        array.add(map);
        array.add(map1);
        System.out.println(array);
    }
}
