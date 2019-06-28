package com.sswh.entity;

/**
 * 角色实体
 * Created by wangchengcheng on 2019/2/25
 */
public class PlatformRoles {

    /**
     * 主键
     */
    private Integer iid;

    /**
     * 角色名称
     */
    private String name;

    /**
     * 角色备注
     */
    private String spec;

    /**
     * 是否为缺省角色<br/>
     * 1 - 缺省角色 <br/>
     * 0 - 非缺省角色
     */
    private Integer isDefault;

    /**
     * 角色类型<br/>
     * 0 - 系统管理员<br/>
     * 1 - 机构管理员<br/>
     * 6 - 自定义角色<br/>
     * 其余2,3,4,5为系统保留类型
     */
    private Integer type;

    /**
     * 拼音的首字母
     */
    private String pinYin;


}
