package com.sswh;

import cn.hutool.core.util.StrUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.sswh.dao.IPlatformUserDao;
import com.sswh.entity.PlatformUser;
import com.sswh.front.dao.IFrontUserDao;
import com.sswh.front.dao.IStudentGradeDao;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.front.studentgrade.service.IStudentGradeService;
import com.sswh.platform.service.MemberService;
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
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wangchengcheng on 2019/1/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
public class SpringTest {
    @Autowired
    IPlatformUserDao pdao;
    @Autowired
    IStudentGradeDao studentGradeDao;
    @Autowired
    IStudentGradeService gradeService;
    @Autowired
    MemberService memberService;


    @Autowired
    IFrontUserDao frontUserDao;

    @Resource(name = "securityManager")
    SecurityManager securityManager;


    /**
     * jedis集群获取对象
     */
    @Autowired
    private ShardedJedisPool shardedJedisPool;

    /**
     * 测试hutool工具类
     */
    @Test
    public void testStrUtil() {
        System.out.println( StrUtil.equals("123", null));//false
        System.out.println(StrUtil.equals(null, null)); //true

        System.out.println(StrUtil.isEmpty(null)); //true
        System.out.println(StrUtil.isEmpty(""));   //true
    }

   @Test
    public void testjson(){
       String s = memberService.organizeMemberJson();
       System.out.println(s);
   }
   @Test
   public void testFrontUser(){
       FrontUserEntity wby12 = frontUserDao.findByLoginName("wby12");
       System.out.println("------------");
   }

    @Test
    public void testSet() {//
        if (shardedJedisPool==null) {
            System.out.println("aaron_kwe");
        }
        ShardedJedis jedis = shardedJedisPool.getResource();

        jedis.set("name", "test1");
        Boolean name = jedis.exists("name");
        List<String> strings = new ArrayList<>();
        strings.add("good");
        strings.add("morning");
        strings.add("zhangqingqing");
        String listName = "list";
        for (String value : strings) {
            jedis.lpush(listName,value);
        }
        List<String> lrange = jedis.lrange(listName, 0, 12);
        System.out.println(jedis.lrange(listName, 0, 12));
        jedis.set("pv",jedis.get("pv"));
        System.out.println(jedis.incrBy("pv",5));
        System.out.println(jedis.get("pv"));
        //   String name1 = jedis.getrange(listName, 0, 12);
       /// System.out.println(name1);
    }
    @Test
    public void regPattern(){
        String regExp = ".+(\\..+)$";
        Pattern p = Pattern.compile(regExp);
        Matcher matcher = p.matcher("hel.lo.doc");
        boolean b = matcher.find();
        if (b) {
            System.out.println(b);
        }
        System.out.println(matcher.group(0)+"---------"+matcher.group(1).substring(1));
    }

    @Test
    public void testStudentGrade(){
        /*List<String> aaron = studentGradeDao.queryMainSubjectListByMainSequece("000001", "aaron");
        List<String> mainSequences = studentGradeDao.queryMainSequeceListByUserName("aaron");
        Float floats = studentGradeDao.queryScoreByMainSubject("000001", "语文", "aaron");
        List<Map> mapScoreList = studentGradeDao.queryScoreListMapByMainSubject("语文", "aaron");
        System.out.println(mapScoreList.get(0).get("scores"));
        List<Date> dates = studentGradeDao.querySubmitTimeByMainSubject("语文", "aaron");
        List<String> strings = DateToolBag.changeDatesListToStringList(dates);
        System.out.println(strings.toString());*/
        List<List<String>> aaron1 = gradeService.source("aaron");
        String s = JSONUtils.toJSONString(aaron1);
        System.out.println(s);
    }


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
