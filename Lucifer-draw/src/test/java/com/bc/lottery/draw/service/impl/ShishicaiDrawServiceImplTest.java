package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.entity.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.bc.lottery.entity.ShishicaiType.HOU_SAN_ZU_XUAN_HE_ZHI;

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

    /**
     * 11选5传统盘
     *
     * @throws Exception
     */
    @Test
    public void testGetBoundsInfoOfLottery11x5() throws Exception {

        kj = "01 02 03 04 05";
        kj1 = "06 08 03 05 09";
        kj2 = "11 07 03 05 10";
        kj3 = "03 09 08 04 02";
        kj4 = "06 10 02 08 03";
        kj5 = "01 03 05 07 09";
        kj6 = "06 08 04 02 10";
        kj7 = "04 05 09 03 11";
        kj8 = "07 05 02 11 08";
        kj9 = "02 03 04 06 05";

        System.out.println("*******************************11选5传统盘开奖测试开始*******************************");
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

            for (Lottery11x5Type lottery11x5Type : Lottery11x5Type.values()) {
                for (int i = 1; i < 11; i++) {
                    System.out.println(lottery11x5Type);
                    System.out.println(lottery11x5Type.desc());
                    System.out.println("==============第 " + i + " 次下注===============");
                    List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(3, lottery11x5Type.value());
                    System.out.println(betNumberList);
                    for (String kjno : kjList) {
                        UserOrderPO userOrder = new UserOrderPO(betNumberList);
                        userOrder.setLotteryId(3L);
                        userOrder.setPlayId(lottery11x5Type.value());
                        UserOrderPO boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
                        System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                    }
                }
            }
        }
        System.out.println("*******************************11选5传统盘开奖测试结束*******************************");
    }

    /**
     * 11x5双面盘
     *
     * @throws Exception
     */
    @Test
    public void testGetBoundsInfoOfLottery11x5Double() throws Exception {

        kj = "01 02 03 04 05";
        kj1 = "06 08 03 05 09";
        kj2 = "11 07 03 05 10";
        kj3 = "03 09 08 04 02";
        kj4 = "06 10 02 08 03";
        kj5 = "01 03 05 07 09";
        kj6 = "06 08 04 02 10";
        kj7 = "04 05 09 03 11";
        kj8 = "07 05 02 11 08";
        kj9 = "02 03 04 06 05";

        System.out.println("*******************************11选5双面盘开奖测试开始*******************************");
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

            for (Lottery11x5DoubleType lottery11x5DoubleType : Lottery11x5DoubleType.values()) {
                for (int i = 1; i < 11; i++) {
                    System.out.println(lottery11x5DoubleType);
                    System.out.println(lottery11x5DoubleType.desc());
                    System.out.println("==============第 " + i + " 次下注===============");
                    List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(4, lottery11x5DoubleType.value());
                    System.out.println(betNumberList);
                    for (String kjno : kjList) {
                        UserOrderPO userOrder = new UserOrderPO(betNumberList);
                        userOrder.setLotteryId(4L);
                        userOrder.setPlayId(lottery11x5DoubleType.value());
                        UserOrderPO boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
                        System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum() + "   是否为和：" + boundsInfo.getIsTied() );
                    }
                }
            }
        }
        System.out.println("*******************************11选5双面盘开奖测试结束*******************************");
    }


    /**
     * 快3双面盘
     *
     * @throws Exception
     */
    @Test
    public void testGetBoundsInfoOfLotteryKuai3Double() throws Exception {

        kj = "123";
        kj1 = "456";
        kj2 = "124";
        kj3 = "256";
        kj4 = "222";
        kj5 = "666";
        kj6 = "445";
        kj7 = "225";
        kj8 = "147";
        kj9 = "111";

        System.out.println("*******************************快3双面盘开奖测试开始*******************************");
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

        for (LotteryKuai3DoubleType lotteryKuai3DoubleType : LotteryKuai3DoubleType.values()) {
            for (int i = 1; i < 2; i++) {
                System.out.println(lotteryKuai3DoubleType);
                System.out.println(lotteryKuai3DoubleType.desc());
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(6, lotteryKuai3DoubleType.value());
                System.out.println(betNumberList);
                for (String kjno : kjList) {
                    UserOrderPO userOrder = new UserOrderPO(betNumberList);
                    userOrder.setLotteryId(6L);
                    userOrder.setPlayId(lotteryKuai3DoubleType.value());
                    UserOrderPO boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                }
            }
        }
        System.out.println("*******************************快3双面盘开奖测试结束*******************************");
    }

    /**
     * PK10传统盘
     *
     * @throws Exception
     */
    @Test
    public void testGetBoundsInfoOfLotteryPK10() throws Exception {

        List<String> betNumbers = new ArrayList<>();
        betNumbers.add("01");
        betNumbers.add("02");
        betNumbers.add("03");
        betNumbers.add("04");
        betNumbers.add("05");
        betNumbers.add("06");
        betNumbers.add("07");
        betNumbers.add("08");
        betNumbers.add("09");
        betNumbers.add("10");

        System.out.println("*******************************PK10传统盘开奖测试开始*******************************");
        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        ShishicaiDrawServiceImpl shishicaiService = new ShishicaiDrawServiceImpl();

        for (LotteryPK10Type lotteryPK10Type : LotteryPK10Type.values()) {
            for (int i = 1; i < 2; i++) {
                kjList.clear();
                System.out.println(lotteryPK10Type);
                System.out.println(lotteryPK10Type.desc());
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(7, lotteryPK10Type.value());
                System.out.println(betNumberList);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder1 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder1.append(bet).append(",");
                });

                String betNumber1 = betBuilder1.toString().substring(0, betBuilder1.toString().length() - 1);

                kjList.add(betNumber1);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder2 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder2.append(bet).append(",");
                });

                String betNumber2 = betBuilder2.toString().substring(0, betBuilder2.toString().length() - 1);

                kjList.add(betNumber2);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder3 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder3.append(bet).append(",");
                });

                String betNumber3 = betBuilder3.toString().substring(0, betBuilder3.toString().length() - 1);

                kjList.add(betNumber3);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder4 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder4.append(bet).append(",");
                });

                betNumber1 = betBuilder4.toString().substring(0, betBuilder4.toString().length() - 1);

                kjList.add(betNumber1);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder5 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder5.append(bet).append(",");
                });

                betNumber1 = betBuilder5.toString().substring(0, betBuilder5.toString().length() - 1);

                kjList.add(betNumber1);

                for (String kjno : kjList) {
                    UserOrderPO userOrder = new UserOrderPO(betNumberList);
                    userOrder.setLotteryId(7L);
                    userOrder.setPlayId(lotteryPK10Type.value());
                    UserOrderPO boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                }
            }
        }
        System.out.println("*******************************PK10传统开奖测试结束*******************************");
    }

    /**
     * PK10双面盘
     *
     * @throws Exception
     */
    @Test
    public void testGetBoundsInfoOfLotteryPK10Double() throws Exception {

 /*       kj = "1,2,3,4,5,6,7,8,9,10";
        kj1 = "10,9,8,7,6,5,4,3,2,1";
        kj2 = "5,4,3,2,1,9,8,7,6,10";
        kj3 = "3,4,9,5,7,1,6,2,10,8";
        kj4 = "6,9,5,4,8,2,1,7,10,3";*/

        List<String> betNumbers = new ArrayList<>();
        betNumbers.add("1");
        betNumbers.add("2");
        betNumbers.add("3");
        betNumbers.add("4");
        betNumbers.add("5");
        betNumbers.add("6");
        betNumbers.add("7");
        betNumbers.add("8");
        betNumbers.add("9");
        betNumbers.add("10");

        System.out.println("*******************************PK10双面盘开奖测试开始*******************************");
        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        ShishicaiDrawServiceImpl shishicaiService = new ShishicaiDrawServiceImpl();

        for (LotteryPK10DoubleType lotteryPK10DoubleType : LotteryPK10DoubleType.values()) {
            for (int i = 1; i < 2; i++) {
                kjList.clear();
                System.out.println(lotteryPK10DoubleType);
                System.out.println(lotteryPK10DoubleType.desc());
                System.out.println("==============第 " + i + " 次下注===============");
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(8, lotteryPK10DoubleType.value());
                System.out.println(betNumberList);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder1 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder1.append(bet).append(",");
                });

                String betNumber1 = betBuilder1.toString().substring(0, betBuilder1.toString().length() - 1);

                kjList.add(betNumber1);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder2 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder2.append(bet).append(",");
                });

                String betNumber2 = betBuilder2.toString().substring(0, betBuilder2.toString().length() - 1);

                kjList.add(betNumber2);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder3 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder3.append(bet).append(",");
                });

                String betNumber3 = betBuilder3.toString().substring(0, betBuilder3.toString().length() - 1);

                kjList.add(betNumber3);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder4 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder4.append(bet).append(",");
                });

                betNumber1 = betBuilder4.toString().substring(0, betBuilder4.toString().length() - 1);

                kjList.add(betNumber1);

                Collections.shuffle(betNumbers);
                StringBuilder betBuilder5 = new StringBuilder();
                betNumbers.forEach(bet -> {
                    betBuilder5.append(bet).append(",");
                });

                betNumber1 = betBuilder5.toString().substring(0, betBuilder5.toString().length() - 1);

                kjList.add(betNumber1);

                for (String kjno : kjList) {
                    UserOrderPO userOrder = new UserOrderPO(betNumberList);
                    userOrder.setLotteryId(8L);
                    userOrder.setPlayId(lotteryPK10DoubleType.value());
                    UserOrderPO boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjno, userOrder);
                    System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                }
            }
        }
        System.out.println("*******************************PK10双面盘开奖测试结束*******************************");
    }

    @Test
    public void testSingleLottery() throws Exception {

        System.out.println("*******************************单独开奖测试开始*******************************");

        String kjt = "32314";

        kjList.add(kjt);

        ShishicaiDrawServiceImpl shishicaiService = new ShishicaiDrawServiceImpl();

        for (ShishicaiType shishicaiType : ShishicaiType.values()) {

            if (shishicaiType.value() == HOU_SAN_ZU_XUAN_HE_ZHI.value()) {

                List<String> betList = new ArrayList<>();
                betList.add("4");
                betList.add("6");
                betList.add("8");
                betList.add("10");
                betList.add("11");
                List<List<String>> betNumberList = new ArrayList<>();
                betNumberList.add(betList);

                UserOrderPO userOrder = new UserOrderPO(betNumberList);
                userOrder.setLotteryId(1L);
                userOrder.setPlayId(shishicaiType.value());
                UserOrderPO boundsInfo = shishicaiService.getBoundsInfoOfLottery(kjt, userOrder);
                System.out.println("开奖号码->" + kjt + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                System.out.println("一等奖次数：" + boundsInfo.getFirstPrizeNum() + ";  二等奖次数：" + boundsInfo.getSecondPrizeNum() + ";  三等奖次数：" + boundsInfo.getThirdPrizeNum() + ";  四等奖次数：" + boundsInfo.getForthPrizeNum() + ";  五等奖次数：" + boundsInfo.getFifthPrizeNum());
                if (boundsInfo.getFirstPrizeNum() != 0 || boundsInfo.getSecondPrizeNum() != 0 || boundsInfo.getThirdPrizeNum() != 0 || boundsInfo.getForthPrizeNum() != 0 || boundsInfo.getFifthPrizeNum() != 0) {
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                }

            }
        }

        System.out.println("*******************************单独开奖测试结束*******************************");
    }

}