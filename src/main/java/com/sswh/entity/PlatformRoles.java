package com.sswh.entity;

/**
 * 角色实体
 * Created by AaronCos on 2019/2/25
 * @author AaronCos
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
     * 角色唯一编码
     */
    private String uuid;

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

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }
}
