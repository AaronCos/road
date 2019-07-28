package com.sswh.model.javase;

/**
 * Created by wangchengcheng on 2019/7/20
 */
public class MyClassTest  {

        public static void main(String[] args) {
        MyHashMap<String, String> map = new MyHashMap<>();
                for (int i = 0; i < 10; i++) {
                        map.put("wang"+i,"hello");
                }
        map.put("wang","li");

        System.out.println(map.get("wang1"));

/*        Map<String, Object> map = new HashMap<>();
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        HashSet<String> strings = new HashSet<>();
        ArrayList<Object> objects = new ArrayList<>();

        MyClassTest[] myClassTests = new MyClassTest[10];
 */   }


}
