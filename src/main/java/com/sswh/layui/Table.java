package com.sswh.layui;

import java.util.List;

/**
 * @author nuanfeng
 * @date 2020/8/29 23:21
 */
public class Table {
    private String toolbar;
    private String elem;
    private boolean page;
    private String url;
    private String method;
    private Integer limits[];
    private List<Column> cols;

    public String getToolbar() {
        return toolbar;
    }

    public void setToolbar(String toolbar) {
        this.toolbar = toolbar;
    }

    public String getElem() {
        return elem;
    }

    public void setElem(String elem) {
        this.elem = elem;
    }

    public boolean isPage() {
        return page;
    }

    public void setPage(boolean page) {
        this.page = page;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer[] getLimits() {
        return limits;
    }

    public void setLimits(Integer[] limits) {
        this.limits = limits;
    }

    public List<Column> getCols() {
        return cols;
    }

    public void setCols(List<Column> cols) {
        this.cols = cols;
    }
}
