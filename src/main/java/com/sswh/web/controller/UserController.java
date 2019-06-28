package com.sswh.web.controller;

import com.sswh.front.entity.FrontUserEntity;
import com.sswh.utils.MD5;
import com.sswh.utils.String2Date;
import com.sswh.utils.StringUtil;
import com.sswh.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {



    /**
     * 注册控制器
     *
     * @param user
     * @param veryCode
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/regist")
    public String regist(FrontUserEntity user, String veryCode, HttpSession session) throws Exception {
        String veryCode1 = (String) session.getAttribute("verycode");
        //判断验证码
        if (!veryCode1.toUpperCase().equals(veryCode.toUpperCase())) {
            session.setAttribute("msg", "验证码输入错误！！！");
            session.setAttribute("registData", user);
            return "/sswh/register";
        }
        //将页面的年月日，传到birthday里面
        user.setCode(UUIDUtils.getCode());
        //设置生日
        user.setBirthday(String2Date.getDate(user.getYear(), user.getMonth(), user.getDay()));
        //设置状态
        user.setStatus(0);
        //设置激活
        String address = user.getAddress();
        String code = user.getCode();
        String address1 = user.getAddress();
        String passWord = user.getPassWord();
        String day = user.getDay();
        String passWord1 = user.getPassWord();
        String hello2222 = user.getPassWord();
        String helo = user.getAddress();
        Date birthday = user.getBirthday();

        user.setCode(UUIDUtils.getCode());
        //设置密码  MD5加密密码
        user.setPassWord(MD5.md5(user.getPassWord()));
        System.out.println("veryCode1 = " + veryCode1);
        System.out.println("user = " + user);
//        userService.regist(user);
        return "login";
    }


    //用户激活,页面请求可以直接过来
    @RequestMapping("/active")
    public String active(String code, String uid) {


        return null;
    }

    @RequestMapping("/test")
    public void getByIid(String iid) {
        FrontUserEntity user = null;
//        try {
//            user = userService.getByIid(Integer.valueOf(iid));
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
//        System.out.printf("iid:" + user);
    }

    /**
     * 查询用户的列表
     */
    @RequestMapping("allUser")
    public void findAllUser() {
//        List<FrontUserEntity> allUser = userService.findAllUser();
//        for (int i = 0; i < allUser.size(); i++) {
//            System.out.printf("allUser:" + i + "--" + allUser.get(i));
//            System.out.println();
//        }
    }

    @RequestMapping("byiids")
    public String findByIids(String siids) {
        if(StringUtil.isEmpty(siids)){
            System.out.println("输入的iid为空");
            return "exception/error";
        }
        List<Integer> iids = StringUtil.strToNumList(siids);
//        List<FrontUserEntity> byIids = userService.findByIids(iids);
//        for (int i = 0; i < byIids.size(); i++) {
//            System.out.println("user" + i + ":" + byIids.get(i));
//        }
        return "exception/success";
    }
}
