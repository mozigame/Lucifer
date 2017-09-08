package com.bc.lottery.service.impl;

import com.bc.lottery.entity.BoundsInfo;
import com.bc.lottery.entity.LotteryOrder;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.entity.ShishicaiType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.bc.lottery.entity.ShishicaiType.Wuxing;

/**
 * ShishicaiServiceImpl Tester.
 *
 * @author clion
 * @version 1.0
 * @since <pre>???? 4, 2017</pre>
 */
public class ShishicaiServiceImplTest {

    private static String kj  = "01234";
    private static String kj1 = "55237";
    private static String kj2 = "64461";
    private static String kj3 = "13343";
    private static String kj4 = "68668";
    private static String kj5 = "66667";
    private static String kj6 = "77777";
    private static String kj7 = "46933";
    private static String kj8 = "97790";
    private static String kj9 = "12345";


    private static List<String> kjList = new ArrayList<>();

    @Before
    public void before() throws Exception {

    }

    /**
     * Method: getBetCount(List<List<String>> betNumbers, LotteryType lotteryType)
     */
    @Test
    public void testGetBetCount() throws Exception {
        System.out.println("*******************************下注算法测试开始*******************************");

        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        ShishicaiServiceImpl shishicaiService = new ShishicaiServiceImpl();

        // 五星
        for (LotteryType lotteryType : Wuxing.values()) {

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

    /**
     * Method: getBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<List<String>> betNumbers)
     */
    @Test
    public void testGetBoundsInfoOfLottery() throws Exception {

        System.out.println("*******************************单独开奖测试开始*******************************");

        kjList.add(kj);
        kjList.add(kj1);
        kjList.add(kj2);
        kjList.add(kj3);
        kjList.add(kj4);
        kjList.add(kj5);
        kjList.add(kj6);
        kjList.add(kj7);
        kjList.add(kj8);
        kjList.add(kj9);

        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        ShishicaiServiceImpl shishicaiService = new ShishicaiServiceImpl();

        // 五星
        for (LotteryType lotteryType : Wuxing.values()) {

            System.out.println("---------------------------五星类型----------------------------------");
            for (int i = 1; i < 21; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");

                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);

                for (String kjno : kjList) {
                    BoundsInfo boundsInfo = shishicaiService.getBoundsInfoOfLottery(lotteryType, kjno, betNumberList);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }
        // 四星

        for (LotteryType lotteryType : ShishicaiType.Sixing.values()) {

            System.out.println("---------------------------四星类型----------------------------------");
            for (int i = 1; i < 21; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                for (String kjno : kjList) {
                    BoundsInfo boundsInfo = shishicaiService.getBoundsInfoOfLottery(lotteryType, kjno, betNumberList);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }
        // 三星

        for (LotteryType lotteryType : ShishicaiType.Sanxing.values()) {

            System.out.println("---------------------------三星类型----------------------------------");

            for (int i = 1; i < 1; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                for (String kjno : kjList) {
                    BoundsInfo boundsInfo = shishicaiService.getBoundsInfoOfLottery(lotteryType, kjno, betNumberList);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }

        // 二星

        for (LotteryType lotteryType : ShishicaiType.Erxing.values()) {

            System.out.println("---------------------------二星类型----------------------------------");

            for (int i = 1; i < 21; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                for (String kjno : kjList) {

                    BoundsInfo boundsInfo = shishicaiService.getBoundsInfoOfLottery(lotteryType, kjno, betNumberList);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }

        // 一星

        for (LotteryType lotteryType : ShishicaiType.Yixing.values()) {

            System.out.println("---------------------------一星类型----------------------------------");
            for (int i = 1; i < 21; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);

                for (String kjno : kjList) {
                    BoundsInfo boundsInfo = shishicaiService.getBoundsInfoOfLottery(lotteryType, kjno, betNumberList);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }

        // 不定胆

        for (LotteryType lotteryType : ShishicaiType.Budingdan.values()) {

            System.out.println("---------------------------不定胆类型----------------------------------");
            for (int i = 1; i < 21; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);

                for (String kjno : kjList) {
                    BoundsInfo boundsInfo = shishicaiService.getBoundsInfoOfLottery(lotteryType, kjno, betNumberList);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }
        // 大小单双
        for (LotteryType lotteryType : ShishicaiType.Daxiaodanshuang.values()) {

            System.out.println("---------------------------大小单双----------------------------------");
            for (int i = 1; i < 21; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);

                for (String kjno : kjList) {
                    BoundsInfo boundsInfo = shishicaiService.getBoundsInfoOfLottery(lotteryType, kjno, betNumberList);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }
        // 趣味

        for (LotteryType lotteryType : ShishicaiType.Quwei.values()) {

            System.out.println("---------------------------趣味类型----------------------------------");
            for (int i = 1; i < 21; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);

                for (String kjno : kjList) {
                    BoundsInfo boundsInfo = shishicaiService.getBoundsInfoOfLottery(lotteryType, kjno, betNumberList);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }
        System.out.println("*******************************单独开奖测试结束*******************************");

    }

    /**
     * Method: getBatchBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBatchBoundsInfoOfLottery() throws Exception {

        System.out.println("*******************************批量开奖测试开始*******************************");
        kjList.add(kj);
        kjList.add(kj1);
        kjList.add(kj2);
        kjList.add(kj3);
        kjList.add(kj4);
        kjList.add(kj5);
        kjList.add(kj6);
        kjList.add(kj7);
        kjList.add(kj8);
        kjList.add(kj9);
        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        ShishicaiServiceImpl shishicaiService = new ShishicaiServiceImpl();

        for (String kj : kjList) {

            System.out.println("==========中奖号码========>>>" + kj);
            // 五星

            System.out.println("---------------------------五星类型----------------------------------");
            for (LotteryType lotteryType : Wuxing.values()) {
                List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if(time > 1500){
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }            }

            // 四星
            System.out.println("---------------------------四星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Sixing.values()) {
                List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if(time > 1500){
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }            }
            // 三星

            System.out.println("---------------------------三星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Sanxing.values()) {
                List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if(time > 1500){
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }            }
            // 二星
            System.out.println("---------------------------二星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Erxing.values()) {
                List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if(time > 1500){
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }            }
            // 一星

            System.out.println("---------------------------一星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Yixing.values()) {
                List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if(time > 1500){
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }            }

            // 不定胆

            System.out.println("---------------------------不定胆类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Budingdan.values()) {
                List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if(time > 1500){
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }            }

            // 大小单双

            System.out.println("---------------------------大小单双类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Daxiaodanshuang.values()) {
                List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if(time > 1500){
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }
            // 趣味

            System.out.println("---------------------------趣味类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Quwei.values()) {
                List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if(time > 1500){
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }

        }
        /*// 五星
        for (LotteryType lotteryType : Wuxing.values()) {

            System.out.println("---------------------------五星类型----------------------------------");
            System.out.println(lotteryType);
            List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
            System.out.println(lotteryOrderList);
            int prizeNumSum = 0;
            for (String kjno : kjList) {
                List<BoundsInfo> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (BoundsInfo boundsInfo : boundsInfoList) {
                    System.out.println("开奖信息->" + boundsInfo);
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        prizeNumSum++;
                    }
                }
                System.out.println("开奖号码->" + kjno + "    总计中奖次数====" + prizeNumSum);
            }
        }
        // 四星
        for (LotteryType lotteryType : ShishicaiType.Sixing.values()) {

            System.out.println("---------------------------四星类型----------------------------------");
            System.out.println(lotteryType);

            List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);

            System.out.println(lotteryOrderList);
            int prizeNumSum = 0;
            for (String kjno : kjList) {
                List<BoundsInfo> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (BoundsInfo boundsInfo : boundsInfoList) {
                    System.out.println("开奖信息->" + boundsInfo);
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        prizeNumSum++;
                    }
                }
                System.out.println("开奖号码->" + kjno + "    总计中奖次数====" + prizeNumSum);
            }
        }
        // 三星
        for (LotteryType lotteryType : ShishicaiType.Sanxing.values()) {

            System.out.println("---------------------------三星类型----------------------------------");
            System.out.println(lotteryType);

            List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);

            System.out.println(lotteryOrderList);
            int prizeNumSum = 0;
            for (String kjno : kjList) {
                List<BoundsInfo> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (BoundsInfo boundsInfo : boundsInfoList) {
                    System.out.println("开奖信息->" + boundsInfo);
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        prizeNumSum++;
                    }
                }
                System.out.println("开奖号码->" + kjno + "    总计中奖次数====" + prizeNumSum);
            }
        }
        // 二星
        for (LotteryType lotteryType : ShishicaiType.Erxing.values()) {

            System.out.println("---------------------------二星类型----------------------------------");
            System.out.println(lotteryType);

            List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
            System.out.println(lotteryOrderList);
            int prizeNumSum = 0;
            for (String kjno : kjList) {
                List<BoundsInfo> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (BoundsInfo boundsInfo : boundsInfoList) {
                    System.out.println("开奖信息->" + boundsInfo);
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        prizeNumSum++;
                    }
                }
                System.out.println("开奖号码->" + kjno + "    总计中奖次数====" + prizeNumSum);
            }
        }
        // 一星
        for (LotteryType lotteryType : ShishicaiType.Yixing.values()) {

            System.out.println("---------------------------一星类型----------------------------------");
            System.out.println(lotteryType);

            List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);
            System.out.println(lotteryOrderList);
            int prizeNumSum = 0;
            for (String kjno : kjList) {
                List<BoundsInfo> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (BoundsInfo boundsInfo : boundsInfoList) {
                    System.out.println("开奖信息->" + boundsInfo);
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        prizeNumSum++;
                    }
                }
                System.out.println("开奖号码->" + kjno + "    总计中奖次数====" + prizeNumSum);
            }
        }
        // 不定胆
        for (LotteryType lotteryType : ShishicaiType.Budingdan.values()) {

            System.out.println("---------------------------不定胆类型----------------------------------");
            System.out.println(lotteryType);

            List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);

            System.out.println(lotteryOrderList);
            int prizeNumSum = 0;
            for (String kjno : kjList) {
                List<BoundsInfo> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (BoundsInfo boundsInfo : boundsInfoList) {
                    System.out.println("开奖信息->" + boundsInfo);
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        prizeNumSum++;
                    }
                }
                System.out.println("开奖号码->" + kjno + "    总计中奖次数====" + prizeNumSum);
            }
        }
        // 大小单双
        for (LotteryType lotteryType : ShishicaiType.Daxiaodanshuang.values()) {

            System.out.println("---------------------------大小单双----------------------------------");
            System.out.println(lotteryType);

            List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);

            System.out.println(lotteryOrderList);
            int prizeNumSum = 0;
            for (String kjno : kjList) {
                List<BoundsInfo> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (BoundsInfo boundsInfo : boundsInfoList) {
                    System.out.println("开奖信息->" + boundsInfo);
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        prizeNumSum++;
                    }
                }
                System.out.println("开奖号码->" + kjno + "    总计中奖次数====" + prizeNumSum);
            }
        }
        // 趣味
        for (LotteryType lotteryType : ShishicaiType.Quwei.values()) {

            System.out.println("---------------------------趣味----------------------------------");
            System.out.println(lotteryType);

            List<LotteryOrder> lotteryOrderList = lotteryOrderTest.getLotteryOrderList(lotteryType);

            System.out.println(lotteryOrderList);
            int prizeNumSum = 0;
            for (String kjno : kjList) {
                List<BoundsInfo> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (BoundsInfo boundsInfo : boundsInfoList) {
                    System.out.println("开奖信息->" + boundsInfo);
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                        prizeNumSum++;
                    }
                }
                System.out.println("开奖号码->" + kjno + "    总计中奖次数====" + prizeNumSum);
            }

        }*/
        System.out.println("*******************************批量开奖测试结束*******************************");

    }

    /**
     * Method: getBoundsInfoOfWuxing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfWuxing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfWuxing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfSixing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfSixing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfSixing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfSanxing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfSanxing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfSanxing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfErxing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfErxing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfErxing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfYixing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfYixing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfYixing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfBudingdan(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfBudingdan() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfBudingdan", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfDaxiaodanshuang(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfDaxiaodanshuang() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfDaxiaodanshuang", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfQuwei(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfQuwei() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfQuwei", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBetNumbers(LotteryType lotteryType, List<List<String>> betNumbers)
     */
    @Test
    public void testGetBetNumbers() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBetNumbers", LotteryType.class, List<List<String>>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu120(String kjStr)
     */
    @Test
    public void testCheckIsZu120() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu120", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu60(String kjStr)
     */
    @Test
    public void testCheckIsZu60() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu60", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu30(String kjStr)
     */
    @Test
    public void testCheckIsZu30() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu30", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu20(String kjStr)
     */
    @Test
    public void testCheckIsZu20() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu20", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu10(String kjStr)
     */
    @Test
    public void testCheckIsZu10() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu10", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu5(String kjStr)
     */
    @Test
    public void testCheckIsZu5() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu5", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu24(String kjStr)
     */
    @Test
    public void testCheckIsZu24() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu24", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu12(String kjStr)
     */
    @Test
    public void testCheckIsZu12() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu12", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu6(String kjStr)
     */
    @Test
    public void testCheckIsZu6() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu6", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu4(String kjStr)
     */
    @Test
    public void testCheckIsZu4() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu4", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsSanxingZu6(String kjStr)
     */
    @Test
    public void testCheckIsSanxingZu6() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsSanxingZu6", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsSanxingZuHe(String kjStr)
     */
    @Test
    public void testCheckIsSanxingZuHe() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsSanxingZuHe", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu3(String kjStr)
     */
    @Test
    public void testCheckIsZu3() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu3", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsErxingFuShi(String kjStr)
     */
    @Test
    public void testCheckIsErxingFuShi() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsErxingFuShi", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
