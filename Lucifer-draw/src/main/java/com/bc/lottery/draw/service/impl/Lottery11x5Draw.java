package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.entity.Lottery11x5DoubleType;
import com.bc.lottery.entity.Lottery11x5Type;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.util.LotteryUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by luis on 2017/4/14.
 */

public class Lottery11x5Draw {

    /**
     * 11选5传统盘开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    public static List<UserOrderPO> getBoundsInfoOfLottery11x5(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        //TODO 把循环放在switch的里面效率会不会有明显提高？

        List<String> kjList = getRealLottery11x5Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            Lottery11x5Type Lottery11x5Type = (Lottery11x5Type) lotteryType;
            switch (Lottery11x5Type) {

                // 复式玩法
                //前三直选复式
                case QIAN_SAN_ZHI_XUAN_FU_SHI:

                    if (size == 3) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))
                                && betNumbers.get(2).contains(kjList.get(2))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前二直选复式
                case QIAN_ER_ZHI_XUAN_FU_SHI:

                    if (size == 2) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjList.get(0))
                                && betNumbers.get(1).contains(kjList.get(1))
                                ) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前三组选复式
                case QIAN_SAN_ZU_XUAN_FU_SHI:
                    //前二组选复式
                case QIAN_ER_ZU_XUAN_FU_SHI:
                    if (size == 1) {

                        //获取中奖号中的非重复字符
                        if (betNumbers.get(0).containsAll(kjList)) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

                    continue;

                    // 单式玩法
                    // 前三组选单式
                case QIAN_SAN_ZU_XUAN_DAN_SHI:
                    if (size == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 3);
                        for (List<String> stringList : realStringList) {
                            if (stringList.size() != 3) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 前二组选单式
                case QIAN_ER_ZU_XUAN_DAN_SHI:

                    if (size == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 2);
                        for (List<String> stringList : realStringList) {
                            if (stringList.size() != 2) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

                    continue;

                    //前三直选单式
                case QIAN_SAN_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {

                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 3);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 3) {
                                continue;
                            }
                            if (stringList.get(0).contains(kjList.get(0))
                                    && stringList.get(1).contains(kjList.get(1))
                                    && stringList.get(2).contains(kjList.get(2))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //前二直选单式
                case QIAN_ER_ZHI_XUAN_DAN_SHI:

                    if (size == 1) {

                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 2);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 2) {
                                continue;
                            }
                            if (stringList.get(0).contains(kjList.get(0))
                                    && stringList.get(1).contains(kjList.get(1))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一星定位胆
                case YI_XING_DING_WEI_DAN:

                    for (int i = 0; i < betNumbers.size(); i++) {
                        if (betNumbers.get(i) != null && betNumbers.get(i).size() > 0 && betNumbers.get(i).contains(kjList.get(i))) {
                            firstPrizeNum++;
                        }
                    }

                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //一码不定胆
                case QIAN_SAN_YI_MA:

                    if (size == 1) {

                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 定单双
                case DING_DAN_SHUANG_0:
                case DING_DAN_SHUANG_1:
                case DING_DAN_SHUANG_2:
                case DING_DAN_SHUANG_3:
                case DING_DAN_SHUANG_4:
                case DING_DAN_SHUANG_5:

                    if (betNumbers.size() == 1) {

                        //获取中奖号的大小单双
                        String dingDSStr = LotteryUtils.getDingDanShuangString(kjList);

                        for (String betNumber : betNumbers.get(0)) {
                            if (betNumber.equals(dingDSStr)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //猜中位
                case CAI_ZHONG_WEI_3:
                case CAI_ZHONG_WEI_4:
                case CAI_ZHONG_WEI_5:
                case CAI_ZHONG_WEI_6:
                case CAI_ZHONG_WEI_7:
                case CAI_ZHONG_WEI_8:
                case CAI_ZHONG_WEI_9:

                    if (betNumbers.size() == 1) {

                        //获取开奖号码的中位号
                        String dingDSStr = LotteryUtils.getCaiZhongWeiString(kjList);

                        for (String betNumber : betNumbers.get(0)) {
                            if (betNumber.equals(dingDSStr)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 复式一中一
                case FU_SHI_YI_ZHONG_YI:
                    // 单式一中一
                case DAN_SHI_YI_ZHONG_YI:
                    if (betNumbers.size() == 1) {

                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 复式二中二
                case FU_SHI_ER_ZHONG_ER:
                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }

                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 2);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                    // 单式二中二
                case DAN_SHI_ER_ZHONG_ER:
                    if (betNumbers.size() == 1) {

                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 2);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 2) {
                                continue;
                            }
                            if (kjList.containsAll(stringList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 复式三中三
                case FU_SHI_SAN_ZHONG_SAN:
                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }

                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 3);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                    // 单式三中三
                case DAN_SHI_SAN_ZHONG_SAN:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 3);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 3) {
                                continue;
                            }
                            if (kjList.containsAll(stringList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //复式四中四
                case FU_SHI_SI_ZHONG_SI:

                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }

                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 4);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单式四中四
                case DAN_SHI_SI_ZHONG_SI:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 4);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 4) {
                                continue;
                            }
                            if (kjList.containsAll(stringList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //复式五中五
                case FU_SHI_WU_ZHONG_WU:
                    if (betNumbers.size() == 1) {
                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 复式六中五
                case FU_SHI_LIU_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                        lotteryOrder.setFirstPrizeNum((int) LotteryUtils.combination((betNumbers.get(0).size() - 5), 1) * firstPrizeNum);
                    }
                    continue;

                    // 单式五中五
                case DAN_SHI_WU_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 5);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 5) {
                                continue;
                            }
                            if (kjList.containsAll(stringList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单式六中五
                case DAN_SHI_LIU_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 6);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 6) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单式七中五
                case DAN_SHI_QI_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 7);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 7) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //单式八中五
                case DAN_SHI_BA_ZHONG_WU:

                    if (betNumbers.size() == 1) {
                        List<List<String>> realStringList = LotteryUtils.getSubStrList11x5(betNumbers.get(0), 8);
                        for (List<String> stringList : realStringList) {
                            //判断中奖号码是否全部相等
                            if (stringList.size() != 8) {
                                continue;
                            }
                            if (stringList.containsAll(kjList)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //复式七中五
                case FU_SHI_QI_ZHONG_WU:
                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                        lotteryOrder.setFirstPrizeNum((int) LotteryUtils.combination((betNumbers.get(0).size() - 5), 2) * firstPrizeNum);
                    }
                    continue;

                case FU_SHI_BA_ZHONG_WU:

                    if (betNumbers.size() == 1) {

                        int prizeNum = 0;
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                        lotteryOrder.setFirstPrizeNum((int) LotteryUtils.combination((betNumbers.get(0).size() - 5), 3) * firstPrizeNum);
                    }
                    continue;
            }
        }
        return lotteryOrderList;
    }

    /**
     * 11选5双面盘开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    public static List<UserOrderPO> getBoundsInfoOfLottery11x5Double(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        kjNo = kjNo.replace("01", "1").replace("02", "2").replace("03", "3").replace("04", "4").replace("05", "5").replace("06", "6").replace("07", "7").replace("08", "8").replace("09", "9");
        List<String> kjList = getRealLottery11x5Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            Lottery11x5DoubleType lottery11x5DoubleType = (Lottery11x5DoubleType) lotteryType;
            switch (lottery11x5DoubleType) {

                //总和大小单双
                case ZONG_HE_DA:
                    if (betNumbers.size() == 1) {
                        if (LotteryUtils.getStrSum(kjList) == 30) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的总和的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 60, 30);
                            if (firstBetList.contains("大")) {
                                firstPrizeNum++;
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
                    }
                    continue;

                case ZONG_HE_XIAO:
                    if (betNumbers.size() == 1) {
                        if (LotteryUtils.getStrSum(kjList) == 30) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的总和的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 60, 30);
                            if (firstBetList.contains("小")) {
                                firstPrizeNum++;
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
                    }
                    continue;
                case ZONG_HE_DAN:
                    if (betNumbers.size() == 1) {

                        //获取中奖号的总和的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 60);
                        if (firstBetList.contains("单")) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                case ZONG_HE_SHUANG:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的总和的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 60);
                        if (firstBetList.contains("双")) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //总和尾大小
                case ZONG_HE_WEI_DA:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的总和的尾数单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList) % 10, 9);

                        if (firstBetList.contains("大")) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                case ZONG_HE_WEI_XIAO:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的总和的尾数单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList) % 10, 9);

                        if (firstBetList.contains("小")) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //总和龙虎和
                case ZONG_HE_LONG:
                case ZONG_HE_HU:

                    if (betNumbers.size() == 1 && kjList.size() == 5) {

                        //获取中奖号的龙虎和信息
                        List<String> firstBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjList.get(0)), Integer.parseInt(kjList.get(4)));

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //单球大小单双
                case YI_QIU_DA:
                case YI_QIU_XIAO:
                case YI_QIU_DAN:
                case YI_QIU_SHUANG:

                case ER_QIU_DA:
                case ER_QIU_XIAO:
                case ER_QIU_DAN:
                case ER_QIU_SHUANG:

                case SAN_QIU_DA:
                case SAN_QIU_XIAO:
                case SAN_QIU_DAN:
                case SAN_QIU_SHUANG:

                case SI_QIU_DA:
                case SI_QIU_XIAO:
                case SI_QIU_DAN:
                case SI_QIU_SHUANG:

                case WU_QIU_DA:
                case WU_QIU_XIAO:
                case WU_QIU_DAN:
                case WU_QIU_SHUANG:

                    if (betNumbers.size() == 1) {

                        if (LotteryUtils.getStrSum(kjList) == 11) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 11, 11);

                            for (String betNumber : betNumbers.get(0)) {
                                if (firstBetList.contains(betNumber)) {
                                    firstPrizeNum++;
                                }
                            }
                            lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        }
                    }
                    continue;

                    // 单球定位模式
                case YI_QIU_DING_WEI_DAN_1:
                case YI_QIU_DING_WEI_DAN_2:
                case YI_QIU_DING_WEI_DAN_3:
                case YI_QIU_DING_WEI_DAN_4:
                case YI_QIU_DING_WEI_DAN_5:
                case YI_QIU_DING_WEI_DAN_6:
                case YI_QIU_DING_WEI_DAN_7:
                case YI_QIU_DING_WEI_DAN_8:
                case YI_QIU_DING_WEI_DAN_9:
                case YI_QIU_DING_WEI_DAN_10:
                case YI_QIU_DING_WEI_DAN_11:

                case ER_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_9:
                case ER_QIU_DING_WEI_DAN_10:
                case ER_QIU_DING_WEI_DAN_11:

                case SAN_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_9:
                case SAN_QIU_DING_WEI_DAN_10:
                case SAN_QIU_DING_WEI_DAN_11:

                case SI_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_9:
                case SI_QIU_DING_WEI_DAN_10:
                case SI_QIU_DING_WEI_DAN_11:

                case WU_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_9:
                case WU_QIU_DING_WEI_DAN_10:
                case WU_QIU_DING_WEI_DAN_11:

                    if (size == 1) {
                        //判断中间号码是否包含在所选的各组号码中
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一中一玩法
                case YI_ZHONG_YI_1:
                case YI_ZHONG_YI_2:
                case YI_ZHONG_YI_3:
                case YI_ZHONG_YI_4:
                case YI_ZHONG_YI_5:
                case YI_ZHONG_YI_6:
                case YI_ZHONG_YI_7:
                case YI_ZHONG_YI_8:
                case YI_ZHONG_YI_9:
                case YI_ZHONG_YI_10:
                case YI_ZHONG_YI_11:

                    if (size == 1 && betNumbers.get(0).size() == 1) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (kjList.containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //连码玩法
                case LIAN_MA_ER_ZHONG_ER:

                    if (size == 1 && LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() == 2) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (kjList.containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case LIAN_MA_SAN_ZHONG_SAN:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() == 3) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (kjList.containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                case LIAN_MA_SI_ZHONG_SI:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() == 4) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (kjList.containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                case LIAN_MA_WU_ZHONG_WU:

                    if (size == 1 && LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() == 5) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (kjList.containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //连码玩法（从上面拆分出来提高效率）
                case LIAN_MA_LIU_ZHONG_WU:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() == 6) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).containsAll(kjList)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case LIAN_MA_QI_ZHONG_WU:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() == 7) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).containsAll(kjList)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                case LIAN_MA_BA_ZHONG_WU:
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() == 8) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).containsAll(kjList)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                    // 组选模式
                case QIAN_ER_ZU_XUAN:
                case QIAN_SAN_ZU_XUAN:

                    if (size == 1 && LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() == betNumbers.get(0).size()) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).containsAll(kjList)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 直选模式
                case QIAN_ER_ZHI_XUAN:
                case QIAN_SAN_ZHI_XUAN:

                    //获取中奖号码的的特殊玩法值
                    if (kjList.size() != betNumbers.size()) {
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    } else {
                        firstPrizeNum = 1;
                        for (int i = 0; i < kjList.size(); i++) {
                            if (!betNumbers.get(i).contains(kjList.get(i))) {
                                firstPrizeNum = 0;
                                break;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
            }
        }
        return lotteryOrderList;
    }

    /**
     * 获取双面11x5的中奖玩法idlist
     *
     * @param str
     * @return
     */
    public static List<Long> getLottery11x5DoubleBetPlayIds(String str) {

        List<Long> resultList = new ArrayList<>();
        for (Lottery11x5DoubleType lottery11x5DoubleType : Lottery11x5DoubleType.values()) {

            List<String> kjList = getRealLottery11x5Kj(str, lottery11x5DoubleType);

            //获取总和的大小单双
            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 60, 30);

            //获取中奖号的总和的尾数单双
            List<String> tailBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList) % 10, 9);

            //获取单球的大小单双
            List<String> singleBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kjList), 9);

            //获取中奖号的龙虎和信息
            List<String> longhuBetList = new ArrayList<>();
            if (kjList.size() == 5) {
                longhuBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjList.get(0)), Integer.parseInt(kjList.get(4)));
            }

            switch (lottery11x5DoubleType) {

                //总和大小单双
                case ZONG_HE_DA:
                    if (firstBetList.contains("大")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case ZONG_HE_XIAO:
                    if (firstBetList.contains("小")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;
                case ZONG_HE_DAN:
                    if (firstBetList.contains("单")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;
                case ZONG_HE_SHUANG:
                    if (firstBetList.contains("双")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                    //总和尾大小
                case ZONG_HE_WEI_DA:
                    if (tailBetList.contains("大")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case ZONG_HE_WEI_XIAO:
                    if (tailBetList.contains("小")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                    //总和龙虎和
                case ZONG_HE_LONG:
                    if (longhuBetList.contains("龙")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case ZONG_HE_HU:

                    if (longhuBetList.contains("虎")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                    //单球大小单双
                case YI_QIU_DA:
                case ER_QIU_DA:
                case SAN_QIU_DA:
                case SI_QIU_DA:
                case WU_QIU_DA:

                    if (singleBetList.contains("大")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case YI_QIU_XIAO:
                case ER_QIU_XIAO:
                case SAN_QIU_XIAO:
                case SI_QIU_XIAO:
                case WU_QIU_XIAO:
                    if (singleBetList.contains("小")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case YI_QIU_DAN:
                case ER_QIU_DAN:
                case SAN_QIU_DAN:
                case SI_QIU_DAN:
                case WU_QIU_DAN:
                    if (singleBetList.contains("单")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;

                case YI_QIU_SHUANG:
                case ER_QIU_SHUANG:
                case SAN_QIU_SHUANG:
                case SI_QIU_SHUANG:
                case WU_QIU_SHUANG:
                    if (singleBetList.contains("双")) {
                        resultList.add(lottery11x5DoubleType.value());
                    }
                    continue;
            }
        }
        return resultList;
    }

    /**
     * 整理11选5的开奖号码
     *
     * @param kj
     * @param lotteryType
     * @return
     */
    private static List<String> getRealLottery11x5Kj(String kj, LotteryType lotteryType) {

        List<String> resultList = new ArrayList<>();

        List<String> kjList = Arrays.asList(kj.replace(" ", ",").replace("|", ",").split(","));

        if (kjList.size() != 5) {
            return resultList;
        }
        if (lotteryType instanceof Lottery11x5DoubleType) {

            Lottery11x5DoubleType lottery11x5DoubleType = (Lottery11x5DoubleType) lotteryType;
            switch (lottery11x5DoubleType) {

                // 截取总和
                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:
                case ZONG_HE_LONG:
                case ZONG_HE_HU:
                case ZONG_HE_WEI_DA:
                case ZONG_HE_WEI_XIAO:

                case YI_ZHONG_YI_1:
                case YI_ZHONG_YI_2:
                case YI_ZHONG_YI_3:
                case YI_ZHONG_YI_4:
                case YI_ZHONG_YI_5:
                case YI_ZHONG_YI_6:
                case YI_ZHONG_YI_7:
                case YI_ZHONG_YI_8:
                case YI_ZHONG_YI_9:
                case YI_ZHONG_YI_10:
                case YI_ZHONG_YI_11:

                case LIAN_MA_ER_ZHONG_ER:
                case LIAN_MA_SAN_ZHONG_SAN:
                case LIAN_MA_SI_ZHONG_SI:
                case LIAN_MA_WU_ZHONG_WU:
                case LIAN_MA_LIU_ZHONG_WU:
                case LIAN_MA_QI_ZHONG_WU:
                case LIAN_MA_BA_ZHONG_WU:
                    resultList.addAll(kjList);
                    break;

                // 截取前二号码
                case QIAN_ER_ZU_XUAN:
                case QIAN_ER_ZHI_XUAN:
                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    break;

                // 截取前三号码
                case QIAN_SAN_ZU_XUAN:
                case QIAN_SAN_ZHI_XUAN:
                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(2));
                    break;

                // 一球号码
                case YI_QIU_DA:
                case YI_QIU_XIAO:
                case YI_QIU_DAN:
                case YI_QIU_SHUANG:
                case YI_QIU_DING_WEI_DAN_1:
                case YI_QIU_DING_WEI_DAN_2:
                case YI_QIU_DING_WEI_DAN_3:
                case YI_QIU_DING_WEI_DAN_4:
                case YI_QIU_DING_WEI_DAN_5:
                case YI_QIU_DING_WEI_DAN_6:
                case YI_QIU_DING_WEI_DAN_7:
                case YI_QIU_DING_WEI_DAN_8:
                case YI_QIU_DING_WEI_DAN_9:
                case YI_QIU_DING_WEI_DAN_10:
                case YI_QIU_DING_WEI_DAN_11:
                    resultList.add(kjList.get(0));
                    break;

                // 二球号码
                case ER_QIU_DA:
                case ER_QIU_XIAO:
                case ER_QIU_DAN:
                case ER_QIU_SHUANG:
                case ER_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_9:
                case ER_QIU_DING_WEI_DAN_10:
                case ER_QIU_DING_WEI_DAN_11:

                    resultList.add(kjList.get(1));
                    break;
                // 三球号码
                case SAN_QIU_DA:
                case SAN_QIU_XIAO:
                case SAN_QIU_DAN:
                case SAN_QIU_SHUANG:
                case SAN_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_9:
                case SAN_QIU_DING_WEI_DAN_10:
                case SAN_QIU_DING_WEI_DAN_11:
                    resultList.add(kjList.get(2));
                    break;
                // 四球号码
                case SI_QIU_DA:
                case SI_QIU_XIAO:
                case SI_QIU_DAN:
                case SI_QIU_SHUANG:
                case SI_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_9:
                case SI_QIU_DING_WEI_DAN_10:
                case SI_QIU_DING_WEI_DAN_11:
                    resultList.add(kjList.get(3));
                    break;

                // 五球号码
                case WU_QIU_DA:
                case WU_QIU_XIAO:
                case WU_QIU_DAN:
                case WU_QIU_SHUANG:
                case WU_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_9:
                case WU_QIU_DING_WEI_DAN_10:
                case WU_QIU_DING_WEI_DAN_11:
                    resultList.add(kjList.get(4));
                    break;
            }
        } else if (lotteryType instanceof Lottery11x5Type) {

            Lottery11x5Type lottery11x5Type = (Lottery11x5Type) lotteryType;
            switch (lottery11x5Type) {

                // 截取总和
                case QIAN_SAN_YI_MA:
                case YI_XING_DING_WEI_DAN:
                case QIAN_SAN_ZHI_XUAN_FU_SHI:
                case QIAN_SAN_ZHI_XUAN_DAN_SHI:
                case QIAN_SAN_ZU_XUAN_FU_SHI:
                case QIAN_SAN_ZU_XUAN_DAN_SHI:

                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    resultList.add(kjList.get(2));
                    break;

                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:

                    resultList.add(kjList.get(0));
                    resultList.add(kjList.get(1));
                    break;

                case CAI_ZHONG_WEI_3:
                case CAI_ZHONG_WEI_4:
                case CAI_ZHONG_WEI_5:
                case CAI_ZHONG_WEI_6:
                case CAI_ZHONG_WEI_7:
                case CAI_ZHONG_WEI_8:
                case CAI_ZHONG_WEI_9:

                case DING_DAN_SHUANG_0:
                case DING_DAN_SHUANG_1:
                case DING_DAN_SHUANG_2:
                case DING_DAN_SHUANG_3:
                case DING_DAN_SHUANG_4:
                case DING_DAN_SHUANG_5:

                case DAN_SHI_YI_ZHONG_YI:
                case DAN_SHI_ER_ZHONG_ER:
                case DAN_SHI_SAN_ZHONG_SAN:
                case DAN_SHI_SI_ZHONG_SI:
                case DAN_SHI_WU_ZHONG_WU:
                case DAN_SHI_LIU_ZHONG_WU:
                case DAN_SHI_QI_ZHONG_WU:
                case DAN_SHI_BA_ZHONG_WU:

                case FU_SHI_YI_ZHONG_YI:
                case FU_SHI_ER_ZHONG_ER:
                case FU_SHI_SAN_ZHONG_SAN:
                case FU_SHI_SI_ZHONG_SI:
                case FU_SHI_WU_ZHONG_WU:
                case FU_SHI_LIU_ZHONG_WU:
                case FU_SHI_QI_ZHONG_WU:
                case FU_SHI_BA_ZHONG_WU:

                    resultList.addAll(kjList);
                    break;
            }
        }
        return resultList;
    }
}
