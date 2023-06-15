package com.ws;

import com.ws.utils.KillServer;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 */
@SpringBootApplication
public class KillProcessApplication {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("请输入要关闭的Windows进程端口号，如果有多个，请用“,”隔开");
        Scanner scanner = new Scanner(System.in);
        //输入的内容
        String input = scanner.next();
        scanner.close();
        String[] split = input.split(",");
        HashSet<Integer> ports = new HashSet<>();
        for (String s : split) {
            try {
                int port = Integer.parseInt(s);
                ports.add(port);
            } catch (Exception e) {
                System.out.println("错误端口号，请输入一个或者多个端口号，用英文逗号隔开");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                System.exit(0);
            }

        }

        KillServer killServer = new KillServer();
        killServer.setPorts(ports);
        System.out.println("关闭" + ports.size() + "个进程");
        for (Integer port : ports) {
            killServer.start(port);
        }
        System.out.println("清理完毕，程序即将退出");
        System.out.println("success！");
        Thread.sleep(1000);
        System.exit(0);
    }
}
