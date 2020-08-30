package com.sswh.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nuanfeng
 * @date 2020/8/30 12:09
 */
@Controller
public class OprExceptionController {

    @RequestMapping("exception_show")
    public String showException(){
        return "exception/exception";
    }

}
