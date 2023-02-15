package com.ws.quartz;

import com.ws.utils.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

//quartz定时任务内容类：具体的任务是什么，要继承QuartzJobBean类
@Slf4j
public class MyQuartz2 extends QuartzJobBean {

    @Autowired
    private EmailUtil emailUtil;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("------quartz定时任务2：发送邮件开始------");
        String title = "1 3 1 4 love you baby";
        String content = " *   *   *   *    \n" +
                "           *     * *     *     \n" +
                "          *  ★   *  ★   *    \n" +
                "           *      ★     *     \n" +
                "    >>>------I love you!   ---->\n" +
                "             *         *      \n" +
                "               *  ★ *       \n" +
                "                *   *          \n" +
                "                 * *          \n" +
                "                  *\n" +
                " ";
        emailUtil.sendMessage(title,content);
        log.info("------quartz定时任务2：发送邮件结束------");

    }


}
