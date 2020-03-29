package com.sswh.platform.controller;

import com.sswh.entity.RecruitEntity;
import com.sswh.platform.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *  TODO: 招聘信息的编辑页面
 * 前台招聘信息后台编辑控制器
 * @author Aaron
 * @date 2020/3/6 22:51
 */
@Controller
@RequestMapping("recruit")
public class OprRecruitController {

    @Autowired
    RecruitService recruitService;


    @RequestMapping("showadd")
    public ModelAndView showAdd(){
        ModelAndView mv = new ModelAndView("sswh/platform/center/recruit-opr");
        mv.addObject("url","add.do");
        return mv;
    }

    @RequestMapping("showedit")
    public ModelAndView showEdit(int iid){
        ModelAndView mv = new ModelAndView("sswh/platform/center/recruit-opr");
        RecruitEntity recruit = recruitService.findByIid(iid);
        mv.addObject("recruit",recruit);
        mv.addObject("url","edit.do");
        return mv;
    }

    @RequestMapping("add")
    @ResponseBody
    public String addRecruit(RecruitEntity recruitEntity){
        int i = recruitService.addRecruit(recruitEntity);
        return "success";
    }
    @RequestMapping("delete")
    @ResponseBody
    public String deleteRecruit(String ids){
        recruitService.deleteRecruit(ids);
        return "success";
    }

    @RequestMapping("edit")
    public void editRecruit(RecruitEntity recruitEntity){


    }


}
