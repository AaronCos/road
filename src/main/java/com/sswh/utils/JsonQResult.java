package com.sswh.utils;

/**
 * 针对layui的json返回格式封装的map工具类
 * @author nuanfeng
 */
public class JsonQResult {
    /**
     * 解析接口状态
     */
    private int code;
    /**
     * 解析提示文本
     */
    private String msg;
    /**
     * 解析数据长度
     */
    private int count;
    /**
     * 解析数据列表
     */
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
