package com.sswh.platform.service.impl;

import com.sswh.dao.ISubjectGradeDao;
import com.sswh.entity.SubjectGrade;
import com.sswh.platform.service.SubjectGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SubjectGradeServiceImpl implements SubjectGradeService {
    @Autowired
    ISubjectGradeDao gradeDao;
    @Override
    public List<SubjectGrade> findByFrontLoginname(String loginname) {
        List<SubjectGrade> gradeList = gradeDao.findByFrontLoginname(loginname);
        return gradeList;
    }

    @Override
    public List<SubjectGrade> findByFrontUsername(String username,String month) {

        List<SubjectGrade> gradeList = gradeDao.findByFrontUsername(username,month);
        return gradeList;
    }

    @Override
    public void updateSubjectGrade(String iid, String subject, String grade) {

        gradeDao.updateSubjectGrade(iid,subject,grade);
    }

    @Override
    public boolean addSubjectGrade(String name, String month, String chinese, String math, String english, String biology, String physics, String chemistry, String history, String geography, String polity, String times, String grade) {
        boolean success = gradeDao.addSubjectGrade(name,month,chinese,math,english,biology,physics,chemistry,history,geography,polity,times,grade);
        return success;
    }

    @Override
    public boolean deleteSubjectGrade(String ids) {
        boolean success = gradeDao.deleteSubjectGrade(ids);
        return success;
    }
}
