package com.taotao.search.bean;

import java.util.List;

/**
 * Created by JARVIS on 2017/7/4.
 */
public class SearchResult {

    private Long total;

    private List<?> list;

    public SearchResult(Long total, List<?> list) {
        this.total = total;
        this.list = list;
    }

    public SearchResult() {
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
