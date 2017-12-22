package com.bc.lottery.draw.service.impl;

import com.babel.forseti_order.model.UserOrderPO;
import com.bc.lottery.entity.LotteryMark6DoubleType;
import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.util.LotteryUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

/**
 * User: clion
 * Date: 2017/11/19
 * Time: 19:10
 **/
public class LotteryMark6Draw {

    /**
     * 六合彩双面盘开奖算法
     *
     * @param lotteryType
     * @param kjNo
     * @param lotteryOrderList
     * @return
     */
    public static List<UserOrderPO> getBoundsInfoOfLotteryMark6Double(LotteryType lotteryType, String kjNo, List<UserOrderPO> lotteryOrderList) {

        List<String> kjList = getRealLotteryMark6Kj(kjNo, lotteryType);
        for (UserOrderPO lotteryOrder : lotteryOrderList) {

            List<List<String>> betNumbers = lotteryOrder.getBetContentProc();

            int firstPrizeNum = 0; // 一等奖次数
            int secondPrizeNum = 0; // 二等奖次数
            int prizeNum = 0;

            LotteryMark6DoubleType lotteryMark6DoubleType = (LotteryMark6DoubleType) lotteryType;
            switch (lotteryMark6DoubleType) {

                // 特码
                case TE_MA_A_1:
                case TE_MA_A_2:
                case TE_MA_A_3:
                case TE_MA_A_4:
                case TE_MA_A_5:
                case TE_MA_A_6:
                case TE_MA_A_7:
                case TE_MA_A_8:
                case TE_MA_A_9:
                case TE_MA_A_10:

                case TE_MA_A_11:
                case TE_MA_A_12:
                case TE_MA_A_13:
                case TE_MA_A_14:
                case TE_MA_A_15:
                case TE_MA_A_16:
                case TE_MA_A_17:
                case TE_MA_A_18:
                case TE_MA_A_19:
                case TE_MA_A_20:

                case TE_MA_A_21:
                case TE_MA_A_22:
                case TE_MA_A_23:
                case TE_MA_A_24:
                case TE_MA_A_25:
                case TE_MA_A_26:
                case TE_MA_A_27:
                case TE_MA_A_28:
                case TE_MA_A_29:
                case TE_MA_A_30:

                case TE_MA_A_31:
                case TE_MA_A_32:
                case TE_MA_A_33:
                case TE_MA_A_34:
                case TE_MA_A_35:
                case TE_MA_A_36:
                case TE_MA_A_37:
                case TE_MA_A_38:
                case TE_MA_A_39:
                case TE_MA_A_40:

                case TE_MA_A_41:
                case TE_MA_A_42:
                case TE_MA_A_43:
                case TE_MA_A_44:
                case TE_MA_A_45:
                case TE_MA_A_46:
                case TE_MA_A_47:
                case TE_MA_A_48:
                case TE_MA_A_49:

                case TE_MA_B_1:
                case TE_MA_B_2:
                case TE_MA_B_3:
                case TE_MA_B_4:
                case TE_MA_B_5:
                case TE_MA_B_6:
                case TE_MA_B_7:
                case TE_MA_B_8:
                case TE_MA_B_9:
                case TE_MA_B_10:

                case TE_MA_B_11:
                case TE_MA_B_12:
                case TE_MA_B_13:
                case TE_MA_B_14:
                case TE_MA_B_15:
                case TE_MA_B_16:
                case TE_MA_B_17:
                case TE_MA_B_18:
                case TE_MA_B_19:
                case TE_MA_B_20:

                case TE_MA_B_21:
                case TE_MA_B_22:
                case TE_MA_B_23:
                case TE_MA_B_24:
                case TE_MA_B_25:
                case TE_MA_B_26:
                case TE_MA_B_27:
                case TE_MA_B_28:
                case TE_MA_B_29:
                case TE_MA_B_30:

                case TE_MA_B_31:
                case TE_MA_B_32:
                case TE_MA_B_33:
                case TE_MA_B_34:
                case TE_MA_B_35:
                case TE_MA_B_36:
                case TE_MA_B_37:
                case TE_MA_B_38:
                case TE_MA_B_39:
                case TE_MA_B_40:

                case TE_MA_B_41:
                case TE_MA_B_42:
                case TE_MA_B_43:
                case TE_MA_B_44:
                case TE_MA_B_45:
                case TE_MA_B_46:
                case TE_MA_B_47:
                case TE_MA_B_48:
                case TE_MA_B_49:

                    // 正一特
                case ZHENG_YI_TE_1:
                case ZHENG_YI_TE_2:
                case ZHENG_YI_TE_3:
                case ZHENG_YI_TE_4:
                case ZHENG_YI_TE_5:
                case ZHENG_YI_TE_6:
                case ZHENG_YI_TE_7:
                case ZHENG_YI_TE_8:
                case ZHENG_YI_TE_9:
                case ZHENG_YI_TE_10:

                case ZHENG_YI_TE_11:
                case ZHENG_YI_TE_12:
                case ZHENG_YI_TE_13:
                case ZHENG_YI_TE_14:
                case ZHENG_YI_TE_15:
                case ZHENG_YI_TE_16:
                case ZHENG_YI_TE_17:
                case ZHENG_YI_TE_18:
                case ZHENG_YI_TE_19:
                case ZHENG_YI_TE_20:

                case ZHENG_YI_TE_21:
                case ZHENG_YI_TE_22:
                case ZHENG_YI_TE_23:
                case ZHENG_YI_TE_24:
                case ZHENG_YI_TE_25:
                case ZHENG_YI_TE_26:
                case ZHENG_YI_TE_27:
                case ZHENG_YI_TE_28:
                case ZHENG_YI_TE_29:
                case ZHENG_YI_TE_30:

                case ZHENG_YI_TE_31:
                case ZHENG_YI_TE_32:
                case ZHENG_YI_TE_33:
                case ZHENG_YI_TE_34:
                case ZHENG_YI_TE_35:
                case ZHENG_YI_TE_36:
                case ZHENG_YI_TE_37:
                case ZHENG_YI_TE_38:
                case ZHENG_YI_TE_39:
                case ZHENG_YI_TE_40:

                case ZHENG_YI_TE_41:
                case ZHENG_YI_TE_42:
                case ZHENG_YI_TE_43:
                case ZHENG_YI_TE_44:
                case ZHENG_YI_TE_45:
                case ZHENG_YI_TE_46:
                case ZHENG_YI_TE_47:
                case ZHENG_YI_TE_48:
                case ZHENG_YI_TE_49:

                    // 正二特
                case ZHENG_ER_TE_1:
                case ZHENG_ER_TE_2:
                case ZHENG_ER_TE_3:
                case ZHENG_ER_TE_4:
                case ZHENG_ER_TE_5:
                case ZHENG_ER_TE_6:
                case ZHENG_ER_TE_7:
                case ZHENG_ER_TE_8:
                case ZHENG_ER_TE_9:
                case ZHENG_ER_TE_10:

                case ZHENG_ER_TE_11:
                case ZHENG_ER_TE_12:
                case ZHENG_ER_TE_13:
                case ZHENG_ER_TE_14:
                case ZHENG_ER_TE_15:
                case ZHENG_ER_TE_16:
                case ZHENG_ER_TE_17:
                case ZHENG_ER_TE_18:
                case ZHENG_ER_TE_19:
                case ZHENG_ER_TE_20:

                case ZHENG_ER_TE_21:
                case ZHENG_ER_TE_22:
                case ZHENG_ER_TE_23:
                case ZHENG_ER_TE_24:
                case ZHENG_ER_TE_25:
                case ZHENG_ER_TE_26:
                case ZHENG_ER_TE_27:
                case ZHENG_ER_TE_28:
                case ZHENG_ER_TE_29:
                case ZHENG_ER_TE_30:

                case ZHENG_ER_TE_31:
                case ZHENG_ER_TE_32:
                case ZHENG_ER_TE_33:
                case ZHENG_ER_TE_34:
                case ZHENG_ER_TE_35:
                case ZHENG_ER_TE_36:
                case ZHENG_ER_TE_37:
                case ZHENG_ER_TE_38:
                case ZHENG_ER_TE_39:
                case ZHENG_ER_TE_40:

                case ZHENG_ER_TE_41:
                case ZHENG_ER_TE_42:
                case ZHENG_ER_TE_43:
                case ZHENG_ER_TE_44:
                case ZHENG_ER_TE_45:
                case ZHENG_ER_TE_46:
                case ZHENG_ER_TE_47:
                case ZHENG_ER_TE_48:
                case ZHENG_ER_TE_49:

                    // 正三特
                case ZHENG_SAN_TE_1:
                case ZHENG_SAN_TE_2:
                case ZHENG_SAN_TE_3:
                case ZHENG_SAN_TE_4:
                case ZHENG_SAN_TE_5:
                case ZHENG_SAN_TE_6:
                case ZHENG_SAN_TE_7:
                case ZHENG_SAN_TE_8:
                case ZHENG_SAN_TE_9:
                case ZHENG_SAN_TE_10:

                case ZHENG_SAN_TE_11:
                case ZHENG_SAN_TE_12:
                case ZHENG_SAN_TE_13:
                case ZHENG_SAN_TE_14:
                case ZHENG_SAN_TE_15:
                case ZHENG_SAN_TE_16:
                case ZHENG_SAN_TE_17:
                case ZHENG_SAN_TE_18:
                case ZHENG_SAN_TE_19:
                case ZHENG_SAN_TE_20:

                case ZHENG_SAN_TE_21:
                case ZHENG_SAN_TE_22:
                case ZHENG_SAN_TE_23:
                case ZHENG_SAN_TE_24:
                case ZHENG_SAN_TE_25:
                case ZHENG_SAN_TE_26:
                case ZHENG_SAN_TE_27:
                case ZHENG_SAN_TE_28:
                case ZHENG_SAN_TE_29:
                case ZHENG_SAN_TE_30:

                case ZHENG_SAN_TE_31:
                case ZHENG_SAN_TE_32:
                case ZHENG_SAN_TE_33:
                case ZHENG_SAN_TE_34:
                case ZHENG_SAN_TE_35:
                case ZHENG_SAN_TE_36:
                case ZHENG_SAN_TE_37:
                case ZHENG_SAN_TE_38:
                case ZHENG_SAN_TE_39:
                case ZHENG_SAN_TE_40:

                case ZHENG_SAN_TE_41:
                case ZHENG_SAN_TE_42:
                case ZHENG_SAN_TE_43:
                case ZHENG_SAN_TE_44:
                case ZHENG_SAN_TE_45:
                case ZHENG_SAN_TE_46:
                case ZHENG_SAN_TE_47:
                case ZHENG_SAN_TE_48:
                case ZHENG_SAN_TE_49:

                    // 正四特
                case ZHENG_SI_TE_1:
                case ZHENG_SI_TE_2:
                case ZHENG_SI_TE_3:
                case ZHENG_SI_TE_4:
                case ZHENG_SI_TE_5:
                case ZHENG_SI_TE_6:
                case ZHENG_SI_TE_7:
                case ZHENG_SI_TE_8:
                case ZHENG_SI_TE_9:
                case ZHENG_SI_TE_10:

                case ZHENG_SI_TE_11:
                case ZHENG_SI_TE_12:
                case ZHENG_SI_TE_13:
                case ZHENG_SI_TE_14:
                case ZHENG_SI_TE_15:
                case ZHENG_SI_TE_16:
                case ZHENG_SI_TE_17:
                case ZHENG_SI_TE_18:
                case ZHENG_SI_TE_19:
                case ZHENG_SI_TE_20:

                case ZHENG_SI_TE_21:
                case ZHENG_SI_TE_22:
                case ZHENG_SI_TE_23:
                case ZHENG_SI_TE_24:
                case ZHENG_SI_TE_25:
                case ZHENG_SI_TE_26:
                case ZHENG_SI_TE_27:
                case ZHENG_SI_TE_28:
                case ZHENG_SI_TE_29:
                case ZHENG_SI_TE_30:

                case ZHENG_SI_TE_31:
                case ZHENG_SI_TE_32:
                case ZHENG_SI_TE_33:
                case ZHENG_SI_TE_34:
                case ZHENG_SI_TE_35:
                case ZHENG_SI_TE_36:
                case ZHENG_SI_TE_37:
                case ZHENG_SI_TE_38:
                case ZHENG_SI_TE_39:
                case ZHENG_SI_TE_40:

                case ZHENG_SI_TE_41:
                case ZHENG_SI_TE_42:
                case ZHENG_SI_TE_43:
                case ZHENG_SI_TE_44:
                case ZHENG_SI_TE_45:
                case ZHENG_SI_TE_46:
                case ZHENG_SI_TE_47:
                case ZHENG_SI_TE_48:
                case ZHENG_SI_TE_49:

                    // 正五特
                case ZHENG_WU_TE_1:
                case ZHENG_WU_TE_2:
                case ZHENG_WU_TE_3:
                case ZHENG_WU_TE_4:
                case ZHENG_WU_TE_5:
                case ZHENG_WU_TE_6:
                case ZHENG_WU_TE_7:
                case ZHENG_WU_TE_8:
                case ZHENG_WU_TE_9:
                case ZHENG_WU_TE_10:

                case ZHENG_WU_TE_11:
                case ZHENG_WU_TE_12:
                case ZHENG_WU_TE_13:
                case ZHENG_WU_TE_14:
                case ZHENG_WU_TE_15:
                case ZHENG_WU_TE_16:
                case ZHENG_WU_TE_17:
                case ZHENG_WU_TE_18:
                case ZHENG_WU_TE_19:
                case ZHENG_WU_TE_20:

                case ZHENG_WU_TE_21:
                case ZHENG_WU_TE_22:
                case ZHENG_WU_TE_23:
                case ZHENG_WU_TE_24:
                case ZHENG_WU_TE_25:
                case ZHENG_WU_TE_26:
                case ZHENG_WU_TE_27:
                case ZHENG_WU_TE_28:
                case ZHENG_WU_TE_29:
                case ZHENG_WU_TE_30:

                case ZHENG_WU_TE_31:
                case ZHENG_WU_TE_32:
                case ZHENG_WU_TE_33:
                case ZHENG_WU_TE_34:
                case ZHENG_WU_TE_35:
                case ZHENG_WU_TE_36:
                case ZHENG_WU_TE_37:
                case ZHENG_WU_TE_38:
                case ZHENG_WU_TE_39:
                case ZHENG_WU_TE_40:

                case ZHENG_WU_TE_41:
                case ZHENG_WU_TE_42:
                case ZHENG_WU_TE_43:
                case ZHENG_WU_TE_44:
                case ZHENG_WU_TE_45:
                case ZHENG_WU_TE_46:
                case ZHENG_WU_TE_47:
                case ZHENG_WU_TE_48:
                case ZHENG_WU_TE_49:

                    // 正六特
                case ZHENG_LIU_TE_1:
                case ZHENG_LIU_TE_2:
                case ZHENG_LIU_TE_3:
                case ZHENG_LIU_TE_4:
                case ZHENG_LIU_TE_5:
                case ZHENG_LIU_TE_6:
                case ZHENG_LIU_TE_7:
                case ZHENG_LIU_TE_8:
                case ZHENG_LIU_TE_9:
                case ZHENG_LIU_TE_10:

                case ZHENG_LIU_TE_11:
                case ZHENG_LIU_TE_12:
                case ZHENG_LIU_TE_13:
                case ZHENG_LIU_TE_14:
                case ZHENG_LIU_TE_15:
                case ZHENG_LIU_TE_16:
                case ZHENG_LIU_TE_17:
                case ZHENG_LIU_TE_18:
                case ZHENG_LIU_TE_19:
                case ZHENG_LIU_TE_20:

                case ZHENG_LIU_TE_21:
                case ZHENG_LIU_TE_22:
                case ZHENG_LIU_TE_23:
                case ZHENG_LIU_TE_24:
                case ZHENG_LIU_TE_25:
                case ZHENG_LIU_TE_26:
                case ZHENG_LIU_TE_27:
                case ZHENG_LIU_TE_28:
                case ZHENG_LIU_TE_29:
                case ZHENG_LIU_TE_30:

                case ZHENG_LIU_TE_31:
                case ZHENG_LIU_TE_32:
                case ZHENG_LIU_TE_33:
                case ZHENG_LIU_TE_34:
                case ZHENG_LIU_TE_35:
                case ZHENG_LIU_TE_36:
                case ZHENG_LIU_TE_37:
                case ZHENG_LIU_TE_38:
                case ZHENG_LIU_TE_39:
                case ZHENG_LIU_TE_40:

                case ZHENG_LIU_TE_41:
                case ZHENG_LIU_TE_42:
                case ZHENG_LIU_TE_43:
                case ZHENG_LIU_TE_44:
                case ZHENG_LIU_TE_45:
                case ZHENG_LIU_TE_46:
                case ZHENG_LIU_TE_47:
                case ZHENG_LIU_TE_48:
                case ZHENG_LIU_TE_49:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains(kjList.get(0))) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                case TE_MA_DA:
                case ZHENG_YI_MA_DA:
                case ZHENG_ER_MA_DA:
                case ZHENG_SAN_MA_DA:
                case ZHENG_SI_MA_DA:
                case ZHENG_WU_MA_DA:
                case ZHENG_LIU_MA_DA:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 49, 49);

                            if (firstBetList.contains("大")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_XIAO:
                case ZHENG_YI_MA_XIAO:
                case ZHENG_ER_MA_XIAO:
                case ZHENG_SAN_MA_XIAO:
                case ZHENG_SI_MA_XIAO:
                case ZHENG_WU_MA_XIAO:
                case ZHENG_LIU_MA_XIAO:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 49, 49);

                            if (firstBetList.contains("小")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_DAN:
                case ZHENG_YI_MA_DAN:
                case ZHENG_ER_MA_DAN:
                case ZHENG_SAN_MA_DAN:
                case ZHENG_SI_MA_DAN:
                case ZHENG_WU_MA_DAN:
                case ZHENG_LIU_MA_DAN:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 49, 49);

                            if (firstBetList.contains("单")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_SHUANG:
                case ZHENG_YI_MA_SHUANG:
                case ZHENG_ER_MA_SHUANG:
                case ZHENG_SAN_MA_SHUANG:
                case ZHENG_SI_MA_SHUANG:
                case ZHENG_WU_MA_SHUANG:
                case ZHENG_LIU_MA_SHUANG:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 49, 49);

                            if (firstBetList.contains("双")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_DA_DAN:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 49, 49);

                            if (firstBetList.contains("大") && firstBetList.contains("单")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_DA_SHUANG:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 49, 49);

                            if (firstBetList.contains("大") && firstBetList.contains("双")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_XIAO_DAN:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 49, 49);

                            if (firstBetList.contains("小") && firstBetList.contains("单")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_XIAO_SHUANG:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 49, 49);

                            if (firstBetList.contains("小") && firstBetList.contains("双")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_WEI_DA:
                case ZHENG_YI_WEI_DA:
                case ZHENG_ER_WEI_DA:
                case ZHENG_SAN_WEI_DA:
                case ZHENG_SI_WEI_DA:
                case ZHENG_WU_WEI_DA:
                case ZHENG_LIU_WEI_DA:

                    // 正码尾大 跟上面一样
                case ZHENG_YI_LIANG_MIAN_WEI_DA:
                case ZHENG_ER_LIANG_MIAN_WEI_DA:
                case ZHENG_SAN_LIANG_MIAN_WEI_DA:
                case ZHENG_SI_LIANG_MIAN_WEI_DA:
                case ZHENG_WU_LIANG_MIAN_WEI_DA:
                case ZHENG_LIU_LIANG_MIAN_WEI_DA:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)) % 10, 49, 49);

                            if (firstBetList.contains("大")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_WEI_XIAO:
                case ZHENG_YI_WEI_XIAO:
                case ZHENG_ER_WEI_XIAO:
                case ZHENG_SAN_WEI_XIAO:
                case ZHENG_SI_WEI_XIAO:
                case ZHENG_WU_WEI_XIAO:
                case ZHENG_LIU_WEI_XIAO:

                    // 正码尾小 跟上面一样
                case ZHENG_YI_LIANG_MIAN_WEI_XIAO:
                case ZHENG_ER_LIANG_MIAN_WEI_XIAO:
                case ZHENG_SAN_LIANG_MIAN_WEI_XIAO:
                case ZHENG_SI_LIANG_MIAN_WEI_XIAO:
                case ZHENG_WU_LIANG_MIAN_WEI_XIAO:
                case ZHENG_LIU_LIANG_MIAN_WEI_XIAO:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)) % 10, 49, 49);

                            if (firstBetList.contains("小")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 两面天肖
                case TE_TIAN_XIAO:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //判断是否是特天肖
                            if (LotteryUtils.checkIsTianxiao(kjList.get(0))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 两面地肖
                case TE_DI_XIAO:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //判断是否是特地肖
                            if (!LotteryUtils.checkIsTianxiao(kjList.get(0))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_QIAN_XIAO:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //判断是否是特前肖
                            if (LotteryUtils.checkIsQianxiao(kjList.get(0))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_HOU_XIAO:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //判断是否是特后肖
                            if (!LotteryUtils.checkIsQianxiao(kjList.get(0))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_JIA_XIAO:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //判断是否是特家肖
                            if (LotteryUtils.checkIsJiaxiao(kjList.get(0))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_YE_XIAO:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //判断是否是特家肖
                            if (!LotteryUtils.checkIsJiaxiao(kjList.get(0))) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 合肖
                case HE_XIAO_ER:
                case HE_XIAO_SAN:
                case HE_XIAO_SI:
                case HE_XIAO_WU:
                case HE_XIAO_LIU:
                case HE_XIAO_QI:
                case HE_XIAO_BA:
                case HE_XIAO_JIU:
                case HE_XIAO_SHI:
                case HE_XIAO_SHI_YI:
                    if (betNumbers.size() == 1) {

                        List<String> firstBetList = LotteryUtils.getShengxiaoTypeList(kjList.get(0));
                        if (betNumbers.get(0).containsAll(firstBetList)) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 两面
                case TE_MA_HE_DA:
                case ZHENG_YI_HE_DA:
                case ZHENG_ER_HE_DA:
                case ZHENG_SAN_HE_DA:
                case ZHENG_SI_HE_DA:
                case ZHENG_WU_HE_DA:
                case ZHENG_LIU_HE_DA:

                    // 正码两面 --跟上面的一样
                case ZHENG_YI_LIANG_MIAN_HE_DA:
                case ZHENG_ER_LIANG_MIAN_HE_DA:
                case ZHENG_SAN_LIANG_MIAN_HE_DA:
                case ZHENG_SI_LIANG_MIAN_HE_DA:
                case ZHENG_WU_LIANG_MIAN_HE_DA:
                case ZHENG_LIU_LIANG_MIAN_HE_DA:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0).get(0)), 13);

                            if (firstBetList.contains("大")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_HE_XIAO:
                case ZHENG_YI_HE_XIAO:
                case ZHENG_ER_HE_XIAO:
                case ZHENG_SAN_HE_XIAO:
                case ZHENG_SI_HE_XIAO:
                case ZHENG_WU_HE_XIAO:
                case ZHENG_LIU_HE_XIAO:

                    // 正码两面 --跟上面的一样
                case ZHENG_YI_LIANG_MIAN_HE_XIAO:
                case ZHENG_ER_LIANG_MIAN_HE_XIAO:
                case ZHENG_SAN_LIANG_MIAN_HE_XIAO:
                case ZHENG_SI_LIANG_MIAN_HE_XIAO:
                case ZHENG_WU_LIANG_MIAN_HE_XIAO:
                case ZHENG_LIU_LIANG_MIAN_HE_XIAO:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0).get(0)), 13);

                            if (firstBetList.contains("小")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_HE_DAN:
                case ZHENG_YI_HE_DAN:
                case ZHENG_ER_HE_DAN:
                case ZHENG_SAN_HE_DAN:
                case ZHENG_SI_HE_DAN:
                case ZHENG_WU_HE_DAN:
                case ZHENG_LIU_HE_DAN:

                    // 正码两面 --跟上面的一样
                case ZHENG_YI_LIANG_MIAN_HE_DAN:
                case ZHENG_ER_LIANG_MIAN_HE_DAN:
                case ZHENG_SAN_LIANG_MIAN_HE_DAN:
                case ZHENG_SI_LIANG_MIAN_HE_DAN:
                case ZHENG_WU_LIANG_MIAN_HE_DAN:
                case ZHENG_LIU_LIANG_MIAN_HE_DAN:


                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0).get(0)), 13);

                            if (firstBetList.contains("单")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case TE_MA_HE_SHUANG:
                case ZHENG_YI_HE_SHUANG:
                case ZHENG_ER_HE_SHUANG:
                case ZHENG_SAN_HE_SHUANG:
                case ZHENG_SI_HE_SHUANG:
                case ZHENG_WU_HE_SHUANG:
                case ZHENG_LIU_HE_SHUANG:

                    // 正码两面 --跟上面的一样
                case ZHENG_YI_LIANG_MIAN_HE_SHUANG:
                case ZHENG_ER_LIANG_MIAN_HE_SHUANG:
                case ZHENG_SAN_LIANG_MIAN_HE_SHUANG:
                case ZHENG_SI_LIANG_MIAN_HE_SHUANG:
                case ZHENG_WU_LIANG_MIAN_HE_SHUANG:
                case ZHENG_LIU_LIANG_MIAN_HE_SHUANG:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains("49")) {
                            lotteryOrder.setIsTied(1);
                        } else {
                            //获取中奖号的大小单双
                            List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0).get(0)), 13);

                            if (firstBetList.contains("双")) {
                                firstPrizeNum++;
                            }
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZONG_HE_DA:
                case ZHENG_MA_ZONG_DA:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 349);
                        if (firstBetList.contains("大")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                case ZONG_HE_XIAO:
                case ZHENG_MA_ZONG_XIAO:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 349);
                        if (firstBetList.contains("小")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                case ZONG_HE_DAN:
                case ZHENG_MA_ZONG_DAN:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 349);
                        if (firstBetList.contains("单")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                case ZONG_HE_SHUANG:
                case ZHENG_MA_ZONG_SHUANG:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的大小单双
                        List<String> firstBetList = LotteryUtils.getDaxiaodanshuangList(LotteryUtils.getStrSum(betNumbers.get(0)), 349);
                        if (firstBetList.contains("双")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 正码
                case ZHENG_MA_1:
                case ZHENG_MA_2:
                case ZHENG_MA_3:
                case ZHENG_MA_4:
                case ZHENG_MA_5:
                case ZHENG_MA_6:
                case ZHENG_MA_7:
                case ZHENG_MA_8:
                case ZHENG_MA_9:
                case ZHENG_MA_10:

                case ZHENG_MA_11:
                case ZHENG_MA_12:
                case ZHENG_MA_13:
                case ZHENG_MA_14:
                case ZHENG_MA_15:
                case ZHENG_MA_16:
                case ZHENG_MA_17:
                case ZHENG_MA_18:
                case ZHENG_MA_19:
                case ZHENG_MA_20:

                case ZHENG_MA_21:
                case ZHENG_MA_22:
                case ZHENG_MA_23:
                case ZHENG_MA_24:
                case ZHENG_MA_25:
                case ZHENG_MA_26:
                case ZHENG_MA_27:
                case ZHENG_MA_28:
                case ZHENG_MA_29:
                case ZHENG_MA_30:

                case ZHENG_MA_31:
                case ZHENG_MA_32:
                case ZHENG_MA_33:
                case ZHENG_MA_34:
                case ZHENG_MA_35:
                case ZHENG_MA_36:
                case ZHENG_MA_37:
                case ZHENG_MA_38:
                case ZHENG_MA_39:
                case ZHENG_MA_40:

                case ZHENG_MA_41:
                case ZHENG_MA_42:
                case ZHENG_MA_43:
                case ZHENG_MA_44:
                case ZHENG_MA_45:
                case ZHENG_MA_46:
                case ZHENG_MA_47:
                case ZHENG_MA_48:
                case ZHENG_MA_49:

                    if (betNumbers.size() == 1) {
                        for (String betNumber : betNumbers.get(0)) {
                            if (kjList.contains(betNumber)) {
                                firstPrizeNum++;
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 特码头数
                case TE_MA_TOU_0:
                case TE_MA_TOU_1:
                case TE_MA_TOU_2:
                case TE_MA_TOU_3:
                case TE_MA_TOU_4:

                    if (betNumbers.size() == 1) {
                        if (kjList.get(0).startsWith(betNumbers.get(0).get(0).substring(0, 1))) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 特码尾数
                case TE_MA_WEI_0:
                case TE_MA_WEI_1:
                case TE_MA_WEI_2:
                case TE_MA_WEI_3:
                case TE_MA_WEI_4:
                case TE_MA_WEI_5:
                case TE_MA_WEI_6:
                case TE_MA_WEI_7:
                case TE_MA_WEI_8:
                case TE_MA_WEI_9:

                    if (betNumbers.size() == 1) {
                        for (String kjStr : kjList) {
                            if (kjStr.endsWith(betNumbers.get(0).get(0).substring(0, 1))) {
                                firstPrizeNum++;
                                break;
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 色波
                case TE_MA_HONG_BO:
                case ZHENG_YI_HONG:
                case ZHENG_ER_HONG:
                case ZHENG_SAN_HONG:
                case ZHENG_SI_HONG:
                case ZHENG_WU_HONG:
                case ZHENG_LIU_HONG:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的色波
                        List<String> firstBetList = LotteryUtils.getDaXiaoDanShuangSeBoList(betNumbers.get(0).get(0), 49);
                        if (firstBetList.contains("红")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                case TE_MA_LAN_BO:
                case ZHENG_YI_LAN:
                case ZHENG_ER_LAN:
                case ZHENG_SAN_LAN:
                case ZHENG_SI_LAN:
                case ZHENG_WU_LAN:
                case ZHENG_LIU_LAN:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的色波
                        List<String> firstBetList = LotteryUtils.getDaXiaoDanShuangSeBoList(betNumbers.get(0).get(0), 49);
                        if (firstBetList.contains("蓝")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                case TE_MA_LV_BO:
                case ZHENG_YI_LV:
                case ZHENG_ER_LV:
                case ZHENG_SAN_LV:
                case ZHENG_SI_LV:
                case ZHENG_WU_LV:
                case ZHENG_LIU_LV:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的色波
                        List<String> firstBetList = LotteryUtils.getDaXiaoDanShuangSeBoList(betNumbers.get(0).get(0), 49);
                        if (firstBetList.contains("绿")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;


                case TE_MA_HONG_DA:
                case TE_MA_HONG_XIAO:
                case TE_MA_HONG_DAN:
                case TE_MA_HONG_SHUANG:
                case TE_MA_HONG_DA_DAN:
                case TE_MA_HONG_DA_SHUANG:
                case TE_MA_HONG_XIAO_DAN:
                case TE_MA_HONG_XIAO_SHUANG:

                case TE_MA_LAN_DA:
                case TE_MA_LAN_XIAO:
                case TE_MA_LAN_DAN:
                case TE_MA_LAN_SHUANG:
                case TE_MA_LAN_DA_DAN:
                case TE_MA_LAN_XIAO_DAN:
                case TE_MA_LAN_DA_SHUANG:
                case TE_MA_LAN_XIAO_SHUANG:

                case TE_MA_LV_DA:
                case TE_MA_LV_XIAO:
                case TE_MA_LV_DAN:
                case TE_MA_LV_SHUANG:
                case TE_MA_LV_DA_DAN:
                case TE_MA_LV_XIAO_DAN:
                case TE_MA_LV_DA_SHUANG:
                case TE_MA_LV_XIAO_SHUANG:

                case TE_MA_A_DA:
                case TE_MA_A_XIAO:
                case TE_MA_A_DAN:
                case TE_MA_A_SHUANG:
                case TE_MA_A_HONG:
                case TE_MA_A_LV:
                case TE_MA_A_LAN:

                case TE_MA_B_DA:
                case TE_MA_B_XIAO:
                case TE_MA_B_DAN:
                case TE_MA_B_SHUANG:
                case TE_MA_B_HONG:
                case TE_MA_B_LV:
                case TE_MA_B_LAN:

                    // 正码两面1-6
                case ZHENG_YI_LIANG_MIAN_DA:
                case ZHENG_YI_LIANG_MIAN_XIAO:
                case ZHENG_YI_LIANG_MIAN_DAN:
                case ZHENG_YI_LIANG_MIAN_SHUANG:
                case ZHENG_YI_LIANG_MIAN_HONG:
                case ZHENG_YI_LIANG_MIAN_LV:
                case ZHENG_YI_LIANG_MIAN_LAN:

                case ZHENG_ER_LIANG_MIAN_DA:
                case ZHENG_ER_LIANG_MIAN_XIAO:
                case ZHENG_ER_LIANG_MIAN_DAN:
                case ZHENG_ER_LIANG_MIAN_SHUANG:
                case ZHENG_ER_LIANG_MIAN_HONG:
                case ZHENG_ER_LIANG_MIAN_LV:
                case ZHENG_ER_LIANG_MIAN_LAN:

                case ZHENG_SAN_LIANG_MIAN_DA:
                case ZHENG_SAN_LIANG_MIAN_XIAO:
                case ZHENG_SAN_LIANG_MIAN_DAN:
                case ZHENG_SAN_LIANG_MIAN_SHUANG:
                case ZHENG_SAN_LIANG_MIAN_HONG:
                case ZHENG_SAN_LIANG_MIAN_LV:
                case ZHENG_SAN_LIANG_MIAN_LAN:


                case ZHENG_SI_LIANG_MIAN_DA:
                case ZHENG_SI_LIANG_MIAN_XIAO:
                case ZHENG_SI_LIANG_MIAN_DAN:
                case ZHENG_SI_LIANG_MIAN_SHUANG:
                case ZHENG_SI_LIANG_MIAN_HONG:
                case ZHENG_SI_LIANG_MIAN_LV:
                case ZHENG_SI_LIANG_MIAN_LAN:


                case ZHENG_WU_LIANG_MIAN_DA:
                case ZHENG_WU_LIANG_MIAN_XIAO:
                case ZHENG_WU_LIANG_MIAN_DAN:
                case ZHENG_WU_LIANG_MIAN_SHUANG:
                case ZHENG_WU_LIANG_MIAN_HONG:
                case ZHENG_WU_LIANG_MIAN_LV:
                case ZHENG_WU_LIANG_MIAN_LAN:

                case ZHENG_LIU_LIANG_MIAN_DA:
                case ZHENG_LIU_LIANG_MIAN_XIAO:
                case ZHENG_LIU_LIANG_MIAN_DAN:
                case ZHENG_LIU_LIANG_MIAN_SHUANG:
                case ZHENG_LIU_LIANG_MIAN_HONG:
                case ZHENG_LIU_LIANG_MIAN_LV:
                case ZHENG_LIU_LIANG_MIAN_LAN:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的大小单双色波
                        List<String> firstBetList = LotteryUtils.getDaXiaoDanShuangSeBoList(betNumbers.get(0).get(0), 49);
                        if (firstBetList.containsAll(Arrays.asList(betNumbers.get(0).get(0).split("")))) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 特肖
                case TE_XIAO_SHU:
                case TE_XIAO_NIU:
                case TE_XIAO_HU:
                case TE_XIAO_TU:
                case TE_XIAO_LONG:
                case TE_XIAO_SHE:
                case TE_XIAO_MA:
                case TE_XIAO_YANG:
                case TE_XIAO_HOU:
                case TE_XIAO_JI:
                case TE_XIAO_GOU:
                case TE_XIAO_ZHU:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的生肖
                        List<String> firstBetList = LotteryUtils.getShengxiaoTypeList(kjList.get(0));
                        for (String betStr : betNumbers.get(0)) {
                            if (firstBetList.contains(betStr)) {
                                firstPrizeNum++;
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 正肖
                case ZHENG_XIAO_SHU:
                case ZHENG_XIAO_NIU:
                case ZHENG_XIAO_HU:
                case ZHENG_XIAO_TU:
                case ZHENG_XIAO_LONG:
                case ZHENG_XIAO_SHE:
                case ZHENG_XIAO_MA:
                case ZHENG_XIAO_YANG:
                case ZHENG_XIAO_HOU:
                case ZHENG_XIAO_JI:
                case ZHENG_XIAO_GOU:
                case ZHENG_XIAO_ZHU:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的生肖
                        for (String betStr : kjList) {
                            List<String> firstBetList = LotteryUtils.getShengxiaoTypeList(betStr);
                            if (betNumbers.get(0).containsAll(firstBetList)) {
                                firstPrizeNum++;
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 平特一肖
                case PING_TE_YI_XIAO_SHU:
                case PING_TE_YI_XIAO_NIU:
                case PING_TE_YI_XIAO_HU:
                case PING_TE_YI_XIAO_TU:
                case PING_TE_YI_XIAO_LONG:
                case PING_TE_YI_XIAO_SHE:
                case PING_TE_YI_XIAO_MA:
                case PING_TE_YI_XIAO_YANG:
                case PING_TE_YI_XIAO_HOU:
                case PING_TE_YI_XIAO_JI:
                case PING_TE_YI_XIAO_GOU:
                case PING_TE_YI_XIAO_ZHU:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的生肖
                        Set<String> firstBetSet = LotteryUtils.getShengxiaoTypeSet(kjList);
                        if (firstBetSet.containsAll(betNumbers.get(0))) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 平特尾数
                case PING_TE_WEI_SHU_0:
                case PING_TE_WEI_SHU_1:
                case PING_TE_WEI_SHU_2:
                case PING_TE_WEI_SHU_3:
                case PING_TE_WEI_SHU_4:
                case PING_TE_WEI_SHU_5:
                case PING_TE_WEI_SHU_6:
                case PING_TE_WEI_SHU_7:
                case PING_TE_WEI_SHU_8:
                case PING_TE_WEI_SHU_9:

                    if (betNumbers.size() == 1) {
                        if (kjList.get(0).endsWith(betNumbers.get(0).get(0).substring(0, 1))) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //五行
                case WU_XING_JIN:
                case WU_XING_MU:
                case WU_XING_SHUI:
                case WU_XING_HUO:
                case WU_XING_TU:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的五行
                        List<String> firstBetList = LotteryUtils.getWuxingTypeList(kjList.get(0));
                        for (String betStr : betNumbers.get(0)) {
                            if (firstBetList.contains(betStr)) {
                                firstPrizeNum++;
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //　七色波红波
                case QI_SE_HONG_BO:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的色波
                        List<String> firstBetList = LotteryUtils.getQiSeBoList(kjList);
                        if (firstBetList.contains("和")) {
                            lotteryOrder.setIsTied(1);
                        } else if (firstBetList.contains("红")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //七色波绿波
                case QI_SE_LV_BO:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的色波
                        List<String> firstBetList = LotteryUtils.getQiSeBoList(kjList);
                        if (firstBetList.contains("和")) {
                            lotteryOrder.setIsTied(1);
                        } else if (firstBetList.contains("绿")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //七色波蓝波
                case QI_SE_LAN_BO:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的色波
                        List<String> firstBetList = LotteryUtils.getQiSeBoList(kjList);
                        if (firstBetList.contains("和")) {
                            lotteryOrder.setIsTied(1);
                        } else if (firstBetList.contains("蓝")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    //七色波和局
                case QI_SE_HE_JU:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的色波
                        List<String> firstBetList = LotteryUtils.getQiSeBoList(kjList);
                        if (firstBetList.contains("和")) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 总肖
                case ZONG_ER_XIAO:
                case ZONG_SAN_XIAO:
                case ZONG_SI_XIAO:
                case ZONG_WU_XIAO:
                case ZONG_LIU_XIAO:
                case ZONG_QI_XIAO:

                    if (betNumbers.size() == 1) {
                        //获取中奖号的生肖集合
                        Set<String> firstBetSet = LotteryUtils.getShengxiaoTypeSet(kjList);
                        if (firstBetSet.size() == Integer.parseInt(betNumbers.get(0).get(0).substring(0, 1))) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZONG_DAN_XIAO:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的生肖集合
                        Set<String> firstBetSet = LotteryUtils.getShengxiaoTypeSet(kjList);
                        if (firstBetSet.size() % 2 == 1) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                case ZONG_SHUANG_XIAO:
                    if (betNumbers.size() == 1) {
                        //获取中奖号的生肖集合
                        Set<String> firstBetSet = LotteryUtils.getShengxiaoTypeSet(kjList);
                        if (firstBetSet.size() % 2 == 0) {
                            firstPrizeNum++;
                        }
                        lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    }
                    continue;

                    // 自选不中
                case ZI_XUAN_BU_ZHONG_5:
                case ZI_XUAN_BU_ZHONG_6:
                case ZI_XUAN_BU_ZHONG_7:
                case ZI_XUAN_BU_ZHONG_8:
                case ZI_XUAN_BU_ZHONG_9:
                case ZI_XUAN_BU_ZHONG_10:

                case ZI_XUAN_BU_ZHONG_11:
                case ZI_XUAN_BU_ZHONG_12:

                    boolean bl = false;
                    if (betNumbers.size() == 1) {
                        //判断是否包含
                        for (String kjStr : kjList) {
                            if (betNumbers.contains(kjStr)) {
                                bl = true;
                                break;
                            }
                        }
                        if (bl) {
                            firstPrizeNum++;
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 连码
                case LIAN_MA_ER_QUAN_ZHONG:

                    prizeNum = 0;
                    if (betNumbers.size() == 1) {
                        for (String betStr : betNumbers.get(0)) {
                            if (kjList.contains(betStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 2);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 连码
                case LIAN_MA_SAN_QUAN_ZHONG:
                    prizeNum = 0;
                    if (betNumbers.size() == 1) {
                        for (String betStr : betNumbers.get(0)) {
                            if (kjList.contains(betStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 3);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 连码
                case LIAN_MA_SI_QUAN_ZHONG:
                    prizeNum = 0;
                    if (betNumbers.size() == 1) {
                        for (String betStr : betNumbers.get(0)) {
                            if (kjList.contains(betStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 4);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 连码
                case LIAN_MA_SAN_ZHONG_ER:
                    // TODO 需要根据业务重新梳理
                    prizeNum = 0;
                    if (betNumbers.size() == 1) {
                        for (String betStr : betNumbers.get(0)) {
                            if (kjList.contains(betStr)) {
                                prizeNum++;
                            }
                        }
                        if (prizeNum == 3) {
                            lotteryOrder.setFirstPrizeNum(1);
                        } else if (prizeNum == 2) {
                            lotteryOrder.setSecondPrizeNum(1);
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 连码
                case LIAN_MA_ER_ZHONG_TE:

                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains(kjList.get(6))) {
                            for (String kjStr : betNumbers.get(0)) {
                                if (kjList.contains(kjStr)) {
                                    prizeNum++;
                                }
                                firstPrizeNum = prizeNum - 1;
                            }
                        } else {
                            for (String kjStr : betNumbers.get(0)) {
                                if (kjList.contains(kjStr)) {
                                    prizeNum++;
                                }
                                secondPrizeNum = (int) LotteryUtils.combination(prizeNum, 2);
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    lotteryOrder.setSecondPrizeNum(secondPrizeNum);
                    continue;

                case LIAN_MA_TE_CHUAN:
                    if (betNumbers.size() == 1) {
                        if (betNumbers.get(0).contains(kjList.get(6))) {
                            for (String kjStr : betNumbers.get(0)) {
                                if (kjList.contains(kjStr)) {
                                    prizeNum++;
                                }
                                firstPrizeNum = prizeNum - 1;
                            }
                        }
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 二连尾
                case ER_LIAN_WEI_0:
                case ER_LIAN_WEI_FEI_0:
                    prizeNum = 0;
                    Set<String> erWeiBetSet = LotteryUtils.getWeishuSet(kjList);
                    if (betNumbers.size() == 1) {
                        for (String kjStr : betNumbers.get(0)) {
                            if (erWeiBetSet.contains(kjStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 2);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 三连尾
                case SAN_LIAN_WEI_0:
                case SAN_LIAN_WEI_FEI_0:
                    prizeNum = 0;
                    Set<String> sanWeiBetSet = LotteryUtils.getWeishuSet(kjList);
                    if (betNumbers.size() == 1) {
                        for (String kjStr : betNumbers.get(0)) {
                            if (sanWeiBetSet.contains(kjStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 3);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 四连尾
                case SI_LIAN_WEI_0:
                case SI_LIAN_WEI_FEI_0:
                    prizeNum = 0;
                    Set<String> siWeiBetSet = LotteryUtils.getWeishuSet(kjList);
                    if (betNumbers.size() == 1) {
                        for (String kjStr : betNumbers.get(0)) {
                            if (siWeiBetSet.contains(kjStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 4);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 五连尾
                case WU_LIAN_WEI_0:
                case WU_LIAN_WEI_FEI_0:
                    prizeNum = 0;
                    Set<String> wuWeiBetSet = LotteryUtils.getWeishuSet(kjList);
                    if (betNumbers.size() == 1) {
                        for (String kjStr : betNumbers.get(0)) {
                            if (wuWeiBetSet.contains(kjStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 二连肖
                case ER_LIAN_XIAO_BEN_MING:
                case ER_LIAN_XIAO_FEI_BEN_MING:
                    prizeNum = 0;
                    Set<String> erXiaoBetSet = LotteryUtils.getShengxiaoTypeSet(kjList);
                    if (betNumbers.size() == 1) {
                        for (String kjStr : betNumbers.get(0)) {
                            if (erXiaoBetSet.contains(kjStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 2);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 三连肖
                case SAN_LIAN_XIAO_BEN_MING:
                case SAN_LIAN_XIAO_FEI_BEN_MING:
                    prizeNum = 0;
                    Set<String> sanXiaoBetSet = LotteryUtils.getShengxiaoTypeSet(kjList);
                    if (betNumbers.size() == 1) {
                        for (String kjStr : betNumbers.get(0)) {
                            if (sanXiaoBetSet.contains(kjStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 3);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 四连肖
                case SI_LIAN_XIAO_BEN_MING:
                case SI_LIAN_XIAO_FEI_BEN_MING:
                    prizeNum = 0;
                    Set<String> siXiaoBetSet = LotteryUtils.getShengxiaoTypeSet(kjList);
                    if (betNumbers.size() == 1) {
                        for (String kjStr : betNumbers.get(0)) {
                            if (siXiaoBetSet.contains(kjStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 4);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

                    // 五连肖
                case WU_LIAN_XIAO_BEN_MING:
                case WU_LIAN_XIAO_FEI_BEN_MING:
                    prizeNum = 0;
                    Set<String> wuXiaoBetSet = LotteryUtils.getShengxiaoTypeSet(kjList);
                    if (betNumbers.size() == 1) {
                        for (String kjStr : betNumbers.get(0)) {
                            if (wuXiaoBetSet.contains(kjStr)) {
                                prizeNum++;
                            }
                        }
                        firstPrizeNum = (int) LotteryUtils.combination(prizeNum, 5);
                    }
                    lotteryOrder.setFirstPrizeNum(firstPrizeNum);
                    continue;

            }
        }
        return lotteryOrderList;
    }

    /**
     * 六合彩开奖号码整理
     *
     * @param kj
     * @param lotteryType
     * @return
     */
    private static List<String> getRealLotteryMark6Kj(String kj, LotteryType lotteryType) {

        List<String> resultList = new ArrayList<>();
        List<String> kjList = Arrays.asList(kj.trim().split(","));

        if (kjList.size() != 7) {
            return resultList;
        }

        if (lotteryType instanceof LotteryMark6DoubleType) {
            LotteryMark6DoubleType lotteryMark6DoubleType = (LotteryMark6DoubleType) lotteryType;
            switch (lotteryMark6DoubleType) {

                // 特码
                case TE_MA_A_1:
                case TE_MA_A_2:
                case TE_MA_A_3:
                case TE_MA_A_4:
                case TE_MA_A_5:
                case TE_MA_A_6:
                case TE_MA_A_7:
                case TE_MA_A_8:
                case TE_MA_A_9:
                case TE_MA_A_10:

                case TE_MA_A_11:
                case TE_MA_A_12:
                case TE_MA_A_13:
                case TE_MA_A_14:
                case TE_MA_A_15:
                case TE_MA_A_16:
                case TE_MA_A_17:
                case TE_MA_A_18:
                case TE_MA_A_19:
                case TE_MA_A_20:

                case TE_MA_A_21:
                case TE_MA_A_22:
                case TE_MA_A_23:
                case TE_MA_A_24:
                case TE_MA_A_25:
                case TE_MA_A_26:
                case TE_MA_A_27:
                case TE_MA_A_28:
                case TE_MA_A_29:
                case TE_MA_A_30:

                case TE_MA_A_31:
                case TE_MA_A_32:
                case TE_MA_A_33:
                case TE_MA_A_34:
                case TE_MA_A_35:
                case TE_MA_A_36:
                case TE_MA_A_37:
                case TE_MA_A_38:
                case TE_MA_A_39:
                case TE_MA_A_40:

                case TE_MA_A_41:
                case TE_MA_A_42:
                case TE_MA_A_43:
                case TE_MA_A_44:
                case TE_MA_A_45:
                case TE_MA_A_46:
                case TE_MA_A_47:
                case TE_MA_A_48:
                case TE_MA_A_49:

                case TE_MA_B_1:
                case TE_MA_B_2:
                case TE_MA_B_3:
                case TE_MA_B_4:
                case TE_MA_B_5:
                case TE_MA_B_6:
                case TE_MA_B_7:
                case TE_MA_B_8:
                case TE_MA_B_9:
                case TE_MA_B_10:

                case TE_MA_B_11:
                case TE_MA_B_12:
                case TE_MA_B_13:
                case TE_MA_B_14:
                case TE_MA_B_15:
                case TE_MA_B_16:
                case TE_MA_B_17:
                case TE_MA_B_18:
                case TE_MA_B_19:
                case TE_MA_B_20:

                case TE_MA_B_21:
                case TE_MA_B_22:
                case TE_MA_B_23:
                case TE_MA_B_24:
                case TE_MA_B_25:
                case TE_MA_B_26:
                case TE_MA_B_27:
                case TE_MA_B_28:
                case TE_MA_B_29:
                case TE_MA_B_30:

                case TE_MA_B_31:
                case TE_MA_B_32:
                case TE_MA_B_33:
                case TE_MA_B_34:
                case TE_MA_B_35:
                case TE_MA_B_36:
                case TE_MA_B_37:
                case TE_MA_B_38:
                case TE_MA_B_39:
                case TE_MA_B_40:

                case TE_MA_B_41:
                case TE_MA_B_42:
                case TE_MA_B_43:
                case TE_MA_B_44:
                case TE_MA_B_45:
                case TE_MA_B_46:
                case TE_MA_B_47:
                case TE_MA_B_48:
                case TE_MA_B_49:

                case TE_MA_DA:
                case TE_MA_XIAO:
                case TE_MA_DAN:
                case TE_MA_SHUANG:

                case TE_MA_DA_DAN:
                case TE_MA_DA_SHUANG:
                case TE_MA_XIAO_DAN:
                case TE_MA_XIAO_SHUANG:

                case TE_MA_HE_DA:
                case TE_MA_HE_XIAO:
                case TE_MA_HE_DAN:
                case TE_MA_HE_SHUANG:

                case TE_MA_WEI_DA:
                case TE_MA_WEI_XIAO:

                case TE_MA_TOU_0:
                case TE_MA_TOU_1:
                case TE_MA_TOU_2:
                case TE_MA_TOU_3:
                case TE_MA_TOU_4:

                case TE_MA_WEI_0:
                case TE_MA_WEI_1:
                case TE_MA_WEI_2:
                case TE_MA_WEI_3:
                case TE_MA_WEI_4:
                case TE_MA_WEI_5:
                case TE_MA_WEI_6:
                case TE_MA_WEI_7:
                case TE_MA_WEI_8:
                case TE_MA_WEI_9:

                    // 色波
                case TE_MA_HONG_BO:
                case TE_MA_LAN_BO:
                case TE_MA_LV_BO:

                case TE_MA_HONG_DA:
                case TE_MA_HONG_XIAO:
                case TE_MA_HONG_DAN:
                case TE_MA_HONG_SHUANG:
                case TE_MA_HONG_DA_DAN:
                case TE_MA_HONG_DA_SHUANG:
                case TE_MA_HONG_XIAO_DAN:
                case TE_MA_HONG_XIAO_SHUANG:

                case TE_MA_LAN_DA:
                case TE_MA_LAN_XIAO:
                case TE_MA_LAN_DAN:
                case TE_MA_LAN_SHUANG:
                case TE_MA_LAN_DA_DAN:
                case TE_MA_LAN_XIAO_DAN:
                case TE_MA_LAN_DA_SHUANG:
                case TE_MA_LAN_XIAO_SHUANG:

                case TE_MA_LV_DA:
                case TE_MA_LV_XIAO:
                case TE_MA_LV_DAN:
                case TE_MA_LV_SHUANG:
                case TE_MA_LV_DA_DAN:
                case TE_MA_LV_XIAO_DAN:
                case TE_MA_LV_DA_SHUANG:
                case TE_MA_LV_XIAO_SHUANG:

                    // 特肖
                case TE_XIAO_SHU:
                case TE_XIAO_NIU:
                case TE_XIAO_HU:
                case TE_XIAO_TU:
                case TE_XIAO_LONG:
                case TE_XIAO_SHE:
                case TE_XIAO_MA:
                case TE_XIAO_YANG:
                case TE_XIAO_HOU:
                case TE_XIAO_JI:
                case TE_XIAO_GOU:
                case TE_XIAO_ZHU:

                case TE_TIAN_XIAO:
                case TE_DI_XIAO:
                case TE_QIAN_XIAO:
                case TE_HOU_XIAO:
                case TE_JIA_XIAO:
                case TE_YE_XIAO:

                    // 合肖
                case HE_XIAO_ER:
                case HE_XIAO_SAN:
                case HE_XIAO_SI:
                case HE_XIAO_WU:
                case HE_XIAO_LIU:
                case HE_XIAO_QI:
                case HE_XIAO_BA:
                case HE_XIAO_JIU:
                case HE_XIAO_SHI:
                case HE_XIAO_SHI_YI:

                    //五行
                case WU_XING_JIN:
                case WU_XING_MU:
                case WU_XING_SHUI:
                case WU_XING_HUO:
                case WU_XING_TU:

                    resultList.add(kjList.get(6));
                    break;

                // 正码
                case ZHENG_MA_1:
                case ZHENG_MA_2:
                case ZHENG_MA_3:
                case ZHENG_MA_4:
                case ZHENG_MA_5:
                case ZHENG_MA_6:
                case ZHENG_MA_7:
                case ZHENG_MA_8:
                case ZHENG_MA_9:
                case ZHENG_MA_10:

                case ZHENG_MA_11:
                case ZHENG_MA_12:
                case ZHENG_MA_13:
                case ZHENG_MA_14:
                case ZHENG_MA_15:
                case ZHENG_MA_16:
                case ZHENG_MA_17:
                case ZHENG_MA_18:
                case ZHENG_MA_19:
                case ZHENG_MA_20:

                case ZHENG_MA_21:
                case ZHENG_MA_22:
                case ZHENG_MA_23:
                case ZHENG_MA_24:
                case ZHENG_MA_25:
                case ZHENG_MA_26:
                case ZHENG_MA_27:
                case ZHENG_MA_28:
                case ZHENG_MA_29:
                case ZHENG_MA_30:

                case ZHENG_MA_31:
                case ZHENG_MA_32:
                case ZHENG_MA_33:
                case ZHENG_MA_34:
                case ZHENG_MA_35:
                case ZHENG_MA_36:
                case ZHENG_MA_37:
                case ZHENG_MA_38:
                case ZHENG_MA_39:
                case ZHENG_MA_40:

                case ZHENG_MA_41:
                case ZHENG_MA_42:
                case ZHENG_MA_43:
                case ZHENG_MA_44:
                case ZHENG_MA_45:
                case ZHENG_MA_46:
                case ZHENG_MA_47:
                case ZHENG_MA_48:
                case ZHENG_MA_49:

                    // 连码
                case LIAN_MA_SAN_ZHONG_ER:
                case LIAN_MA_ER_QUAN_ZHONG:
                case LIAN_MA_SAN_QUAN_ZHONG:
                case LIAN_MA_SI_QUAN_ZHONG:

                    // 正肖
                case ZHENG_XIAO_SHU:
                case ZHENG_XIAO_NIU:
                case ZHENG_XIAO_HU:
                case ZHENG_XIAO_TU:
                case ZHENG_XIAO_LONG:
                case ZHENG_XIAO_SHE:
                case ZHENG_XIAO_MA:
                case ZHENG_XIAO_YANG:
                case ZHENG_XIAO_HOU:
                case ZHENG_XIAO_JI:
                case ZHENG_XIAO_GOU:
                case ZHENG_XIAO_ZHU:

                    resultList.addAll(kjList);
                    resultList.remove(6);
                    break;

                // 正一特
                case ZHENG_YI_TE_1:
                case ZHENG_YI_TE_2:
                case ZHENG_YI_TE_3:
                case ZHENG_YI_TE_4:
                case ZHENG_YI_TE_5:
                case ZHENG_YI_TE_6:
                case ZHENG_YI_TE_7:
                case ZHENG_YI_TE_8:
                case ZHENG_YI_TE_9:
                case ZHENG_YI_TE_10:

                case ZHENG_YI_TE_11:
                case ZHENG_YI_TE_12:
                case ZHENG_YI_TE_13:
                case ZHENG_YI_TE_14:
                case ZHENG_YI_TE_15:
                case ZHENG_YI_TE_16:
                case ZHENG_YI_TE_17:
                case ZHENG_YI_TE_18:
                case ZHENG_YI_TE_19:
                case ZHENG_YI_TE_20:

                case ZHENG_YI_TE_21:
                case ZHENG_YI_TE_22:
                case ZHENG_YI_TE_23:
                case ZHENG_YI_TE_24:
                case ZHENG_YI_TE_25:
                case ZHENG_YI_TE_26:
                case ZHENG_YI_TE_27:
                case ZHENG_YI_TE_28:
                case ZHENG_YI_TE_29:
                case ZHENG_YI_TE_30:

                case ZHENG_YI_TE_31:
                case ZHENG_YI_TE_32:
                case ZHENG_YI_TE_33:
                case ZHENG_YI_TE_34:
                case ZHENG_YI_TE_35:
                case ZHENG_YI_TE_36:
                case ZHENG_YI_TE_37:
                case ZHENG_YI_TE_38:
                case ZHENG_YI_TE_39:
                case ZHENG_YI_TE_40:

                case ZHENG_YI_TE_41:
                case ZHENG_YI_TE_42:
                case ZHENG_YI_TE_43:
                case ZHENG_YI_TE_44:
                case ZHENG_YI_TE_45:
                case ZHENG_YI_TE_46:
                case ZHENG_YI_TE_47:
                case ZHENG_YI_TE_48:
                case ZHENG_YI_TE_49:

                case ZHENG_YI_MA_DA:
                case ZHENG_YI_MA_XIAO:
                case ZHENG_YI_MA_DAN:
                case ZHENG_YI_MA_SHUANG:
                case ZHENG_YI_HE_DA:
                case ZHENG_YI_HE_XIAO:
                case ZHENG_YI_HE_DAN:
                case ZHENG_YI_HE_SHUANG:
                case ZHENG_YI_WEI_DA:
                case ZHENG_YI_WEI_XIAO:
                case ZHENG_YI_LV:
                case ZHENG_YI_LAN:
                case ZHENG_YI_HONG:

                    resultList.add(kjList.get(0));
                    break;

                // 正二特
                case ZHENG_ER_TE_1:
                case ZHENG_ER_TE_2:
                case ZHENG_ER_TE_3:
                case ZHENG_ER_TE_4:
                case ZHENG_ER_TE_5:
                case ZHENG_ER_TE_6:
                case ZHENG_ER_TE_7:
                case ZHENG_ER_TE_8:
                case ZHENG_ER_TE_9:
                case ZHENG_ER_TE_10:

                case ZHENG_ER_TE_11:
                case ZHENG_ER_TE_12:
                case ZHENG_ER_TE_13:
                case ZHENG_ER_TE_14:
                case ZHENG_ER_TE_15:
                case ZHENG_ER_TE_16:
                case ZHENG_ER_TE_17:
                case ZHENG_ER_TE_18:
                case ZHENG_ER_TE_19:
                case ZHENG_ER_TE_20:

                case ZHENG_ER_TE_21:
                case ZHENG_ER_TE_22:
                case ZHENG_ER_TE_23:
                case ZHENG_ER_TE_24:
                case ZHENG_ER_TE_25:
                case ZHENG_ER_TE_26:
                case ZHENG_ER_TE_27:
                case ZHENG_ER_TE_28:
                case ZHENG_ER_TE_29:
                case ZHENG_ER_TE_30:

                case ZHENG_ER_TE_31:
                case ZHENG_ER_TE_32:
                case ZHENG_ER_TE_33:
                case ZHENG_ER_TE_34:
                case ZHENG_ER_TE_35:
                case ZHENG_ER_TE_36:
                case ZHENG_ER_TE_37:
                case ZHENG_ER_TE_38:
                case ZHENG_ER_TE_39:
                case ZHENG_ER_TE_40:

                case ZHENG_ER_TE_41:
                case ZHENG_ER_TE_42:
                case ZHENG_ER_TE_43:
                case ZHENG_ER_TE_44:
                case ZHENG_ER_TE_45:
                case ZHENG_ER_TE_46:
                case ZHENG_ER_TE_47:
                case ZHENG_ER_TE_48:
                case ZHENG_ER_TE_49:

                case ZHENG_ER_MA_DA:
                case ZHENG_ER_MA_XIAO:
                case ZHENG_ER_MA_DAN:
                case ZHENG_ER_MA_SHUANG:
                case ZHENG_ER_HE_DA:
                case ZHENG_ER_HE_XIAO:
                case ZHENG_ER_HE_DAN:
                case ZHENG_ER_HE_SHUANG:
                case ZHENG_ER_WEI_DA:
                case ZHENG_ER_WEI_XIAO:
                case ZHENG_ER_LV:
                case ZHENG_ER_LAN:
                case ZHENG_ER_HONG:

                    resultList.add(kjList.get(1));
                    break;

                // 正三特
                case ZHENG_SAN_TE_1:
                case ZHENG_SAN_TE_2:
                case ZHENG_SAN_TE_3:
                case ZHENG_SAN_TE_4:
                case ZHENG_SAN_TE_5:
                case ZHENG_SAN_TE_6:
                case ZHENG_SAN_TE_7:
                case ZHENG_SAN_TE_8:
                case ZHENG_SAN_TE_9:
                case ZHENG_SAN_TE_10:

                case ZHENG_SAN_TE_11:
                case ZHENG_SAN_TE_12:
                case ZHENG_SAN_TE_13:
                case ZHENG_SAN_TE_14:
                case ZHENG_SAN_TE_15:
                case ZHENG_SAN_TE_16:
                case ZHENG_SAN_TE_17:
                case ZHENG_SAN_TE_18:
                case ZHENG_SAN_TE_19:
                case ZHENG_SAN_TE_20:

                case ZHENG_SAN_TE_21:
                case ZHENG_SAN_TE_22:
                case ZHENG_SAN_TE_23:
                case ZHENG_SAN_TE_24:
                case ZHENG_SAN_TE_25:
                case ZHENG_SAN_TE_26:
                case ZHENG_SAN_TE_27:
                case ZHENG_SAN_TE_28:
                case ZHENG_SAN_TE_29:
                case ZHENG_SAN_TE_30:

                case ZHENG_SAN_TE_31:
                case ZHENG_SAN_TE_32:
                case ZHENG_SAN_TE_33:
                case ZHENG_SAN_TE_34:
                case ZHENG_SAN_TE_35:
                case ZHENG_SAN_TE_36:
                case ZHENG_SAN_TE_37:
                case ZHENG_SAN_TE_38:
                case ZHENG_SAN_TE_39:
                case ZHENG_SAN_TE_40:

                case ZHENG_SAN_TE_41:
                case ZHENG_SAN_TE_42:
                case ZHENG_SAN_TE_43:
                case ZHENG_SAN_TE_44:
                case ZHENG_SAN_TE_45:
                case ZHENG_SAN_TE_46:
                case ZHENG_SAN_TE_47:
                case ZHENG_SAN_TE_48:
                case ZHENG_SAN_TE_49:

                case ZHENG_SAN_MA_DA:
                case ZHENG_SAN_MA_XIAO:
                case ZHENG_SAN_MA_DAN:
                case ZHENG_SAN_MA_SHUANG:
                case ZHENG_SAN_HE_DA:
                case ZHENG_SAN_HE_XIAO:
                case ZHENG_SAN_HE_DAN:
                case ZHENG_SAN_HE_SHUANG:
                case ZHENG_SAN_WEI_DA:
                case ZHENG_SAN_WEI_XIAO:
                case ZHENG_SAN_LV:
                case ZHENG_SAN_LAN:
                case ZHENG_SAN_HONG:

                    resultList.add(kjList.get(2));
                    break;

                // 正四特
                case ZHENG_SI_TE_1:
                case ZHENG_SI_TE_2:
                case ZHENG_SI_TE_3:
                case ZHENG_SI_TE_4:
                case ZHENG_SI_TE_5:
                case ZHENG_SI_TE_6:
                case ZHENG_SI_TE_7:
                case ZHENG_SI_TE_8:
                case ZHENG_SI_TE_9:
                case ZHENG_SI_TE_10:

                case ZHENG_SI_TE_11:
                case ZHENG_SI_TE_12:
                case ZHENG_SI_TE_13:
                case ZHENG_SI_TE_14:
                case ZHENG_SI_TE_15:
                case ZHENG_SI_TE_16:
                case ZHENG_SI_TE_17:
                case ZHENG_SI_TE_18:
                case ZHENG_SI_TE_19:
                case ZHENG_SI_TE_20:

                case ZHENG_SI_TE_21:
                case ZHENG_SI_TE_22:
                case ZHENG_SI_TE_23:
                case ZHENG_SI_TE_24:
                case ZHENG_SI_TE_25:
                case ZHENG_SI_TE_26:
                case ZHENG_SI_TE_27:
                case ZHENG_SI_TE_28:
                case ZHENG_SI_TE_29:
                case ZHENG_SI_TE_30:

                case ZHENG_SI_TE_31:
                case ZHENG_SI_TE_32:
                case ZHENG_SI_TE_33:
                case ZHENG_SI_TE_34:
                case ZHENG_SI_TE_35:
                case ZHENG_SI_TE_36:
                case ZHENG_SI_TE_37:
                case ZHENG_SI_TE_38:
                case ZHENG_SI_TE_39:
                case ZHENG_SI_TE_40:

                case ZHENG_SI_TE_41:
                case ZHENG_SI_TE_42:
                case ZHENG_SI_TE_43:
                case ZHENG_SI_TE_44:
                case ZHENG_SI_TE_45:
                case ZHENG_SI_TE_46:
                case ZHENG_SI_TE_47:
                case ZHENG_SI_TE_48:
                case ZHENG_SI_TE_49:

                case ZHENG_SI_MA_DA:
                case ZHENG_SI_MA_XIAO:
                case ZHENG_SI_MA_DAN:
                case ZHENG_SI_MA_SHUANG:
                case ZHENG_SI_HE_DA:
                case ZHENG_SI_HE_XIAO:
                case ZHENG_SI_HE_DAN:
                case ZHENG_SI_HE_SHUANG:
                case ZHENG_SI_WEI_DA:
                case ZHENG_SI_WEI_XIAO:
                case ZHENG_SI_LV:
                case ZHENG_SI_LAN:
                case ZHENG_SI_HONG:

                    resultList.add(kjList.get(3));
                    break;

                // 正五特
                case ZHENG_WU_TE_1:
                case ZHENG_WU_TE_2:
                case ZHENG_WU_TE_3:
                case ZHENG_WU_TE_4:
                case ZHENG_WU_TE_5:
                case ZHENG_WU_TE_6:
                case ZHENG_WU_TE_7:
                case ZHENG_WU_TE_8:
                case ZHENG_WU_TE_9:
                case ZHENG_WU_TE_10:

                case ZHENG_WU_TE_11:
                case ZHENG_WU_TE_12:
                case ZHENG_WU_TE_13:
                case ZHENG_WU_TE_14:
                case ZHENG_WU_TE_15:
                case ZHENG_WU_TE_16:
                case ZHENG_WU_TE_17:
                case ZHENG_WU_TE_18:
                case ZHENG_WU_TE_19:
                case ZHENG_WU_TE_20:

                case ZHENG_WU_TE_21:
                case ZHENG_WU_TE_22:
                case ZHENG_WU_TE_23:
                case ZHENG_WU_TE_24:
                case ZHENG_WU_TE_25:
                case ZHENG_WU_TE_26:
                case ZHENG_WU_TE_27:
                case ZHENG_WU_TE_28:
                case ZHENG_WU_TE_29:
                case ZHENG_WU_TE_30:

                case ZHENG_WU_TE_31:
                case ZHENG_WU_TE_32:
                case ZHENG_WU_TE_33:
                case ZHENG_WU_TE_34:
                case ZHENG_WU_TE_35:
                case ZHENG_WU_TE_36:
                case ZHENG_WU_TE_37:
                case ZHENG_WU_TE_38:
                case ZHENG_WU_TE_39:
                case ZHENG_WU_TE_40:

                case ZHENG_WU_TE_41:
                case ZHENG_WU_TE_42:
                case ZHENG_WU_TE_43:
                case ZHENG_WU_TE_44:
                case ZHENG_WU_TE_45:
                case ZHENG_WU_TE_46:
                case ZHENG_WU_TE_47:
                case ZHENG_WU_TE_48:
                case ZHENG_WU_TE_49:

                case ZHENG_WU_MA_DA:
                case ZHENG_WU_MA_XIAO:
                case ZHENG_WU_MA_DAN:
                case ZHENG_WU_MA_SHUANG:
                case ZHENG_WU_HE_DA:
                case ZHENG_WU_HE_XIAO:
                case ZHENG_WU_HE_DAN:
                case ZHENG_WU_HE_SHUANG:
                case ZHENG_WU_WEI_DA:
                case ZHENG_WU_WEI_XIAO:
                case ZHENG_WU_LV:
                case ZHENG_WU_LAN:
                case ZHENG_WU_HONG:

                    resultList.add(kjList.get(4));
                    break;

                // 正六特
                case ZHENG_LIU_TE_1:
                case ZHENG_LIU_TE_2:
                case ZHENG_LIU_TE_3:
                case ZHENG_LIU_TE_4:
                case ZHENG_LIU_TE_5:
                case ZHENG_LIU_TE_6:
                case ZHENG_LIU_TE_7:
                case ZHENG_LIU_TE_8:
                case ZHENG_LIU_TE_9:
                case ZHENG_LIU_TE_10:

                case ZHENG_LIU_TE_11:
                case ZHENG_LIU_TE_12:
                case ZHENG_LIU_TE_13:
                case ZHENG_LIU_TE_14:
                case ZHENG_LIU_TE_15:
                case ZHENG_LIU_TE_16:
                case ZHENG_LIU_TE_17:
                case ZHENG_LIU_TE_18:
                case ZHENG_LIU_TE_19:
                case ZHENG_LIU_TE_20:

                case ZHENG_LIU_TE_21:
                case ZHENG_LIU_TE_22:
                case ZHENG_LIU_TE_23:
                case ZHENG_LIU_TE_24:
                case ZHENG_LIU_TE_25:
                case ZHENG_LIU_TE_26:
                case ZHENG_LIU_TE_27:
                case ZHENG_LIU_TE_28:
                case ZHENG_LIU_TE_29:
                case ZHENG_LIU_TE_30:

                case ZHENG_LIU_TE_31:
                case ZHENG_LIU_TE_32:
                case ZHENG_LIU_TE_33:
                case ZHENG_LIU_TE_34:
                case ZHENG_LIU_TE_35:
                case ZHENG_LIU_TE_36:
                case ZHENG_LIU_TE_37:
                case ZHENG_LIU_TE_38:
                case ZHENG_LIU_TE_39:
                case ZHENG_LIU_TE_40:

                case ZHENG_LIU_TE_41:
                case ZHENG_LIU_TE_42:
                case ZHENG_LIU_TE_43:
                case ZHENG_LIU_TE_44:
                case ZHENG_LIU_TE_45:
                case ZHENG_LIU_TE_46:
                case ZHENG_LIU_TE_47:
                case ZHENG_LIU_TE_48:
                case ZHENG_LIU_TE_49:

                case ZHENG_LIU_MA_DA:
                case ZHENG_LIU_MA_XIAO:
                case ZHENG_LIU_MA_DAN:
                case ZHENG_LIU_MA_SHUANG:
                case ZHENG_LIU_HE_DA:
                case ZHENG_LIU_HE_XIAO:
                case ZHENG_LIU_HE_DAN:
                case ZHENG_LIU_HE_SHUANG:
                case ZHENG_LIU_WEI_DA:
                case ZHENG_LIU_WEI_XIAO:
                case ZHENG_LIU_LV:
                case ZHENG_LIU_LAN:
                case ZHENG_LIU_HONG:

                    resultList.add(kjList.get(5));
                    break;

                case ZONG_DAN_XIAO:
                case ZONG_SHUANG_XIAO:
                case ZONG_QI_XIAO:
                case ZONG_LIU_XIAO:
                case ZONG_WU_XIAO:
                case ZONG_SI_XIAO:
                case ZONG_SAN_XIAO:
                case ZONG_ER_XIAO:

                case WU_LIAN_XIAO_BEN_MING:
                case WU_LIAN_XIAO_FEI_BEN_MING:
                case SI_LIAN_XIAO_BEN_MING:
                case SI_LIAN_XIAO_FEI_BEN_MING:
                case SAN_LIAN_XIAO_BEN_MING:
                case SAN_LIAN_XIAO_FEI_BEN_MING:
                case ER_LIAN_XIAO_BEN_MING:
                case ER_LIAN_XIAO_FEI_BEN_MING:
                case WU_LIAN_WEI_0:
                case WU_LIAN_WEI_FEI_0:
                case SI_LIAN_WEI_0:
                case SI_LIAN_WEI_FEI_0:
                case SAN_LIAN_WEI_0:
                case SAN_LIAN_WEI_FEI_0:
                case ER_LIAN_WEI_0:
                case ER_LIAN_WEI_FEI_0:

                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:
                case ZHENG_MA_ZONG_DA:
                case ZHENG_MA_ZONG_XIAO:
                case ZHENG_MA_ZONG_DAN:
                case ZHENG_MA_ZONG_SHUANG:

                case QI_SE_HE_JU:
                case QI_SE_LAN_BO:
                case QI_SE_LV_BO:
                case QI_SE_HONG_BO:

                case LIAN_MA_TE_CHUAN:
                case LIAN_MA_ER_ZHONG_TE:

                case PING_TE_YI_XIAO_SHU:
                case PING_TE_YI_XIAO_NIU:
                case PING_TE_YI_XIAO_HU:
                case PING_TE_YI_XIAO_TU:
                case PING_TE_YI_XIAO_LONG:
                case PING_TE_YI_XIAO_SHE:
                case PING_TE_YI_XIAO_MA:
                case PING_TE_YI_XIAO_YANG:
                case PING_TE_YI_XIAO_HOU:
                case PING_TE_YI_XIAO_JI:
                case PING_TE_YI_XIAO_GOU:
                case PING_TE_YI_XIAO_ZHU:

                case PING_TE_WEI_SHU_0:
                case PING_TE_WEI_SHU_1:
                case PING_TE_WEI_SHU_2:
                case PING_TE_WEI_SHU_3:
                case PING_TE_WEI_SHU_4:
                case PING_TE_WEI_SHU_5:
                case PING_TE_WEI_SHU_6:
                case PING_TE_WEI_SHU_7:
                case PING_TE_WEI_SHU_8:
                case PING_TE_WEI_SHU_9:

                case ZI_XUAN_BU_ZHONG_5:
                case ZI_XUAN_BU_ZHONG_6:
                case ZI_XUAN_BU_ZHONG_7:
                case ZI_XUAN_BU_ZHONG_8:
                case ZI_XUAN_BU_ZHONG_9:
                case ZI_XUAN_BU_ZHONG_10:
                case ZI_XUAN_BU_ZHONG_11:
                case ZI_XUAN_BU_ZHONG_12:

                    resultList.addAll(kjList);
                    break;

                default:
                    resultList.addAll(kjList);
            }
        }
        return resultList;
    }
}