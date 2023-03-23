package com.ws.dynamicProxy.dao.impl;

import com.ws.dynamicProxy.dao.BookDao;

public class BookDaoImpl implements BookDao {
    @Override
    public void add() {
        System.out.println("添加书籍信息...");
    }

    @Override
    public void update() {
        System.out.println("更新书籍信息...");
    }

    @Override
    public void query() {
        System.out.println("查询书籍信息...");
    }

    @Override
    public void delete() {
        System.out.println("删除书籍信息...");
    }
}
