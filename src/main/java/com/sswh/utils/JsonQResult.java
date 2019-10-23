package com.sswh.utils;

import cn.hutool.core.util.StrUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangchengcheng on 2019/9/28
 */
public class JsonQResult {

    private String code;
    private String message;
    private String data;
    private String jsonQResult;
    private Map<String,Object> jsonQMap = new HashMap<>();
    private Map<String,Object> dataJson = new HashMap<>();
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getJsonQResult() {
        return jsonQResult;
    }

    public void setJsonQResult(String jsonQResult) {
        this.jsonQResult = jsonQResult;
    }

    public Map<String, Object> getjsonQMap() {
        return jsonQMap;
    }

    public void setJsonQMap(String key,Object value) {
        if(StringUtil.isEmpty(this.code)){
            this.code = "01";
        }
        this.jsonQMap.put("code",this.code);
        if(StringUtil.isEmpty(this.message)){
            this.message = "未设置提示信息";
        }
        this.jsonQMap.put("message",this.message);
        if(!StrUtil.isEmpty(key)){
            this.dataJson.put(key,value);
            this.jsonQMap.put("data", JSONObject.toJSON(this.dataJson));
        }
        this.jsonQResult = JSONUtils.toJSONString(this.jsonQMap);
    }
    public void setJsonQMap() {
        if(StringUtil.isEmpty(this.code)){
            this.code = "01";
        }
        this.jsonQMap.put("code",this.code);
        if(StringUtil.isEmpty(this.message)){
            this.message = "未设置提示信息";
        }
        this.jsonQMap.put("message",this.message);
        this.jsonQResult = JSONUtils.toJSONString(this.jsonQMap);
    }


    @Override
    public String toString() {
        return "JsonQResult{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", jsonQResult='" + jsonQResult + '\'' +
                ", jsonQMap=" + jsonQMap +
                '}';
    }

    public static void main(String[] args) {
        JsonQResult jsonQResult = new JsonQResult();
        jsonQResult.setJsonQMap("hello","woshi");
        jsonQResult.setJsonQMap("good","boy");
        String jsonQResult1 = jsonQResult.getJsonQResult();
        System.out.println(jsonQResult1);
        JSONObject o = (JSONObject) JSONObject.parse(jsonQResult1);
        JSONObject data =(JSONObject) o.get("data");
        System.out.println(data.toJSONString());
        Object o1 = JSONObject.toJSON(data);
        System.out.println(o1.toString());
    }
}
