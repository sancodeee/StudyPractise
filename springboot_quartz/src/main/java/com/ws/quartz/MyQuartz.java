package com.ws.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

//定时任务内容类：具体的任务是什么，要继承QuartzJobBean类
public class MyQuartz extends QuartzJobBean {
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("quartz定时任务...");
    }
}
