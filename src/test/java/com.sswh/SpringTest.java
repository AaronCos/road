package com.sswh;

import com.sswh.platform.dao.PlatformUserDao;
import com.sswh.platform.entity.PlatformUserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
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
    @Resource
    PlatformUserDao pdao;

    @Test
    public void hello() {
        System.out.println("hello spring test");
    }

    @Test
    public void registUser() {
        PlatformUserEntity puser = new PlatformUserEntity("wang9", "qwer");
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
        PlatformUserEntity puser = null;
        ArrayList<PlatformUserEntity> pes = new ArrayList<>();
        for (int i = 5; i < 10; i++) {
            puser = new PlatformUserEntity("wang" + i, "qwer");
            pes.add(puser);
        }
        pdao.registUsers(pes);
    }

    @Test
    public void findByIid() {
        PlatformUserEntity user = pdao.findByIid(1l);
        System.out.println("用户中心:" + user.toString());
    }

    @Test
    public void findByIids() {
        List<Integer> iids = new ArrayList<>();
        iids.add(1);
        iids.add(5);
        iids.add(3);
        List<PlatformUserEntity> byIids = pdao.findByIids(iids);
        for (int i = 0; i < byIids.size(); i++) {
            System.out.println(byIids.get(i));
        }

    }

    @Test
    public void findByUserName() {
        PlatformUserEntity wang7 = pdao.findByUserName("wang7");
        System.out.println("wang:" + wang7.toString());
    }

    @Test
    public void findByIdCard() {
        PlatformUserEntity byIdCard = pdao.findByIdCard("32092119921");
        System.out.println("idCard:" + byIdCard.toString());
    }
}
