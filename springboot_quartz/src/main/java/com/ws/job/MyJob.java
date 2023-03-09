package com.ws.job;

import com.ws.utils.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

//quartz定时任务内容类：具体的任务是什么，要继承QuartzJobBean类
@Slf4j
public class MyJob extends QuartzJobBean {

    @Autowired
    private EmailUtil emailUtil;

    // 发邮件任务
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("------quartz定时任务1：发送邮件开始------");
        String title = "ᵀʰᵉ ᵖᵉʳˢᵒⁿ ʷʰᵒ ˡᵒᵛᵉˢ ʸᵒᵘ ʰᵃˢ ᵍᵒⁿᵉ ⁿⁱᵍʰᵗ ᵃⁿᵈ ⁿⁱᵍʰᵗ,\n" +
                "ʷᵃˡᵏⁱⁿᵍ ᵒⁿ ᵗʰᵉ ʷᵃʸ";
        String content = "━━━━━━━━\n" +
                "┏┯┓┏┯┓┏┯┓┏┯┓\n" +
                "┠开┨┠开┨┠心┨┠心┨\n" +
                "┗┷┛┗┷┛┗┷┛┗┷┛\n" +
                "┏┯┓┏┯┓┏┯┓┏┯┓\n" +
                "┠幸┨┠福┨┠①┨┠生┨\n" +
                "┗┷┛┗┷┛┗┷┛┗┷┛\n" +
                "┏━━┓┏━━┓┏━━┓\n" +
                "┃┏━┛┗━┓┃┃┏┓┃\n" +
                "┃┗━┓┏━┛┃┃┃┃┃\n" +
                "┗━┓┃┃┏━┛┃┃┃┃\n" +
                "┏━┛┃┃┗━┓┃┗┛┃\n" +
                "┗━━┛┗━━┛┗━━┛\n" +
                "　　　╱╱╱╱╲╲.\\\n" +
                "　　／╱╱╱╱╱╱╲╲.\\\\\n" +
                "　　/／／／／╱╱╱╲╲.\\\\\n" +
                "　　/／／／／╱　..＾..╲.//\n" +
                "　　/／／／╱　　＜O＞.//　\n" +
                "　　\\／＼　　」　`````╱\n" +
                "..　　　　╲　▽　 ╱\n" +
                "__　◣　　　◣_◢　　　◢\n" +
                "　　◥████████████◤\n" +
                "　　◢◤█████████◥◣\n" +
                "　　◥◣█████████◢◤\n" +
                "　　　◥◥██████◤◤\n" +
                "　　　　◢██████◣\n" +
                "　　　 ███◤　◥███\n" +
                "　　　███　　　　███\n" +
                "　　　　███　　███\n" +
                "　　　◢▇█　　　█▇◣";
        emailUtil.sendMessage(title,content);
        log.info("------quartz定时任务1：发送邮件结束------");
    }
}
