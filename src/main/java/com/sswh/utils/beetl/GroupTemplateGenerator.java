package com.sswh.utils.beetl;

import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.StringTemplateResourceLoader;

import java.io.IOException;

/**
 * @author nuanfeng
 * @date 2020/4/21 21:37
 */
public class GroupTemplateGenerator {

    private volatile static GroupTemplate groupTemplate;

    private GroupTemplateGenerator() {

    }

    /**
     * GroupTemplate的双重加锁单例实现
     *
     * @return
     */
    public static GroupTemplate getInstance() {

        if (groupTemplate == null) {
            synchronized (GroupTemplate.class) {
                if (groupTemplate == null) {
                    StringTemplateResourceLoader resourceLoader = new StringTemplateResourceLoader();
                    Configuration cfg = null;
                    try {
                        cfg = Configuration.defaultConfiguration();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    groupTemplate = new GroupTemplate(resourceLoader, cfg);
                }

            }
        }
        return groupTemplate;
    }

}
