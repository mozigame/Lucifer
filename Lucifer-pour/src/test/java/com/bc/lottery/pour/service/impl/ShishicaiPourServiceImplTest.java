package com.bc.lottery.pour.service.impl;

import com.bc.lottery.entity.*;
import com.bc.lottery.pour.service.LotteryPourHandle;
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
        System.out.println("*******************************官彩时时彩下注算法测试开始*******************************");

        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        ShishicaiPourServiceImpl shishicaiService = new ShishicaiPourServiceImpl();

        for (ShishicaiType shishicaiType : ShishicaiType.values()) {

            System.out.println("---------------------------时时彩类型----------------------------------");
            for (int i = 1; i < 2; i++) {
                System.out.println(shishicaiType);
                System.out.println(shishicaiType.desc());
                System.out.println("==============第 " + i + " 次下注===============");

                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(1, shishicaiType.value());
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getBetCount(betNumberList, shishicaiType.value());
                System.out.println("下注单数: " + boundsNo);
            }
        }

        System.out.println("*******************************官彩时时彩下注算法测试结束*******************************");
    }

    @Test
    public void testGetLottery11x5BetCount() throws Exception {
        System.out.println("*******************************官彩11x5下注算法测试开始*******************************");

        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        ShishicaiPourServiceImpl shishicaiService = new ShishicaiPourServiceImpl();

        for (Lottery11x5Type lottery11x5Type : Lottery11x5Type.values()) {

            System.out.println("---------------------------11选5类型----------------------------------");
            for (int i = 1; i < 11; i++) {
                System.out.println(lottery11x5Type);
                System.out.println(lottery11x5Type.desc());
                System.out.println("==============第 " + i + " 次下注===============");

                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(3, lottery11x5Type.value());
                System.out.println(betNumberList);
                long boundsNo = shishicaiService.getLotteryBetCount(3L, lottery11x5Type.value(), betNumberList);
                System.out.println("下注单数: " + boundsNo);
            }
        }

        System.out.println("*******************************官彩11x5下注算法测试结束*******************************");
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

    @Test
    public void testLotteryPourBetNumber() throws Exception {

        LotteryPourHandle lotteryPourHandler = new ShishicaiPourServiceImpl();
        Long lotteryId = 4l;
        Long playId = 43801l;
        String betContent = "2,3";
        List<List<String>> betNumbers = lotteryPourHandler.getLotteryListByType(lotteryId, playId, betContent);
        Long count = lotteryPourHandler.getLotteryBetCount(lotteryId, playId, betNumbers);
        System.out.println(count);
    }

    @Test
    public void testRandomBetContent() {
        LotteryPourHandle lotteryPourHandler = new ShishicaiPourServiceImpl();
        Long playId = 22504l;
        List<List<String>> list = lotteryPourHandler.getBetNumbersByType(playId);
        String betContent = lotteryPourHandler.getStringByLotteryList(playId, list);
        System.out.println("----betContent=" + betContent);
    }

    @Test
    public void testGetLotteryBetContent() {
        LotteryPourHandle lotteryPourHandler = new ShishicaiPourServiceImpl();
        System.out.println("========================官方时时彩========================");
        for (ShishicaiType shishicaiType : ShishicaiType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(1L, shishicaiType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(1L, shishicaiType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(1L, shishicaiType.value(), list);
            System.out.println(shishicaiType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);

        }
        System.out.println("========================双面时时彩========================");
        for (ShishicaiDoubleType shishicaiDoubleType : ShishicaiDoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(2L, shishicaiDoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(2L, shishicaiDoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(2L, shishicaiDoubleType.value(), list);
            System.out.println(shishicaiDoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);

        }
        System.out.println("========================双面11x5========================");
        for (Lottery11x5DoubleType lottery11x5DoubleType : Lottery11x5DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(4L, lottery11x5DoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(4L, lottery11x5DoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(4L, lottery11x5DoubleType.value(), list);
            System.out.println(lottery11x5DoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }

        System.out.println("========================双面快3========================");
        for (LotteryKuai3DoubleType lotteryKuai3DoubleType : LotteryKuai3DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(6L, lotteryKuai3DoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(6L, lotteryKuai3DoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(6L, lotteryKuai3DoubleType.value(), list);
            System.out.println(lotteryKuai3DoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }

        System.out.println("========================双面PK10========================");
        for (LotteryPK10DoubleType lotteryPK10DoubleType : LotteryPK10DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(8L, lotteryPK10DoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(8L, lotteryPK10DoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(8L, lotteryPK10DoubleType.value(), list);
            System.out.println(lotteryPK10DoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }

        System.out.println("========================天津时时彩========================");
        for (ShishicaiDoubleType shishicaiDoubleType : ShishicaiDoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(12L, shishicaiDoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(12L, shishicaiDoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(12L, shishicaiDoubleType.value(), list);
            System.out.println(shishicaiDoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }
        System.out.println("========================新疆时时彩========================");
        for (ShishicaiDoubleType shishicaiDoubleType : ShishicaiDoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(14L, shishicaiDoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(14L, shishicaiDoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(14L, shishicaiDoubleType.value(), list);
            System.out.println(shishicaiDoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }

        System.out.println("========================广东11选5========================");
        for (Lottery11x5DoubleType lottery11x5DoubleType : Lottery11x5DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(16L, lottery11x5DoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(16L, lottery11x5DoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(16L, lottery11x5DoubleType.value(), list);
            System.out.println(lottery11x5DoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }
        System.out.println("========================山东11选5========================");
        for (Lottery11x5DoubleType lottery11x5DoubleType : Lottery11x5DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(18L, lottery11x5DoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(18L, lottery11x5DoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(18L, lottery11x5DoubleType.value(), list);
            System.out.println(lottery11x5DoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }
        System.out.println("========================安徽快3========================");
        for (LotteryKuai3DoubleType lotteryKuai3DoubleType : LotteryKuai3DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(20L, lotteryKuai3DoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(20L, lotteryKuai3DoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(20L, lotteryKuai3DoubleType.value(), list);
            System.out.println(lotteryKuai3DoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }
        System.out.println("========================湖北快3========================");
        for (LotteryKuai3DoubleType lotteryKuai3DoubleType : LotteryKuai3DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(22L, lotteryKuai3DoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(22L, lotteryKuai3DoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(22L, lotteryKuai3DoubleType.value(), list);
            System.out.println(lotteryKuai3DoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }
    }

    @Test
    public void testGetLottery11x5BetContent() {
        LotteryPourHandle lotteryPourHandler = new ShishicaiPourServiceImpl();
        System.out.println("========================双面11选5========================");
        List<List<String>> strList = lotteryPourHandler.getLotteryListByType(104L, 41603L, "总和单");

        System.out.println(strList);

        long betCount = lotteryPourHandler.getLotteryBetCount(104L, 41603L, strList);

        System.out.println(betCount);
    }

    @Test
    public void testGetLotteryMark6BetContent() {

        System.out.println("========================六合彩========================");
        LotteryPourHandle lotteryPourHandler = new ShishicaiPourServiceImpl();
        for (LotteryMark6DoubleType lotteryMark6DoubleType : LotteryMark6DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(10L, lotteryMark6DoubleType.value());
            String betContent = lotteryPourHandler.getStringByLotteryList(10L, lotteryMark6DoubleType.value(), list);
            Long betCount = lotteryPourHandler.getLotteryBetCount(10L, lotteryMark6DoubleType.value(), list);
            System.out.println(lotteryMark6DoubleType.desc() + "=" + list);
            System.out.println(betCount + "|" + betContent);
        }
    }

    @Test
    public void testGetLotteryMark6NumbersByType() {
        System.out.println("========================六合彩========================");

        LotteryPourHandle lotteryPourHandler = new ShishicaiPourServiceImpl();
        for (LotteryMark6DoubleType lotteryMark6DoubleType : LotteryMark6DoubleType.values()) {
            List<List<String>> list = lotteryPourHandler.getBetNumbersByType(10L, lotteryMark6DoubleType.value());
            System.out.println(lotteryMark6DoubleType.desc() + "=" + list);
        }

    }
}
