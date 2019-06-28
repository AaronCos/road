package com.sswh;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

/**
 * Created by wangchengcheng on 2019/1/12
 */

public class RedisTest {
    /**
     * 利用fastJson解析json
     */
    @Test
    public void helloTest() {
        String a = "{\n" +
                "    \"code\":0,\n" +
                "    \"msg\":\"成功\",\n" +
                "    \"data\":[\n" +
                "        {\n" +
                "            \"type\":\"1\",\n" +
                "            \"ip\":\"可以根据ip地址提取，ip为空时提取所有的\",\n" +
                "            \"policy_code\":\"08e3a69fc29a951db2616ae1e3137dad\",\n" +
                "            \"policy_list\":[\n" +
                "                {\n" +
                "                    \"module_type\":\"host\",\n" +
                "                    \"log_type\":\"file\",\n" +
                "                    \"policy_type\":\"1,3,4\",\n" +
                "                    \"begin_time\":\"2019-03-01 12:00:00\",\n" +
                "                    \"end_time\":\"2019-03-01 16:30:00\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"module_type\":\"server\",\n" +
                "                    \"log_type\":\" process \",\n" +
                "                    \"policy_type\":\"2,3\",\n" +
                "                    \"begin_time\":\"2019-03-01 12:00:00\",\n" +
                "                    \"end_time\":\"2019-03-01 16:30:00\"\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"type\":\"2\",\n" +
                "            \"policy_code\":\"27cfd2ba5c35c7e0db520e66d2f4a59l\",\n" +
                "            \"policy_list\":[\n" +
                "                {\n" +
                "                    \"module_type\":\"host\",\n" +
                "                    \"log_type\":\"file\"\n" +
                "                },\n" +
                "                {\n" +
                "                    \"module_type\":\"server\",\n" +
                "                    \"log_type\":\"process\"\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        System.out.println("hello test");

        JSONObject parse = null;
        try {
            parse = (JSONObject) JSONObject.parse(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int code = (int) parse.get("code");
        System.out.println(code);
        JSONArray data = (JSONArray) parse.get("data");
        int size = data.size();
        System.out.println(size);
        JSONObject jsonObject = data.getJSONObject(0);
        String type = (String) jsonObject.get("policy_code");
        System.out.println(type);
    }




}
