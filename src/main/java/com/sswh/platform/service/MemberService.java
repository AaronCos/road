package com.sswh.platform.service;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sswh.front.dao.IFrontUserDao;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.front.entity.SchoolEntity;
import com.sswh.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: Aaron
 * @Description:
 * @Date Created in 12:56 2019/12/17
 * @Modeified by:
 */
@Service
public class MemberService {
    @Autowired
    IFrontUserDao frontUserDao;
    public Integer addMember(FrontUserEntity frontUserEntity){

        if (frontUserEntity != null) {
            if (StrUtil.isNotEmpty(frontUserEntity.getPassword())) {
                String password_salt = StringUtil.uuid();
                frontUserEntity.setPassword_salt(password_salt);
                frontUserEntity.setPassword(new Md5Hash(frontUserEntity.getPassword(), password_salt).toString());
            }
        }
        frontUserEntity.setJoinTime(new Date());
        Integer integer = frontUserDao.registUser(frontUserEntity);
        return integer;

    }

    public String organizeMemberJson() {
        List<FrontUserEntity> members = frontUserDao.findAllFrontUser();
        JSONObject jo = new JSONObject();
        SchoolEntity school = new SchoolEntity();
        school.setId(111);
        school.setTitle("这是什么奇葩");

        if (CollectionUtils.isEmpty(members)) {
            jo.put("code", 0);
            jo.put("msg","未查询到数据");
            jo.put("count", 0);
            jo.put("data", null);
        } else {
            for (FrontUserEntity member : members) {
                if ("0".equals(member.getSex())) {
                    member.setSex("女");
                }else{
                    member.setSex("男");
                }
                school.setTitle(member.getUsername());
                member.setDw_xinzhi(school);
            }
            jo.put("code", 0);
            jo.put("msg", "返回信息成功");
            jo.put("count", members.size());
            jo.put("data", members);
        }
        String originString = JSON.toJSONString(jo, SerializerFeature.DisableCircularReferenceDetect);
        JSONObject obj = JSON.parseObject(originString);
        JSONArray data = obj.getJSONArray("data");
        JSONArray array = new JSONArray();
        if (data!=null) {
            for (int i = 0; i < data.size(); i++) {
                JSONObject jsonObject = data.getJSONObject(i);
                //int iid = (int) jsonObject.get("iid");
                // jsonObject.put("id",iid+"");
                // jsonObject.remove("iid");
                //jsonObject.remove("isStudent");
                //String a = (String)jsonObject.get("joinTime");
                //jsonObject.put("joinTime",a.substring(0,10));
                array.add(jsonObject);
            }
        }
        jo.put("data",array);
        String newString = JSON.toJSONString(jo, SerializerFeature.DisableCircularReferenceDetect);
        return newString;
    }

    public void updateStatusOrIsStudent(String iid, String name, String state) {
        frontUserDao.updateStatusOrIsStudent(iid,name,state);
    }

    public List<FrontUserEntity> findFrontUsers(String username, String start, String end, int page, int limit) {

      List<FrontUserEntity> userList =   frontUserDao.findFrontUsers(username,start,end,page,limit);
      return userList;
    }

    public int findFrontUsersCount(String username, String start, String end) {

        int count =   frontUserDao.findFrontUsersCount(username,start,end);
        return count;
    }

    public boolean deleteFrontUser(String ids) {

        boolean flag = frontUserDao.deleteFrontUser(ids);
        return flag;
    }

    public FrontUserEntity findFrontUserByIid(String iid) {

        FrontUserEntity user =   frontUserDao.findFrontUserByIid(iid);
        return user;
    }

    public Boolean editUser(FrontUserEntity frontUser) {

        boolean flag = frontUserDao.editUser(frontUser);
        return flag;
    }

    public int findFrontUsersByName(String username) {

        int flag = frontUserDao.findFrontUsersByName(username);
        return flag;
    }
}
