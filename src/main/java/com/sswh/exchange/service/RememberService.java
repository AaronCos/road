package com.sswh.exchange.service;

import com.sswh.enumpackage.DealState;
import com.sswh.exchange.entity.RememberList;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author nuanfeng
 * @date 2020/8/7 19:25
 */
public interface RememberService {

    /**
     * abhs query
     * @param userId 用户id
     * @param dealState  1:完成 0：未完成 2: 所有
     * @param date 一般是当前日期
     * @return
     */
    public List<Map<String, Object>> rememberList(Integer userId, DealState dealState, Date date);
    /**
     * 超期未完成记录
     * @param userId 用户id
     * @return 该用户超期未完成的所有任务
     */
    List<Map<String, Object>> unfinished(Integer userId);

    /**
     * 已完成记录
     * @param userId 用户id
     * @return
     */
    List<Map<String, Object>> finished(Integer userId);

    /**
     * 所有记录
     * @param userId 用户id
     * @return
     */
    List<Map<String, Object>> allRememberRecord(Integer userId);


    /**
     * abhs新增
     *
     * @param rememberList
     */

    public  int abhsInsert(RememberList rememberList);

    /**
     * abhs 修改
     * @return
     */
    public Integer abhsUpdate(RememberList rememberList);









}
