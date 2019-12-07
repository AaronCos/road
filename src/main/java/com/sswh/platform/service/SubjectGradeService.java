package com.sswh.platform.service;

import com.sswh.entity.SubjectGrade;
import java.util.List;

public interface SubjectGradeService {
    public List<SubjectGrade> findByFrontLoginname(String loginname);

    public List<SubjectGrade> findByFrontUsername(String username);

    void updateSubjectGrade(String iid, String subject, String grade);
}
