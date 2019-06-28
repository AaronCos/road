package com.sswh.entity;

/**
 * 权限表
 * Created by wangchengcheng on 2019/2/25
 */
public class PlatformRights {


    /**
     * 主键
     */
    private Integer iid;

    /**
     * 唯一标识（此标识只是用来确定层次关系）
     */
    private String codeId;

    /**
     * 父标识（此标识只是用来确定层次关系）
     */
    private String parentCodeId;

    /**
     * 模块标识
     */
    private String moduleId;

    /**
     * 模块名称
     */
    private String moduleName;

    /**
     * 功能标识
     */
    private String functionId;

    /**
     * 功能名称
     */
    private String functionName;

    /**
     * 动态id
     */
    private String dynamicId;

    /**
     * 类型（此参数为自由参数）
     */
    private String custom = "";

    public Integer getIid() {
        return iid;
    }

    public void setIid(Integer iid) {
        this.iid = iid;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getParentCodeId() {
        return parentCodeId;
    }

    public void setParentCodeId(String parentCodeId) {
        this.parentCodeId = parentCodeId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getDynamicId() {
        return dynamicId;
    }

    public void setDynamicId(String dynamicId) {
        this.dynamicId = dynamicId;
    }

    public String getCustom() {
        return custom;
    }

    public void setCustom(String custom) {
        this.custom = custom;
    }

    @Override public String toString() {
        return "PlatformRights{" + "iid=" + iid + ", codeId='" + codeId + '\'' + ", parentCodeId='" + parentCodeId
            + '\'' + ", moduleId='" + moduleId + '\'' + ", moduleName='" + moduleName + '\'' + ", functionId='"
            + functionId + '\'' + ", functionName='" + functionName + '\'' + ", dynamicId='" + dynamicId + '\''
            + ", custom='" + custom + '\'' + '}';
    }
}
