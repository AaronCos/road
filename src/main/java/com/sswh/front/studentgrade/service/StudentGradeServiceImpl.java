package com.sswh.front.studentgrade.service;

import com.sswh.front.dao.IStudentGradeDao;
import com.sswh.utils.DateToolBag;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by wangchengcheng on 2019/6/30
 */
@Service
public class StudentGradeServiceImpl implements IStudentGradeService {
    @Autowired
    IStudentGradeDao studentGradeDao;

    @Override
    public List<List<String>> source(String username) {
        List<List<String>> result = new ArrayList<>();
        List<String> strings = null;
        List<String> mainSequences = studentGradeDao.queryMainSequeceListByUserName(username);
        if (mainSequences != null || mainSequences.size() > 0) {
            List<String> mainSubjectList = null;
            for (int i = 0; i < mainSequences.size(); i++) {
                mainSubjectList = studentGradeDao.queryMainSubjectListByMainSequece(mainSequences.get(i), username);
            }
            if (CollectionUtils.isNotEmpty(mainSubjectList)) {
                for (int j = 0; j < mainSubjectList.size(); j++) {//获取某科目成绩列表
                    List<String> scoreList = studentGradeDao.queryScoreListByMainSubject(mainSubjectList.get(j), username);
                    Collections.reverse(scoreList);
                    scoreList.add(0, mainSubjectList.get(j));
                    result.add(scoreList);
                }
            }
            List<Date> dates = studentGradeDao.querySubmitTimeByMainSequece(mainSequences);
            strings = DateToolBag.changeDatesListToStringList(dates);
            Collections.reverse(strings);
            strings.add(0, "考试时间");
        }
        result.add(0, strings);
        return result;
    }
}
