package com.ws.schedule;

import java.util.Timer;
import java.util.TimerTask;

public class TimeTask {

    public static void main(String[] args) {
        //spring自带定时任务API测试
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务...");
            }
        };
        timer.schedule(task,2000,1000);
    }

}
