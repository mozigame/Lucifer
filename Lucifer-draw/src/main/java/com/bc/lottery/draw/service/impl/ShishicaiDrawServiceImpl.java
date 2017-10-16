package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.draw.service.LotteryDrawHandle;
import com.bc.lottery.entity.Lottery11x5DoubleType;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.entity.ShishicaiDoubleType;
import com.bc.lottery.entity.ShishicaiType;
import com.bc.lottery.util.LotteryUtils;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by luis on 2017/4/14.
 */

public class ShishicaiDrawServiceImpl implements LotteryDrawHandle {

    private static final int[] ZHI_XUAN_KUA_DU = {10, 54, 96, 126, 144, 150, 144, 126, 96, 54};

    private static final int[] SAN_XING_ZHI_XUAN_HE_ZHI = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
    private static final int[] SAN_XING_ZU_XUAN_HE_ZHI = {0, 1, 2, 2, 4, 5, 6, 8, 10, 11, 13, 14, 14, 15, 15, 14, 14, 13, 11, 10, 8, 6, 5, 4, 2, 2, 1};

    private static final int[] ER_XING_ZHI_XUAN_HE_ZHI = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final int[] ER_XING_ZU_XUAN_HE_ZHI = {0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 4, 4, 3, 3, 2, 2, 1, 1};

