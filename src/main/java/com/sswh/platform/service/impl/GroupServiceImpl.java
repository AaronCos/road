package com.sswh.platform.service.impl;

import com.sswh.dao.PlatformGroupDao;
import com.sswh.entity.PlatformGroup;
import com.sswh.platform.service.GroupService;
import com.sswh.utils.core.StrUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (PlatformGroup)表服务实现类
 *
 * @author makejava
 * @since 2020-06-14 13:40:01
 */
@Service("platformGroupService")
public class GroupServiceImpl implements GroupService {


    @Resource
    private PlatformGroupDao platformGroupDao;

    /**
     * 通过ID查询单条数据
     *
     * @param iid 主键
     * @return 实例对象
     */
    @Override
    public PlatformGroup queryById(Integer iid) {
        return this.platformGroupDao.queryById(iid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<PlatformGroup> queryAllByLimit(int offset, int limit) {
        return this.platformGroupDao.queryAllByLimit(offset, limit);
    }

    @Override
    public List<PlatformGroup> queryAll(PlatformGroup group) {
        return this.platformGroupDao.queryAll(group);
    }

    /**
     * 新增数据
     *
     * @param platformGroup 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformGroup insert(PlatformGroup platformGroup) {
        this.platformGroupDao.insert(platformGroup);
        return platformGroup;
    }

    /**
     * 修改数据
     *
     * @param platformGroup 实例对象
     * @return 实例对象
     */
    @Override
    public PlatformGroup update(PlatformGroup platformGroup) {
        this.platformGroupDao.update(platformGroup);
        return this.queryById(platformGroup.getIid());
    }

    /**
     * 通过主键删除数据
     *
     * @param iid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer iid) {
        return this.platformGroupDao.deleteById(iid) > 0;
    }

    @Override
    public boolean deleteByIds(String iids) {
        if (iids.isEmpty()) {
            return false;
        }
        int i = this.platformGroupDao.deleteByIds(StrUtil.idsToList(iids, ","));
        return i>0 ? true : false;
    }


}