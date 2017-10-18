package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.entity.ShishicaiDoubleType;
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

        for (ShishicaiType shishicaiType : ShishicaiType.values()) {

            for (int i = 1; i < 11; i++) {
                System.out.println(shishicaiType);
                System.out.println(shishicaiType.desc());
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(1, shishicaiType.value());
                System.out.println(betNumberList);
                for (String kjno : kjList) {
                    UserOrderPO userOrder = new UserOrderPO(betNumberList);
                    userOrder.setLotteryId(1L);
                    userOrder.setPlayId(shishicaiType.value());
                    UserOrderPO boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    System.out.println("一等奖次数：" + boundsInfo.getFirstPrizeNum() + ";  二等奖次数：" + boundsInfo.getSecondPrizeNum() + ";  三等奖次数：" + boundsInfo.getThirdPrizeNum() + ";  四等奖次数：" + boundsInfo.getForthPrizeNum() + ";  五等奖次数：" + boundsInfo.getFifthPrizeNum());
                    if (boundsInfo.getFirstPrizeNum() != 0 || boundsInfo.getSecondPrizeNum() != 0 || boundsInfo.getThirdPrizeNum() != 0 || boundsInfo.getForthPrizeNum() != 0 || boundsInfo.getFifthPrizeNum() != 0) {
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
        ShishicaiDrawServiceImpl shishicaiService = new ShishicaiDrawServiceImpl();

        for (String kj : kjList) {

            System.out.println("==========中奖号码========>>>" + kj);

            for (ShishicaiType shishicaiType : ShishicaiType.values()) {
                System.out.println("玩法类型===========>>>>>" + shishicaiType + "---------------------------类型----------------------------------");
                List<UserOrderPO> lotteryOrderList = lotteryOrderTest.getUserOrderList(1, shishicaiType.value());
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


    /**
     * 双面盘时时彩类型开奖测试
     *
     * @throws Exception
     */
    @Test
    public void testGetBoundsInfoOfLotteryDouble() throws Exception {

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

        for (String kj : kjList) {

            System.out.println("==========中奖号码========>>>" + kj);

            for (ShishicaiDoubleType shishicaiDoubleType : ShishicaiDoubleType.values()) {
                for (int i = 1; i < 2; i++) {
                    System.out.println(shishicaiDoubleType);
                    System.out.println(shishicaiDoubleType.desc());
                    System.out.println("==============第 " + i + " 次下注===============");
                    List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(2, shishicaiDoubleType.value());
                    System.out.println(betNumberList);
                    for (String kjno : kjList) {
                        UserOrderPO userOrder = new UserOrderPO(betNumberList);
                        userOrder.setLotteryId(2L);
                        userOrder.setPlayId(shishicaiDoubleType.value());
                        UserOrderPO boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
                        System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    }
                }
            }

            System.out.println("*******************************单独开奖测试结束*******************************");

        }

    }
}