    @Override
    public UserOrderPO getBoundsInfoOfLottery(String kj, UserOrderPO order) {

        if (kj.length() != 5) {
            return null;
        }
        List<UserOrderPO> lotteryOrderList = new ArrayList<>();
        lotteryOrderList.add(order);
        LotteryType lotteryType = LotteryType.parseType(order.getLotteryId(), order.getPlayId());
        String realLotteryKj = getRealLotteryKj(kj, lotteryType);
        // 如果类型属于传统时时彩
        if (lotteryType instanceof ShishicaiType) {

            return getBoundsInfoOfShishicai(lotteryType, realLotteryKj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof ShishicaiDoubleType) {

            return getBoundsInfoOfShishicaiDouble(lotteryType, realLotteryKj, lotteryOrderList).get(0);
        } else if (lotteryType instanceof Lottery11x5DoubleType) {

            return getBoundsInfoOfShishicai(lotteryType, realLotteryKj, lotteryOrderList).get(0);
        }

        return order;
    }

    private String getRealLotteryKj(String kj, LotteryType lotteryType) {

        String realLotteryKj = kj;
        if (lotteryType instanceof ShishicaiType) {
            ShishicaiType shishicaiType = (ShishicaiType) lotteryType;

            switch (shishicaiType) {

                // 截取四星中奖号
                case SI_XING_ZHI_XUAN_ZU_HE:
                case SI_XING_ZHI_XUAN_DAN_SHI:
                case SI_XING_ZHI_XUAN_FU_SHI:
                case ZU_XUAN_24:
                case ZU_XUAN_12:
                case ZU_XUAN_6:
                case ZU_XUAN_4:
                    realLotteryKj = kj.substring(1, 5);
                    break;

                // 截取三星号码
                case QIAN_SAN_DAN_SHI:
                case QIAN_SAN_FU_SHI:
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case QIAN_SAN_ZHI_XUAN_HE_ZHI:
                case QIAN_SAN_ZU_LIU:
                case QIAN_SAN_ZU_SAN:
                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(0, 3);
                    break;
                case ZHONG_SAN_DAN_SHI:
                case ZHONG_SAN_FU_SHI:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(1, 4);
                    break;
                case HOU_SAN_DAN_SHI:
                case HOU_SAN_FU_SHI:
                case HOU_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                case HOU_SAN_ZU_LIU:
                case HOU_SAN_ZU_SAN:
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(2, 5);
                    break;

                // 二星号码
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_HE_ZHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(0, 2);
                    break;
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_FU_SHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_FU_SHI:
                case HOU_ER_ZU_XUAN_HE_ZHI:
                    realLotteryKj = kj.substring(3, 5);
                    break;

                case QIAN_SAN_YI_MA:
                case QIAN_SAN_ER_MA:

                    realLotteryKj = kj.substring(0, 3);
                    break;
                case HOU_SAN_YI_MA:
                case HOU_SAN_ER_MA:
                    realLotteryKj = kj.substring(2, 5);
                    break;
            }
        } else if (lotteryType instanceof ShishicaiDoubleType) {

            ShishicaiDoubleType shishicaiDoubleType = (ShishicaiDoubleType) lotteryType;

            switch (shishicaiDoubleType) {

                // 截取总和
                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:
                case ZONG_HE_LONG:
                case ZONG_HE_HU:
                case ZONG_HE_HE:
                    realLotteryKj = kj.substring(0, 5);
                    break;

                // 截取三星号码
                case QIAN_SAN_BAO_ZI:
                case QIAN_SAN_SHUN_ZI:
                case QIAN_SAN_DUI_ZI:
                case QIAN_SAN_BAN_SHUN:
                case QIAN_SAN_ZA_LIU:
                    realLotteryKj = kj.substring(0, 3);
                    break;
                case ZHONG_SAN_BAO_ZI:
                case ZHONG_SAN_SHUN_ZI:
                case ZHONG_SAN_DUI_ZI:
                case ZHONG_SAN_BAN_SHUN:
                case ZHONG_SAN_ZA_LIU:
                    realLotteryKj = kj.substring(1, 4);
                    break;
                case HOU_SAN_BAO_ZI:
                case HOU_SAN_SHUN_ZI:
                case HOU_SAN_DUI_ZI:
                case HOU_SAN_BAN_SHUN:
                case HOU_SAN_ZA_LIU:
                    realLotteryKj = kj.substring(2, 5);
                    break;

                // 一球号码
                case YI_QIU_DA:
                case YI_QIU_XIAO:
                case YI_QIU_DAN:
                case YI_QIU_SHUANG:
                case YI_QIU_DING_WEI_DAN_0:
                case YI_QIU_DING_WEI_DAN_1:
                case YI_QIU_DING_WEI_DAN_2:
                case YI_QIU_DING_WEI_DAN_3:
                case YI_QIU_DING_WEI_DAN_4:
                case YI_QIU_DING_WEI_DAN_5:
                case YI_QIU_DING_WEI_DAN_6:
                case YI_QIU_DING_WEI_DAN_7:
                case YI_QIU_DING_WEI_DAN_8:
                case YI_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(0, 1);
                    break;

                // 二球号码
                case ER_QIU_DA:
                case ER_QIU_XIAO:
                case ER_QIU_DAN:
                case ER_QIU_SHUANG:
                case ER_QIU_DING_WEI_DAN_0:
                case ER_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(1, 2);
                    break;

                // 三球号码
                case SAN_QIU_DA:
                case SAN_QIU_XIAO:
                case SAN_QIU_DAN:
                case SAN_QIU_SHUANG:
                case SAN_QIU_DING_WEI_DAN_0:
                case SAN_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(2, 3);
                    break;

                // 四球号码
                case SI_QIU_DA:
                case SI_QIU_XIAO:
                case SI_QIU_DAN:
                case SI_QIU_SHUANG:
                case SI_QIU_DING_WEI_DAN_0:
                case SI_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(3, 4);
                    break;

                // 五球号码
                case WU_QIU_DA:
                case WU_QIU_XIAO:
                case WU_QIU_DAN:
                case WU_QIU_SHUANG:
                case WU_QIU_DING_WEI_DAN_0:
                case WU_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_9:
                    realLotteryKj = kj.substring(4, 5);
                    break;
            }
        } else if (lotteryType instanceof Lottery11x5DoubleType) {

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
                    realLotteryKj = kj.substring(0, 5);
                    break;

                // 截取前二号码
                case QIAN_ER_ZU_XUAN:
                case QIAN_ER_ZHI_XUAN:
                    realLotteryKj = kj.substring(0, 2);
                    break;

                // 截取前三号码
                case QIAN_SAN_ZU_XUAN:
                case QIAN_SAN_ZHI_XUAN:
                    realLotteryKj = kj.substring(0, 3);
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
                    realLotteryKj = kj.substring(0, 1);
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
                    realLotteryKj = kj.substring(1, 2);
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
                    realLotteryKj = kj.substring(2, 3);
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
                    realLotteryKj = kj.substring(3, 4);
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
                    realLotteryKj = kj.substring(4, 5);
                    break;
            }
        }

        return realLotteryKj;
    }

