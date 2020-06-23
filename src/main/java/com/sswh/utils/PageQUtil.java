package com.sswh.utils;

import cn.hutool.core.util.PageUtil;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/6/14 14:34
 */
public class PageQUtil<T> {

    /**
     * 返回layui需要格式的数据，发送当前页的数据
     *
     * @param allData
     * @param page
     * @param limit
     * @return
     */
    public JsonQResult setPageData(List<T> allData, int page, int limit) {
        JsonQResult jsonQResult = JsonQResult.getInstance();
        int total = 0;
        if (!allData.isEmpty()) {
            total = allData.size();
        } else {
            total = 0;
        }
        jsonQResult.setCode(0);
        jsonQResult.setCount(total);
        jsonQResult.setMsg("返回成功");
        jsonQResult.setData(currentPageResult(page, limit, allData, total));
        return jsonQResult;
    }

    /**
     * 获取当前页的数据
     *
     * @param page    第几页
     * @param limit   每页的条数
     * @param allData 待查询的所有的数据
     * @param total   数据池的总数
     * @return
     */
    public List<T> currentPageResult(int page, int limit, List<T> allData, int total) {
        if(total == 0){
            return null;
        }
        int totalPage = PageUtil.totalPage(total, limit);
        List<T> currPageData = null;
        if (page >= totalPage) {
            currPageData = allData.subList((totalPage - 1) * limit, total);
        } else if (page < 1) {
            currPageData = allData.subList(0, (page * limit));
        } else {
            currPageData = allData.subList((page - 1) * limit, (page * limit));
        }
        return currPageData;
    }


}
