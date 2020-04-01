package com.sswh.platform.controller;

import com.sswh.platform.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("manager/evaluate")
public class ListEvaluationController {
    @Autowired
    EvaluationService evaluationService;

    @RequestMapping("/evaluationlist")
    public String membershow() {
        return "sswh/platform/center/evaluation-list";
    }
}
