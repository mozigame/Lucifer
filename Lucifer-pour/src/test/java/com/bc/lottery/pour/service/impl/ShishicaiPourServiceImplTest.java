package com.bc.lottery.pour.service.impl;

import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.entity.ShishicaiType;
import com.bc.lottery.util.LotteryOrderTest;
import org.junit.Test;

import java.util.List;

/**
 * User: clion
 * Date: 2017/9/8
 * Time: 19:07
 **/
public class ShishicaiPourServiceImplTest {

    @Test
    public void testGetBetCount() throws Exception {
        System.out.println("*******************************下注算法测试开始*******************************");

        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        ShishicaiPourServiceImpl shishicaiService = new ShishicaiPourServiceImpl();

        // 五星
        for (LotteryType lotteryType : ShishicaiType.Wuxing.values()) {

            System.out.println("---------------------------五星类型----------------------------------");
            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");

                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, lotteryType);
                System.out.println("下注单数: " + boundsNo);
            }
        }
        // 四星

        for (LotteryType lotteryType : ShishicaiType.Sixing.values()) {

            System.out.println("---------------------------四星类型----------------------------------");
            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, lotteryType);
                System.out.println("下注单数: " + boundsNo);
            }
        }
        // 三星

        for (LotteryType lotteryType : ShishicaiType.Sanxing.values()) {

            System.out.println("---------------------------三星类型----------------------------------");

            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, lotteryType);
                System.out.println("下注单数: " + boundsNo);
            }
        }

        // 二星

        for (LotteryType lotteryType : ShishicaiType.Erxing.values()) {

            System.out.println("---------------------------二星类型----------------------------------");

            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, lotteryType);
                System.out.println("下注单数: " + boundsNo);
            }
        }

        // 一星

        for (LotteryType lotteryType : ShishicaiType.Yixing.values()) {

            System.out.println("---------------------------一星类型----------------------------------");
            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, lotteryType);
                System.out.println("下注单数: " + boundsNo);
            }
        }

        // 不定胆

        for (LotteryType lotteryType : ShishicaiType.Budingdan.values()) {

            System.out.println("---------------------------不定胆类型----------------------------------");
            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, lotteryType);
                System.out.println("下注单数: " + boundsNo);
            }
        }
        // 大小单双
        for (LotteryType lotteryType : ShishicaiType.Daxiaodanshuang.values()) {

            System.out.println("---------------------------大小单双----------------------------------");
            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, lotteryType);
                System.out.println("下注单数: " + boundsNo);
            }
        }
        // 趣味

        for (LotteryType lotteryType : ShishicaiType.Quwei.values()) {

            System.out.println("---------------------------趣味类型----------------------------------");
            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, lotteryType);
                System.out.println("下注单数: " + boundsNo);
            }
        }
        System.out.println("*******************************下注算法测试结束*******************************");

    }
}