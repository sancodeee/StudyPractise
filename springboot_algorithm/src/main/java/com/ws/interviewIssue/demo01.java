package com.ws.interviewIssue;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * N(1<=N<=10000000)个用户独立参加 M(1<=M<=10)轮淘赛每轮淘赛对战的 NPC 难度逐渐升高，根据比赛结果每轮均有相应的积分奖励，每轮比赛有四种结果和一种 bonus加分机制:
 * 1.挑战胜利统一加当前轮次+1分第一轮加1+1=2分,第二轮加2+1=3分,第三轮加3+1=4分...)，晋级下一轮
 * 2.挑战失败，不加分，比赛结束
 * 晋级下一轮3.挑战平局，不加分，
 * 4.直接放弃，加一分，比赛结束
 * 5若晋级下一轮人数/本轮淘汰人数<=1/10，说明本轮比赛额外残酷，所有晋级下一轮人员可额外得 bonus 加分: bonus=floor(本轮淘汰人数/晋级下一轮人数--若为浮点数向下取整如淘汰人数=100，晋级下一轮人数=8， 8/100<=1/10，则本轮所有晋级人员额外bonus 加分 floor(100/8=12.5)=12,
 * 给定初始的参赛人数N,以及一个 M*4 的二维数组表示1~M 每一轮比赛的最终胜率败率平局率和放弃率百分比，求N个人比赛结束后的人均积分sample:
 * N=1000,M=3
 * 二维数组:
 * a[M][4] = [[70, 10, 10, 10],85，0, 10],[5,[0,50,50,0],
 * 其含义如下:
 * 平局率 放弃率胜率 败率
 * 第1轮70101010
 * 85第2轮5010
 * 第3轮505000
 * 其上表示 第1 轮1000 人有1000*70/100=700 人胜利晋级下一轮,1000*10/100=100 人失败淘汰，1000*10/100=100 人平局晋级下一轮， 1000*10/100=100 人放弃比赛，该轮总积分为:700*2+100*1=1500
 * 以此类推，最终所有轮次比赛结束后 每人平均积分为 2460/1000=2.46
 */
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
            log.info("当前轮数：{}", (i + 1));
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
        double average = new BigDecimal(sum).divide(new BigDecimal(N), 2, BigDecimal.ROUND_HALF_UP).doubleValue();
        log.info("平均分：{}", average);
        //时间复杂度是O(M)
    }


}
