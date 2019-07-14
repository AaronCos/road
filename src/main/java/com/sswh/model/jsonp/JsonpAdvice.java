package com.sswh.model.jsonp;

import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by wangchengcheng on 2019/7/12
 */
//@ControllerAdvice(basePackageClasses = {Hello.class})
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice {
   public JsonpAdvice() {
        super("callbackparam");
    }
}
