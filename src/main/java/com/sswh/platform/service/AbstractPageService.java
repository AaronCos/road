package com.sswh.platform.service;

import cn.hutool.core.util.StrUtil;
import com.sswh.utils.JsonQResult;
import com.sswh.utils.PageQUtil;

import java.util.List;

/**
 * 分页抽象类，需要进行分页的栏目，可以进行继承
 *
 * @param <T> 实体的类型
 * @param <E> dao的类型
 * @author nuanfeng
 */
public abstract class AbstractPageService<T, E> {


    public E pageDao;

    public AbstractPageService() {

    }

    public AbstractPageService(E tempDao) {
        this.pageDao = tempDao;
    }


    public JsonQResult combineData(String title, int page, int limit) {
        JsonQResult jsonQResult = JsonQResult.getInstance();
        PageQUtil<T> tPageQUtil = new PageQUtil<>();

        List<T> allRecruit;
        if (StrUtil.isEmpty(title)) {
            allRecruit = this.findAll();
        } else {
            allRecruit = this.findByTitle(title);
        }
        return tPageQUtil.setPageData(allRecruit, page, limit);
    }

    /**
     * 查询所有的抽象方法
     *
     * @return
     */
    public abstract List<T> findAll();

    /**
     * 根据名称进行查找的抽象方法
     *
     * @param title
     * @return
     */
    public abstract List<T> findByTitle(String title);

}
