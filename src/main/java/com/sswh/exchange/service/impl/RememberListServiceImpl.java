package com.sswh.exchange.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.sswh.Enum.Client;
import com.sswh.Enum.DealState;
import com.sswh.Enum.ResultState;
import com.sswh.exchange.dao.RememberListDao;
import com.sswh.exchange.entity.RememberList;
import com.sswh.exchange.entity.RememberLog;
import com.sswh.exchange.service.RememberListService;
import com.sswh.exchange.service.RememberLogService;
import com.sswh.utils.AbhsUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * (RememberList)表服务实现类
 *
 * @author makejava
 * @since 2020-08-05 19:18:51
 */
@Service("rememberListService")
public class RememberListServiceImpl implements RememberListService {
    @Resource
    private RememberListDao rememberListDao;

    @Resource
    private RememberLogService rememberLogService;

    public static void main(String[] args) {
        DateTime date = DateUtil.date();
        System.out.println(date);
        int i = date.weekOfMonth();
        System.out.println(i);
        int i1 = date.dayOfMonth();
        System.out.println(i1);
        int i2 = date.dayOfWeek();
        System.out.println(i2);
        long millis = DateUnit.DAY.getMillis();
        System.out.println(millis);

    }

    /**
     * 艾宾浩斯新增
     *
     * @param rememberList
     */
    @Override
    public synchronized int abhsInsert(RememberList rememberList) {

        RememberList result = insert(rememberList);
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
            rememberLog.setFinished(DealState.FINISHED.getDealStateCode());
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


    private Date[] produceAbhsTimeArray(Date initDate) {
        return null;
    }

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    @Override
    public RememberList queryById(Integer iid) {
        return this.rememberListDao.queryById(iid);
    }

    @Override
    public List<RememberList> queryByUserId(Integer userId) {
        List<RememberList> rememberLists = this.rememberListDao.queryByUserId(userId);

        List<RememberLog> rememberLogs = new ArrayList<>();
        List<Map<String, Object>> listMap = new ArrayList<>();

        for (int i = 0; i < rememberLists.size(); i++) {
            RememberList rememberList = rememberLists.get(i);
            Integer iid = rememberList.getIid();
            List<RememberLog> rememberLogs1 = rememberLogService.queryByRememberListIid(iid);
            for (int j = 0; j < rememberLogs1.size(); j++) {
                Map<String, Object> tempMap = new HashMap<>();
                tempMap.put("title",rememberList.getTitle());
                tempMap.put("content",rememberList.getContent());
                tempMap.put("rememberTime",new DateTime(rememberLogs1.get(j).getSendtime()));
                tempMap.put("finished",rememberLogs1.get(j).getFinished());
                listMap.add(tempMap);
            }
        }
        for (Map map: listMap
             ) {
            System.out.println(map.toString());

        }
        return rememberLists;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<RememberList> queryAllByLimit(int offset, int limit) {
        return this.rememberListDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param rememberList 实例对象
     * @return 实例对象
     */
    @Override
    public RememberList insert(RememberList rememberList) {
        this.rememberListDao.insert(rememberList);
        return rememberList;
    }

    /**
     * 修改数据
     *
     * @param rememberList 实例对象
     * @return 实例对象
     */
    @Override
    public RememberList update(RememberList rememberList) {
        this.rememberListDao.update(rememberList);
        return this.queryById(rememberList.getIid());
    }

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer iid) {
        return this.rememberListDao.deleteById(iid) > 0;
    }
}