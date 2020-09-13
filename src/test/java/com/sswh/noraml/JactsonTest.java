package com.sswh.noraml;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * json解析数据
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件
public class JactsonTest {


    @Test
    public void testIo() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String sample = "我是一个字符串";
        String s = objectMapper.writeValueAsString(sample);
    }
    @Test
    public void testData(){
        List<Integer> zhengChang = new ArrayList<>();
        List<Integer> tingYe = new ArrayList<>();
        List<Integer> zhuXiao = new ArrayList<>();
        List<Integer> xieYe = new ArrayList<>();

        Map<String, Map> citykeyMap = new HashMap<>();

        String [] citys = {"南京","苏州","无锡","常州","镇江","南通","扬州","泰州","徐州","淮安","宿迁","盐城","连云港"};

        String [] state = {"正常","停业","注销","歇业"};

        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("pageNum", "1");
        JSONObject jsonObject = (JSONObject) JSONObject.parse(content);
        System.out.println(jsonObject.get("code"));
        Integer code = (Integer) jsonObject.get("code");
        if (code.equals(200)) {
            String data = jsonObject.getString("data");
            if (data.isEmpty()) {
                return;
            }
            JSONArray jsonArray = JSONArray.parseArray(data);
            if (jsonArray != null) {
                for (int i = 0; i < jsonArray.size(); i++) {
                    String orgCompanySnm = jsonArray.getJSONObject(i).getString("orgCompanySnm");
                    String cuLicstatusNm = jsonArray.getJSONObject(i).getString("cuLicstatusNm");
                    String num = jsonArray.getJSONObject(i).getString("num");
                    if (citykeyMap.containsKey(orgCompanySnm)){
                        citykeyMap.get(orgCompanySnm).put(cuLicstatusNm,num);
                    }else{
                        Map<String, String> stateMap = new HashMap<>();
                        stateMap.put(cuLicstatusNm,num);
                        citykeyMap.put(orgCompanySnm,stateMap);
                    }
                }
            }
            zhengChang = acqDataArray(citykeyMap, zhengChang, citys, state[0]);
            tingYe = acqDataArray(citykeyMap, tingYe, citys, state[1]);
            zhuXiao = acqDataArray(citykeyMap, zhuXiao, citys, state[2]);
            xieYe = acqDataArray(citykeyMap, xieYe, citys, state[3]);
            sys(zhengChang);
            sys(tingYe);
            sys(zhuXiao);
            sys(xieYe);


        }

    }
    private void sys(List<Integer> list){
        for (Integer integer : list) {
            System.out.printf(" "+integer);
        }
        System.out.println();
    }
    private List<Integer> acqDataArray(Map<String, Map> citykeyMap, List<Integer> zhengChang, String[] citys, String key) {
        for (int i = 0; i < citys.length; i++) {
            Map map = citykeyMap.get(citys[i]);
            int num;
            try {
                num = Integer.parseInt((String) map.get(key));
            } catch (NumberFormatException e) {
                num = 0;
            }
            zhengChang.add(i,num);
        }
        return zhengChang;
    }

    class AllowCerification implements Serializable {
        /**
         * "dtMonthId":"月份"
         */
        private String dtMonthId;
        /**
         * "dtDayId":"查询日期"
         */
        private String dtDayId;
        /**
         * "orgCompanyId":"公司id"
         */
        private String orgCompanyId;
        /**
         * "orgCompanySnm":"公司名称"
         */
        private String orgCompanySnm;
        /**
         * 许可证状态，正常、注销、停业、歇业"
         */
        private String cuLicstatusNm;
        /**
         * "sortNbr":"公司排序号"
         */
        private String sortNbr;
        /**
         * "num":"许可证个数"
         */
        private String num;


        public String getDtMonthId() {
            return dtMonthId;
        }

        public void setDtMonthId(String dtMonthId) {
            this.dtMonthId = dtMonthId;
        }

        public String getDtDayId() {
            return dtDayId;
        }

        public void setDtDayId(String dtDayId) {
            this.dtDayId = dtDayId;
        }

        public String getOrgCompanyId() {
            return orgCompanyId;
        }

        public void setOrgCompanyId(String orgCompanyId) {
            this.orgCompanyId = orgCompanyId;
        }

        public String getOrgCompanySnm() {
            return orgCompanySnm;
        }

        public void setOrgCompanySnm(String orgCompanySnm) {
            this.orgCompanySnm = orgCompanySnm;
        }

        public String getCuLicstatusNm() {
            return cuLicstatusNm;
        }

        public void setCuLicstatusNm(String cuLicstatusNm) {
            this.cuLicstatusNm = cuLicstatusNm;
        }

        public String getSortNbr() {
            return sortNbr;
        }

        public void setSortNbr(String sortNbr) {
            this.sortNbr = sortNbr;
        }

        public String getNum() {
            return num;
        }

        public void setNum(String num) {
            this.num = num;
        }
    }


    class Friend{
        private int iid;
        private String name;
        private int age;

        public Friend() {
        }

        public Friend(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getIid() {
            return iid;
        }

        public void setIid(int iid) {
            this.iid = iid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Friend{" +
                    "iid=" + iid +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }





    public String content = "{\n" +
            "  \"code\": 200,\n" +
            "  \"message\": \"返回\",\n" +
            "  \"data\": [\n" +
            "    {\n" +
            "      \"sortNbr\": \"1\",\n" +
            "      \"orgCompanyId\": \"3820001\",\n" +
            "      \"orgCompanySnm\": \"南京\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"2628\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"1\",\n" +
            "      \"orgCompanyId\": \"3820001\",\n" +
            "      \"orgCompanySnm\": \"南京\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"24379\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"1\",\n" +
            "      \"orgCompanyId\": \"3820001\",\n" +
            "      \"orgCompanySnm\": \"南京\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"29972\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"2\",\n" +
            "      \"orgCompanyId\": \"3820005\",\n" +
            "      \"orgCompanySnm\": \"苏州\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"32\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"2\",\n" +
            "      \"orgCompanyId\": \"3820005\",\n" +
            "      \"orgCompanySnm\": \"苏州\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"44651\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"2\",\n" +
            "      \"orgCompanyId\": \"3820005\",\n" +
            "      \"orgCompanySnm\": \"苏州\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"92555\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"3\",\n" +
            "      \"orgCompanyId\": \"3820002\",\n" +
            "      \"orgCompanySnm\": \"无锡\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"439\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"3\",\n" +
            "      \"orgCompanyId\": \"3820002\",\n" +
            "      \"orgCompanySnm\": \"无锡\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"26504\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"3\",\n" +
            "      \"orgCompanyId\": \"3820002\",\n" +
            "      \"orgCompanySnm\": \"无锡\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"32152\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"4\",\n" +
            "      \"orgCompanyId\": \"3820004\",\n" +
            "      \"orgCompanySnm\": \"常州\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"165\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"4\",\n" +
            "      \"orgCompanyId\": \"3820004\",\n" +
            "      \"orgCompanySnm\": \"常州\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"21706\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"4\",\n" +
            "      \"orgCompanyId\": \"3820004\",\n" +
            "      \"orgCompanySnm\": \"常州\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"31486\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"5\",\n" +
            "      \"orgCompanyId\": \"3821001\",\n" +
            "      \"orgCompanySnm\": \"镇江\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"226\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"5\",\n" +
            "      \"orgCompanyId\": \"3821001\",\n" +
            "      \"orgCompanySnm\": \"镇江\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"17376\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"5\",\n" +
            "      \"orgCompanyId\": \"3821001\",\n" +
            "      \"orgCompanySnm\": \"镇江\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"29952\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"6\",\n" +
            "      \"orgCompanyId\": \"3820006\",\n" +
            "      \"orgCompanySnm\": \"南通\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"1292\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"6\",\n" +
            "      \"orgCompanyId\": \"3820006\",\n" +
            "      \"orgCompanySnm\": \"南通\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"34317\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"6\",\n" +
            "      \"orgCompanyId\": \"3820006\",\n" +
            "      \"orgCompanySnm\": \"南通\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"35785\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"7\",\n" +
            "      \"orgCompanyId\": \"3820010\",\n" +
            "      \"orgCompanySnm\": \"扬州\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"302\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"7\",\n" +
            "      \"orgCompanyId\": \"3820010\",\n" +
            "      \"orgCompanySnm\": \"扬州\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"23012\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"7\",\n" +
            "      \"orgCompanyId\": \"3820010\",\n" +
            "      \"orgCompanySnm\": \"扬州\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"25598\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"8\",\n" +
            "      \"orgCompanyId\": \"3820013\",\n" +
            "      \"orgCompanySnm\": \"泰州\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"482\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"8\",\n" +
            "      \"orgCompanyId\": \"3820013\",\n" +
            "      \"orgCompanySnm\": \"泰州\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"26389\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"8\",\n" +
            "      \"orgCompanyId\": \"3820013\",\n" +
            "      \"orgCompanySnm\": \"泰州\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"23028\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"9\",\n" +
            "      \"orgCompanyId\": \"3820003\",\n" +
            "      \"orgCompanySnm\": \"徐州\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"2600\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"9\",\n" +
            "      \"orgCompanyId\": \"3820003\",\n" +
            "      \"orgCompanySnm\": \"徐州\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"53782\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"9\",\n" +
            "      \"orgCompanyId\": \"3820003\",\n" +
            "      \"orgCompanySnm\": \"徐州\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"50691\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"10\",\n" +
            "      \"orgCompanyId\": \"3820008\",\n" +
            "      \"orgCompanySnm\": \"淮安\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"575\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"10\",\n" +
            "      \"orgCompanyId\": \"3820008\",\n" +
            "      \"orgCompanySnm\": \"淮安\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"24273\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"10\",\n" +
            "      \"orgCompanyId\": \"3820008\",\n" +
            "      \"orgCompanySnm\": \"淮安\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"27387\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"11\",\n" +
            "      \"orgCompanyId\": \"3820012\",\n" +
            "      \"orgCompanySnm\": \"宿迁\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"1383\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"11\",\n" +
            "      \"orgCompanyId\": \"3820012\",\n" +
            "      \"orgCompanySnm\": \"宿迁\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"24285\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"11\",\n" +
            "      \"orgCompanyId\": \"3820012\",\n" +
            "      \"orgCompanySnm\": \"宿迁\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"35867\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"12\",\n" +
            "      \"orgCompanyId\": \"3820009\",\n" +
            "      \"orgCompanySnm\": \"盐城\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"854\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"12\",\n" +
            "      \"orgCompanyId\": \"3820009\",\n" +
            "      \"orgCompanySnm\": \"盐城\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"39437\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"12\",\n" +
            "      \"orgCompanyId\": \"3820009\",\n" +
            "      \"orgCompanySnm\": \"盐城\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"36842\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"13\",\n" +
            "      \"orgCompanyId\": \"3820007\",\n" +
            "      \"orgCompanySnm\": \"连云港\",\n" +
            "      \"cuLicstatusNm\": \"停业\",\n" +
            "      \"num\": \"1845\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"13\",\n" +
            "      \"orgCompanyId\": \"3820007\",\n" +
            "      \"orgCompanySnm\": \"连云港\",\n" +
            "      \"cuLicstatusNm\": \"正常\",\n" +
            "      \"num\": \"25273\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"sortNbr\": \"13\",\n" +
            "      \"orgCompanyId\": \"3820007\",\n" +
            "      \"orgCompanySnm\": \"连云港\",\n" +
            "      \"cuLicstatusNm\": \"注销\",\n" +
            "      \"num\": \"26839\",\n" +
            "      \"dtMonthId\": \"202009\",\n" +
            "      \"dtDayId\": \"20200902\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"count\": \"39\"\n" +
            "}";







}
