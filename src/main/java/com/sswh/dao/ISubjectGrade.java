package com.sswh.dao;

import com.sswh.entity.SubjectGrade;

import java.util.List;

/**
 * @Author: WangChengCheng
 * @Description:
 * @Date Created in 16:21 2019/11/24
 * @Modeified by:
 */
public interface ISubjectGrade {
    /**
     * 根据用户名查询成绩列表
     * @param username 用户名
     * @return 各科成绩实体列表
     */
    List<SubjectGrade> findByFrontUsername(String username);

    /**
     * 查询所有各科成绩列表
     * @return 各科成绩实体列表
     */
    List<SubjectGrade> findAllSubjectGrade();

    /**
     * 插入一条成绩信息
     * @param subjectGrade  成绩实体，该成绩实体必须含有用户的uuid
     * @return
     */
    int insertByFrontUserUuid(SubjectGrade subjectGrade);

    /**
     * 批量插入成绩信息，主要用于导入
     * @param subjectGrades
     * @return 返回插入成功的条数
     */
    int insertListByFrontUserUuid(List<SubjectGrade> subjectGrades);

    /**
     * 删除一条成绩信息
     * @param gradeUuid 成绩唯一键
     * @return >0 表示删除成功
     */
    int deleteByGradeUuid(String gradeUuid);

    /**
     * 批量删除多条信息
     * @param gradeUuids 成绩唯一键列表
     * @return 成功删除的条数
     */
    int deleteByGradeUuids(List<String> gradeUuids);

    /**
     * 根据当前信息的uuid,更新成绩
     * @param userUuid
     * @return
     */
    int updateByFrontUserUuid(String userUuid);


}
