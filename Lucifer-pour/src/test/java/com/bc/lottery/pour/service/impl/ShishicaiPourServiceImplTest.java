package com.bc.lottery.pour.service.impl;

import com.bc.lottery.entity.ShishicaiType;
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

        for (ShishicaiType shishicaiType : ShishicaiType.values()) {

            System.out.println("---------------------------时时彩类型----------------------------------");
            for (int i = 1; i < 2; i++) {
                System.out.println(shishicaiType);
                System.out.println(shishicaiType.desc());
                System.out.println("==============第 " + i + " 次下注===============");

                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(shishicaiType.value());
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, shishicaiType.value());
                System.out.println("下注单数: " + boundsNo);
            }
        }

        System.out.println("*******************************下注算法测试结束*******************************");
    }

    @Test
    public void testGetBetNumbersByType() throws Exception {
        System.out.println("*******************************生成注单测试开始*******************************");

        ShishicaiPourServiceImpl shishicaiService = new ShishicaiPourServiceImpl();
        for (ShishicaiType shishicaiType : ShishicaiType.values()) {

            for (int i = 1; i < 2; i++) {
                System.out.println(shishicaiType);
                System.out.println(shishicaiType.desc());
                System.out.println("==============第 " + i + " 次下注===============");

                List<List<String>> betNumberList = shishicaiService.getBetNumbersByType(shishicaiType.value());
                System.out.println(betNumberList);
            }
        }
        System.out.println("*******************************生成注单测试开始*******************************");
    }

}