package com.ws.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class KillServer {

    //端口号集合
    private Set<Integer> ports;

    //获取本类中ports
    public Set<Integer> getPorts(){
        return this.ports;
    }

    public void setPorts(Set<Integer> ports) {
        this.ports = ports;
    }

//    public static void main(String[] args) throws InterruptedException {
//        System.out.println("请输入要关闭的Windows进程端口号，如果有多个，请用“,”隔开");
//        Scanner scanner = new Scanner(System.in);
//        //输入的内容
//        String input = scanner.next();
//        scanner.close();
//        String[] split = input.split(",");
//        HashSet<Integer> ports = new HashSet<>();
//        for (String s : split) {
//            try {
//                int port = Integer.parseInt(s);
//                ports.add(port);
//            } catch (Exception e) {
//                System.out.println("错误端口号，请输入一个或者多个端口号，用英文逗号隔开");
//                try {
//                    Thread.sleep(5000);
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace();
//                }
//                System.exit(0);
//            }
//
//        }
//
//        KillServer killServer = new KillServer();
//        killServer.ports = ports;
//        System.out.println("关闭" + ports.size() + "个进程");
//        for (Integer port : ports) {
//            killServer.start(port);
//        }
//        System.out.println("清理完毕，程序即将退出");
//        System.out.println("success");
//        Thread.sleep(5000);
//        System.exit(0);
//
//    }

    public void start(int port) {
        Runtime runtime = Runtime.getRuntime();
        try {
            //查找进程号
            Process processId = runtime.exec("cmd /c netstat -ano | findstr \"" + port + "\"");
            InputStream inputStream = processId.getInputStream();
            List<String> read = read(inputStream, "UTF-8");
            if (read.size() == 0) {
                System.out.println("找不到该端口");
                try {
                    Thread.sleep(6000);
                    System.exit(0);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                for (String string : read) {
                    System.out.println(string);
                }
                System.out.println("找到" + read.size() + "个进程，正在准备清理");
                kill(read);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 校验此端口是否为指定的端口，因为 findstr命令会是把包含的找出来，例如查找80端口，但是会把8099查找出来
     *
     * @param str
     * @return
     */
    private boolean validPort(String str) {
        Pattern pattern = Pattern.compile("^ *[a-zA-Z]+ +\\S+");
        Matcher matcher = pattern.matcher(str);

        matcher.find();
        String find = matcher.group();
        int spstart = find.lastIndexOf(":");
        find = find.substring(spstart + 1);

        int port = 0;
        try {
            port = Integer.parseInt(find);
        } catch (NumberFormatException e) {
            System.out.println("查找到错误的端口:" + find);
            return false;
        }
        if (this.ports.contains(port)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 更换为一个Set，去掉重复的pid值
     *
     * @param data
     */
    public void kill(List<String> data) {
        Set<Integer> pids = new HashSet<>();
        for (String line : data) {
            int offset = line.lastIndexOf(" ");
            String spid = line.substring(offset);
            spid = spid.replaceAll(" ", "");
            int pid = 0;
            try {
                pid = Integer.parseInt(spid);
            } catch (NumberFormatException e) {
                System.out.println("获取的进程号错误:" + spid);
            }
            pids.add(pid);
        }
        killWithPid(pids);
    }

    /**
     * 一次性杀除所有的端口
     *
     * @param pids
     */
    public void killWithPid(Set<Integer> pids) {
        for (Integer pid : pids) {
            try {
                Process process = Runtime.getRuntime().exec("taskkill /F /pid " + pid + "");
                InputStream inputStream = process.getInputStream();
                String txt = readTxt(inputStream, "GBK");
                System.out.println(txt);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private List<String> read(InputStream in, String charset) throws IOException {
        List<String> data = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
        String line;
        while ((line = reader.readLine()) != null) {
            boolean validPort = validPort(line);
            if (validPort) {
                data.add(line);
            }
        }
        reader.close();
        return data;
    }

    public String readTxt(InputStream in, String charset) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, charset));
        StringBuffer sb = new StringBuffer();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        reader.close();
        return sb.toString();
    }

}
