package com.sswh.platform.service;

import cn.hutool.core.util.PageUtil;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/6/9 6:08
 */
public abstract class CurrentPageData<T> {

    public List<T> currentPageResult(int page, int limit, List<T> allData) {
        int total = 0;
        if (!allData.isEmpty()) {
            total = allData.size();
        }else{
            return null;
        }
        int totalPage = PageUtil.totalPage(total, limit);
        if ((page == totalPage)) {
            allData = allData.subList((page-1)*limit,total);
        }else{
            allData = allData.subList((page-1)*limit,(page*limit));
        }
        return allData;
    }
}
