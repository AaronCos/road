package com.sswh.entity;

/**
 * Created by nuanfeng on 2019/3/10
 */
public class PlatformGroup {


    /**
     * 主键
     */
    private Integer iid;

    /**
     * 机构名称
     */
    private String name;

    /**
     * 机构描述
     */
    private String spec;

    /**
     * 父id
     */
    private Integer pid;

    /**
     * 父机构名称
     */
    private String pname;

    /**
     * 机构编码
     */
    private String codeId;

    /**
     * 排序号
     */
    private Integer orderid = 0;

    /**
     * 拼音的首字母
     */
    private String pinYin;

    /**
     * 附加属性 不计入数据库
     */

    /**
     * 父机构编码
     */
    private String parCodeid = "";

    /**
     * 是否有下属机构
     */
    private Boolean isParent = false;
    /**
     * 机构级别
     * @return
     */
    private Integer level = 0;

    /**
     * 部门负责人id
     * @return
     */
    private Integer userid = 0;

    /**
     * 部门负责人姓名
     * @return
     */
    private String userName = "";

    /**
     * 是否显示在通讯录
     * @return
     */
    private Integer contactshow = 1;

    /**
     * 是否可删除
     * @return
     */
    private Integer canDelete;
}
