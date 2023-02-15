package com.ws.test;

import com.ws.utils.EmailUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class EmailTest {

    @Autowired
    private EmailUtil emailUtil;

    @Test
    void contextLoads(){

    }

    @Test
    void sendStringEmail(){
        //测试邮件发送（无附件）
        String title = "520";
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
        log.info("邮件发送完成...");
    }



}
