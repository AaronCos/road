package com.sswh;

import com.sswh.dao.IPlatformUserDao;
import com.sswh.entity.PlatformUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangchengcheng on 2019/1/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
public class SpringTest {
    @Autowired
    IPlatformUserDao pdao;


    @Resource(name = "securityManager")
    SecurityManager securityManager;


   /* @BeforeClass
    public void setShiro() {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        StandaloneMockMvcBuilder builder = MockMvcBuilders.standaloneSetup(context);
        builder.addFilters((Filter) context.getBean("shiroFilter"));

    }*/

    @Test
    public void testCustomRealm(){


        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("mark", "qwer1234");
        subject.login(token);
        subject.isAuthenticated();

    }
    @Test
    public void hello() {
        System.out.println("hello spring test");
    }


    @Test
    public void registUser() {
        PlatformUser puser = new PlatformUser();
        puser.setMobilePhone("2373230956");
        puser.setIdCard("3209211993");
        Integer integer = pdao.registUser(puser);
        System.out.println("插入成功后的返回值：" + integer);
    }

    /**
     * 批量插入用户
     */
    @Test
    public void registUsers() {
        PlatformUser puser = null;
        ArrayList<PlatformUser> pes = new ArrayList<PlatformUser>();
        for (int i = 5; i < 10; i++) {
            puser = new PlatformUser();
            pes.add(puser);
        }
        pdao.registUsers(pes);
    }

    @Test
    public void findByIid() {
        PlatformUser user = pdao.findByIid(1l);
        System.out.println("用户中心:" + user.toString());
    }

    @Test
    public void findByIids() {
        List<Integer> iids = new ArrayList<Integer>();
        iids.add(1);
        iids.add(5);
        iids.add(3);
        List<PlatformUser> byIids = pdao.findByIids(iids);
        for (int i = 0; i < byIids.size(); i++) {
            System.out.println(byIids.get(i));
        }

    }

    @Test
    public void findByUserName() {
        PlatformUser wang7 = pdao.findByUsername("wang7");
        System.out.println("wang:" + wang7.toString());
    }

    @Test
    public void findByIdCard() {
        PlatformUser byIdCard = pdao.findByIdCard("32092119921");
        System.out.println("idCard:" + byIdCard.toString());
    }
    @Test
    public void getMdt(){
        Md5Hash md5Hash = new Md5Hash("qwer1234","dab4d1f5e7a94b7c8b927aebef6ee8d4");
        System.out.println(md5Hash.toString());
    }


}
