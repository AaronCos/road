package com.sswh.model.beetl;

import com.sswh.utils.beetl.GroupTemplateGenerator;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;

/**
 * @author nuanfeng
 * @date 2020/4/21 22:14
 */
public class BeetlModel {
    public static void main(String[] args) {
        useBeetl();
    }
    public static  void useBeetl(){
        GroupTemplate groupTemplate = GroupTemplateGenerator.getInstance();
        Template t = groupTemplate.getTemplate("hello,${name}");
        t.binding("name","beetl");
        String str = t.render();
        System.out.println(str);
    }
}
