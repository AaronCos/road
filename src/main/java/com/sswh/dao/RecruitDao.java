package com.sswh.dao;

import com.sswh.entity.RecruitEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/3/22 22:31
 */
public interface RecruitDao {

    /**
     * 编写招聘信息
     * @param group 招聘实体
     * @return
     */
    int writeRecruit(RecruitEntity group);

    List<RecruitEntity> findAllRecruit();

    /**
     * 通过招聘标题获取招聘实体信息
     * @param title 标题
     * @return
     */
    List<RecruitEntity> findByTitle(String title);

    /**
     * 通过科目代号获取招聘信息实体
     * @param subjectBh 编号
     * @return
     */
    RecruitEntity findBySubjectBh(int subjectBh);

    /**
     * 修改展示状态
     * @param pageshow 是否展示
     * @param iid 招聘信息id
     * @return
     */
    int changePageShow(@Param("pageshow") int pageshow,@Param("iid") int iid);


    RecruitEntity findByIid(int iid);

    boolean updateRecruit(RecruitEntity groupEntity);

    void deleteRecruit(String[] ids);

}
