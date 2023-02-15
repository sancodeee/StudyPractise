package com.ws.config;

import com.ws.quartz.MyQuartz;
import com.ws.quartz.MyQuartz2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {


//    工作明细：需要绑定指定的工作job
    @Bean
    public JobDetail firstJobDetail(){
        //storeDurably()方法用于设定当此定时任务没启动时是否要做持久化操作到数据库
        //绑定工作job：MyQuartz类为定义好的工作内容类
        return JobBuilder.newJob(MyQuartz.class).storeDurably().build();
    }

    @Bean
    public JobDetail secondJobDetail(){
        return JobBuilder.newJob(MyQuartz2.class).storeDurably().build();
    }

//    触发器：需要绑定工作明细JobDetail
    @Bean
    public Trigger firstTrigger(){
        //用于规定何时触发该触发器 执行的周期 执行的频度 执行的时间点
        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/5 * * * * ?");
        //绑定工作明细JobDetail
        return TriggerBuilder.newTrigger().forJob(firstJobDetail()).withSchedule(scheduleBuilder).build();
    }

    @Bean
    public Trigger secondTrigger(){
        return TriggerBuilder.newTrigger().forJob(secondJobDetail()).withSchedule(firstTrigger().getScheduleBuilder()).build();
    }





}
