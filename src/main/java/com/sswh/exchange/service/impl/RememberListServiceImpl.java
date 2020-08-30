package com.sswh.exchange.service.impl;

import com.sswh.exchange.dao.RememberListDao;
import com.sswh.exchange.entity.RememberList;
import com.sswh.exchange.service.RememberListService;
import com.sswh.exchange.service.RememberLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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