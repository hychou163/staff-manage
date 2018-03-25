package com.hyjoy.domain;

import lombok.Data;

import java.util.List;

/**
 * Created by hyjoy on 2018/3/25.
 */
@Data
public class PageBean<T> {
    private int currPage; // 当前页数
    private int pageSize; // 每页显示的记录数
    private int totalCount; // 总记录数
    private int totalPage; // 总页数
    private List<T> list; // 每页显示的数据
}
