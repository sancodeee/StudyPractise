package com.ws.dynamicProxy.dao.impl;

import com.ws.dynamicProxy.dao.BookDao;

public class BookDaoImpl2 implements BookDao {
    @Override
    public void add() {
        System.out.println("权限校验");

        System.out.println("执行添加功能");

        System.out.println("产生日志文件");
    }

    @Override
    public void update() {
        System.out.println("权限校验");

        System.out.println("执行更新功能");

        System.out.println("产生日志文件");
    }

    @Override
    public void query() {
        System.out.println("权限校验");

        System.out.println("执行查询功能");

        System.out.println("产生日志文件");
    }

    @Override
    public void delete() {
        System.out.println("权限校验");

        System.out.println("执行删除功能");

        System.out.println("产生日志文件");
    }
}
