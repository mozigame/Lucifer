package com.bc.lottery.draw.service.impl;

import com.babel.venus.po.UserOrder;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.entity.ShishicaiType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * User: clion
 * Date: 2017/9/8
 * Time: 18:50
 **/
public class ShishicaiDrawServiceImplTest {

    private static String kj = "01234";
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
        ShishicaiDrawServiceImpl shishicaiService = new ShishicaiDrawServiceImpl();

        /*// 五星
        for (LotteryType lotteryType : ShishicaiType.Wuxing.values()) {

            System.out.println("---------------------------五星类型----------------------------------");
            for (int i = 1; i < 11; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");

                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                UserOrder userOrder = new UserOrder(lotteryType, betNumberList);
                for (String kjno : kjList) {
                    UserOrder boundsInfo = shishicaiService.getBoundsInfoOfLottery( kjno, userOrder);
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
            for (int i = 1; i < 11; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                UserOrder userOrder = new UserOrder(lotteryType, betNumberList);
                for (String kjno : kjList) {
                    UserOrder boundsInfo = shishicaiService.getBoundsInfoOfLottery( kjno, userOrder);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }*/
        // 三星

        for (LotteryType lotteryType : ShishicaiType.Sanxing.values()) {

            System.out.println("---------------------------三星类型----------------------------------");

            for (int i = 1; i < 11; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                UserOrder userOrder = new UserOrder(lotteryType, betNumberList);
                for (String kjno : kjList) {
                    UserOrder boundsInfo = shishicaiService.getBoundsInfoOfLottery( kjno, userOrder);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }

       /*// 二星

        for (LotteryType lotteryType : ShishicaiType.Erxing.values()) {

            System.out.println("---------------------------二星类型----------------------------------");

            for (int i = 1; i < 11; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                UserOrder userOrder = new UserOrder(lotteryType, betNumberList);
                for (String kjno : kjList) {
                    UserOrder boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
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
            for (int i = 1; i < 11; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);
                UserOrder userOrder = new UserOrder(lotteryType, betNumberList);
                for (String kjno : kjList) {
                    UserOrder boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
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
            for (int i = 1; i < 11; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);

                UserOrder userOrder = new UserOrder(lotteryType, betNumberList);
                for (String kjno : kjList) {
                    UserOrder boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
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
            for (int i = 1; i < 11; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);

                UserOrder boundsInfo = new UserOrder(lotteryType, betNumberList);
                for (String kjno : kjList) {
                    shishicaiService.getBoundsInfoOfLottery(kjno, boundsInfo);
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
            for (int i = 1; i < 11; i++) {
                System.out.println(lotteryType);
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(lotteryType);
                System.out.println(betNumberList);

                UserOrder userOrder = new UserOrder(lotteryType, betNumberList);

                for (String kjno : kjList) {
                    UserOrder boundsInfo = shishicaiService.getBoundsInfoOfLottery( kjno, userOrder);
                    System.out.println(boundsInfo);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0) {
                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                    }
                }
            }
        }*/
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
        ShishicaiDrawServiceImpl shishicaiService = new ShishicaiDrawServiceImpl();

        for (String kj : kjList) {

            System.out.println("==========中奖号码========>>>" + kj);
            // 五星

            System.out.println("---------------------------五星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Wuxing.values()) {
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }

            // 四星
            System.out.println("---------------------------四星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Sixing.values()) {
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }
            // 三星

            System.out.println("---------------------------三星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Sanxing.values()) {
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }
            // 二星
            System.out.println("---------------------------二星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Erxing.values()) {
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }
            // 一星

            System.out.println("---------------------------一星类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Yixing.values()) {
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }

            // 不定胆

            System.out.println("---------------------------不定胆类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Budingdan.values()) {
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }

            // 大小单双

            System.out.println("---------------------------大小单双类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Daxiaodanshuang.values()) {
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
                    System.out.println(lotteryType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }
            // 趣味

            System.out.println("---------------------------趣味类型----------------------------------");
            for (LotteryType lotteryType : ShishicaiType.Quwei.values()) {
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(lotteryType);
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(lotteryType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
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
                List<UserOrder> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (UserOrder boundsInfo : boundsInfoList) {
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
                List<UserOrder> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (UserOrder boundsInfo : boundsInfoList) {
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
                List<UserOrder> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (UserOrder boundsInfo : boundsInfoList) {
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
                List<UserOrder> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (UserOrder boundsInfo : boundsInfoList) {
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
                List<UserOrder> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (UserOrder boundsInfo : boundsInfoList) {
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
                List<UserOrder> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (UserOrder boundsInfo : boundsInfoList) {
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
                List<UserOrder> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (UserOrder boundsInfo : boundsInfoList) {
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
                List<UserOrder> boundsInfoList = shishicaiService.getBatchBoundsInfoOfLottery(lotteryType, kjno, lotteryOrderList);
                for (UserOrder boundsInfo : boundsInfoList) {
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

}