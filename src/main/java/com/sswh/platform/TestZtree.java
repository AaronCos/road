package com.sswh.platform;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nuanfeng
 * @date 2020/8/30 16:53
 */
@Controller
public class TestZtree {


    @RequestMapping("ztree")
    public String ztree(){
       return "core/ztree/ztree";
   }
}
