package com.sswh.noraml;

import com.sswh.config.ThreadPoolConfig;
import com.sswh.model.thread.AsyncTask;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author nuanfeng
 * @date 2020/8/29 10:27
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
@ContextConfiguration(classes = ThreadPoolConfig.class)
public class ThreadTest {
    @Autowired
    public AsyncTask asyncTask;

    public void testTask(){
        asyncTask.testAsycTask();
    }

}
