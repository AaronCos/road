package com.sswh;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: WangChengCheng
 * @Description: 测试FreeMarker
 * @Date Created in 22:39 2019/10/23
 * @Modeified by:
 */
public class FreemarkerTest {


    @Test
    public void firstDemo() throws Exception {
        //1、创建Configuration对象，指定编码集和模板文件夹
        Configuration configuration = new Configuration(Configuration.getVersion());
        configuration.setDefaultEncoding("utf-8");
        configuration.setDirectoryForTemplateLoading(new File("E:\\IdeaProjects\\complat\\src\\main\\webapp\\WEB-INF\\templates"));
        //2、创建Template对象，指定模板文件
        Template template = configuration.getTemplate("test.ftl");
        //3、准备数据，Map或POJO类型，推荐Map
        Map<String, Object> data = new HashMap<>();
        data.put("test", "第一个Freemarker例子");
        data.put("good","ftl是如此的简单");
        //4、创建Writer对象，指定输出文件
        Writer writer = new FileWriter("E:/ftl_out/test.txt");
        //5、生成模板文件
        template.process(data, writer);
    }

}
