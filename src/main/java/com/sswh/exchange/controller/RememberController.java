package com.sswh.exchange.controller;

import com.sswh.enumpackage.DealState;
import com.sswh.exchange.entity.RememberList;
import com.sswh.exchange.service.RememberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author nuanfeng
 * @date 2020/8/7 12:42
 */
@RestController
public class RememberController {

    @Autowired
    RememberService rememberService;

    @GetMapping("rememberlist")
    @CrossOrigin
    public List<Map<String, Object>> rememberList(int userId, @RequestParam("dealcode") Integer dealCode) {
        DealState dealState;
        switch (dealCode) {
            case 1:
                dealState = DealState.FINISHED;
                break;
            case 2:
                dealState = DealState.All;
                break;
            default:
                dealState = DealState.UNFINISHED;
        }
        return rememberService.rememberList(userId, dealState, new Date());
    }

    /**
     * 新增
     * @param rememberList
     */
    @PostMapping("addContent")
    @CrossOrigin
    public void addContent(RememberList rememberList, HttpServletResponse response){
        //response.addHeader("Access-Control-Allow-Origin","*");
        rememberService.abhsInsert(rememberList);
    }




}
