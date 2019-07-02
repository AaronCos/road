package com.sswh.front.dao;

import com.sswh.front.entity.StudentGradeEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by wangchengcheng on 2019/6/30
 */
public interface IStudentGradeDao {
    /**
     * 插入学生成绩
     * @param studentGrade 学生成绩实体
     * @return
     */
    Integer insertGrade(StudentGradeEntity studentGrade);
    /**
     * 根据用户名返回主序列列表，按升序排列
     * @param username 用户名
     * @return 主批次列表
     */
    List<String> queryMainSequeceListByUserName(String username);

    /**
     * 通过用户名和主批次查询该批次下的科目列表
     * @param mainSequence
     * @param username
     * @return
     */
    List<String> queryMainSubjectListByMainSequece(@Param("mainSequence") String mainSequence,@Param("username") String username);

    /**
     * 通过科目名称和用户名和批次号查寻分数
     * @param mainSubject
     * @return
     */
    Float queryScoreByMainSubject(String mainSequence,String mainSubject,String username);

    /**
     * 查询所有批次单科成绩列表
     * @param mainSubject
     * @param username
     * @return
     */
    List<Map> queryScoreListMapByMainSubject(String mainSubject, String username);
    List<String> queryScoreListByMainSubject(String mainSubject, String username);

    /**
     * 同一科目的时间序列
     * @param mainSubject
     * @param username
     * @return
     */
    List<Date> querySubmitTimeByMainSubject(String mainSubject, String username);

    /**
     * 根据批次列表获取对应的时间列表
     * @param seq
     * @return
     */
    List<Date> querySubmitTimeByMainSequece(List<String> seq);

}