    @Override
    public List<UserOrderPO> getBatchBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<UserOrderPO> lotteryOrderList) {

        if (kj.length() != 5 || lotteryOrderList.size() == 0) {
            return null;
        }
        // 如果类型属于五星
        String realLotteryKj = getRealLotteryKj(kj, lotteryType);

        return getBoundsInfoOfShishicai(lotteryType, realLotteryKj, lotteryOrderList);

    }

    //TODO 把循环放在switch的里面效率会不会有明显提高？

    /**
     * 时时彩传统盘开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfShishicai(LotteryType lotteryType, String kj, List<UserOrderPO> lotteryOrderList) {

        String[] kjArr = kj.split("");
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数
            int secondPrizeNum = 0;// 二等奖次数
            int thirdPrizeNum = 0; // 三等奖次数
            int forthPrizeNum = 0; // 四等奖次数
            int fifthPrizeNum = 0; // 五等奖次数

            Set<String> kjStrList = new HashSet<>();
            ShishicaiType shishicaiType = (ShishicaiType) lotteryType;
            switch (shishicaiType) {

                // 五星直选复式
                case WU_XING_ZHI_XUAN_FU_SHI:
                    if (size == 5) {
                        //判断中间号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjArr[0])
                                && betNumbers.get(1).contains(kjArr[1])
                                && betNumbers.get(2).contains(kjArr[2])
                                && betNumbers.get(3).contains(kjArr[3])
                                && betNumbers.get(4).contains(kjArr[4])) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 五星直选单式
                case WU_XING_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && betNumber.equals(kj)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case WU_XING_ZHI_XUAN_ZU_HE:
                    if (size == 5) {
                        // 判断是否中五等奖
                        if (betNumbers.get(4).contains(kjArr[4])) {
                            fifthPrizeNum++;
                            // 判断是否中四等奖
                            if (betNumbers.get(3).contains(kjArr[3])) {
                                forthPrizeNum++;
                                // 判断是否中三等奖
                                if (betNumbers.get(2).contains(kjArr[2])) {
                                    thirdPrizeNum++;
                                    // 判断是否中二等奖
                                    if (betNumbers.get(1).contains(kjArr[1])) {
                                        secondPrizeNum++;
                                        // 判断是否中一等奖
                                        if (betNumbers.get(0).contains(kjArr[0])) {
                                            firstPrizeNum++;
                                        }
                                    }
                                }
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                        lotteryOrder.setThirdPrizeNum(thirdPrizeNum);
                        lotteryOrder.setForthPrizeNum(forthPrizeNum);
                        lotteryOrder.setFifthPrizeNum(fifthPrizeNum);
                    }
                    continue;

                case ZU_XUAN_120:
                    if (size == 1 && checkIsZu120(kj)) {

                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(unDupStrList)) {

                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_60:
                    if (size == 2 && checkIsZu60(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_30:
                    if (size == 2 && checkIsZu30(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).contains(LotteryUtils.getUnDupStr(kj).get(0))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_20:
                    if (size == 2 && checkIsZu20(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_10:
                    if (size == 2 && checkIsZu10(kj)) {

                        //获取中奖号中的重复3次的字符
                        Set<String> dupStrList = LotteryUtils.getDupStrByDupNum(kj, 3);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getDupStrByDupNum(kj, 2))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;
                case ZU_XUAN_5:
                    if (size == 2 && checkIsZu5(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).contains(LotteryUtils.getUnDupStr(kj).get(0))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 四星玩法
                    //四星直选复式
                case SI_XING_ZHI_XUAN_FU_SHI:

                    if (size == 4) {
                        //判断中间号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjArr[0])
                                && betNumbers.get(1).contains(kjArr[1])
                                && betNumbers.get(2).contains(kjArr[2])
                                && betNumbers.get(3).contains(kjArr[3])) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 四星直选单式
                case SI_XING_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && betNumber.equals(kj)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case SI_XING_ZHI_XUAN_ZU_HE:
                    if (size == 4) {
                        // 判断是否中四等奖
                        if (betNumbers.get(3).contains(kjArr[3])) {
                            forthPrizeNum++;
                            // 判断是否中三等奖
                            if (betNumbers.get(2).contains(kjArr[2])) {
                                thirdPrizeNum++;
                                // 判断是否中二等奖
                                if (betNumbers.get(1).contains(kjArr[1])) {
                                    secondPrizeNum++;
                                    // 判断是否中一等奖
                                    if (betNumbers.get(0).contains(kjArr[0])) {
                                        firstPrizeNum++;
                                    }
                                }
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                        lotteryOrder.setThirdPrizeNum(thirdPrizeNum);
                        lotteryOrder.setForthPrizeNum(forthPrizeNum);
                    }
                    continue;

                case ZU_XUAN_24:
                    if (size == 1 && checkIsZu24(kj)) {

                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(unDupStrList)) {

                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_12:
                    if (size == 2 && checkIsZu12(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_6:
                    if (size == 1 && checkIsZu6(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZU_XUAN_4:
                    if (size == 2 && checkIsZu4(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList)) {

                            //判断中奖号中的非重复字符是否全部选中
                            if (betNumbers.get(1).containsAll(LotteryUtils.getUnDupStr(kj))) {
                                firstPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三星玩法
                    //三星复式
                case QIAN_SAN_FU_SHI:
                case ZHONG_SAN_FU_SHI:
                case HOU_SAN_FU_SHI:

                    if (size == 3) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjArr[0])
                                && betNumbers.get(1).contains(kjArr[1])
                                && betNumbers.get(2).contains(kjArr[2])) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三星单式
                case QIAN_SAN_DAN_SHI:
                case ZHONG_SAN_DAN_SHI:
                case HOU_SAN_DAN_SHI:
                    if (size == 1) {
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && betNumber.equals(kj)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三星直选和值
                case QIAN_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                    if (size == 1) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //三星组三
                case QIAN_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_SAN:
                case HOU_SAN_ZU_SAN:
                    if (size == 1 && checkIsZu3(kj)) {

                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(dupStrList) && betNumbers.get(0).containsAll(unDupStrList)) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //三星组六
                case QIAN_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_LIU:
                case HOU_SAN_ZU_LIU:
                    if (size == 1 && checkIsSanxingZu6(kj)) {

                        //判断中奖号中的非重复字符是否全部选中
                        if (betNumbers.get(0).containsAll(LotteryUtils.getUnDupStr(kj))) {
                            firstPrizeNum = 1;
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 三星组选和值
                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                    if (size == 1 && checkIsSanxingZuHe(kj)) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {

                            //判断是否中组三一等奖
                            if (checkIsZu3(kj)) {
                                firstPrizeNum = 1;
                            }
                            //判断是否中三星组六一等奖
                            else if (checkIsSanxingZu6(kj)) {
                                secondPrizeNum = 1;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                    }
                    continue;

                    // 三星混合组选
                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_HUN_HE_ZU_XUAN:
                    // 获取注单号码
                    if (size == 1) {
                        List<List<String>> betNumberList = getSanxingBetNumbers(betNumbers);

                        if (checkIsZu3(kj)) {
                            for (List<String> betNumber : betNumberList) {
                                StringBuilder orderNumber = new StringBuilder();
                                for (String bet : betNumber) {
                                    orderNumber.append(bet);
                                }
                                if (betNumber.size() != 3 || !checkIsZu3(orderNumber.toString())) {
                                    continue;
                                }
                                // 判断是否中组三一等奖(判断重复位和非重复位分别是否相等)
                                if (LotteryUtils.getDupStrByDupNum(betNumber.toString(), 2).containsAll(LotteryUtils.getDupStr(kj))
                                        && betNumber.containsAll(LotteryUtils.getUnDupStr(kj))) {
                                    firstPrizeNum++;
                                }
                            }
                        } else if (checkIsSanxingZu6(kj)) {
                            for (List<String> betNumber : betNumberList) {

                                // 判断是否中组三一等奖(判断重复位和非重复位分别是否相等)
                                if (betNumber.containsAll(LotteryUtils.getUnDupStr(kj))) {
                                    secondPrizeNum++;
                                }
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                        lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                    }
                    continue;

                    // 二星
                    //二星直选复式
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case HOU_ER_ZHI_XUAN_FU_SHI:

                    if (size == 2) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(kjArr[0])
                                && betNumbers.get(1).contains(kjArr[1])
                                ) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二星直选单式
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_DAN_SHI:

                    if (size == 1) {
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && betNumber.equals(kj)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

                    continue;

                    //二星组选复式
                case QIAN_ER_ZU_XUAN_FU_SHI:
                case HOU_ER_ZU_XUAN_FU_SHI:
                    if (size == 1 && checkIsErxingFuShi(kj)) {

                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(unDupStrList)) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }

                    continue;

                    //二星组合单式
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:
                    if (size == 1 && checkIsErxingFuShi(kj)) {
                        String anotherKj = kjArr[1] + kjArr[0];
                        List<String> betNumberList = getBetNumbers(lotteryType, betNumbers);
                        for (String betNumber : betNumberList) {
                            if (betNumber != null && (betNumber.equals(kj) || betNumber.equals(anotherKj))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二星直选和值
                case QIAN_ER_ZHI_XUAN_HE_ZHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                    if (size == 1) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二星组选和值
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                case HOU_ER_ZU_XUAN_HE_ZHI:
                    if (size == 1 && checkIsErxingFuShi(kj)) {
                        //判断中奖号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).contains(String.valueOf(LotteryUtils.getStrSum(kj)))) {
                            firstPrizeNum = 1;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一星定位胆
                case YI_XING_DING_WEI_DAN:

                    for (int i = 0; i < betNumbers.size(); i++) {
                        if (betNumbers.get(i) != null && betNumbers.get(i).size() > 0 && betNumbers.get(i).contains(kjArr[i])) {
                            firstPrizeNum++;
                        }
                    }

                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //一码不定胆
                case QIAN_SAN_YI_MA:
                case HOU_SAN_YI_MA:

                    if (size == 1) {
                        //TODO 是否需要优化
                        //获取中奖号中的重复字符
                        Set<String> dupStrList = LotteryUtils.getDupStr(kj);
                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        for (String betNumber : betNumbers.get(0)) {
                            if (dupStrList.contains(betNumber) || unDupStrList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 二码不定胆
                case QIAN_SAN_ER_MA:
                case HOU_SAN_ER_MA:

                    //先判断是不是豹子号
                    if (size == 1 && LotteryUtils.getDupStrByDupNum(kj, 3).size() == 0) {

                        int betNum = 0; // 中奖号码数
                        for (String betNumber : betNumbers.get(0)) {
                            if (kj.contains(betNumber)) {
                                betNum++;
                            }
                        }
                        if (betNum >= 2) {
                            firstPrizeNum = (int) LotteryUtils.combination(betNum, 2);
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //前二码大小单双
                case QIAN_ER_DA_XIAO_DAN_SHUANG:
                    if (betNumbers.size() == 2) {

                        int firstBetNum = 0;
                        int secondBetNum = 0;
                        //获取中奖号的第一个号码的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjArr[0]), 9);
                        //获取中奖号的第二个号码的大小单双
                        List<String> secondBetList = LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjArr[1]), 9);

                        for (String kjNo : firstBetList) {
                            if (betNumbers.get(0).contains(kjNo)) {
                                firstBetNum++;
                            }
                        }
                        for (String kjNo : secondBetList) {
                            if (betNumbers.get(1).contains(kjNo)) {
                                secondBetNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstBetNum * secondBetNum);
                    }
                    continue;

                    //后二码大小单双
                case HOU_ER_DA_XIAO_DAN_SHUANG:

                    if (betNumbers.size() == 2) {

                        int firstBetNum = 0;
                        int secondBetNum = 0;
                        //获取中奖号的第一个号码的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjArr[3]), 9);
                        //获取中奖号的第二个号码的大小单双
                        List<String> secondBetList = LotteryUtils.getDaxiaodanshuangList(Integer.parseInt(kjArr[4]), 9);

                        for (String kjNo : firstBetList) {
                            if (betNumbers.get(0).contains(kjNo)) {
                                firstBetNum++;
                            }
                        }
                        for (String kjNo : secondBetList) {
                            if (betNumbers.get(1).contains(kjNo)) {
                                secondBetNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstBetNum * secondBetNum);
                    }
                    continue;

                    //总和大小单双
                case ZONG_HE_DA_XIAO_DAN_SHUANG:

                    if (betNumbers.size() == 1) {

                        //获取中奖号的第一个号码的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 45);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //一帆风顺
                case YI_FAN_FENG_SHUN:

                    for (String betNumber : betNumbers.get(0)) {
                        if (kj.contains(betNumber)) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //好事成双
                case HAO_SHI_CHENG_SHUANG:

                    kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 2);
                    if (kjStrList.size() == 0) {
                        continue;
                    }

                    for (String betNumber : betNumbers.get(0)) {
                        if (kjStrList.contains(betNumber)) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //三星报喜
                case SAN_XING_BAO_XI:

                    kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 3);
                    if (kjStrList.size() == 0) {
                        continue;
                    }
                    for (String betNumber : betNumbers.get(0)) {
                        if (kjStrList.contains(betNumber)) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;
                    //四季发财
                case SI_JI_FA_CAI:

                    kjStrList = LotteryUtils.getDupStrByMixDupNum(kj, 4);
                    if (kjStrList.size() == 0) {
                        continue;
                    }
                    for (String betNumber : betNumbers.get(0)) {
                        if (kjStrList.contains(betNumber)) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;
            }
        }
        return lotteryOrderList;
    }


    /**
     * 时时彩双面盘开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfShishicaiDouble(LotteryType lotteryType, String kj, List<UserOrderPO> lotteryOrderList) {

        String[] kjArr = kj.split("");
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            Set<String> kjStrList = new HashSet<>();
            ShishicaiDoubleType shishicaiType = (ShishicaiDoubleType) lotteryType;
            switch (shishicaiType) {


                //总和大小单双
                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:

                    if (betNumbers.size() == 1) {

                        //获取总和的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 45);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //总和龙虎和
                case ZONG_HE_LONG:
                case ZONG_HE_HU:
                case ZONG_HE_HE:

                    if (betNumbers.size() == 1 && kjArr.length == 5) {

                        //获取中奖号的龙虎和信息
                        List<String> firstBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjArr[0]), Integer.parseInt(kjArr[4]));

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

                        //获取中奖号的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 9);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 单球定位模式
                case YI_QIU_DING_WEI_DAN_0:
                case YI_QIU_DING_WEI_DAN_1:
                case YI_QIU_DING_WEI_DAN_2:
                case YI_QIU_DING_WEI_DAN_3:
                case YI_QIU_DING_WEI_DAN_4:
                case YI_QIU_DING_WEI_DAN_5:
                case YI_QIU_DING_WEI_DAN_6:
                case YI_QIU_DING_WEI_DAN_7:
                case YI_QIU_DING_WEI_DAN_8:
                case YI_QIU_DING_WEI_DAN_9:

                case ER_QIU_DING_WEI_DAN_0:
                case ER_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_9:

                case SAN_QIU_DING_WEI_DAN_0:
                case SAN_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_9:

                case SI_QIU_DING_WEI_DAN_0:
                case SI_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_9:

                case WU_QIU_DING_WEI_DAN_0:
                case WU_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_9:

                    if (size == 1) {
                        //判断中间号码是否包含在所选的各组号码中
                        for (String betNumber : betNumbers.get(0)) {
                            if (kj.contains(betNumber) || kj.equals(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 特殊玩法模式
                case QIAN_SAN_BAO_ZI:
                case QIAN_SAN_SHUN_ZI:
                case QIAN_SAN_DUI_ZI:
                case QIAN_SAN_BAN_SHUN:
                case QIAN_SAN_ZA_LIU:

                case ZHONG_SAN_BAO_ZI:
                case ZHONG_SAN_SHUN_ZI:
                case ZHONG_SAN_DUI_ZI:
                case ZHONG_SAN_BAN_SHUN:
                case ZHONG_SAN_ZA_LIU:

                case HOU_SAN_BAO_ZI:
                case HOU_SAN_SHUN_ZI:
                case HOU_SAN_DUI_ZI:
                case HOU_SAN_BAN_SHUN:
                case HOU_SAN_ZA_LIU:

                    if (size == 1) {
                        //获取中奖号码的的特殊玩法值
                        List<String> firstBetList = LotteryUtils.getDoubleTeShuWanFaList(kj);
                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
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
     * 11选5双面盘开奖算法
     *
     * @param lotteryType
     * @param kj
     * @param lotteryOrderList
     * @return
     */
    private List<UserOrderPO> getBoundsInfoOfLottery11x5Double(LotteryType lotteryType, String kj, List<UserOrderPO> lotteryOrderList) {

        String[] kjArr = kj.split("");
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int size = betNumbers.size();
            int firstPrizeNum = 0; // 一等奖次数

            Set<String> kjStrList = new HashSet<>();
            Lottery11x5DoubleType lottery11x5DoubleType = (Lottery11x5DoubleType) lotteryType;
            switch (lottery11x5DoubleType) {


                //总和大小单双
                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:

                    if (betNumbers.size() == 1) {

                        //获取中奖号的总和的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 66);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //总和大小单双
                case ZONG_HE_WEI_DA:
                case ZONG_HE_WEI_XIAO:

                    if (betNumbers.size() == 1) {

                        //获取中奖号的总和的尾数单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj) % 10, 9);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //总和龙虎和
                case ZONG_HE_LONG:
                case ZONG_HE_HU:

                    if (betNumbers.size() == 1 && kjArr.length == 5) {

                        //获取中奖号的龙虎和信息
                        List<String> firstBetList = LotteryUtils.getLongHuHeList(Integer.parseInt(kjArr[0]), Integer.parseInt(kjArr[4]));

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

                        //获取中奖号的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(kj), 9);

                        for (String betNumber : betNumbers.get(0)) {
                            if (firstBetList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }

                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
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
                            if (kj.contains(betNumber) || kj.equals(betNumber)) {
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

                    //连码玩法
                case LIAN_MA_ER_ZHONG_ER:
                case LIAN_MA_SAN_ZHONG_SAN:
                case LIAN_MA_SI_ZHONG_SI:
                case LIAN_MA_WU_ZHONG_WU:

                    if (size == 1) {
                        Set<String> kjSet = LotteryUtils.getDupStrByDupNum(kj, 1);
                        //判断中间号码是否包含在所选的各组号码中
                        if (kjSet.containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    //连码玩法（从上面拆分出来提高效率）
                case LIAN_MA_LIU_ZHONG_WU:
                case LIAN_MA_QI_ZHONG_WU:
                case LIAN_MA_BA_ZHONG_WU:

                    if (size == 1) {
                        Set<String> kjSet = LotteryUtils.getDupStrByDupNum(kj, 1);
                        //判断中间号码是否包含在所选的各组号码中
                        if (betNumbers.get(0).containsAll(kjSet)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 组选模式
                case QIAN_ER_ZU_XUAN:
                case QIAN_SAN_ZU_XUAN:

                    if (size == 1) {
                        //获取中奖号中的非重复字符
                        List<String> unDupStrList = LotteryUtils.getUnDupStr(kj);
                        if (betNumbers.get(0).containsAll(unDupStrList)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 直选模式
                case QIAN_ER_ZHI_XUAN:
                case QIAN_SAN_ZHI_XUAN:

                    //获取中奖号码的的特殊玩法值
                    List<String> kjList = LotteryUtils.getUnDupStr(kj);
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
     * 获取注单号码列表  --支持类型 (五星直选单式,四星直选单式,三星直选单式)
     *
     * @param lotteryType
     * @param betNumbers
     * @return
     */
    private List<String> getBetNumbers(LotteryType lotteryType, List<List<String>> betNumbers) {

        // 如果类型属于五星
        ShishicaiType shishicaiType = (ShishicaiType) lotteryType;
        switch (shishicaiType) {

            // 五星直选单式
            case WU_XING_ZHI_XUAN_DAN_SHI:
                return LotteryUtils.getSubStrList(betNumbers.get(0), 5);

            // 四星直选单式
            case SI_XING_ZHI_XUAN_DAN_SHI:
                return LotteryUtils.getSubStrList(betNumbers.get(0), 4);

            // 三星直选单式
            case QIAN_SAN_DAN_SHI:
            case ZHONG_SAN_DAN_SHI:
            case HOU_SAN_DAN_SHI:

                // 三星混合组选
            case QIAN_SAN_HUN_HE_ZU_XUAN:
            case ZHONG_SAN_HUN_HE_ZU_XUAN:
            case HOU_SAN_HUN_HE_ZU_XUAN:
                return LotteryUtils.getSubStrList(betNumbers.get(0), 3);

            // 二星直选单式
            case QIAN_ER_ZHI_XUAN_DAN_SHI:
            case HOU_ER_ZHI_XUAN_DAN_SHI:
                // 二星混合组选
            case QIAN_ER_ZU_XUAN_DAN_SHI:
            case HOU_ER_ZU_XUAN_DAN_SHI:
                return LotteryUtils.getSubStrList(betNumbers.get(0), 2);
        }

        return null;
    }

    /**
     * 获取注单号码列表  --支持类型 (三星混合组选)
     *
     * @param betNumbers
     * @return
     */
    private List<List<String>> getSanxingBetNumbers(List<List<String>> betNumbers) {

        return LotteryUtils.getStrListForSanxing(betNumbers.get(0), 3);
    }

    /**
     * 判断中奖号是否满足组120规则
     *
     * @param kjStr
     * @return
     */

    private boolean checkIsZu120(String kjStr) {
        // TODO 可用正则优化  /^(\d),\1,\1/
        //return !kjStr.matches("/^(\\d),\\1,\\1/") && !LotteryUtils.checkDifferent(kjStr);

        return LotteryUtils.getUnDupStr(kjStr).size() == 5;
    }

    /**
     * 判断中奖号是否满足组60规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu60(String kjStr) {
        // TODO 可用正则优化  /^(\d),\1,\1/
        //return !kjStr.matches("/^(\\d),\\1,\\1/") && !LotteryUtils.checkDifferent(kjStr);

        return LotteryUtils.getDupStr(kjStr).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 3;
    }

    /**
     * 判断中奖号是否满足组30规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu30(String kjStr) {
        return LotteryUtils.getDupStr(kjStr).size() == 2 && LotteryUtils.getUnDupStr(kjStr).size() == 1;
    }

    /**
     * 判断中奖号是否满足组20规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu20(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 2;
    }

    /**
     * 判断中奖号是否满足组10规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu10(String kjStr) {

        //return LotteryUtils.getDupStrByDupNum(kjStr, 3).size() == 1 && LotteryUtils.getDupStrByDupNum(kjStr, 2).size() == 1;
        return LotteryUtils.getDupStr(kjStr).size() == 2 && LotteryUtils.getUnDupStr(kjStr).size() == 0;
    }

    /**
     * 判断中奖号是否满足组5规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu5(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 1;
    }

    /**
     * 判断中奖号是否满足组24规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu24(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 0 && LotteryUtils.getUnDupStr(kjStr).size() == 4;
    }

    /**
     * 判断中奖号是否满足组12规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu12(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 2;
    }

    /**
     * 判断中奖号是否满足组6规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu6(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 2;
    }

    /**
     * 判断中奖号是否满足组4规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu4(String kjStr) {

        return LotteryUtils.getDupStrByDupNum(kjStr, 3).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 1;
    }

    /**
     * 判断中奖号是否满足三星组6规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsSanxingZu6(String kjStr) {

        return LotteryUtils.getUnDupStr(kjStr).size() == 3;
    }

    /**
     * 判断中奖号是否满足三星组选和值规则（即去除豹子号）
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsSanxingZuHe(String kjStr) {

        return LotteryUtils.getDupStrByDupNum(kjStr, 3).size() == 0;
    }

    /**
     * 判断中奖号是否满足三星组3规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsZu3(String kjStr) {

        return LotteryUtils.getDupStrByDupNum(kjStr, 2).size() == 1 && LotteryUtils.getUnDupStr(kjStr).size() == 1;
    }

    /**
     * 判断中奖号是否满足二星复式规则
     *
     * @param kjStr
     * @return
     */
    private boolean checkIsErxingFuShi(String kjStr) {

        return LotteryUtils.getDupStr(kjStr).size() == 0 && LotteryUtils.getUnDupStr(kjStr).size() == 2;
    }

    public static void main(String[] args) {

        String strEncoder = "DBQZLAgK";
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] resultByte = decoder.decodeBuffer(strEncoder);
            if (resultByte.length >= 4) {
                List<String> resultList = new ArrayList();
                for (byte bt : resultByte) {
                    int rString = bt;
                    resultList.add(String.valueOf(rString));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
