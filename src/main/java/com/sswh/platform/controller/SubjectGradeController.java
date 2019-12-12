package com.sswh.platform.controller;

import cn.hutool.json.JSONObject;
import com.sswh.entity.SubjectGrade;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.platform.service.SubjectGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping(value="subjectGrade")
public class SubjectGradeController {

    @Autowired
    SubjectGradeService gradeService;
    @RequestMapping(value="/subjectGradeList")
    public ModelAndView gotoGradeList() {
        System.out.println("hello world");
        ModelAndView modelAndView = new ModelAndView("sswh/platform/subjectGrade/subjectGradeList");
       // String loginname = "";
        //List<SubjectGrade> gradeList = gradeService.findByFrontLoginname(loginname);
       // modelAndView.addObject("gradeList",gradeList);
        return modelAndView;
    }

    @RequestMapping(value="/addStudentGrade")
    public ModelAndView addStudentGrade() {
        System.out.println("hello world");
        ModelAndView modelAndView = new ModelAndView("sswh/platform/subjectGrade/addStudentGrade");
        // String loginname = "";
        //List<SubjectGrade> gradeList = gradeService.findByFrontLoginname(loginname);
        // modelAndView.addObject("gradeList",gradeList);
        return modelAndView;
    }

    @RequestMapping(value="/findByFrontUsername",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject findByFrontUsername(String username,String month) {

        List<SubjectGrade> gradeList = gradeService.findByFrontUsername(username,month);
        System.out.println("size:"+gradeList.size());
        System.out.println("111111111112");
        JSONObject json = new JSONObject();
        json.put("code","0");
        json.put("msg","");
        json.put("count",gradeList.size());
        json.put("data", gradeList);

        return json;
    }

    @RequestMapping(value="/updateSubjectGrade")
    @ResponseBody
    public void updateSubjectGrade(String iid,String subject,String grade) {

        gradeService.updateSubjectGrade(iid,subject,grade);

    }

    @RequestMapping(value="/addSubjectGrade")
    @ResponseBody
    public JSONObject addSubjectGrade(String name,String month,String chinese,String math,String english,String biology,String physics,String chemistry,String history,String geography,String polity,String times) {

       boolean success =  gradeService.addSubjectGrade(name,month,chinese,math,english,biology,physics,chemistry,history,geography,polity,times);
       JSONObject json = new JSONObject();
        json.put("success",success);
        return json;
    }

    @RequestMapping(value="/deleteSubjectGrade")
    @ResponseBody
    public JSONObject deleteSubjectGrade(String ids) {

        boolean success =  gradeService.deleteSubjectGrade(ids);
        JSONObject json = new JSONObject();
        json.put("success",success);
        return json;
    }
}
