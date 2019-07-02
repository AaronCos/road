package com.sswh.front.studentgrade.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.sswh.front.studentgrade.service.IStudentGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wangchengcheng on 2019/6/30
 */
@Controller
public class StudentGradeController {
    @Autowired
    IStudentGradeService studentGradeService;

    @RequestMapping(value = "gradeShow")
    public ModelAndView showCountPage(String username){
        ModelAndView mv = new ModelAndView("front/count");
        List<List<String>> source = studentGradeService.source(username);
        String s = JSONUtils.toJSONString(source);
        mv.addObject("source",s);
        return mv;
    }

}
