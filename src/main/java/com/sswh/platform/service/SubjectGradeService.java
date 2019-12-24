package com.sswh.platform.service;

import com.sswh.entity.SubjectGrade;
import java.util.List;

public interface SubjectGradeService {
    public List<SubjectGrade> findByFrontLoginname(String loginname);

    public List<SubjectGrade> findByFrontUsername(String username,String month);

    void updateSubjectGrade(String iid, String subject, String grade);

    boolean addSubjectGrade(String name, String month, String chinese, String math, String english, String biology, String physics, String chemistry, String history, String geography, String polity, String times, String grade);

    boolean deleteSubjectGrade(String ids);
}
