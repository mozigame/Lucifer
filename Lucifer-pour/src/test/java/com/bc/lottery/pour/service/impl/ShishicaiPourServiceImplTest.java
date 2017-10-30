package com.bc.lottery.pour.service.impl;

import com.bc.lottery.entity.Lottery11x5Type;
import com.bc.lottery.entity.ShishicaiType;
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

        LotteryPourHandle lotteryPourHandler=new ShishicaiPourServiceImpl();
        Long lotteryId=4l;
        Long playId=43801l;
        String betContent="2,3";
        List<List<String>> betNumbers=lotteryPourHandler.getLotteryListByType(lotteryId, playId, betContent);
        Long count=lotteryPourHandler.getLotteryBetCount(lotteryId, playId, betNumbers);
        System.out.println(count);
    }

    @Test
    public void testRandomBetContent(){
        LotteryPourHandle lotteryPourHandler = new ShishicaiPourServiceImpl();
        Long playId=22504l;
        List<List<String>> list= lotteryPourHandler.getBetNumbersByType(playId);
        String betContent=lotteryPourHandler.getStringByLotteryList(playId, list);
        System.out.println("----betContent="+betContent);
    }
}