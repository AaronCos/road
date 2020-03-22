package com.sswh.model.jsonp;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wangchengcheng on 2019/7/12
 * @author mirac
 */
@Controller
@RequestMapping("hellojson")
public class AcquireJson {

    @RequestMapping("json")
    @ResponseBody
    public List<Map> acquireJson(){
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map1 = new HashMap<>();
        List<Map> list = new ArrayList<>();
        map.put("name","zhangsan");
        map.put("age",12);
        list.add(map);
        map1.put("name","lisi");
        map1.put("age",13);
        list.add(map1);
        String s = JSONObject.toJSON(list).toString();
        //s = "success_jsonpCallback("+s+")";
        return list;
    }
}
