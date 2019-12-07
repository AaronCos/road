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
    public List<SubjectGrade> findByFrontUsername(String username) {

        List<SubjectGrade> gradeList = gradeDao.findByFrontUsername(username);
        return gradeList;
    }

    @Override
    public void updateSubjectGrade(String iid, String subject, String grade) {

        gradeDao.updateSubjectGrade(iid,subject,grade);
    }
}
