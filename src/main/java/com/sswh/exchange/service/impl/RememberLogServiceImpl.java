package com.sswh.exchange.service.impl;

import com.sswh.exchange.dao.RememberLogDao;
import com.sswh.exchange.entity.RememberLog;
import com.sswh.exchange.service.RememberLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (RememberLog)表服务实现类
 *
 * @author makejava
 * @since 2020-08-06 19:42:05
 */
@Service("rememberLogService")
public class RememberLogServiceImpl implements RememberLogService {

    @Resource
    private RememberLogDao rememberLogDao;


    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    @Override
    public RememberLog queryById(Integer iid) {
        return this.rememberLogDao.queryById(iid);
    }

    /**
     * 查询元记录下当前需要背诵的任务
     * @param rememberListIid rembemberList表主键
     * @return
     */
    @Override
    public List<RememberLog> queryByRememberListIid(Integer rememberListIid) {
        return rememberLogDao.queryByRememberListIid(rememberListIid,0,new Date());
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<RememberLog> queryAllByLimit(int offset, int limit) {
        return this.rememberLogDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增记忆记录
     *
     * @param rememberLog 实例对象
     * @return 实例对象
     */
    @Override
    public RememberLog insert(RememberLog rememberLog) {
        this.rememberLogDao.insert(rememberLog);
        return rememberLog;
    }

    /**
     * 修改数据
     *
     * @param rememberLog 实例对象
     * @return 实例对象
     */
    @Override
    public RememberLog update(RememberLog rememberLog) {
        this.rememberLogDao.update(rememberLog);
        return this.queryById(rememberLog.getIid());
    }

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer iid) {
        return this.rememberLogDao.deleteById(iid) > 0;
    }
}