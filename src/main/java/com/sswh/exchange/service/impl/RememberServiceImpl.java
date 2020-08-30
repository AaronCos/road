package com.sswh.exchange.service.impl;

import cn.hutool.core.date.DateTime;
import com.sswh.enumpackage.Client;
import com.sswh.enumpackage.DealState;
import com.sswh.enumpackage.ResultState;
import com.sswh.exchange.dao.RememberListDao;
import com.sswh.exchange.dao.RememberLogDao;
import com.sswh.exchange.entity.RememberList;
import com.sswh.exchange.entity.RememberLog;
import com.sswh.exchange.service.RememberListService;
import com.sswh.exchange.service.RememberLogService;
import com.sswh.exchange.service.RememberService;
import com.sswh.utils.AbhsUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author nuanfeng
 * @date 2020/8/7 19:31
 */
@Service
public class RememberServiceImpl implements RememberService {


    @Resource
    private RememberListDao rememberListDao;

    @Resource
    private RememberLogDao rememberLogDao;

    @Resource
    private RememberLogService rememberLogService;

    @Resource
    private RememberListService rememberListService;





    /**
     * 艾宾浩斯新增
     *
     * @param rememberList
     */
    @Override
    public int abhsInsert(RememberList rememberList) {

        RememberList result = rememberListService.insert(rememberList);
        int rememberListIid = result.getIid();
        int successCount = 0;

        List<RememberLog> rememberLogs = new ArrayList<>();
        /**生成abhs时间序列*/
        List<DateTime> dateTimes = AbhsUtil.acquireAbhsTimeList();
        for (int i = 0; i < dateTimes.size(); i++) {
            RememberLog rememberLog = new RememberLog();
            rememberLog.setRememberListIid(rememberListIid);
            rememberLog.setSendtime(dateTimes.get(i));
            rememberLog.setClient(Client.PC.getClientCode());
            rememberLog.setResult(ResultState.SUCCESS.getStateCode());
            rememberLog.setFinished(DealState.UNFINISHED.getDealStateCode());
            rememberLogs.add(rememberLog);
        }
        for (int i = 0; i < rememberLogs.size(); i++) {
            RememberLog insert = rememberLogService.insert(rememberLogs.get(i));
            if (insert != null) {
                successCount++;
            }
        }
        return successCount;
    }

    /**
     * abhs修改
     * @return
     */
    @Override
    public Integer abhsUpdate(RememberList rememberList) {
        return rememberListDao.update(rememberList);
    }


    @Override
    public List<Map<String, Object>> rememberList(Integer userId, DealState dealState, Date date){
        List<RememberList> rememberLists = this.rememberListDao.queryByUserId(userId);
        date = date == null?new Date():date;
        List<Map<String, Object>> listMap = new ArrayList<>();

        for (int i = 0; i < rememberLists.size(); i++) {
            RememberList rememberList = rememberLists.get(i);
            Integer iid = rememberList.getIid();
            List<RememberLog> rememberLogs1 = rememberLogDao.queryByRememberListIid(iid,dealState.getDealStateCode(),date);

            for (int j = 0; j < rememberLogs1.size(); j++) {
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("title", rememberList.getTitle());
                tempMap.put("content", rememberList.getContent());
                tempMap.put("rememberTime", new DateTime(rememberLogs1.get(j).getSendtime()));
                tempMap.put("finished", rememberLogs1.get(j).getFinished());
                listMap.add(tempMap);
            }
        }
        for (Map map : listMap) {
            System.out.println(map.toString());
        }
        return listMap;
    }
    /**
     *
     * @param userId
     * @return
     */
    @Override
    public List<Map<String, Object>> unfinished(Integer userId) {
       return rememberList(userId,DealState.UNFINISHED,new Date());
    }

    @Override
    public List<Map<String, Object>> finished(Integer userId) {
        return rememberList(userId,DealState.FINISHED,new Date());
    }

    @Override
    public List<Map<String, Object>> allRememberRecord(Integer userId) {
        return rememberList(userId,DealState.All,new Date());
    }


}
