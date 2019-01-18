package com.sswh.web.controller;

import com.sswh.entity.User;
import com.sswh.service.UserService;
import com.sswh.utils.MD5;
import com.sswh.utils.UUIDUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource(name = "userService")
    private UserService userService;
    /**
     * ddfdsd
     *
     * @param user
     * @param veryCode
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping("/regist")
    public String regist(User user, String veryCode, HttpSession session) throws Exception {
        String veryCode1 = (String) session.getAttribute("verycode");
        //判断验证码
	/*	if(!veryCode1.equals(veryCode)){
			session.setAttribute("msg", "验证码输入错误！！！");
			session.setAttribute("registData", user);
			return "redirect:/page/register";
		}*/
        //将页面的年月日，传到birthday里面
        System.out.println("验证码相等");
        user.setId(UUIDUtils.getCode());
        //设置生日
        //user.setBirthday(String2Date.getDate(user.getYear(), user.getMonth(), user.getDay()));
        //设置状态
        user.setStatus(0);


        //        user.set
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
        System.out.printf("");
        System.out.println("veryCode1 = " + veryCode1);
        System.out.println("user = " + user);
        return "login";
    }


    //用户激活,页面请求可以直接过来
    @RequestMapping("/active")
    public String active(String code, String uid) {


        return null;
    }


}
