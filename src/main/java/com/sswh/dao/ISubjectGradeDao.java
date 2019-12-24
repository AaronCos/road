package com.sswh.dao;

import com.sswh.entity.SubjectGrade;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author: WangChengCheng
 * @Description:
 * @Date Created in 16:21 2019/11/24
 * @Modeified by:
 */
public interface ISubjectGradeDao {
    /**
     * 根据登录名查询成绩列表
     * @param loginname 登录名
     * @return 各科成绩实体列表
     */
    List<SubjectGrade> findByFrontLoginname(String loginname);

    /**
     * 根据用户名查询成绩列表
     * @param username 登录名
     * @return 各科成绩实体列表
     */
    List<SubjectGrade> findByFrontUsername(@Param("username") String username,@Param("month") String month);

    /**
     * 查询所有各科成绩列表
     * @return 各科成绩实体列表
     */
    List<SubjectGrade> findAllSubjectGrade();

    /**
     * 插入一条成绩信息
     * @param subjectGrade  成绩实体，该成绩实体必须含有用户的登录名loginname
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
     * 根据当前信息的gradeUuid,更新成绩
     * @param subjectGrade 此实体中必须包含 gradeUuid
     * @return
     */
    int updateByFrontUserUuid(SubjectGrade subjectGrade);


    void updateSubjectGrade(@Param("iid") String iid,@Param("subject") String subject,@Param("grade") String grade);

    boolean addSubjectGrade(@Param("name") String name, @Param("month") String month, @Param("chinese") String chinese, @Param("math") String math,
                            @Param("english") String english, @Param("biology") String biology, @Param("physics") String physics, @Param("chemistry") String chemistry,
                            @Param("history") String history, @Param("geography") String geography, @Param("polity") String polity, @Param("times") String times, @Param("grade")String grade);

    boolean deleteSubjectGrade( @Param("ids")String ids);
}
