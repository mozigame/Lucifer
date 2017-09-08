package com.bc.lottery.pour.service.impl;

import com.bc.lottery.entity.LotteryType;
import com.bc.lottery.entity.ShishicaiType;
import com.bc.lottery.pour.service.LotteryPourHandle;
import com.bc.lottery.util.LotteryUtils;

import java.util.List;

/**
 * Created by luis on 2017/4/14.
 */

class ShishicaiPourServiceImpl implements LotteryPourHandle, ShishicaiType {

    private static final int[] ZHI_XUAN_KUA_DU = {10, 54, 96, 126, 144, 150, 144, 126, 96, 54};

    private static final int[] SAN_XING_ZHI_XUAN_HE_ZHI = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
    private static final int[] SAN_XING_ZU_XUAN_HE_ZHI = {0, 1, 2, 2, 4, 5, 6, 8, 10, 11, 13, 14, 14, 15, 15, 14, 14, 13, 11, 10, 8, 6, 5, 4, 2, 2, 1};

    private static final int[] ER_XING_ZHI_XUAN_HE_ZHI = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final int[] ER_XING_ZU_XUAN_HE_ZHI = {0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 4, 4, 3, 3, 2, 2, 1, 1};

    @Override
    public long getBetCount(List<List<String>> betNumbers, LotteryType lotteryType) {
        int size = betNumbers.size();

        if (lotteryType instanceof Wuxing) {
            Wuxing wuxingType = (Wuxing) lotteryType;
            switch (wuxingType) {

                case WU_XING_ZHI_XUAN_FU_SHI:
                    if (size == 5) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case WU_XING_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 5;
                    }
                    return 0;

                case WU_XING_ZHI_XUAN_ZU_HE:
                    if (size == 5) {
                        return 5 * LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case ZU_XUAN_120:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 5);
                    }
                    return 0;

                case ZU_XUAN_60:
                    if (size == 2) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 3, betNumbers);
                    }
                    return 0;

                case ZU_XUAN_30:
                    if (size == 2) {
                        return LotteryUtils.twoCombinationRemoveRepeat(2, 1, betNumbers);
                    }
                    return 0;

                case ZU_XUAN_20:
                    if (size == 2) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 2, betNumbers);
                    }
                    return 0;

                case ZU_XUAN_10:
                case ZU_XUAN_5:
                    if (size == 2) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 1, betNumbers);
                    }
                    return 0;

                default:
                    return 0;
            }
        } else if (lotteryType instanceof Sixing) {
            Sixing sixingType = (Sixing) lotteryType;
            switch (sixingType) {
                case SI_XING_ZHI_XUAN_FU_SHI:
                    if (size == 4) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case SI_XING_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 4;
                    }
                    return 0;

                case SI_XING_ZHI_XUAN_ZU_HE:
                    if (size == 4) {
                        return 4 * LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case ZU_XUAN_24:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 4);
                    }
                    return 0;

                case ZU_XUAN_12:
                    if (size == 2) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 2, betNumbers);
                    }
                    return 0;

                case ZU_XUAN_6:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case ZU_XUAN_4:
                    if (size == 2) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 1, betNumbers);
                    }
                    return 0;

                default:
                    return 0;

            }
        } else if (lotteryType instanceof Sanxing) {
            Sanxing sanxingType = (Sanxing) lotteryType;
            switch (sanxingType) {
                case QIAN_SAN_FU_SHI:
                case ZHONG_SAN_FU_SHI:
                case HOU_SAN_FU_SHI:
                    if (size == 3) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case QIAN_SAN_DAN_SHI:
                case ZHONG_SAN_DAN_SHI:
                case HOU_SAN_DAN_SHI:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 3;
                    }
                    return 0;

                case QIAN_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_SAN:
                case HOU_SAN_ZU_SAN:
                    if (size == 1) {
                        return 2 * LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case QIAN_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_LIU:
                case HOU_SAN_ZU_LIU:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 3);
                    }
                    return 0;

                case QIAN_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case HOU_SAN_HUN_HE_ZU_XUAN:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 3;
                    }
                    return 0;

                case QIAN_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                    if (size == 1) {
                        int count = 0;
                        for (String number : betNumbers.get(0)) {
                            try {
                                count += SAN_XING_ZHI_XUAN_HE_ZHI[Integer.parseInt(number)];
                            } catch (NumberFormatException e) {
                            }
                        }
                        return count;
                    }
                    return 0;

                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                    if (size == 1) {
                        int count = 0;
                        for (String number : betNumbers.get(0)) {
                            try {
                                count += SAN_XING_ZU_XUAN_HE_ZHI[Integer.parseInt(number)];
                            } catch (NumberFormatException e) {
                            }
                        }
                        return count;
                    }
                    return 0;

                default:
                    return 0;
            }
        } else if (lotteryType instanceof Erxing) {
            Erxing erxingType = (Erxing) lotteryType;
            switch (erxingType) {
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case HOU_ER_ZHI_XUAN_FU_SHI:
                    if (size == 2) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_DAN_SHI:

                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZU_XUAN_DAN_SHI:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 2;
                    }
                    return 0;

                case QIAN_ER_ZU_XUAN_FU_SHI:
                case HOU_ER_ZU_XUAN_FU_SHI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case QIAN_ER_ZHI_XUAN_HE_ZHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                    if (size == 1) {
                        int count = 0;
                        for (String number : betNumbers.get(0)) {
                            try {
                                count += ER_XING_ZHI_XUAN_HE_ZHI[Integer.parseInt(number)];
                            } catch (NumberFormatException e) {
                            }
                        }
                        return count;
                    }
                    return 0;

                case QIAN_ER_ZU_XUAN_HE_ZHI:
                case HOU_ER_ZU_XUAN_HE_ZHI:
                    if (size == 1) {
                        int count = 0;
                        for (String number : betNumbers.get(0)) {
                            try {
                                count += ER_XING_ZU_XUAN_HE_ZHI[Integer.parseInt(number)];
                            } catch (NumberFormatException e) {
                            }
                        }
                        return count;
                    }
                    return 0;

                default:
                    return 0;
            }
        } else if (lotteryType instanceof Yixing) {
            Yixing yixingType = (Yixing) lotteryType;
            switch (yixingType) {
                case YI_XING_DING_WEI_DAN:
                    if (size != 0) {
                        return LotteryUtils.toPlusAll(betNumbers);
                    }
                    return 0;

                default:
                    return 0;
            }
        } else if (lotteryType instanceof Budingdan) {
            Budingdan budingdanType = (Budingdan) lotteryType;
            switch (budingdanType) {
                case QIAN_SAN_YI_MA:
                case ZHONG_SAN_YI_MA:
                case HOU_SAN_YI_MA:
                case REN_SAN_YI_MA:
                case SI_XING_YI_MA:
                    if (size == 1) {
                        return betNumbers.get(0).size();
                    }
                    return 0;

                case QIAN_SAN_ER_MA:
                case HOU_SAN_ER_MA:
                case SI_XING_ER_MA:
                case WU_XING_ER_MA:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case WU_XING_SAN_MA:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 3);
                    }
                    return 0;

                default:
                    return 0;
            }
        } else if (lotteryType instanceof Daxiaodanshuang) {
            Daxiaodanshuang daxiaodanshuangType = (Daxiaodanshuang) lotteryType;
            switch (daxiaodanshuangType) {
                case QIAN_ER_DA_XIAO_DAN_SHUANG:
                case HOU_ER_DA_XIAO_DAN_SHUANG:
                case REN_XUAN_ER_DA_XIAO_DAN_SHUANG:
                    if (size == 2) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case QIAN_SAN_DA_XIAO_DAN_SHUANG:
                case HOU_SAN_DA_XIAO_DAN_SHUANG:
                    if (size == 3) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                default:
                    return 0;
            }
        } else if (lotteryType instanceof Quwei) {
            Quwei budingdanType = (Quwei) lotteryType;
            switch (budingdanType) {
                case YI_FAN_FENG_SHUN:
                case HAO_SHI_CHENG_SHUANG:
                case SAN_XING_BAO_XI:
                case SI_JI_FA_CAI:
                    if (size == 1) {
                        return betNumbers.get(0).size();
                    }
                    return 0;

                default:
                    return 0;
            }
        }

        return 0;
    }

}
