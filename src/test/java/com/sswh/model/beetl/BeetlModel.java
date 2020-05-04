package com.sswh.model.beetl;

import com.sswh.utils.beetl.GroupTemplateGenerator;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author nuanfeng
 * @date 2020/4/21 22:14
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
public class BeetlModel {

    @Test
    public void testBeetl() {
        GroupTemplate groupTemplate = GroupTemplateGenerator.getInstance();
        Template t = groupTemplate.getTemplate("hello,${name}");
        t.binding("name", "beetl");
        String str = t.render();
        Assert.assertEquals("hello,beetl", str);
    }
}
