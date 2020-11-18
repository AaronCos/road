package com.sswh.noraml;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.alibaba.druid.support.json.JSONUtils;
import com.sswh.dao.PlatformUserDao;
import com.sswh.dao.RecruitDao;
import com.sswh.entity.PlatformUser;
import com.sswh.enumpackage.AbhsTimeUnit;
import com.sswh.exchange.dao.RememberLogDao;
import com.sswh.exchange.entity.RememberList;
import com.sswh.exchange.entity.RememberLog;
import com.sswh.exchange.service.RememberService;
import com.sswh.exchange.service.impl.RememberListServiceImpl;
import com.sswh.exchange.service.impl.RememberLogServiceImpl;
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
import java.util.Date;
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
    PlatformUserDao pdao;
    @Autowired
    IStudentGradeDao studentGradeDao;
    @Autowired
    IStudentGradeService gradeService;
    @Autowired
    MemberService memberService;
    @Autowired
    RecruitDao groupDao;
    @Autowired
    IFrontUserDao frontUserDao;

    @Resource(name = "securityManager")
    SecurityManager securityManager;

    @Autowired
    RememberLogDao rememberLogDao;

    @Autowired
    RememberLogServiceImpl rememberLogService;

    @Autowired
    RememberListServiceImpl rememberListService;

    @Autowired
    RememberService rememberService;

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
        RememberList rememberList = new RememberList();
        rememberList.setTitle("将进酒");
        rememberList.setContent("《将进酒》\n" +
                "李白\n" +
                "君不见， \n" +
                "黄河之水天上来，奔流到海不复回。 \n" +
                "君不见，\n" +
                " 高堂明镜悲白发，朝如青丝暮成雪。 \n" +
                "人生得意须尽欢，莫使金樽空对月。 \n" +
                "天生我材必有用，千金散尽还复来。 \n" +
                "烹羊宰牛且为乐，会须一饮三百杯。 \n" +
                "岑夫子，丹丘生，将进酒，杯莫停。 \n" +
                "与君歌一曲，请君为我倾耳听。\n" +
                " 钟鼓馔玉不足贵，但愿长醉不复醒。 \n" +
                "古来圣贤皆寂寞，惟有饮者留其名。\n" +
                " 陈王昔时宴平乐，斗酒十千恣欢谑。 \n" +
                "主人何为言少钱，径须沽取对君酌。 \n" +
                "五花马，千金裘， \n" +
                "呼儿将出换美酒，与尔同销万古愁");
        rememberList.setCreatetime(new Date());
        rememberList.setUpdatetime(null);
        rememberList.setUserid(7788);
        rememberService.abhsInsert(rememberList);

    }

    /**
     * 查询未复习的记录
     */
    @Test
    public void testReadRememberLists(){
        //List<RememberList> rememberLists = rememberService.unfinished(7788);
        //Assert.assertEquals(rememberLists.size(),4 );
    }


    @Test
    public void testDao(){

        RememberList rememberList = new RememberList();
        rememberList.setTitle("news");
        rememberList.setCreatetime(new Date());
        rememberList.setUpdatetime(null);
        rememberList.setUserid(12345);
        RememberList result = rememberListService.insert(rememberList);

        int rememberListIid = result.getIid();


        List<RememberLog> rememberLogs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            RememberLog rememberLog = new RememberLog();
            rememberLog.setRememberListIid(rememberListIid);
            rememberLog.setSendtime(new Date());
            rememberLog.setClient(1);
            rememberLog.setResult(1);
            rememberLog.setFinished(0);
            rememberLogs.add(rememberLog);
        }
        for (int i = 0; i < rememberLogs.size(); i++) {
            rememberLogService.insert(rememberLogs.get(i));
        }





      /*  List<RememberLog> rememberLogs = rememberLogService.queryAllByLimit(0, 10);
        System.out.println(rememberLogs);
        Date sendtime = rememberLogs.get(0).getSendtime();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        String format = df.format(sendtime);
        System.out.println(format);*/

/*rememberLogService
        RecruitEntity group = groupDao.findRecruit(com.sswh.Enum.Subject.CHINESE);
        System.out.println("----");*/
    }
    @Test
    public void testMonth(){
        int[] days = {1,2,5,7,8,9};
        Date initDate = new Date();
        List<DateTime> dates = new ArrayList<>();
        long current = DateUtil.current(false);

        long after20 = 0L;
        after20 = current + AbhsTimeUnit.MINUTE.getMillis()*20; //20分钟后
        DateTime dateTime = new DateTime(after20);
        dates.add(dateTime);

        //System.out.println(dateTime);
        for (int i = 0; i < days.length; i++) {
            long temp = current;
            temp = temp + AbhsTimeUnit.DAY.getMillis()*days[i];
            DateTime dateTimeTemp = new DateTime(temp);
            dates.add(dateTimeTemp);
        }
        for (int i = 0; i < dates.size(); i++) {
            System.out.println(dates.get(i));
        }


    }


   @Test
    public void testjson(){
       String s = memberService.organizeMemberJson();
       System.out.println(s);
   }
   @Test
   public void testSax(){
        String path = "E:\\catbywhere\\project2019\\江苏省_烟草专卖局\\code\\Assistant\\WebContent\\WEB-INF\\config\\jsyc\\line.xml";



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
