package com.bc.lottery.draw.service.impl;

import com.babel.venus.po.UserOrder;
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

<<<<<<< HEAD
        for (ShishicaiType shishicaiType : ShishicaiType.values()) {
=======
        /*// 五星
        for (LotteryType lotteryType : ShishicaiType.Wuxing.values()) {
>>>>>>> 7befe3bf5b7bd760c95893e711c26a43b0b4db46

            for (int i = 1; i < 11; i++) {
                System.out.println(shishicaiType);
                System.out.println("==============第 " + i + " 次下注===============");

                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(shishicaiType.value());
                System.out.println(betNumberList);
<<<<<<< HEAD
                UserOrder userOrder = new UserOrder(shishicaiType, betNumberList);
=======
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
>>>>>>> 7befe3bf5b7bd760c95893e711c26a43b0b4db46
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

<<<<<<< HEAD
=======
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
>>>>>>> 7befe3bf5b7bd760c95893e711c26a43b0b4db46
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

            for (ShishicaiType shishicaiType : ShishicaiType.values()) {
                System.out.println("玩法类型===========>>>>>" + shishicaiType + "---------------------------类型----------------------------------");
                List<UserOrder> lotteryOrderList = lotteryOrderTest.getUserOrderList(shishicaiType.value());
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    shishicaiService.getBatchBoundsInfoOfLottery(shishicaiType, kj, lotteryOrderList);
                }
                long currTime2 = System.currentTimeMillis();
                long time = currTime2 - currTime1;
                System.out.println(shishicaiType + "===============玩法时间=========>" + time + "毫秒");
                if (time > 1500) {
                    System.out.println(shishicaiType + "======================================================================时间超长啦================================================================================>" + time + "毫秒");
                }
            }

            System.out.println("*******************************批量开奖测试结束*******************************");

        }

    }
}