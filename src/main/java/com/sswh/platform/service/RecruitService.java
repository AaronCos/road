package com.sswh.platform.service;

import com.sswh.entity.RecruitEntity;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/3/23 17:22
 */
public interface RecruitService {
    /**
     * 搜索所有的招聘信息
     *
     * @return
     */
    List<RecruitEntity> findAllRecruit();

    /**
     * 通过标题获取招聘信息
     *
     * @param title
     * @return
     */
    List<RecruitEntity> findByTitle(String title);


    RecruitEntity findByIid(int iid);

    /**
     * 通过课程编号获取该课程的招聘列表
     *
     * @param subjectBh 课程编号
     * @param pageshow  可以选泽获取展示和不展示的信息
     * @return 招聘列表
     */
    List<RecruitEntity> findBySubject(int subjectBh, int pageshow);

    /**
     * 新增Recruit
     *
     * @param recruitEntity
     * @return
     */
    int addRecruit(RecruitEntity recruitEntity);

    /**
     * 删除招聘信息
     * @param ids 选中的主键字符串
     * @return
     */
    boolean deleteRecruit(String ids);

    /**
     * 修改招聘信息
     * @param recruitEntity
     * @return
     */
    boolean updateRecruit(RecruitEntity recruitEntity);

};

