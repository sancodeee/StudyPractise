package com.ws.sort;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Slf4j
public class demo01 {

    //计算某一轮所有人的总得分
    public int calculateScore(int peopleCount, int round, int[] eachRound) {

        BigDecimal winRate = new BigDecimal(eachRound[0]).multiply(new BigDecimal("0.01"));
        BigDecimal failRate = new BigDecimal(eachRound[1]).multiply(new BigDecimal("0.01"));
        BigDecimal drawRate = new BigDecimal(eachRound[2]).multiply(new BigDecimal("0.01"));
        BigDecimal abandRate = new BigDecimal(eachRound[3]).multiply(new BigDecimal("0.01"));

        BigDecimal winScore = winRate.multiply(new BigDecimal(peopleCount)).multiply(new BigDecimal(round + 1));
        BigDecimal abandScore = abandRate.multiply(new BigDecimal(peopleCount)).multiply(new BigDecimal("1"));

        //某一轮的总得分
        return winScore.add(abandScore).intValue();
    }

    //晋级人员 奖励得分机制
    public int calculateBonus(int passNum, int outNum) {
        //如果 晋级人数/淘汰人数 <= 1/10
        if (passNum != 0 && outNum != 0) {
            if ((new BigDecimal(passNum).divide(new BigDecimal(outNum), 2, BigDecimal.ROUND_HALF_UP)).compareTo(new BigDecimal("0.1")) <= 0) {
                BigDecimal divide = new BigDecimal(outNum).divide(new BigDecimal(passNum)).setScale(0, RoundingMode.DOWN);
                return divide.multiply(new BigDecimal(passNum)).intValue();
            }
        }
        return 0;
    }

    //计算总得分
    public int calculateSumScore(int N, int M, int[][] rounds) {
        //初始人数为N
        int peopleCount = N;
        //总得分
        int count = 0;

        for (int i = 0; i < M; i++) {
            int[] round = rounds[i];
            log.info("当前轮数：{}", (i+1));
            //每轮的得分
            int score = calculateScore(peopleCount, (i + 1), round);
            log.info("当前轮的得分:{}", score);
            //每轮的晋级人数、淘汰人数
            int pass = new BigDecimal(peopleCount).multiply(new BigDecimal(round[0] + round[2])).multiply(new BigDecimal("0.01")).intValue();
            log.info("当前轮的晋级人数:{}", pass);
            //每轮淘汰的人数
            int out = new BigDecimal(peopleCount).multiply(new BigDecimal(round[1] + round[3])).multiply(new BigDecimal("0.01")).intValue();
            log.info("当前轮淘汰的人数:{}", out);
            //奖励得分
            int bonusScore = calculateBonus(pass, out);
            log.info("奖励得分:{}", bonusScore);
            //下一轮的人数
            peopleCount = pass;
            log.info("下一轮的人数:{}", peopleCount);
            //当前轮的总得分
            count += (score + bonusScore);
            log.info("当前轮的总得分:{}", count);
        }

        return count;
    }

    @Test
    public void test() {
        int N = 1000;
        int M = 3;
        int[][] rounds = {{70, 10, 10, 10},
                {5, 85, 0, 10},
                {0, 50, 50, 0}};

        int sum = calculateSumScore(N, M, rounds);
        log.info("sum:{}", sum);
        double average = new BigDecimal(sum).divide(new BigDecimal(N),2,BigDecimal.ROUND_HALF_UP).doubleValue();
        log.info("平均分：{}", average);
    }


}
