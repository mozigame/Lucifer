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
 * Date: 217/9/8
 * Time: 18:50
 **/
public class LotteryDrawServiceImplTest {

    private static String kj = "12345";
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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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
                    UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

        for (String kj : kjList) {

            System.out.println("==========中奖号码========>>>" + kj);

            for (ShishicaiType shishicaiType : ShishicaiType.values()) {
                System.out.println("玩法类型===========>>>>>" + shishicaiType + "---------------------------类型----------------------------------");
                List<UserOrderPO> lotteryOrderList = lotteryOrderTest.getUserOrderList(1, shishicaiType.value());
                //System.out.println(lotteryOrderList);
                long currTime1 = System.currentTimeMillis();
                for (int i = 0; i < 1000; i++) {
                    lotteryDrawService.getBatchBoundsInfoOfLottery(shishicaiType, kj, lotteryOrderList);
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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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
                        UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
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

        kj = "1 2 3 4 5";
        kj1 = "6 8 3 5 9";
        kj2 = "11 7 3 5 10";
        kj3 = "3 9 8 4 2";
        kj4 = "6 10 2 8 3";
        kj5 = "1 3 5 7 9";
        kj6 = "6 8 4 2 10";
        kj7 = "4 5 9 3 11";
        kj8 = "7 5 2 11 8";
        kj9 = "2 3 4 6 5";

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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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
                        UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
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

        kj = "1,2,3,4,5";
        kj1 = "6,8,3,5,9";
        kj2 = "11,7,3,5,10";
        kj3 = "5,9,8,4,2";
        kj4 = "6,10,2,8,3";
        kj5 = "1,3,5,7,9";
        kj6 = "6,8,4,3,10";
        kj7 = "4,5,9,3,11";
        kj8 = "7,5,2,11,8";
        kj9 = "2,3,4,6,5";

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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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
                        UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
                        System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum() + "   是否为和：" + boundsInfo.getIsTied());
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

        kj = "1,2,3";
        kj1 = "4,5,6";
        kj2 = "1,2,4";
        kj3 = "2,5,6";
        kj4 = "2,2,2";
        kj5 = "6,6,6";
        kj6 = "4,4,5";
        kj7 = "2,2,5";
        kj8 = "1,4,7";
        kj9 = "1,1,1";

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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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
                    UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
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

        System.out.println("*******************************PK10传统盘开奖测试开始*******************************");
        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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
                    UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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
                    UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
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

        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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
                UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjt, userOrder);
                System.out.println("开奖号码->" + kjt + "    中奖次数: " + boundsInfo.getFirstPrizeNum());
                System.out.println("一等奖次数：" + boundsInfo.getFirstPrizeNum() + ";  二等奖次数：" + boundsInfo.getSecondPrizeNum() + ";  三等奖次数：" + boundsInfo.getThirdPrizeNum() + ";  四等奖次数：" + boundsInfo.getForthPrizeNum() + ";  五等奖次数：" + boundsInfo.getFifthPrizeNum());
                if (boundsInfo.getFirstPrizeNum() != 0 || boundsInfo.getSecondPrizeNum() != 0 || boundsInfo.getThirdPrizeNum() != 0 || boundsInfo.getForthPrizeNum() != 0 || boundsInfo.getFifthPrizeNum() != 0) {
                    System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@中奖了@@@@@@@@@@@@@@@@@@@@@@@@@@");
                }

            }
        }

        System.out.println("*******************************单独开奖测试结束*******************************");
    }

    /**
     * 双面盘时时彩中奖类型
     *
     * @throws Exception
     */
    @Test
    public void testGetShishicaiDoublePlayIds() throws Exception {

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

        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

        for (String kj : kjList) {

            System.out.println("==========中奖号码========>>>" + kj);

            List<Long> playIdList = lotteryDrawService.getLotteryBetPlayIds(2L, kj);
            System.out.println(playIdList);

            System.out.println("*******************************单独开奖测试结束*******************************");

        }

    }


    @Test
    public void testGetLottery11x5DoublePlayIds() throws Exception {

        kj = "1,2,3,4,5";
        kj1 = "6,8,3,5,9";
        kj2 = "11 7 3 5 10";
        kj3 = "3 9 8 4 2";
        kj4 = "6 10 2 8 3";
        kj5 = "1 3 5 7 9";
        kj6 = "6 8 4 2 10";
        kj7 = "4 5 9 3 11";
        kj8 = "7 5 2 11 8";
        kj9 = "2 3 4 6 5";

        System.out.println("*******************************11选5双面长龙测试开始*******************************");
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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

        for (String kj : kjList) {

            System.out.println("==========中奖号码========>>>" + kj);

            List<Long> playIdList = lotteryDrawService.getLotteryBetPlayIds(4L, kj);
            System.out.println(playIdList);

        }

    }

    @Test
    public void testGetLotteryKuai3DoublePlayIds() throws Exception {

        kj = "1,2,3";
        kj1 = "4,5,6";
        kj2 = "1,2,4";
        kj3 = "2,5,6";
        kj4 = "2,2,2";
        kj5 = "6,6,6";
        kj6 = "4,4,5";
        kj7 = "2,2,5";
        kj8 = "1,4,7";
        kj9 = "1,1,1";

        System.out.println("*******************************快3双面长龙测试开始*******************************");
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
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

        for (String kj : kjList) {

            System.out.println("==========中奖号码========>>>" + kj);

            List<Long> playIdList = lotteryDrawService.getLotteryBetPlayIds(6L, kj);
            System.out.println(playIdList);

        }

    }

    /**
     * PK10双面盘
     *
     * @throws Exception
     */
    @Test
    public void testGetLotteryPK10DoublePlayIds() throws Exception {

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

        System.out.println("*******************************PK10双面长龙开奖测试开始*******************************");
        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();

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

                for (String kj : kjList) {

                    System.out.println("==========中奖号码========>>>" + kj);

                    List<Long> playIdList = lotteryDrawService.getLotteryBetPlayIds(8L, kj);
                    System.out.println(playIdList);

                }
            }
        }
        System.out.println("*******************************PK10双面长龙测试结束*******************************");
    }


    /**
     * 六合彩
     *
     * @throws Exception
     */
    @Test
    public void testGetBoundsInfoOfMark6Double() throws Exception {

        System.out.println("*******************************六合彩双面盘开奖测试开始*******************************");
        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        for (int i = 0; i < 10; i++) {
            String kjNo = lotteryOrderTest.getMark6RandomKjNumbers();
            kjList.add(kjNo);
        }
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();
        for (String kj : kjList) {
            System.out.println("==========中奖号码========>>>" + kj);
            for (LotteryMark6DoubleType lotteryMark6DoubleType : LotteryMark6DoubleType.values()) {
                for (int i = 1; i < 2; i++) {
                    System.out.println(lotteryMark6DoubleType);
                    System.out.println(lotteryMark6DoubleType.desc() + " --> " + lotteryMark6DoubleType.value());
                    System.out.println("==============第 " + i + " 次下注===============");
                    List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(10, lotteryMark6DoubleType.value());
                    System.out.println(betNumberList);
                    for (String kjno : kjList) {
                        UserOrderPO userOrder = new UserOrderPO(betNumberList);
                        userOrder.setLotteryId(10L);
                        userOrder.setPlayId(lotteryMark6DoubleType.value());
                        UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
                        if (boundsInfo.getFirstPrizeNum() != 0) {
                            System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum() + "   是否为和：" + boundsInfo.getIsTied() + "          =======中奖了========");
                        }else{
                            System.out.println("开奖号码->" + kjno + "    中奖次数: " + boundsInfo.getFirstPrizeNum() + "   是否为和：" + boundsInfo.getIsTied());
                        }
                    }
                }
            }
        }
        System.out.println("*******************************六合彩双面盘开奖测试结束*******************************");
    }

    @Test
    public void testGetBatchBoundsInfoFateOfMark6Double() throws Exception {

        System.out.println("*******************************六合彩双面盘开奖概率测试开始*******************************");
        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        for (int i = 0; i < 100; i++) {
            String kjNo = lotteryOrderTest.getMark6RandomKjNumbers();
            kjList.add(kjNo);
        }
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();
        System.out.println("==========下注次数========>>> 1万");
        for (LotteryMark6DoubleType lotteryMark6DoubleType : LotteryMark6DoubleType.values()) {
            System.out.println(lotteryMark6DoubleType);
            System.out.println(lotteryMark6DoubleType.desc() + " --> " + lotteryMark6DoubleType.value());
            int betNum = 0;
            for (int i = 1; i < 100; i++) {
                for (String kjno : kjList) {
                    List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(10, lotteryMark6DoubleType.value());
                    UserOrderPO userOrder = new UserOrderPO(betNumberList);
                    userOrder.setLotteryId(10L);
                    userOrder.setPlayId(lotteryMark6DoubleType.value());
                    UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
                    betNum += boundsInfo.getFirstPrizeNum();
                }
            }
            double fate = betNum / 100;
            System.out.println("中奖次数=" + betNum);
            System.out.println("中奖概率（乘100）=" + fate);
            System.out.println("********************分割线***************************");
        }
        System.out.println("*******************************六合彩双面盘开奖概率测试开始*******************************");
    }

    @Test
    public void testGetSingleBoundsInfoFateOfMark6Double() throws Exception {

        System.out.println("*******************************六合彩单独开奖概率测试开始*******************************");
        LotteryOrderTest lotteryOrderTest = new LotteryOrderTest();
        for (int i = 0; i < 100; i++) {
            String kjNo = lotteryOrderTest.getMark6RandomKjNumbers();
            kjList.add(kjNo);
        }
        LotteryDrawServiceImpl lotteryDrawService = new LotteryDrawServiceImpl();
        System.out.println("==========下注次数========>>> 100万");
        System.out.println(LotteryMark6DoubleType.LIAN_MA_SAN_ZHONG_ER);
        System.out.println(LotteryMark6DoubleType.LIAN_MA_SAN_ZHONG_ER.desc() + " --> " + LotteryMark6DoubleType.LIAN_MA_SAN_ZHONG_ER.value());
        int betNum = 0;
        for (int i = 1; i < 10000; i++) {
            for (String kjno : kjList) {
                List<List<String>> betNumberList = lotteryOrderTest.getBetNumbersByType(10, LotteryMark6DoubleType.LIAN_MA_SAN_ZHONG_ER.value());
                UserOrderPO userOrder = new UserOrderPO(betNumberList);
                userOrder.setLotteryId(10L);
                userOrder.setPlayId(LotteryMark6DoubleType.LIAN_MA_SAN_ZHONG_ER.value());
                UserOrderPO boundsInfo = lotteryDrawService.getBoundsInfoOfLottery(kjno, userOrder);
                betNum += boundsInfo.getFirstPrizeNum();
            }
        }
        System.out.println("中奖次数=" + betNum);
        System.out.println("中奖概率=" + (double) betNum / 1000000);
        System.out.println("********************分割线***************************");
        System.out.println("*******************************六合彩双面盘开奖概率测试开始*******************************");
    }
}