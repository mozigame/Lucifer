package com.bc.lottery.pour.service.impl;

import com.bc.lottery.entity.*;
import com.bc.lottery.pour.service.LotteryPourHandle;
import com.bc.lottery.util.JsonUtils;
import com.bc.lottery.util.LotteryUtils;

import java.util.*;

/**
 * Created by clion on 2017/9/14.
 */
public class ShishicaiPourServiceImpl implements LotteryPourHandle {

    private static final int[] ZHI_XUAN_KUA_DU = {10, 54, 96, 126, 144, 150, 144, 126, 96, 54};

    private static final int[] SAN_XING_ZHI_XUAN_HE_ZHI = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 63, 69, 73, 75, 75, 73, 69, 63, 55, 45, 36, 28, 21, 15, 10, 6, 3, 1};
    private static final int[] SAN_XING_ZU_XUAN_HE_ZHI = {0, 1, 2, 2, 4, 5, 6, 8, 10, 11, 13, 14, 14, 15, 15, 14, 14, 13, 11, 10, 8, 6, 5, 4, 2, 2, 1};

    private static final int[] ER_XING_ZHI_XUAN_HE_ZHI = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static final int[] ER_XING_ZU_XUAN_HE_ZHI = {0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 4, 4, 3, 3, 2, 2, 1, 1};

    @Override
    public long getBetCount(List<List<String>> betNumbers, Long playId) {

        return getShiShiCaiBetCount(playId, betNumbers);
    }

    @Override
    public long getLotteryBetCount(Long lotteryId, Long playId, List<List<String>> betNumbers) {

        if (betNumbers == null || betNumbers.size() == 0) {
            return 0;
        }
        if (lotteryId == 1) {
            return getShiShiCaiBetCount(playId, betNumbers);
        } else if (lotteryId == 2 || lotteryId == 12 || lotteryId == 14 || lotteryId == 102) {
            if (LotteryUtils.getDupStrByDupNum(betNumbers.get(0), 1).size() != 1) {
                return 0;
            }
            return 1;
        } else if (lotteryId == 3) {
            return getLottery11x5BetCount(playId, betNumbers);
        } else if (lotteryId == 4 || lotteryId == 16 || lotteryId == 18 || lotteryId == 104) {
            return getLottery11x5DoubleBetCount(playId, betNumbers);
        } else if (lotteryId == 5) {
            return getLotteryKuai3BetCount(playId, betNumbers);
        } else if (lotteryId == 6 || lotteryId == 20 || lotteryId == 22 || lotteryId == 106) {
            return getLotteryKuai3DoubleBetCount(playId, betNumbers);
        } else if (lotteryId == 7) {
            return getLotteryPK10BetCount(playId, betNumbers);
        } else if (lotteryId == 8 || lotteryId == 108) {
            if (betNumbers.get(0).size() != 1) {
                return 0;
            }
            return 1;
        } else if (lotteryId == 10) {
            return getLotteryMark6DoubleBetCount(playId, betNumbers);
        }
        return 0;
    }

    @Override
    public List<List<String>> getBetNumbersByType(Long playId) {
        return getShishicaiNumbers(playId);
    }

    @Override
    public List<List<String>> getBetNumbersByType(Long lotteryId, Long playId) {

        List<List<String>> resultList = new ArrayList<>();
        if (lotteryId == 1) {
            return getShishicaiNumbers(playId);
        } else if (lotteryId == 2 || lotteryId == 12 || lotteryId == 14) {
            return getShishicaiDoubleNumbers(playId);
        } else if (lotteryId == 4 || lotteryId == 16 || lotteryId == 18) {
            return get11x5DoubleNumbers(playId);
        } else if (lotteryId == 6 || lotteryId == 20 || lotteryId == 22) {
            return getKuai3DoubleNumbers(playId);
        } else if (lotteryId == 8) {
            return getPK10DoubleNumbers(playId);
        } else if (lotteryId == 10) {
            return getMark6DoubleNumbers(playId);
        }
        return resultList;
    }

    @Override
    public List<List<String>> getLotteryListByType(Long playId, String str) {

        return getLotteryShishicaiByType(playId, str);
    }

    //官方时时彩的字符串转换
    private List<List<String>> getLotteryShishicaiByType(Long playId, String str) {
        List<List<String>> strList = new ArrayList<>();

        ShishicaiType shishicaiType = ShishicaiType.parse(playId);
        if (shishicaiType == null) {
            return strList;
        }
        switch (shishicaiType) {

            case WU_XING_ZHI_XUAN_FU_SHI:
            case WU_XING_ZHI_XUAN_ZU_HE:
            case ZU_XUAN_60:
            case ZU_XUAN_30:
            case ZU_XUAN_20:
            case ZU_XUAN_10:
            case ZU_XUAN_5:

            case SI_XING_ZHI_XUAN_FU_SHI:
            case SI_XING_ZHI_XUAN_ZU_HE:
            case ZU_XUAN_12:
            case ZU_XUAN_4:

            case QIAN_SAN_FU_SHI:
            case ZHONG_SAN_FU_SHI:
            case HOU_SAN_FU_SHI:

            case QIAN_ER_ZHI_XUAN_FU_SHI:
            case HOU_ER_ZHI_XUAN_FU_SHI:

            case YI_XING_DING_WEI_DAN:

            case QIAN_ER_DA_XIAO_DAN_SHUANG:
            case HOU_ER_DA_XIAO_DAN_SHUANG:
            case ZONG_HE_DA_XIAO_DAN_SHUANG:

                return JsonUtils.json2LotteryList(str);

            case WU_XING_ZHI_XUAN_DAN_SHI:

            case SI_XING_ZHI_XUAN_DAN_SHI:

            case QIAN_SAN_DAN_SHI:
            case ZHONG_SAN_DAN_SHI:
            case HOU_SAN_DAN_SHI:
            case QIAN_SAN_HUN_HE_ZU_XUAN:
            case ZHONG_SAN_HUN_HE_ZU_XUAN:
            case HOU_SAN_HUN_HE_ZU_XUAN:

            case QIAN_ER_ZHI_XUAN_DAN_SHI:
            case HOU_ER_ZHI_XUAN_DAN_SHI:
            case QIAN_ER_ZU_XUAN_DAN_SHI:
            case HOU_ER_ZU_XUAN_DAN_SHI:

                return JsonUtils.danShiJson2LotteryList(str);

            case ZU_XUAN_120:
            case ZU_XUAN_24:
            case ZU_XUAN_6:

            case QIAN_SAN_ZHI_XUAN_HE_ZHI:
            case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
            case HOU_SAN_ZHI_XUAN_HE_ZHI:
            case QIAN_SAN_ZU_SAN:
            case ZHONG_SAN_ZU_SAN:
            case HOU_SAN_ZU_SAN:
            case QIAN_SAN_ZU_LIU:
            case HOU_SAN_ZU_LIU:
            case ZHONG_SAN_ZU_LIU:
            case QIAN_SAN_ZU_XUAN_HE_ZHI:
            case ZHONG_SAN_ZU_XUAN_HE_ZHI:
            case HOU_SAN_ZU_XUAN_HE_ZHI:

            case QIAN_ER_ZHI_XUAN_HE_ZHI:
            case HOU_ER_ZHI_XUAN_HE_ZHI:
            case QIAN_ER_ZU_XUAN_FU_SHI:
            case HOU_ER_ZU_XUAN_FU_SHI:
            case QIAN_ER_ZU_XUAN_HE_ZHI:
            case HOU_ER_ZU_XUAN_HE_ZHI:

            case QIAN_SAN_YI_MA:
            case HOU_SAN_YI_MA:
            case QIAN_SAN_ER_MA:
            case HOU_SAN_ER_MA:

            case YI_FAN_FENG_SHUN:
            case HAO_SHI_CHENG_SHUANG:
            case SAN_XING_BAO_XI:
            case SI_JI_FA_CAI:

                return JsonUtils.oneOnlyJson2LotteryList(str);

            default:
                return strList;
        }
    }

    private List<List<String>> getShishicaiNumbers(Long playId) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(String.valueOf(i));
        }
        Collections.shuffle(list);
        String[] oneNumber = {list.get(0)};
        Collections.shuffle(list);
        String[] twoNumber = {list.get(0), list.get(1)};
        Collections.shuffle(list);
        String[] threeNumber = {list.get(0), list.get(1), list.get(2)};
        Collections.shuffle(list);
        String[] fourNumber = {list.get(0), list.get(1), list.get(2), list.get(3)};
        Collections.shuffle(list);
        String[] fiveNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)};

        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> priBetNumber0 = new ArrayList<>();
        List<String> priBetNumber1 = new ArrayList<>();

        ShishicaiType shishicaiType = ShishicaiType.parse(playId);
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();

        if (shishicaiType != null) {
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            priBetNumber0.clear();
            switch (shishicaiType) {
                //五星
                case WU_XING_ZHI_XUAN_ZU_HE:
                case WU_XING_ZHI_XUAN_FU_SHI:
                    return getRandomList(9, 5, 1);

                case WU_XING_ZHI_XUAN_DAN_SHI:
                    return getRandomList(9, 1, 5);

                case ZU_XUAN_120:
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    break;
                case ZU_XUAN_60:

                    Collections.shuffle(list);
                    firstList.clear();
                    secondList.clear();
                    firstList.add(list.get(0));
                    secondList.add(list.get(1));
                    secondList.add(list.get(2));
                    secondList.add(list.get(3));
                    priBetNumbers.add(firstList);
                    priBetNumbers.add(secondList);
                    break;
                case ZU_XUAN_30:

                    Collections.shuffle(list);
                    firstList.clear();
                    secondList.clear();
                    firstList.add(list.get(0));
                    firstList.add(list.get(1));
                    secondList.add(list.get(2));
                    priBetNumbers.add(firstList);
                    priBetNumbers.add(secondList);
                    break;
                case ZU_XUAN_20:
                case ZU_XUAN_12:

                    Collections.shuffle(list);
                    firstList.clear();
                    secondList.clear();
                    firstList.add(list.get(0));
                    secondList.add(list.get(1));
                    secondList.add(list.get(2));
                    priBetNumbers.add(firstList);
                    priBetNumbers.add(secondList);
                    break;
                case ZU_XUAN_10:
                case ZU_XUAN_5:
                case ZU_XUAN_4:

                    Collections.shuffle(list);
                    firstList.clear();
                    secondList.clear();
                    firstList.add(list.get(0));
                    secondList.add(list.get(1));
                    priBetNumbers.add(firstList);
                    priBetNumbers.add(secondList);
                    break;

                // 四星
                case SI_XING_ZHI_XUAN_ZU_HE:
                case SI_XING_ZHI_XUAN_FU_SHI:
                    return getRandomList(9, 4, 1);
                case SI_XING_ZHI_XUAN_DAN_SHI:
                    return getRandomList(9, 1, 4);
                case ZU_XUAN_24:
                    priBetNumbers.add(Arrays.asList(fourNumber));
                    break;

                case ZU_XUAN_6:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    break;

                //三星
                case HOU_SAN_FU_SHI:
                case ZHONG_SAN_FU_SHI:
                case QIAN_SAN_FU_SHI:
                    return getRandomList(9, 3, 1);
                case HOU_SAN_DAN_SHI:
                case ZHONG_SAN_DAN_SHI:
                case QIAN_SAN_DAN_SHI:
                    return getRandomList(9, 1, 3);
                case HOU_SAN_ZHI_XUAN_HE_ZHI:
                case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                case QIAN_SAN_ZHI_XUAN_HE_ZHI:

                    String[] hezhi = new String[1];
                    hezhi[0] = String.valueOf(new Random().nextInt(27));
                    priBetNumbers.add(Arrays.asList(hezhi));
                    break;
                case HOU_SAN_ZU_SAN:
                case ZHONG_SAN_ZU_SAN:
                case QIAN_SAN_ZU_SAN:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    break;
                case HOU_SAN_HUN_HE_ZU_XUAN:
                case ZHONG_SAN_HUN_HE_ZU_XUAN:
                case QIAN_SAN_HUN_HE_ZU_XUAN:

                    //TODO 去除豹子
                    return getRandomList(9, 1, 3);
                case HOU_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_LIU:
                case QIAN_SAN_ZU_LIU:
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    break;
                case HOU_SAN_ZU_XUAN_HE_ZHI:
                case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                case QIAN_SAN_ZU_XUAN_HE_ZHI:
                    String[] zuxuanhezhi = new String[1];
                    zuxuanhezhi[0] = String.valueOf(new Random().nextInt(25) + 1);

                    priBetNumbers.add(Arrays.asList(zuxuanhezhi));
                    break;

                // 二星
                case HOU_ER_ZHI_XUAN_FU_SHI:
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                    return getRandomList(9, 2, 1);
                case HOU_ER_ZU_XUAN_DAN_SHI:
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                case HOU_ER_ZHI_XUAN_DAN_SHI:
                case QIAN_ER_ZHI_XUAN_DAN_SHI:

                    return getRandomList(9, 1, 2);

                case HOU_ER_ZU_XUAN_HE_ZHI:
                case QIAN_ER_ZU_XUAN_HE_ZHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                case QIAN_ER_ZHI_XUAN_HE_ZHI:

                    String[] erXingZuxuanhezhi = new String[1];
                    erXingZuxuanhezhi[0] = String.valueOf(new Random().nextInt(17) + 1);

                    priBetNumbers.add(Arrays.asList(erXingZuxuanhezhi));
                    break;

                case HOU_ER_ZU_XUAN_FU_SHI:
                case QIAN_ER_ZU_XUAN_FU_SHI:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    break;
                //一星
                case YI_XING_DING_WEI_DAN:
                    return getRandomList(9, 5, 1);

                // 不定胆
                case HOU_SAN_ER_MA:
                case QIAN_SAN_ER_MA:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    break;
                case HOU_SAN_YI_MA:
                case QIAN_SAN_YI_MA:
                    priBetNumbers.add(Arrays.asList(oneNumber));
                    break;

                // 大小单双
                case HOU_ER_DA_XIAO_DAN_SHUANG:
                case QIAN_ER_DA_XIAO_DAN_SHUANG:
                    List<String> daxiaoList = new ArrayList<>();
                    daxiaoList.add("大");
                    daxiaoList.add("双");
                    daxiaoList.add("小");
                    daxiaoList.add("单");
                    Collections.shuffle(daxiaoList);
                    priBetNumber0.add(daxiaoList.get(0));
                    Collections.shuffle(daxiaoList);
                    priBetNumber1.add(daxiaoList.get(0));
                    priBetNumbers.add(priBetNumber0);
                    priBetNumbers.add(priBetNumber1);
                    break;

                case ZONG_HE_DA_XIAO_DAN_SHUANG:
                    List<String> zongheList = new ArrayList<>();
                    zongheList.add("大");
                    zongheList.add("双");
                    zongheList.add("小");
                    zongheList.add("单");
                    Collections.shuffle(zongheList);
                    priBetNumber0.add(zongheList.get(0));
                    priBetNumbers.add(priBetNumber0);
                    break;

                //趣味
                case SI_JI_FA_CAI:
                case SAN_XING_BAO_XI:
                case HAO_SHI_CHENG_SHUANG:
                case YI_FAN_FENG_SHUN:
                    priBetNumbers.add(Arrays.asList(oneNumber));
                    break;
            }
        }

        return priBetNumbers;
    }

    private List<List<String>> getShishicaiDoubleNumbers(Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();

        ShishicaiDoubleType shishicaiDoubleType = ShishicaiDoubleType.parse(playId);
        List<String> firstList = new ArrayList<>();
        if (shishicaiDoubleType != null) {
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            switch (shishicaiDoubleType) {

                case ZONG_HE_DA:
                case YI_QIU_DA:
                case ER_QIU_DA:
                case SAN_QIU_DA:
                case SI_QIU_DA:
                case WU_QIU_DA:
                    firstList.add("大");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_XIAO:
                case YI_QIU_XIAO:
                case ER_QIU_XIAO:
                case SAN_QIU_XIAO:
                case SI_QIU_XIAO:
                case WU_QIU_XIAO:
                    firstList.add("小");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_DAN:
                case YI_QIU_DAN:
                case ER_QIU_DAN:
                case SAN_QIU_DAN:
                case SI_QIU_DAN:
                case WU_QIU_DAN:
                    firstList.add("单");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_SHUANG:
                case YI_QIU_SHUANG:
                case ER_QIU_SHUANG:
                case SAN_QIU_SHUANG:
                case SI_QIU_SHUANG:
                case WU_QIU_SHUANG:
                    firstList.add("双");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_LONG:
                    firstList.add("龙");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_HU:
                    firstList.add("虎");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_HE:
                    firstList.add("和");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_0:
                case ER_QIU_DING_WEI_DAN_0:
                case SAN_QIU_DING_WEI_DAN_0:
                case SI_QIU_DING_WEI_DAN_0:
                case WU_QIU_DING_WEI_DAN_0:
                    firstList.add("0");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_1:
                    firstList.add("1");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_2:
                    firstList.add("2");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_3:
                    firstList.add("3");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_4:
                    firstList.add("4");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_5:
                    firstList.add("5");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_6:
                    firstList.add("6");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_7:
                    firstList.add("7");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_8:
                    firstList.add("8");
                    priBetNumbers.add(firstList);
                    break;

                case YI_QIU_DING_WEI_DAN_9:
                case ER_QIU_DING_WEI_DAN_9:
                case SAN_QIU_DING_WEI_DAN_9:
                case SI_QIU_DING_WEI_DAN_9:
                case WU_QIU_DING_WEI_DAN_9:
                    firstList.add("9");
                    priBetNumbers.add(firstList);
                    break;

                case QIAN_SAN_BAO_ZI:
                case ZHONG_SAN_BAO_ZI:
                case HOU_SAN_BAO_ZI:
                    firstList.add("豹子");
                    priBetNumbers.add(firstList);
                    break;

                case QIAN_SAN_SHUN_ZI:
                case ZHONG_SAN_SHUN_ZI:
                case HOU_SAN_SHUN_ZI:
                    firstList.add("顺子");
                    priBetNumbers.add(firstList);
                    break;

                case QIAN_SAN_DUI_ZI:
                case ZHONG_SAN_DUI_ZI:
                case HOU_SAN_DUI_ZI:
                    firstList.add("对子");
                    priBetNumbers.add(firstList);
                    break;

                case QIAN_SAN_BAN_SHUN:
                case ZHONG_SAN_BAN_SHUN:
                case HOU_SAN_BAN_SHUN:
                    firstList.add("半顺");
                    priBetNumbers.add(firstList);
                    break;

                case QIAN_SAN_ZA_LIU:
                case ZHONG_SAN_ZA_LIU:
                case HOU_SAN_ZA_LIU:
                    firstList.add("杂六");
                    priBetNumbers.add(firstList);
                    break;
            }
        }

        return priBetNumbers;
    }

    private List<List<String>> get11x5DoubleNumbers(Long playId) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 11; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (i < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(i);
            list.add(stringBuilder.toString());
        }
        Collections.shuffle(list);
        String[] oneNumber = {list.get(0)};
        Collections.shuffle(list);
        String[] twoNumber = {list.get(0), list.get(1)};
        Collections.shuffle(list);
        String[] threeNumber = {list.get(0), list.get(1), list.get(2)};
        Collections.shuffle(list);
        String[] fourNumber = {list.get(0), list.get(1), list.get(2), list.get(3)};
        Collections.shuffle(list);
        String[] fiveNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)};
        Collections.shuffle(list);
        String[] sixNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)};
        Collections.shuffle(list);
        String[] sevenNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6)};
        Collections.shuffle(list);
        String[] eightNumber = {list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5), list.get(6), list.get(7)};

        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> priBetNumber0 = new ArrayList<>();

        Lottery11x5DoubleType lottery11x5DoubleType = Lottery11x5DoubleType.parse(playId);
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        List<String> thirdList = new ArrayList<>();

        if (lottery11x5DoubleType != null) {
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            priBetNumber0.clear();
            switch (lottery11x5DoubleType) {
                case ZONG_HE_DA:
                case ZONG_HE_WEI_DA:
                case YI_QIU_DA:
                case ER_QIU_DA:
                case SAN_QIU_DA:
                case SI_QIU_DA:
                case WU_QIU_DA:
                    firstList.add("大");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_XIAO:
                case ZONG_HE_WEI_XIAO:
                case YI_QIU_XIAO:
                case ER_QIU_XIAO:
                case SAN_QIU_XIAO:
                case SI_QIU_XIAO:
                case WU_QIU_XIAO:
                    firstList.add("小");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_DAN:
                case YI_QIU_DAN:
                case ER_QIU_DAN:
                case SAN_QIU_DAN:
                case SI_QIU_DAN:
                case WU_QIU_DAN:
                    firstList.add("单");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_SHUANG:
                case YI_QIU_SHUANG:
                case ER_QIU_SHUANG:
                case SAN_QIU_SHUANG:
                case SI_QIU_SHUANG:
                case WU_QIU_SHUANG:
                    firstList.add("双");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_LONG:
                    firstList.add("龙");
                    priBetNumbers.add(firstList);
                    break;

                case ZONG_HE_HU:
                    firstList.add("虎");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_1:
                case YI_QIU_DING_WEI_DAN_1:
                case ER_QIU_DING_WEI_DAN_1:
                case SAN_QIU_DING_WEI_DAN_1:
                case SI_QIU_DING_WEI_DAN_1:
                case WU_QIU_DING_WEI_DAN_1:
                    firstList.add("01");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_2:
                case YI_QIU_DING_WEI_DAN_2:
                case ER_QIU_DING_WEI_DAN_2:
                case SAN_QIU_DING_WEI_DAN_2:
                case SI_QIU_DING_WEI_DAN_2:
                case WU_QIU_DING_WEI_DAN_2:
                    firstList.add("02");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_3:
                case YI_QIU_DING_WEI_DAN_3:
                case ER_QIU_DING_WEI_DAN_3:
                case SAN_QIU_DING_WEI_DAN_3:
                case SI_QIU_DING_WEI_DAN_3:
                case WU_QIU_DING_WEI_DAN_3:
                    firstList.add("03");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_4:
                case YI_QIU_DING_WEI_DAN_4:
                case ER_QIU_DING_WEI_DAN_4:
                case SAN_QIU_DING_WEI_DAN_4:
                case SI_QIU_DING_WEI_DAN_4:
                case WU_QIU_DING_WEI_DAN_4:
                    firstList.add("04");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_5:
                case YI_QIU_DING_WEI_DAN_5:
                case ER_QIU_DING_WEI_DAN_5:
                case SAN_QIU_DING_WEI_DAN_5:
                case SI_QIU_DING_WEI_DAN_5:
                case WU_QIU_DING_WEI_DAN_5:
                    firstList.add("05");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_6:
                case YI_QIU_DING_WEI_DAN_6:
                case ER_QIU_DING_WEI_DAN_6:
                case SAN_QIU_DING_WEI_DAN_6:
                case SI_QIU_DING_WEI_DAN_6:
                case WU_QIU_DING_WEI_DAN_6:
                    firstList.add("06");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_7:
                case YI_QIU_DING_WEI_DAN_7:
                case ER_QIU_DING_WEI_DAN_7:
                case SAN_QIU_DING_WEI_DAN_7:
                case SI_QIU_DING_WEI_DAN_7:
                case WU_QIU_DING_WEI_DAN_7:
                    firstList.add("07");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_8:
                case YI_QIU_DING_WEI_DAN_8:
                case ER_QIU_DING_WEI_DAN_8:
                case SAN_QIU_DING_WEI_DAN_8:
                case SI_QIU_DING_WEI_DAN_8:
                case WU_QIU_DING_WEI_DAN_8:
                    firstList.add("08");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_9:
                case YI_QIU_DING_WEI_DAN_9:
                case ER_QIU_DING_WEI_DAN_9:
                case SAN_QIU_DING_WEI_DAN_9:
                case SI_QIU_DING_WEI_DAN_9:
                case WU_QIU_DING_WEI_DAN_9:
                    firstList.add("09");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_10:
                case YI_QIU_DING_WEI_DAN_10:
                case ER_QIU_DING_WEI_DAN_10:
                case SAN_QIU_DING_WEI_DAN_10:
                case SI_QIU_DING_WEI_DAN_10:
                case WU_QIU_DING_WEI_DAN_10:
                    firstList.add("10");
                    priBetNumbers.add(firstList);
                    break;

                case YI_ZHONG_YI_11:
                case YI_QIU_DING_WEI_DAN_11:
                case ER_QIU_DING_WEI_DAN_11:
                case SAN_QIU_DING_WEI_DAN_11:
                case SI_QIU_DING_WEI_DAN_11:
                case WU_QIU_DING_WEI_DAN_11:
                    firstList.add("11");
                    priBetNumbers.add(firstList);
                    break;

                case LIAN_MA_ER_ZHONG_ER:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    break;

                case LIAN_MA_SAN_ZHONG_SAN:
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    break;

                case LIAN_MA_SI_ZHONG_SI:
                    priBetNumbers.add(Arrays.asList(fourNumber));
                    break;

                case LIAN_MA_WU_ZHONG_WU:
                    priBetNumbers.add(Arrays.asList(fiveNumber));
                    break;

                case LIAN_MA_LIU_ZHONG_WU:
                    priBetNumbers.add(Arrays.asList(sixNumber));
                    break;

                case LIAN_MA_QI_ZHONG_WU:
                    priBetNumbers.add(Arrays.asList(sevenNumber));
                    break;

                case LIAN_MA_BA_ZHONG_WU:
                    priBetNumbers.add(Arrays.asList(eightNumber));
                    break;

                case QIAN_ER_ZU_XUAN:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    break;

                case QIAN_SAN_ZU_XUAN:
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    break;

                case QIAN_ER_ZHI_XUAN:
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    break;

                case QIAN_SAN_ZHI_XUAN:
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    break;
            }
        }
        return priBetNumbers;
    }

    private List<List<String>> getKuai3DoubleNumbers(Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> priBetNumber0 = new ArrayList<>();

        LotteryKuai3DoubleType lotteryKuai3DoubleType = LotteryKuai3DoubleType.parse(playId);
        List<String> firstList = new ArrayList<>();

        if (lotteryKuai3DoubleType != null) {
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            priBetNumber0.clear();
            switch (lotteryKuai3DoubleType) {
                case SAN_JUN_大:
                    firstList.add("大");
                    priBetNumbers.add(firstList);
                    break;

                case SAN_JUN_小:
                    firstList.add("小");
                    priBetNumbers.add(firstList);
                    break;

                case SAN_JUN_1:
                case WEI_SHAI_1:
                case DUAN_PAI_1:
                    firstList.add("1");
                    priBetNumbers.add(firstList);
                    break;

                case SAN_JUN_2:
                case WEI_SHAI_2:
                case DUAN_PAI_2:
                    firstList.add("2");
                    priBetNumbers.add(firstList);
                    break;

                case SAN_JUN_3:
                case WEI_SHAI_3:
                case DUAN_PAI_3:
                    firstList.add("3");
                    priBetNumbers.add(firstList);
                    break;

                case SAN_JUN_4:
                case WEI_SHAI_4:
                case DUAN_PAI_4:
                case DIAN_SHU_HE_4:
                    firstList.add("4");
                    priBetNumbers.add(firstList);
                    break;

                case SAN_JUN_5:
                case DUAN_PAI_5:
                case WEI_SHAI_5:
                case DIAN_SHU_HE_5:
                    firstList.add("5");
                    priBetNumbers.add(firstList);
                    break;

                case SAN_JUN_6:
                case DUAN_PAI_6:
                case WEI_SHAI_6:
                case DIAN_SHU_HE_6:
                    firstList.add("6");
                    priBetNumbers.add(firstList);
                    break;

                case DIAN_SHU_HE_7:
                    firstList.add("7");
                    priBetNumbers.add(firstList);
                    break;

                case DIAN_SHU_HE_8:
                    firstList.add("8");
                    priBetNumbers.add(firstList);
                    break;

                case DIAN_SHU_HE_9:
                    firstList.add("9");
                    priBetNumbers.add(firstList);
                    break;

                case DIAN_SHU_HE_10:
                    firstList.add("10");
                    priBetNumbers.add(firstList);
                    break;

                case DIAN_SHU_HE_11:
                    firstList.add("11");
                    priBetNumbers.add(firstList);
                    break;

                case DIAN_SHU_HE_12:
                    firstList.add("12");
                    priBetNumbers.add(firstList);
                    break;
                case DIAN_SHU_HE_13:
                    firstList.add("13");
                    priBetNumbers.add(firstList);
                    break;
                case DIAN_SHU_HE_14:
                    firstList.add("14");
                    priBetNumbers.add(firstList);
                    break;
                case DIAN_SHU_HE_15:
                    firstList.add("15");
                    priBetNumbers.add(firstList);
                    break;
                case DIAN_SHU_HE_16:
                    firstList.add("16");
                    priBetNumbers.add(firstList);
                    break;
                case DIAN_SHU_HE_17:
                    firstList.add("17");
                    priBetNumbers.add(firstList);
                    break;

                case QUAN_SHAI:
                    firstList.add("全");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_12:
                    firstList.add("1");
                    firstList.add("2");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_13:
                    firstList.add("1");
                    firstList.add("3");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_14:
                    firstList.add("1");
                    firstList.add("4");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_15:
                    firstList.add("1");
                    firstList.add("5");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_16:
                    firstList.add("1");
                    firstList.add("6");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_23:
                    firstList.add("2");
                    firstList.add("3");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_24:
                    firstList.add("2");
                    firstList.add("4");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_25:
                    firstList.add("2");
                    firstList.add("5");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_26:
                    firstList.add("2");
                    firstList.add("6");
                    priBetNumbers.add(firstList);
                    break;

                case CHANG_PAI_34:
                    firstList.add("3");
                    firstList.add("4");
                    priBetNumbers.add(firstList);
                    break;
                case CHANG_PAI_35:
                    firstList.add("3");
                    firstList.add("5");
                    priBetNumbers.add(firstList);
                    break;
                case CHANG_PAI_36:
                    firstList.add("3");
                    firstList.add("6");
                    priBetNumbers.add(firstList);
                    break;
                case CHANG_PAI_45:
                    firstList.add("4");
                    firstList.add("5");
                    priBetNumbers.add(firstList);
                    break;
                case CHANG_PAI_46:
                    firstList.add("4");
                    firstList.add("6");
                    priBetNumbers.add(firstList);
                    break;
                case CHANG_PAI_56:
                    firstList.add("5");
                    firstList.add("6");
                    priBetNumbers.add(firstList);
                    break;
            }
        }
        return priBetNumbers;
    }

    private List<List<String>> getPK10DoubleNumbers(Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> priBetNumber0 = new ArrayList<>();

        LotteryPK10DoubleType lotteryPK10DoubleType = LotteryPK10DoubleType.parse(playId);
        List<String> firstList = new ArrayList<>();

        if (lotteryPK10DoubleType != null) {
            for (List<String> lists : priBetNumbers) {
                lists.clear();
            }
            priBetNumber0.clear();
            switch (lotteryPK10DoubleType) {
                case GUAN_YA_HE_DA:
                case DAN_HAO_GUAN_DA:
                case DAN_HAO_YA_DA:
                case DAN_HAO_THIRD_DA:
                case DAN_HAO_FORTH_DA:
                case DAN_HAO_FIFTH_DA:
                case DAN_HAO_SIXTH_DA:
                case DAN_HAO_SEVENTH_DA:
                case DAN_HAO_EIGHTH_DA:
                case DAN_HAO_NINTH_DA:
                case DAN_HAO_TENTH_DA:
                    firstList.add("大");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_XIAO:
                case DAN_HAO_GUAN_XIAO:
                case DAN_HAO_YA_XIAO:
                case DAN_HAO_THIRD_XIAO:
                case DAN_HAO_FORTH_XIAO:
                case DAN_HAO_FIFTH_XIAO:
                case DAN_HAO_SIXTH_XIAO:
                case DAN_HAO_SEVENTH_XIAO:
                case DAN_HAO_EIGHTH_XIAO:
                case DAN_HAO_NINTH_XIAO:
                case DAN_HAO_TENTH_XIAO:
                    firstList.add("小");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_DAN:
                case DAN_HAO_GUAN_DAN:
                case DAN_HAO_YA_DAN:
                case DAN_HAO_THIRD_DAN:
                case DAN_HAO_FORTH_DAN:
                case DAN_HAO_FIFTH_DAN:
                case DAN_HAO_SIXTH_DAN:
                case DAN_HAO_SEVENTH_DAN:
                case DAN_HAO_EIGHTH_DAN:
                case DAN_HAO_NINTH_DAN:
                case DAN_HAO_TENTH_DAN:
                    firstList.add("单");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_SHUANG:
                case DAN_HAO_GUAN_SHUANG:
                case DAN_HAO_YA_SHUANG:
                case DAN_HAO_THIRD_SHUANG:
                case DAN_HAO_FORTH_SHUANG:
                case DAN_HAO_FIFTH_SHUANG:
                case DAN_HAO_SIXTH_SHUANG:
                case DAN_HAO_SEVENTH_SHUANG:
                case DAN_HAO_EIGHTH_SHUANG:
                case DAN_HAO_NINTH_SHUANG:
                case DAN_HAO_TENTH_SHUANG:
                    firstList.add("双");
                    priBetNumbers.add(firstList);
                    break;

                case DAN_HAO_GUAN_LONG:
                case DAN_HAO_YA_LONG:
                case DAN_HAO_THIRD_LONG:
                case DAN_HAO_FORTH_LONG:
                case DAN_HAO_FIFTH_LONG:
                    firstList.add("龙");
                    priBetNumbers.add(firstList);
                    break;

                case DAN_HAO_GUAN_HU:
                case DAN_HAO_YA_HU:
                case DAN_HAO_THIRD_HU:
                case DAN_HAO_FORTH_HU:
                case DAN_HAO_FIFTH_HU:

                    firstList.add("虎");
                    priBetNumbers.add(firstList);
                    break;

                case DAN_HAO_GUAN_1:
                case DAN_HAO_YA_1:
                case DAN_HAO_THIRD_1:
                case DAN_HAO_FORTH_1:
                case DAN_HAO_FIFTH_1:
                case DAN_HAO_SIXTH_1:
                case DAN_HAO_SEVENTH_1:
                case DAN_HAO_EIGHTH_1:
                case DAN_HAO_NINTH_1:
                case DAN_HAO_TENTH_1:
                    firstList.add("01");
                    priBetNumbers.add(firstList);
                    break;

                case DAN_HAO_GUAN_2:
                case DAN_HAO_YA_2:
                case DAN_HAO_THIRD_2:
                case DAN_HAO_FORTH_2:
                case DAN_HAO_FIFTH_2:
                case DAN_HAO_SIXTH_2:
                case DAN_HAO_SEVENTH_2:
                case DAN_HAO_EIGHTH_2:
                case DAN_HAO_NINTH_2:
                case DAN_HAO_TENTH_2:
                    firstList.add("02");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_3:
                case DAN_HAO_GUAN_3:
                case DAN_HAO_YA_3:
                case DAN_HAO_THIRD_3:
                case DAN_HAO_FORTH_3:
                case DAN_HAO_FIFTH_3:
                case DAN_HAO_SIXTH_3:
                case DAN_HAO_SEVENTH_3:
                case DAN_HAO_EIGHTH_3:
                case DAN_HAO_NINTH_3:
                case DAN_HAO_TENTH_3:
                    firstList.add("03");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_4:
                case DAN_HAO_GUAN_4:
                case DAN_HAO_YA_4:
                case DAN_HAO_THIRD_4:
                case DAN_HAO_FORTH_4:
                case DAN_HAO_FIFTH_4:
                case DAN_HAO_SIXTH_4:
                case DAN_HAO_SEVENTH_4:
                case DAN_HAO_EIGHTH_4:
                case DAN_HAO_NINTH_4:
                case DAN_HAO_TENTH_4:

                    firstList.add("04");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_5:
                case DAN_HAO_GUAN_5:
                case DAN_HAO_YA_5:
                case DAN_HAO_THIRD_5:
                case DAN_HAO_FORTH_5:
                case DAN_HAO_FIFTH_5:
                case DAN_HAO_SIXTH_5:
                case DAN_HAO_SEVENTH_5:
                case DAN_HAO_EIGHTH_5:
                case DAN_HAO_NINTH_5:
                case DAN_HAO_TENTH_5:
                    firstList.add("05");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_6:
                case DAN_HAO_GUAN_6:
                case DAN_HAO_YA_6:
                case DAN_HAO_THIRD_6:
                case DAN_HAO_FORTH_6:
                case DAN_HAO_FIFTH_6:
                case DAN_HAO_SIXTH_6:
                case DAN_HAO_SEVENTH_6:
                case DAN_HAO_EIGHTH_6:
                case DAN_HAO_NINTH_6:
                case DAN_HAO_TENTH_6:
                    firstList.add("06");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_7:
                case DAN_HAO_GUAN_7:
                case DAN_HAO_YA_7:
                case DAN_HAO_THIRD_7:
                case DAN_HAO_FORTH_7:
                case DAN_HAO_FIFTH_7:
                case DAN_HAO_SIXTH_7:
                case DAN_HAO_SEVENTH_7:
                case DAN_HAO_EIGHTH_7:
                case DAN_HAO_NINTH_7:
                case DAN_HAO_TENTH_7:
                    firstList.add("07");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_8:
                case DAN_HAO_GUAN_8:
                case DAN_HAO_YA_8:
                case DAN_HAO_THIRD_8:
                case DAN_HAO_FORTH_8:
                case DAN_HAO_FIFTH_8:
                case DAN_HAO_SIXTH_8:
                case DAN_HAO_SEVENTH_8:
                case DAN_HAO_EIGHTH_8:
                case DAN_HAO_NINTH_8:
                case DAN_HAO_TENTH_8:
                    firstList.add("08");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_9:
                case DAN_HAO_GUAN_9:
                case DAN_HAO_YA_9:
                case DAN_HAO_THIRD_9:
                case DAN_HAO_FORTH_9:
                case DAN_HAO_FIFTH_9:
                case DAN_HAO_SIXTH_9:
                case DAN_HAO_SEVENTH_9:
                case DAN_HAO_EIGHTH_9:
                case DAN_HAO_NINTH_9:
                case DAN_HAO_TENTH_9:
                    firstList.add("09");
                    priBetNumbers.add(firstList);
                    break;

                case GUAN_YA_HE_10:
                case DAN_HAO_GUAN_10:
                case DAN_HAO_YA_10:
                case DAN_HAO_THIRD_10:
                case DAN_HAO_FORTH_10:
                case DAN_HAO_FIFTH_10:
                case DAN_HAO_SIXTH_10:
                case DAN_HAO_SEVENTH_10:
                case DAN_HAO_EIGHTH_10:
                case DAN_HAO_NINTH_10:
                case DAN_HAO_TENTH_10:
                    firstList.add("10");
                    priBetNumbers.add(firstList);
                    break;


                case GUAN_YA_HE_19:
                    firstList.add("19");
                    priBetNumbers.add(firstList);
                    break;
                case GUAN_YA_HE_18:
                    firstList.add("18");
                    priBetNumbers.add(firstList);
                    break;
                case GUAN_YA_HE_17:
                    firstList.add("17");
                    priBetNumbers.add(firstList);
                    break;
                case GUAN_YA_HE_16:
                    firstList.add("16");
                    priBetNumbers.add(firstList);
                    break;
                case GUAN_YA_HE_15:
                    firstList.add("15");
                    priBetNumbers.add(firstList);
                    break;
                case GUAN_YA_HE_14:
                    firstList.add("14");
                    priBetNumbers.add(firstList);
                    break;
                case GUAN_YA_HE_13:
                    firstList.add("13");
                    priBetNumbers.add(firstList);
                    break;
                case GUAN_YA_HE_12:
                    firstList.add("12");
                    priBetNumbers.add(firstList);
                    break;
                case GUAN_YA_HE_11:
                    firstList.add("11");
                    priBetNumbers.add(firstList);
                    break;

            }
        }
        return priBetNumbers;

    }

    private List<List<String>> getMark6DoubleNumbers(Long playId) {

        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> numList = new ArrayList<>();
        String big = "大";
        String small = "小";
        String single = "单";
        String shuang = "双";
        String hong = "红";
        String lan = "蓝";
        String lv = "绿";

        // 尾数
        List<String> weishuList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(i));
            weishuList.add(stringBuilder.toString());
        }
        Collections.shuffle(weishuList);
        List<String> oneWeishu = new ArrayList<>();
        oneWeishu.add(weishuList.get(0));
        Collections.shuffle(weishuList);
        List<String> twoWeishu = new ArrayList<>();
        twoWeishu.add(weishuList.get(0));
        twoWeishu.add(weishuList.get(1));
        Collections.shuffle(weishuList);
        List<String> threeWeishu = new ArrayList<>();
        threeWeishu.add(weishuList.get(0));
        threeWeishu.add(weishuList.get(1));
        threeWeishu.add(weishuList.get(2));
        Collections.shuffle(weishuList);
        List<String> fourWeishu = new ArrayList<>();
        fourWeishu.add(weishuList.get(0));
        fourWeishu.add(weishuList.get(1));
        fourWeishu.add(weishuList.get(2));
        fourWeishu.add(weishuList.get(3));
        Collections.shuffle(weishuList);
        List<String> fiveWeishu = new ArrayList<>();
        fiveWeishu.add(weishuList.get(0));
        fiveWeishu.add(weishuList.get(1));
        fiveWeishu.add(weishuList.get(2));
        fiveWeishu.add(weishuList.get(3));
        fiveWeishu.add(weishuList.get(4));

        // 正码
        List<String> list = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            if (i < 10) {
                stringBuilder.append("0");
            }
            stringBuilder.append(String.valueOf(i));
            list.add(stringBuilder.toString());
        }
        Collections.shuffle(list);
        List<String> twoNumber = new ArrayList<>();
        twoNumber.add(list.get(0));
        twoNumber.add(list.get(1));
        Collections.shuffle(list);
        List<String> threeNumber = new ArrayList<>();
        threeNumber.add(list.get(0));
        threeNumber.add(list.get(1));
        threeNumber.add(list.get(2));
        Collections.shuffle(list);
        List<String> fourNumber = new ArrayList<>();
        fourNumber.add(list.get(0));
        fourNumber.add(list.get(1));
        fourNumber.add(list.get(2));
        fourNumber.add(list.get(3));

        Collections.shuffle(list);
        List<String> fiveNumber = new ArrayList<>();
        fiveNumber.add(list.get(0));
        fiveNumber.add(list.get(1));
        fiveNumber.add(list.get(2));
        fiveNumber.add(list.get(3));
        fiveNumber.add(list.get(4));
        Collections.shuffle(list);
        List<String> sixNumber = new ArrayList<>();
        sixNumber.add(list.get(0));
        sixNumber.add(list.get(1));
        sixNumber.add(list.get(2));
        sixNumber.add(list.get(3));
        sixNumber.add(list.get(4));
        sixNumber.add(list.get(5));
        Collections.shuffle(list);
        List<String> sevenNumber = new ArrayList<>();
        sevenNumber.add(list.get(0));
        sevenNumber.add(list.get(1));
        sevenNumber.add(list.get(2));
        sevenNumber.add(list.get(3));
        sevenNumber.add(list.get(4));
        sevenNumber.add(list.get(5));
        sevenNumber.add(list.get(6));
        Collections.shuffle(list);
        List<String> eightNumber = new ArrayList<>();
        eightNumber.add(list.get(0));
        eightNumber.add(list.get(1));
        eightNumber.add(list.get(2));
        eightNumber.add(list.get(3));
        eightNumber.add(list.get(4));
        eightNumber.add(list.get(5));
        eightNumber.add(list.get(6));
        eightNumber.add(list.get(7));
        Collections.shuffle(list);

        List<String> nineNumber = new ArrayList<>();
        nineNumber.add(list.get(0));
        nineNumber.add(list.get(1));
        nineNumber.add(list.get(2));
        nineNumber.add(list.get(3));
        nineNumber.add(list.get(4));
        nineNumber.add(list.get(5));
        nineNumber.add(list.get(6));
        nineNumber.add(list.get(7));
        nineNumber.add(list.get(8));
        Collections.shuffle(list);

        List<String> tenNumber = new ArrayList<>();
        tenNumber.add(list.get(0));
        tenNumber.add(list.get(1));
        tenNumber.add(list.get(2));
        tenNumber.add(list.get(3));
        tenNumber.add(list.get(4));
        tenNumber.add(list.get(5));
        tenNumber.add(list.get(6));
        tenNumber.add(list.get(7));
        tenNumber.add(list.get(8));
        tenNumber.add(list.get(9));
        Collections.shuffle(list);

        List<String> elevenNumber = new ArrayList<>();
        elevenNumber.add(list.get(0));
        elevenNumber.add(list.get(1));
        elevenNumber.add(list.get(2));
        elevenNumber.add(list.get(3));
        elevenNumber.add(list.get(4));
        elevenNumber.add(list.get(5));
        elevenNumber.add(list.get(6));
        elevenNumber.add(list.get(7));
        elevenNumber.add(list.get(8));
        elevenNumber.add(list.get(9));
        elevenNumber.add(list.get(10));
        Collections.shuffle(list);

        List<String> twelveNumber = new ArrayList<>();
        twelveNumber.add(list.get(0));
        twelveNumber.add(list.get(1));
        twelveNumber.add(list.get(2));
        twelveNumber.add(list.get(3));
        twelveNumber.add(list.get(4));
        twelveNumber.add(list.get(5));
        twelveNumber.add(list.get(6));
        twelveNumber.add(list.get(7));
        twelveNumber.add(list.get(8));
        twelveNumber.add(list.get(9));
        twelveNumber.add(list.get(10));
        twelveNumber.add(list.get(11));
        Collections.shuffle(list);

        //生肖
        List<String> shengxiaoList = new ArrayList<>();
        shengxiaoList.add("鼠");
        shengxiaoList.add("牛");
        shengxiaoList.add("虎");
        shengxiaoList.add("兔");
        shengxiaoList.add("龙");
        shengxiaoList.add("蛇");
        shengxiaoList.add("马");
        shengxiaoList.add("羊");
        shengxiaoList.add("猴");
        shengxiaoList.add("鸡");
        shengxiaoList.add("狗");
        shengxiaoList.add("猪");
        Collections.shuffle(list);

        List<String> twoXiao = new ArrayList<>();
        twoXiao.add(shengxiaoList.get(0));
        twoXiao.add(shengxiaoList.get(1));
        Collections.shuffle(shengxiaoList);
        List<String> threeXiao = new ArrayList<>();
        threeXiao.add(shengxiaoList.get(0));
        threeXiao.add(shengxiaoList.get(1));
        threeXiao.add(shengxiaoList.get(2));
        Collections.shuffle(shengxiaoList);
        List<String> fourXiao = new ArrayList<>();
        fourXiao.add(shengxiaoList.get(0));
        fourXiao.add(shengxiaoList.get(1));
        fourXiao.add(shengxiaoList.get(2));
        fourXiao.add(shengxiaoList.get(3));
        Collections.shuffle(shengxiaoList);
        List<String> fiveXiao = new ArrayList<>();
        fiveXiao.add(shengxiaoList.get(0));
        fiveXiao.add(shengxiaoList.get(1));
        fiveXiao.add(shengxiaoList.get(2));
        fiveXiao.add(shengxiaoList.get(3));
        fiveXiao.add(shengxiaoList.get(4));
        Collections.shuffle(shengxiaoList);

        List<String> sixXiao = new ArrayList<>();
        sixXiao.add(shengxiaoList.get(0));
        sixXiao.add(shengxiaoList.get(1));
        sixXiao.add(shengxiaoList.get(2));
        sixXiao.add(shengxiaoList.get(3));
        sixXiao.add(shengxiaoList.get(4));
        sixXiao.add(shengxiaoList.get(5));
        Collections.shuffle(shengxiaoList);

        List<String> sevenXiao = new ArrayList<>();
        sevenXiao.add(shengxiaoList.get(0));
        sevenXiao.add(shengxiaoList.get(1));
        sevenXiao.add(shengxiaoList.get(2));
        sevenXiao.add(shengxiaoList.get(3));
        sevenXiao.add(shengxiaoList.get(4));
        sevenXiao.add(shengxiaoList.get(5));
        sevenXiao.add(shengxiaoList.get(6));
        Collections.shuffle(shengxiaoList);

        List<String> eightXiao = new ArrayList<>();
        eightXiao.add(shengxiaoList.get(0));
        eightXiao.add(shengxiaoList.get(1));
        eightXiao.add(shengxiaoList.get(2));
        eightXiao.add(shengxiaoList.get(3));
        eightXiao.add(shengxiaoList.get(4));
        eightXiao.add(shengxiaoList.get(5));
        eightXiao.add(shengxiaoList.get(6));
        eightXiao.add(shengxiaoList.get(7));
        Collections.shuffle(shengxiaoList);

        List<String> nineXiao = new ArrayList<>();
        nineXiao.add(shengxiaoList.get(0));
        nineXiao.add(shengxiaoList.get(1));
        nineXiao.add(shengxiaoList.get(2));
        nineXiao.add(shengxiaoList.get(3));
        nineXiao.add(shengxiaoList.get(4));
        nineXiao.add(shengxiaoList.get(5));
        nineXiao.add(shengxiaoList.get(6));
        nineXiao.add(shengxiaoList.get(7));
        nineXiao.add(shengxiaoList.get(8));
        Collections.shuffle(shengxiaoList);

        List<String> tenXiao = new ArrayList<>();
        tenXiao.add(shengxiaoList.get(0));
        tenXiao.add(shengxiaoList.get(1));
        tenXiao.add(shengxiaoList.get(2));
        tenXiao.add(shengxiaoList.get(3));
        tenXiao.add(shengxiaoList.get(4));
        tenXiao.add(shengxiaoList.get(5));
        tenXiao.add(shengxiaoList.get(6));
        tenXiao.add(shengxiaoList.get(7));
        tenXiao.add(shengxiaoList.get(8));
        tenXiao.add(shengxiaoList.get(9));
        Collections.shuffle(shengxiaoList);


        List<String> elevenXiao = new ArrayList<>();
        elevenXiao.add(shengxiaoList.get(0));
        elevenXiao.add(shengxiaoList.get(1));
        elevenXiao.add(shengxiaoList.get(2));
        elevenXiao.add(shengxiaoList.get(3));
        elevenXiao.add(shengxiaoList.get(4));
        elevenXiao.add(shengxiaoList.get(5));
        elevenXiao.add(shengxiaoList.get(6));
        elevenXiao.add(shengxiaoList.get(7));
        elevenXiao.add(shengxiaoList.get(8));
        elevenXiao.add(shengxiaoList.get(9));
        elevenXiao.add(shengxiaoList.get(10));
        Collections.shuffle(shengxiaoList);

        LotteryMark6DoubleType lotteryMark6DoubleType = LotteryMark6DoubleType.parse(playId);
        if (lotteryMark6DoubleType == null) {
            return priBetNumbers;
        }
        switch (lotteryMark6DoubleType) {

            case TE_MA_A_1:
            case TE_MA_B_1:
            case ZHENG_MA_1:
            case ZHENG_YI_TE_1:
            case ZHENG_ER_TE_1:
            case ZHENG_SAN_TE_1:
            case ZHENG_SI_TE_1:
            case ZHENG_WU_TE_1:
            case ZHENG_LIU_TE_1:

                numList.add("01");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_2:
            case TE_MA_B_2:
            case ZHENG_MA_2:
            case ZHENG_YI_TE_2:
            case ZHENG_ER_TE_2:
            case ZHENG_SAN_TE_2:
            case ZHENG_SI_TE_2:
            case ZHENG_WU_TE_2:
            case ZHENG_LIU_TE_2:
                numList.add("02");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_3:
            case TE_MA_B_3:
            case ZHENG_MA_3:
            case ZHENG_YI_TE_3:
            case ZHENG_ER_TE_3:
            case ZHENG_SAN_TE_3:
            case ZHENG_SI_TE_3:
            case ZHENG_WU_TE_3:
            case ZHENG_LIU_TE_3:
                numList.add("03");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_4:
            case TE_MA_B_4:
            case ZHENG_MA_4:
            case ZHENG_YI_TE_4:
            case ZHENG_ER_TE_4:
            case ZHENG_SAN_TE_4:
            case ZHENG_SI_TE_4:
            case ZHENG_WU_TE_4:
            case ZHENG_LIU_TE_4:
                numList.add("04");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_5:
            case TE_MA_B_5:
            case ZHENG_MA_5:
            case ZHENG_YI_TE_5:
            case ZHENG_ER_TE_5:
            case ZHENG_SAN_TE_5:
            case ZHENG_SI_TE_5:
            case ZHENG_WU_TE_5:
            case ZHENG_LIU_TE_5:

                numList.add("05");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_6:
            case TE_MA_B_6:
            case ZHENG_MA_6:
            case ZHENG_YI_TE_6:
            case ZHENG_ER_TE_6:
            case ZHENG_SAN_TE_6:
            case ZHENG_SI_TE_6:
            case ZHENG_WU_TE_6:
            case ZHENG_LIU_TE_6:

                numList.add("06");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_7:
            case TE_MA_B_7:
            case ZHENG_MA_7:
            case ZHENG_YI_TE_7:
            case ZHENG_ER_TE_7:
            case ZHENG_SAN_TE_7:
            case ZHENG_SI_TE_7:
            case ZHENG_WU_TE_7:
            case ZHENG_LIU_TE_7:

                numList.add("07");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_8:
            case TE_MA_B_8:
            case ZHENG_MA_8:
            case ZHENG_YI_TE_8:
            case ZHENG_ER_TE_8:
            case ZHENG_SAN_TE_8:
            case ZHENG_SI_TE_8:
            case ZHENG_WU_TE_8:
            case ZHENG_LIU_TE_8:

                numList.add("08");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_9:
            case TE_MA_B_9:
            case ZHENG_MA_9:
            case ZHENG_YI_TE_9:
            case ZHENG_ER_TE_9:
            case ZHENG_SAN_TE_9:
            case ZHENG_SI_TE_9:
            case ZHENG_WU_TE_9:
            case ZHENG_LIU_TE_9:

                numList.add("09");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_10:
            case TE_MA_B_10:
            case ZHENG_MA_10:
            case ZHENG_YI_TE_10:
            case ZHENG_ER_TE_10:
            case ZHENG_SAN_TE_10:
            case ZHENG_SI_TE_10:
            case ZHENG_WU_TE_10:
            case ZHENG_LIU_TE_10:
                numList.add("10");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_11:
            case TE_MA_B_11:
            case ZHENG_MA_11:
            case ZHENG_YI_TE_11:
            case ZHENG_ER_TE_11:
            case ZHENG_SAN_TE_11:
            case ZHENG_SI_TE_11:
            case ZHENG_WU_TE_11:
            case ZHENG_LIU_TE_11:
                numList.add("11");
                priBetNumbers.add(numList);
                break;
            case TE_MA_A_12:
            case TE_MA_B_12:
            case ZHENG_MA_12:
            case ZHENG_YI_TE_12:
            case ZHENG_ER_TE_12:
            case ZHENG_SAN_TE_12:
            case ZHENG_SI_TE_12:
            case ZHENG_WU_TE_12:
            case ZHENG_LIU_TE_12:

                numList.add("12");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_13:
            case TE_MA_B_13:
            case ZHENG_MA_13:
            case ZHENG_YI_TE_13:
            case ZHENG_ER_TE_13:
            case ZHENG_SAN_TE_13:
            case ZHENG_SI_TE_13:
            case ZHENG_WU_TE_13:
            case ZHENG_LIU_TE_13:

                numList.add("13");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_14:
            case TE_MA_B_14:
            case ZHENG_MA_14:
            case ZHENG_YI_TE_14:
            case ZHENG_ER_TE_14:
            case ZHENG_SAN_TE_14:
            case ZHENG_SI_TE_14:
            case ZHENG_WU_TE_14:
            case ZHENG_LIU_TE_14:

                numList.add("14");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_15:
            case TE_MA_B_15:
            case ZHENG_MA_15:
            case ZHENG_YI_TE_15:
            case ZHENG_ER_TE_15:
            case ZHENG_SAN_TE_15:
            case ZHENG_SI_TE_15:
            case ZHENG_WU_TE_15:
            case ZHENG_LIU_TE_15:

                numList.add("15");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_16:
            case TE_MA_B_16:
            case ZHENG_MA_16:
            case ZHENG_YI_TE_16:
            case ZHENG_ER_TE_16:
            case ZHENG_SAN_TE_16:
            case ZHENG_SI_TE_16:
            case ZHENG_WU_TE_16:
            case ZHENG_LIU_TE_16:

                numList.add("16");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_17:
            case TE_MA_B_17:
            case ZHENG_MA_17:
            case ZHENG_YI_TE_17:
            case ZHENG_ER_TE_17:
            case ZHENG_SAN_TE_17:
            case ZHENG_SI_TE_17:
            case ZHENG_WU_TE_17:
            case ZHENG_LIU_TE_17:

                numList.add("17");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_18:
            case TE_MA_B_18:
            case ZHENG_MA_18:
            case ZHENG_YI_TE_18:
            case ZHENG_ER_TE_18:
            case ZHENG_SAN_TE_18:
            case ZHENG_SI_TE_18:
            case ZHENG_WU_TE_18:
            case ZHENG_LIU_TE_18:

                numList.add("18");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_19:
            case TE_MA_B_19:
            case ZHENG_MA_19:
            case ZHENG_YI_TE_19:
            case ZHENG_ER_TE_19:
            case ZHENG_SAN_TE_19:
            case ZHENG_SI_TE_19:
            case ZHENG_WU_TE_19:
            case ZHENG_LIU_TE_19:

                numList.add("19");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_20:
            case TE_MA_B_20:
            case ZHENG_MA_20:
            case ZHENG_YI_TE_20:
            case ZHENG_ER_TE_20:
            case ZHENG_SAN_TE_20:
            case ZHENG_SI_TE_20:
            case ZHENG_WU_TE_20:
            case ZHENG_LIU_TE_20:

                numList.add("20");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_21:
            case TE_MA_B_21:
            case ZHENG_MA_21:
            case ZHENG_YI_TE_21:
            case ZHENG_ER_TE_21:
            case ZHENG_SAN_TE_21:
            case ZHENG_SI_TE_21:
            case ZHENG_WU_TE_21:
            case ZHENG_LIU_TE_21:

                numList.add("21");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_22:
            case TE_MA_B_22:
            case ZHENG_MA_22:
            case ZHENG_YI_TE_22:
            case ZHENG_ER_TE_22:
            case ZHENG_SAN_TE_22:
            case ZHENG_SI_TE_22:
            case ZHENG_WU_TE_22:
            case ZHENG_LIU_TE_22:

                numList.add("22");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_23:
            case TE_MA_B_23:
            case ZHENG_MA_23:
            case ZHENG_YI_TE_23:
            case ZHENG_ER_TE_23:
            case ZHENG_SAN_TE_23:
            case ZHENG_SI_TE_23:
            case ZHENG_WU_TE_23:
            case ZHENG_LIU_TE_23:

                numList.add("23");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_24:
            case TE_MA_B_24:
            case ZHENG_MA_24:
            case ZHENG_YI_TE_24:
            case ZHENG_ER_TE_24:
            case ZHENG_SAN_TE_24:
            case ZHENG_SI_TE_24:
            case ZHENG_WU_TE_24:
            case ZHENG_LIU_TE_24:

                numList.add("24");
                priBetNumbers.add(numList);

                break;

            case TE_MA_A_25:
            case TE_MA_B_25:
            case ZHENG_MA_25:
            case ZHENG_YI_TE_25:
            case ZHENG_ER_TE_25:
            case ZHENG_SAN_TE_25:
            case ZHENG_SI_TE_25:
            case ZHENG_WU_TE_25:
            case ZHENG_LIU_TE_25:

                numList.add("25");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_26:
            case TE_MA_B_26:
            case ZHENG_MA_26:
            case ZHENG_YI_TE_26:
            case ZHENG_ER_TE_26:
            case ZHENG_SAN_TE_26:
            case ZHENG_SI_TE_26:
            case ZHENG_WU_TE_26:
            case ZHENG_LIU_TE_26:

                numList.add("26");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_27:
            case TE_MA_B_27:
            case ZHENG_MA_27:
            case ZHENG_YI_TE_27:
            case ZHENG_ER_TE_27:
            case ZHENG_SAN_TE_27:
            case ZHENG_SI_TE_27:
            case ZHENG_WU_TE_27:
            case ZHENG_LIU_TE_27:

                numList.add("27");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_28:
            case TE_MA_B_28:
            case ZHENG_MA_28:
            case ZHENG_YI_TE_28:
            case ZHENG_ER_TE_28:
            case ZHENG_SAN_TE_28:
            case ZHENG_SI_TE_28:
            case ZHENG_WU_TE_28:
            case ZHENG_LIU_TE_28:

                numList.add("28");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_29:
            case TE_MA_B_29:
            case ZHENG_MA_29:
            case ZHENG_YI_TE_29:
            case ZHENG_ER_TE_29:
            case ZHENG_SAN_TE_29:
            case ZHENG_SI_TE_29:
            case ZHENG_WU_TE_29:
            case ZHENG_LIU_TE_29:

                numList.add("29");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_30:
            case TE_MA_B_30:
            case ZHENG_MA_30:
            case ZHENG_YI_TE_30:
            case ZHENG_ER_TE_30:
            case ZHENG_SAN_TE_30:
            case ZHENG_SI_TE_30:
            case ZHENG_WU_TE_30:
            case ZHENG_LIU_TE_30:

                numList.add("30");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_31:
            case TE_MA_B_31:
            case ZHENG_MA_31:
            case ZHENG_YI_TE_31:
            case ZHENG_ER_TE_31:
            case ZHENG_SAN_TE_31:
            case ZHENG_SI_TE_31:
            case ZHENG_WU_TE_31:
            case ZHENG_LIU_TE_31:

                numList.add("31");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_32:
            case TE_MA_B_32:
            case ZHENG_MA_32:
            case ZHENG_YI_TE_32:
            case ZHENG_ER_TE_32:
            case ZHENG_SAN_TE_32:
            case ZHENG_SI_TE_32:
            case ZHENG_WU_TE_32:
            case ZHENG_LIU_TE_32:

                numList.add("32");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_33:
            case TE_MA_B_33:
            case ZHENG_MA_33:
            case ZHENG_YI_TE_33:
            case ZHENG_ER_TE_33:
            case ZHENG_SAN_TE_33:
            case ZHENG_SI_TE_33:
            case ZHENG_WU_TE_33:
            case ZHENG_LIU_TE_33:

                numList.add("33");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_34:
            case TE_MA_B_34:
            case ZHENG_MA_34:
            case ZHENG_YI_TE_34:
            case ZHENG_ER_TE_34:
            case ZHENG_SAN_TE_34:
            case ZHENG_SI_TE_34:
            case ZHENG_WU_TE_34:
            case ZHENG_LIU_TE_34:

                numList.add("34");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_35:
            case TE_MA_B_35:
            case ZHENG_MA_35:
            case ZHENG_YI_TE_35:
            case ZHENG_ER_TE_35:
            case ZHENG_SAN_TE_35:
            case ZHENG_SI_TE_35:
            case ZHENG_WU_TE_35:
            case ZHENG_LIU_TE_35:

                numList.add("35");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_36:
            case TE_MA_B_36:
            case ZHENG_MA_36:
            case ZHENG_YI_TE_36:
            case ZHENG_ER_TE_36:
            case ZHENG_SAN_TE_36:
            case ZHENG_SI_TE_36:
            case ZHENG_WU_TE_36:
            case ZHENG_LIU_TE_36:

                numList.add("36");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_37:
            case TE_MA_B_37:
            case ZHENG_MA_37:
            case ZHENG_YI_TE_37:
            case ZHENG_ER_TE_37:
            case ZHENG_SAN_TE_37:
            case ZHENG_SI_TE_37:
            case ZHENG_WU_TE_37:
            case ZHENG_LIU_TE_37:

                numList.add("37");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_38:
            case TE_MA_B_38:
            case ZHENG_MA_38:
            case ZHENG_YI_TE_38:
            case ZHENG_ER_TE_38:
            case ZHENG_SAN_TE_38:
            case ZHENG_SI_TE_38:
            case ZHENG_WU_TE_38:
            case ZHENG_LIU_TE_38:

                numList.add("38");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_39:
            case TE_MA_B_39:
            case ZHENG_MA_39:
            case ZHENG_YI_TE_39:
            case ZHENG_ER_TE_39:
            case ZHENG_SAN_TE_39:
            case ZHENG_SI_TE_39:
            case ZHENG_WU_TE_39:
            case ZHENG_LIU_TE_39:

                numList.add("39");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_40:
            case TE_MA_B_40:
            case ZHENG_MA_40:
            case ZHENG_YI_TE_40:
            case ZHENG_ER_TE_40:
            case ZHENG_SAN_TE_40:
            case ZHENG_SI_TE_40:
            case ZHENG_WU_TE_40:
            case ZHENG_LIU_TE_40:

                numList.add("40");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_41:
            case TE_MA_B_41:
            case ZHENG_MA_41:
            case ZHENG_YI_TE_41:
            case ZHENG_ER_TE_41:
            case ZHENG_SAN_TE_41:
            case ZHENG_SI_TE_41:
            case ZHENG_WU_TE_41:
            case ZHENG_LIU_TE_41:

                numList.add("41");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_42:
            case TE_MA_B_42:
            case ZHENG_MA_42:
            case ZHENG_YI_TE_42:
            case ZHENG_ER_TE_42:
            case ZHENG_SAN_TE_42:
            case ZHENG_SI_TE_42:
            case ZHENG_WU_TE_42:
            case ZHENG_LIU_TE_42:

                numList.add("42");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_43:
            case TE_MA_B_43:
            case ZHENG_MA_43:
            case ZHENG_YI_TE_43:
            case ZHENG_ER_TE_43:
            case ZHENG_SAN_TE_43:
            case ZHENG_SI_TE_43:
            case ZHENG_WU_TE_43:
            case ZHENG_LIU_TE_43:

                numList.add("43");
                priBetNumbers.add(numList);

                break;
            case TE_MA_A_44:
            case TE_MA_B_44:
            case ZHENG_MA_44:
            case ZHENG_YI_TE_44:
            case ZHENG_ER_TE_44:
            case ZHENG_SAN_TE_44:
            case ZHENG_SI_TE_44:
            case ZHENG_WU_TE_44:
            case ZHENG_LIU_TE_44:

                numList.add("44");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_45:
            case TE_MA_B_45:
            case ZHENG_MA_45:
            case ZHENG_YI_TE_45:
            case ZHENG_ER_TE_45:
            case ZHENG_SAN_TE_45:
            case ZHENG_SI_TE_45:
            case ZHENG_WU_TE_45:
            case ZHENG_LIU_TE_45:

                numList.add("45");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_46:
            case TE_MA_B_46:
            case ZHENG_MA_46:
            case ZHENG_YI_TE_46:
            case ZHENG_ER_TE_46:
            case ZHENG_SAN_TE_46:
            case ZHENG_SI_TE_46:
            case ZHENG_WU_TE_46:
            case ZHENG_LIU_TE_46:

                numList.add("46");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_47:
            case TE_MA_B_47:
            case ZHENG_MA_47:
            case ZHENG_YI_TE_47:
            case ZHENG_ER_TE_47:
            case ZHENG_SAN_TE_47:
            case ZHENG_SI_TE_47:
            case ZHENG_WU_TE_47:
            case ZHENG_LIU_TE_47:

                numList.add("47");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_48:
            case TE_MA_B_48:
            case ZHENG_MA_48:
            case ZHENG_YI_TE_48:
            case ZHENG_ER_TE_48:
            case ZHENG_SAN_TE_48:
            case ZHENG_SI_TE_48:
            case ZHENG_WU_TE_48:
            case ZHENG_LIU_TE_48:

                numList.add("48");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_49:
            case TE_MA_B_49:
            case ZHENG_MA_49:
            case ZHENG_YI_TE_49:
            case ZHENG_ER_TE_49:
            case ZHENG_SAN_TE_49:
            case ZHENG_SI_TE_49:
            case ZHENG_WU_TE_49:
            case ZHENG_LIU_TE_49:

                numList.add("49");
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_DA:
            case TE_MA_B_DA:
            case TE_MA_DA:

            case TE_MA_HE_DA:
            case TE_MA_WEI_DA:
            case TE_MA_HONG_DA:
            case TE_MA_LAN_DA:
            case TE_MA_LV_DA:

            case ZHENG_MA_ZONG_DA:
            case ZONG_HE_DA:

            case ZHENG_YI_HE_DA:
            case ZHENG_YI_LIANG_MIAN_DA:
            case ZHENG_YI_LIANG_MIAN_HE_DA:
            case ZHENG_YI_LIANG_MIAN_WEI_DA:
            case ZHENG_YI_MA_DA:
            case ZHENG_YI_WEI_DA:

            case ZHENG_ER_MA_DA:
            case ZHENG_ER_LIANG_MIAN_DA:
            case ZHENG_ER_HE_DA:
            case ZHENG_ER_LIANG_MIAN_HE_DA:
            case ZHENG_ER_LIANG_MIAN_WEI_DA:
            case ZHENG_ER_WEI_DA:

            case ZHENG_SAN_HE_DA:
            case ZHENG_SAN_LIANG_MIAN_DA:
            case ZHENG_SAN_LIANG_MIAN_HE_DA:
            case ZHENG_SAN_LIANG_MIAN_WEI_DA:
            case ZHENG_SAN_MA_DA:
            case ZHENG_SAN_WEI_DA:
            case ZHENG_SI_HE_DA:
            case ZHENG_SI_LIANG_MIAN_DA:
            case ZHENG_SI_LIANG_MIAN_HE_DA:
            case ZHENG_SI_LIANG_MIAN_WEI_DA:
            case ZHENG_SI_MA_DA:
            case ZHENG_SI_WEI_DA:
            case ZHENG_WU_HE_DA:
            case ZHENG_WU_LIANG_MIAN_DA:
            case ZHENG_WU_LIANG_MIAN_HE_DA:
            case ZHENG_WU_LIANG_MIAN_WEI_DA:
            case ZHENG_WU_MA_DA:
            case ZHENG_WU_WEI_DA:
            case ZHENG_LIU_HE_DA:
            case ZHENG_LIU_LIANG_MIAN_DA:
            case ZHENG_LIU_LIANG_MIAN_HE_DA:
            case ZHENG_LIU_LIANG_MIAN_WEI_DA:
            case ZHENG_LIU_MA_DA:
            case ZHENG_LIU_WEI_DA:

                numList.add(big);
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_XIAO:
            case TE_MA_B_XIAO:
            case TE_MA_XIAO:

            case TE_MA_HE_XIAO:
            case TE_MA_WEI_XIAO:
            case TE_MA_HONG_XIAO:
            case TE_MA_LAN_XIAO:
            case TE_MA_LV_XIAO:

            case ZHENG_MA_ZONG_XIAO:
            case ZONG_HE_XIAO:

            case ZHENG_YI_HE_XIAO:
            case ZHENG_YI_LIANG_MIAN_XIAO:
            case ZHENG_YI_LIANG_MIAN_HE_XIAO:
            case ZHENG_YI_LIANG_MIAN_WEI_XIAO:
            case ZHENG_YI_MA_XIAO:
            case ZHENG_YI_WEI_XIAO:

            case ZHENG_ER_MA_XIAO:
            case ZHENG_ER_LIANG_MIAN_XIAO:
            case ZHENG_ER_HE_XIAO:
            case ZHENG_ER_LIANG_MIAN_HE_XIAO:
            case ZHENG_ER_LIANG_MIAN_WEI_XIAO:
            case ZHENG_ER_WEI_XIAO:

            case ZHENG_SAN_HE_XIAO:
            case ZHENG_SAN_LIANG_MIAN_XIAO:
            case ZHENG_SAN_LIANG_MIAN_HE_XIAO:
            case ZHENG_SAN_LIANG_MIAN_WEI_XIAO:
            case ZHENG_SAN_MA_XIAO:
            case ZHENG_SAN_WEI_XIAO:
            case ZHENG_SI_HE_XIAO:
            case ZHENG_SI_LIANG_MIAN_XIAO:
            case ZHENG_SI_LIANG_MIAN_HE_XIAO:
            case ZHENG_SI_LIANG_MIAN_WEI_XIAO:
            case ZHENG_SI_MA_XIAO:
            case ZHENG_SI_WEI_XIAO:
            case ZHENG_WU_HE_XIAO:
            case ZHENG_WU_LIANG_MIAN_XIAO:
            case ZHENG_WU_LIANG_MIAN_HE_XIAO:
            case ZHENG_WU_LIANG_MIAN_WEI_XIAO:
            case ZHENG_WU_MA_XIAO:
            case ZHENG_WU_WEI_XIAO:
            case ZHENG_LIU_HE_XIAO:
            case ZHENG_LIU_LIANG_MIAN_XIAO:
            case ZHENG_LIU_LIANG_MIAN_HE_XIAO:
            case ZHENG_LIU_LIANG_MIAN_WEI_XIAO:
            case ZHENG_LIU_MA_XIAO:
            case ZHENG_LIU_WEI_XIAO:
                numList.add(small);
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_DAN:
            case TE_MA_B_DAN:
            case TE_MA_DAN:

            case TE_MA_HE_DAN:
            case TE_MA_HONG_DAN:
            case TE_MA_LAN_DAN:
            case TE_MA_LV_DAN:

            case ZHENG_MA_ZONG_DAN:
            case ZONG_HE_DAN:

            case ZHENG_YI_HE_DAN:
            case ZHENG_YI_LIANG_MIAN_DAN:
            case ZHENG_YI_LIANG_MIAN_HE_DAN:
            case ZHENG_YI_MA_DAN:

            case ZHENG_ER_MA_DAN:
            case ZHENG_ER_LIANG_MIAN_DAN:
            case ZHENG_ER_HE_DAN:
            case ZHENG_ER_LIANG_MIAN_HE_DAN:

            case ZHENG_SAN_HE_DAN:
            case ZHENG_SAN_LIANG_MIAN_DAN:
            case ZHENG_SAN_LIANG_MIAN_HE_DAN:
            case ZHENG_SAN_MA_DAN:
            case ZHENG_SI_HE_DAN:
            case ZHENG_SI_LIANG_MIAN_DAN:
            case ZHENG_SI_LIANG_MIAN_HE_DAN:
            case ZHENG_SI_MA_DAN:
            case ZHENG_WU_HE_DAN:
            case ZHENG_WU_LIANG_MIAN_DAN:
            case ZHENG_WU_LIANG_MIAN_HE_DAN:
            case ZHENG_WU_MA_DAN:
            case ZHENG_LIU_HE_DAN:
            case ZHENG_LIU_LIANG_MIAN_DAN:
            case ZHENG_LIU_LIANG_MIAN_HE_DAN:
            case ZHENG_LIU_MA_DAN:

            case ZONG_DAN_XIAO:

                numList.add(single);
                priBetNumbers.add(numList);
                break;

            case TE_MA_A_SHUANG:
            case TE_MA_B_SHUANG:
            case TE_MA_SHUANG:

            case TE_MA_HE_SHUANG:
            case TE_MA_HONG_SHUANG:
            case TE_MA_LAN_SHUANG:
            case TE_MA_LV_SHUANG:

            case ZHENG_MA_ZONG_SHUANG:
            case ZONG_HE_SHUANG:

            case ZHENG_YI_HE_SHUANG:
            case ZHENG_YI_LIANG_MIAN_SHUANG:
            case ZHENG_YI_LIANG_MIAN_HE_SHUANG:
            case ZHENG_YI_MA_SHUANG:

            case ZHENG_ER_MA_SHUANG:
            case ZHENG_ER_LIANG_MIAN_SHUANG:
            case ZHENG_ER_HE_SHUANG:
            case ZHENG_ER_LIANG_MIAN_HE_SHUANG:

            case ZHENG_SAN_HE_SHUANG:
            case ZHENG_SAN_LIANG_MIAN_SHUANG:
            case ZHENG_SAN_LIANG_MIAN_HE_SHUANG:
            case ZHENG_SAN_MA_SHUANG:
            case ZHENG_SI_HE_SHUANG:
            case ZHENG_SI_LIANG_MIAN_SHUANG:
            case ZHENG_SI_LIANG_MIAN_HE_SHUANG:
            case ZHENG_SI_MA_SHUANG:
            case ZHENG_WU_HE_SHUANG:
            case ZHENG_WU_LIANG_MIAN_SHUANG:
            case ZHENG_WU_LIANG_MIAN_HE_SHUANG:
            case ZHENG_WU_MA_SHUANG:
            case ZHENG_LIU_HE_SHUANG:
            case ZHENG_LIU_LIANG_MIAN_SHUANG:
            case ZHENG_LIU_LIANG_MIAN_HE_SHUANG:
            case ZHENG_LIU_MA_SHUANG:

            case ZONG_SHUANG_XIAO:

                numList.add(shuang);
                priBetNumbers.add(numList);
                break;

            case QI_SE_HONG_BO:
            case TE_MA_HONG_BO:
            case TE_MA_A_HONG:
            case TE_MA_B_HONG:
            case ZHENG_YI_HONG:
            case ZHENG_ER_HONG:
            case ZHENG_SAN_HONG:
            case ZHENG_SI_HONG:
            case ZHENG_WU_HONG:
            case ZHENG_LIU_HONG:
            case ZHENG_YI_LIANG_MIAN_HONG:
            case ZHENG_ER_LIANG_MIAN_HONG:
            case ZHENG_SAN_LIANG_MIAN_HONG:
            case ZHENG_LIU_LIANG_MIAN_HONG:
            case ZHENG_SI_LIANG_MIAN_HONG:
            case ZHENG_WU_LIANG_MIAN_HONG:

                numList.add(hong);
                priBetNumbers.add(numList);
                break;

            case QI_SE_LV_BO:
            case TE_MA_LV_BO:
            case TE_MA_A_LV:
            case TE_MA_B_LV:
            case ZHENG_YI_LV:
            case ZHENG_ER_LV:
            case ZHENG_SAN_LV:
            case ZHENG_SI_LV:
            case ZHENG_WU_LV:
            case ZHENG_LIU_LV:
            case ZHENG_YI_LIANG_MIAN_LV:
            case ZHENG_ER_LIANG_MIAN_LV:
            case ZHENG_SAN_LIANG_MIAN_LV:
            case ZHENG_LIU_LIANG_MIAN_LV:
            case ZHENG_SI_LIANG_MIAN_LV:
            case ZHENG_WU_LIANG_MIAN_LV:

                numList.add(lv);
                priBetNumbers.add(numList);
                break;

            case QI_SE_LAN_BO:
            case TE_MA_LAN_BO:
            case TE_MA_A_LAN:
            case TE_MA_B_LAN:
            case ZHENG_YI_LAN:
            case ZHENG_ER_LAN:
            case ZHENG_SAN_LAN:
            case ZHENG_SI_LAN:
            case ZHENG_WU_LAN:
            case ZHENG_LIU_LAN:
            case ZHENG_YI_LIANG_MIAN_LAN:
            case ZHENG_ER_LIANG_MIAN_LAN:
            case ZHENG_SAN_LIANG_MIAN_LAN:
            case ZHENG_LIU_LIANG_MIAN_LAN:
            case ZHENG_SI_LIANG_MIAN_LAN:
            case ZHENG_WU_LIANG_MIAN_LAN:

                numList.add(lan);
                priBetNumbers.add(numList);
                break;

            case QI_SE_HE_JU:
                numList.add("和");
                priBetNumbers.add(numList);
                break;

            // 头数
            case TE_MA_TOU_0:
                numList.add("0");
                priBetNumbers.add(numList);
                break;
            case TE_MA_TOU_1:
                numList.add("1");
                priBetNumbers.add(numList);
                break;
            case TE_MA_TOU_2:
                numList.add("2");
                priBetNumbers.add(numList);
                break;
            case TE_MA_TOU_3:
                numList.add("3");
                priBetNumbers.add(numList);
                break;
            case TE_MA_TOU_4:
                numList.add("4");
                priBetNumbers.add(numList);
                break;
            // 尾数
            case PING_TE_WEI_SHU_0:
            case TE_MA_WEI_0:
                numList.add("0");
                priBetNumbers.add(numList);
                break;
            case PING_TE_WEI_SHU_1:
            case TE_MA_WEI_1:
                numList.add("1");
                priBetNumbers.add(numList);
                break;
            case PING_TE_WEI_SHU_2:
            case TE_MA_WEI_2:
                numList.add("2");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_3:
            case TE_MA_WEI_3:
                numList.add("3");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_4:
            case TE_MA_WEI_4:
                numList.add("4");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_5:
            case TE_MA_WEI_5:
                numList.add("5");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_6:
            case TE_MA_WEI_6:
                numList.add("6");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_7:
            case TE_MA_WEI_7:
                numList.add("7");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_8:
            case TE_MA_WEI_8:
                numList.add("8");
                priBetNumbers.add(numList);
                break;

            case PING_TE_WEI_SHU_9:
            case TE_MA_WEI_9:
                numList.add("9");
                priBetNumbers.add(numList);
                break;

            // 合肖 二
            case HE_XIAO_ER:
                priBetNumbers.add(twoXiao);
                break;
            // 合肖 三
            case HE_XIAO_SAN:
                priBetNumbers.add(threeXiao);
                break;
            // 合肖 四
            case HE_XIAO_SI:
                priBetNumbers.add(fourXiao);
                break;
            // 合肖 五
            case HE_XIAO_WU:
                priBetNumbers.add(fiveXiao);
                break;
            // 合肖 六
            case HE_XIAO_LIU:
                priBetNumbers.add(sixXiao);
                break;
            // 合肖
            case HE_XIAO_QI:
                priBetNumbers.add(sevenXiao);
                break;

            case HE_XIAO_BA:
                priBetNumbers.add(eightXiao);
                break;

            case HE_XIAO_JIU:
                priBetNumbers.add(nineXiao);
                break;

            case HE_XIAO_SHI:
                priBetNumbers.add(tenXiao);
                break;

            case HE_XIAO_SHI_YI:
                priBetNumbers.add(elevenXiao);
                break;

            case PING_TE_YI_XIAO_SHU:
            case ZHENG_XIAO_SHU:
            case TE_XIAO_SHU:
                numList.add("鼠");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_NIU:
            case ZHENG_XIAO_NIU:
            case TE_XIAO_NIU:
                numList.add("牛");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_HU:
            case ZHENG_XIAO_HU:
            case TE_XIAO_HU:
                numList.add("虎");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_TU:
            case ZHENG_XIAO_TU:
            case TE_XIAO_TU:
                numList.add("兔");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_LONG:
            case ZHENG_XIAO_LONG:
            case TE_XIAO_LONG:
                numList.add("龙");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_SHE:
            case ZHENG_XIAO_SHE:
            case TE_XIAO_SHE:
                numList.add("蛇");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_MA:
            case ZHENG_XIAO_MA:
            case TE_XIAO_MA:
                numList.add("马");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_YANG:
            case ZHENG_XIAO_YANG:
            case TE_XIAO_YANG:
                numList.add("羊");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_HOU:
            case ZHENG_XIAO_HOU:
            case TE_XIAO_HOU:
                numList.add("猴");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_JI:
            case ZHENG_XIAO_JI:
            case TE_XIAO_JI:
                numList.add("鸡");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_GOU:
            case ZHENG_XIAO_GOU:
            case TE_XIAO_GOU:
                numList.add("狗");
                priBetNumbers.add(numList);
                break;
            case PING_TE_YI_XIAO_ZHU:
            case ZHENG_XIAO_ZHU:
            case TE_XIAO_ZHU:
                numList.add("猪");
                priBetNumbers.add(numList);
                break;

            case WU_XING_JIN:
                numList.add("金");
                priBetNumbers.add(numList);
                break;
            case WU_XING_MU:
                numList.add("木");
                priBetNumbers.add(numList);
                break;
            case WU_XING_SHUI:
                numList.add("水");
                priBetNumbers.add(numList);
                break;
            case WU_XING_HUO:
                numList.add("火");
                priBetNumbers.add(numList);
                break;
            case WU_XING_TU:
                numList.add("土");
                priBetNumbers.add(numList);
                break;

            // 尾数
            case ER_LIAN_WEI_0:
            case ER_LIAN_WEI_FEI_0:
                priBetNumbers.add(twoWeishu);
                break;

            case SAN_LIAN_WEI_0:
            case SAN_LIAN_WEI_FEI_0:
                priBetNumbers.add(threeWeishu);
                break;

            case SI_LIAN_WEI_0:
            case SI_LIAN_WEI_FEI_0:
                priBetNumbers.add(fourWeishu);
                break;

            case WU_LIAN_WEI_0:
            case WU_LIAN_WEI_FEI_0:
                priBetNumbers.add(fiveWeishu);
                break;

            case ER_LIAN_XIAO_BEN_MING:
            case ER_LIAN_XIAO_FEI_BEN_MING:
                priBetNumbers.add(twoXiao);
                break;

            case SAN_LIAN_XIAO_BEN_MING:
            case SAN_LIAN_XIAO_FEI_BEN_MING:
                priBetNumbers.add(threeXiao);
                break;

            case SI_LIAN_XIAO_BEN_MING:
            case SI_LIAN_XIAO_FEI_BEN_MING:
                priBetNumbers.add(fourXiao);
                break;

            case WU_LIAN_XIAO_BEN_MING:
            case WU_LIAN_XIAO_FEI_BEN_MING:
                priBetNumbers.add(fiveXiao);
                break;

            case LIAN_MA_ER_QUAN_ZHONG:
            case LIAN_MA_ER_ZHONG_TE:
            case LIAN_MA_ER_ZHONG_ER:
            case LIAN_MA_TE_CHUAN:
                priBetNumbers.add(sixNumber);
                break;

            case LIAN_MA_SAN_QUAN_ZHONG:
            case LIAN_MA_SAN_ZHONG_ER:
            case LIAN_MA_SAN_ZHONG_SAN:

                priBetNumbers.add(sevenNumber);
                break;

            case LIAN_MA_SI_QUAN_ZHONG:
                priBetNumbers.add(eightNumber);
                break;

            case ZI_XUAN_BU_ZHONG_5:
                priBetNumbers.add(fiveNumber);
                break;
            case ZI_XUAN_BU_ZHONG_6:
                priBetNumbers.add(sixNumber);
                break;
            case ZI_XUAN_BU_ZHONG_7:
                priBetNumbers.add(sevenNumber);
                break;
            case ZI_XUAN_BU_ZHONG_8:
                priBetNumbers.add(eightNumber);
                break;
            case ZI_XUAN_BU_ZHONG_9:
                priBetNumbers.add(nineNumber);
                break;
            case ZI_XUAN_BU_ZHONG_10:
                priBetNumbers.add(tenNumber);
                break;
            case ZI_XUAN_BU_ZHONG_11:
                priBetNumbers.add(elevenNumber);
                break;
            case ZI_XUAN_BU_ZHONG_12:
                priBetNumbers.add(twelveNumber);
                break;

            case TE_TIAN_XIAO:
                numList.add("天肖");
                priBetNumbers.add(numList);
                break;
            case TE_DI_XIAO:
                numList.add("地肖");
                priBetNumbers.add(numList);
                break;
            case TE_QIAN_XIAO:
                numList.add("前肖");
                priBetNumbers.add(numList);
                break;
            case TE_HOU_XIAO:
                numList.add("后肖");
                priBetNumbers.add(numList);
                break;
            case TE_JIA_XIAO:
                numList.add("家肖");
                priBetNumbers.add(numList);
                break;
            case TE_YE_XIAO:
                numList.add("野肖");
                priBetNumbers.add(numList);
                break;

            case ZONG_ER_XIAO:
                numList.add("2");
                priBetNumbers.add(numList);
                break;
            case ZONG_SAN_XIAO:
                numList.add("3");
                priBetNumbers.add(numList);
                break;
            case ZONG_SI_XIAO:
                numList.add("4");
                priBetNumbers.add(numList);
                break;
            case ZONG_WU_XIAO:
                numList.add("5");
                priBetNumbers.add(numList);
                break;
            case ZONG_LIU_XIAO:
                numList.add("6");
                priBetNumbers.add(numList);
                break;
            case ZONG_QI_XIAO:
                numList.add("7");
                priBetNumbers.add(numList);
                break;

            case TE_MA_DA_DAN:
                numList.add("大单");
                priBetNumbers.add(numList);
                break;
            case TE_MA_XIAO_DAN:
                numList.add("小单");
                priBetNumbers.add(numList);
                break;

            case TE_MA_DA_SHUANG:
                numList.add("大双");
                priBetNumbers.add(numList);
                break;
            case TE_MA_XIAO_SHUANG:
                numList.add("小双");
                priBetNumbers.add(numList);
                break;
            case TE_MA_LV_DA_SHUANG:
                numList.add("绿大双");
                priBetNumbers.add(numList);
                break;
            case TE_MA_LAN_DA_SHUANG:
                numList.add("蓝大双");
                priBetNumbers.add(numList);
                break;
            case TE_MA_LV_DA_DAN:
                numList.add("绿大单");
                priBetNumbers.add(numList);
                break;
            case TE_MA_LAN_DA_DAN:
                numList.add("蓝大单");
                priBetNumbers.add(numList);
                break;
            case TE_MA_HONG_DA_DAN:
                numList.add("红大单");
                priBetNumbers.add(numList);
                break;
            case TE_MA_LV_XIAO_DAN:
                numList.add("绿大单");
                priBetNumbers.add(numList);
                break;
            case TE_MA_LAN_XIAO_DAN:
                numList.add("蓝大单");
                priBetNumbers.add(numList);
                break;
            case TE_MA_HONG_XIAO_DAN:
                numList.add("红小单");
                priBetNumbers.add(numList);
                break;
            case TE_MA_HONG_DA_SHUANG:
                numList.add("红大双");
                priBetNumbers.add(numList);
                break;
            case TE_MA_LV_XIAO_SHUANG:
                numList.add("绿小双");
                priBetNumbers.add(numList);
                break;
            case TE_MA_LAN_XIAO_SHUANG:
                numList.add("蓝小双");
                priBetNumbers.add(numList);
                break;
            case TE_MA_HONG_XIAO_SHUANG:
                numList.add("红小双");
                priBetNumbers.add(numList);
                break;
        }
        return priBetNumbers;
    }


    // 双面彩时时彩转换
    private List<List<String>> getLotteryShishicaiDoubleByType(Long playId, String str) {

        return JsonUtils.oneOnlyJson2LotteryList(str);
    }

    // 双面彩11x5转换
    private List<List<String>> getLottery11x5DoubleByType(Long playId, String str) {

        return JsonUtils.oneOnlyJson2LotteryList(str);
    }

    // 双面彩快3转换
    private List<List<String>> getLotteryKuai3DoubleByType(Long playId, String str) {

        return JsonUtils.oneOnlyJson2LotteryList(str);
    }

    // 双面彩PK10转换
    private List<List<String>> getLotteryPK10DoubleByType(Long playId, String str) {

        return JsonUtils.oneOnlyJson2LotteryList(str);
    }

    // 双面彩六合彩转换
    private List<List<String>> getLotteryMark6DoubleByType(Long playId, String str) {

        return JsonUtils.oneOnlyJson2LotteryList(str);
    }

    @Override
    public List<List<String>> getLotteryListByType(Long lotteryId, Long playId, String str) {

        List<List<String>> strList = new ArrayList<>();
        if (lotteryId == 1) {
            return getLotteryListByType(playId, str);
        } else if (lotteryId == 2 || lotteryId == 12 || lotteryId == 14 || lotteryId == 102) {
            return getLotteryShishicaiDoubleByType(playId, str);
        } else if (lotteryId == 4 || lotteryId == 16 || lotteryId == 18 || lotteryId == 104) {
            return getLottery11x5DoubleByType(playId, str);
        } else if (lotteryId == 6 || lotteryId == 20 || lotteryId == 22 || lotteryId == 106) {
            return getLotteryKuai3DoubleByType(playId, str);
        } else if (lotteryId == 8 || lotteryId == 108) {
            return getLotteryPK10DoubleByType(playId, str);
        } else if (lotteryId == 10) {
            return getLotteryMark6DoubleByType(playId, str);
        }
        return strList;
    }

    @Override
    public List<Integer> getLotteryCountByType(Long lotteryId, Long playId, String str) {

        List<Integer> resultList = new ArrayList<>();

        if (lotteryId == 1) {

            ShishicaiType shishicaiType = ShishicaiType.parse(playId);
            if (shishicaiType == null) {
                return resultList;
            }
            switch (shishicaiType) {

                case YI_XING_DING_WEI_DAN:

                    JsonUtils.json2LotteryList(str).forEach(lotteryCount -> {
                        resultList.add(lotteryCount.size());
                    });
                    break;

                default:
                    return resultList;
            }
        }
        return resultList;
    }

    @Override
    public String getStringByLotteryList(Long playId, List<List<String>> lotteryList) {

        return getShishicaiStringByLotteryList(playId, lotteryList);
    }

    @Override
    public String getStringByLotteryList(Long lotteryId, Long playId, List<List<String>> lotteryList) {

        if (lotteryId == 1) {
            return getShishicaiStringByLotteryList(playId, lotteryList);
        } else {
            return JsonUtils.lotteryList2OneOnlyJson(lotteryList);
        }
    }

    /**
     * 官彩时时彩
     *
     * @param playId
     * @param lotteryList
     * @return
     */
    private String getShishicaiStringByLotteryList(Long playId, List<List<String>> lotteryList) {

        ShishicaiType shishicaiType = ShishicaiType.parse(playId);
        if (shishicaiType == null || lotteryList.size() == 0) {
            return "";
        }
        switch (shishicaiType) {

            case WU_XING_ZHI_XUAN_FU_SHI:
            case WU_XING_ZHI_XUAN_ZU_HE:
            case ZU_XUAN_60:
            case ZU_XUAN_30:
            case ZU_XUAN_20:
            case ZU_XUAN_10:
            case ZU_XUAN_5:

            case SI_XING_ZHI_XUAN_FU_SHI:
            case SI_XING_ZHI_XUAN_ZU_HE:
            case ZU_XUAN_12:
            case ZU_XUAN_4:

            case QIAN_SAN_FU_SHI:
            case ZHONG_SAN_FU_SHI:
            case HOU_SAN_FU_SHI:

            case QIAN_ER_ZHI_XUAN_FU_SHI:
            case HOU_ER_ZHI_XUAN_FU_SHI:

            case YI_XING_DING_WEI_DAN:

            case QIAN_ER_DA_XIAO_DAN_SHUANG:
            case HOU_ER_DA_XIAO_DAN_SHUANG:
            case ZONG_HE_DA_XIAO_DAN_SHUANG:

                return JsonUtils.lotteryList2Json(lotteryList);

            case WU_XING_ZHI_XUAN_DAN_SHI:
                return JsonUtils.lotteryListToDanShi(lotteryList, 5);

            case SI_XING_ZHI_XUAN_DAN_SHI:
                return JsonUtils.lotteryListToDanShi(lotteryList, 4);

            case QIAN_SAN_DAN_SHI:
            case ZHONG_SAN_DAN_SHI:
            case HOU_SAN_DAN_SHI:
            case QIAN_SAN_HUN_HE_ZU_XUAN:
            case ZHONG_SAN_HUN_HE_ZU_XUAN:
            case HOU_SAN_HUN_HE_ZU_XUAN:

                return JsonUtils.lotteryListToDanShi(lotteryList, 3);

            case QIAN_ER_ZHI_XUAN_DAN_SHI:
            case HOU_ER_ZHI_XUAN_DAN_SHI:
            case QIAN_ER_ZU_XUAN_DAN_SHI:
            case HOU_ER_ZU_XUAN_DAN_SHI:

                return JsonUtils.lotteryListToDanShi(lotteryList, 2);

            case ZU_XUAN_120:
            case ZU_XUAN_24:
            case ZU_XUAN_6:

            case QIAN_SAN_ZHI_XUAN_HE_ZHI:
            case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
            case HOU_SAN_ZHI_XUAN_HE_ZHI:
            case QIAN_SAN_ZU_SAN:
            case ZHONG_SAN_ZU_SAN:
            case HOU_SAN_ZU_SAN:
            case QIAN_SAN_ZU_LIU:
            case HOU_SAN_ZU_LIU:
            case ZHONG_SAN_ZU_LIU:
            case QIAN_SAN_ZU_XUAN_HE_ZHI:
            case ZHONG_SAN_ZU_XUAN_HE_ZHI:
            case HOU_SAN_ZU_XUAN_HE_ZHI:

            case QIAN_ER_ZHI_XUAN_HE_ZHI:
            case HOU_ER_ZHI_XUAN_HE_ZHI:
            case QIAN_ER_ZU_XUAN_FU_SHI:
            case HOU_ER_ZU_XUAN_FU_SHI:
            case QIAN_ER_ZU_XUAN_HE_ZHI:
            case HOU_ER_ZU_XUAN_HE_ZHI:

            case QIAN_SAN_YI_MA:
            case HOU_SAN_YI_MA:
            case QIAN_SAN_ER_MA:
            case HOU_SAN_ER_MA:

            case YI_FAN_FENG_SHUN:
            case HAO_SHI_CHENG_SHUANG:
            case SAN_XING_BAO_XI:
            case SI_JI_FA_CAI:

                return JsonUtils.lotteryList2OneOnlyJson(lotteryList);

            default:
                return "";

        }

    }


    // 获取随机数（可重复）
    private List<List<String>> getRandomList(int maxNum, int outerLength, int innerLength) {

        List<List<String>> returnList = new ArrayList<>();
        for (int i = 0; i < outerLength; i++) {
            List<String> oneList = new ArrayList<>();
            for (int j = 0; j < innerLength; j++) {
                oneList.add(String.valueOf(new Random().nextInt(maxNum)));
            }
            returnList.add(oneList);
        }
        return returnList;
    }


    /**
     * 获取时时彩下注算法
     *
     * @param playId
     * @param betNumbers
     * @return
     */

    private long getShiShiCaiBetCount(Long playId, List<List<String>> betNumbers) {

        int size = betNumbers.size();
        ShishicaiType shishicaiType = ShishicaiType.parse(playId);
        if (shishicaiType != null) {

            switch (shishicaiType) {

                case WU_XING_ZHI_XUAN_FU_SHI:
                    if (size == 5 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case WU_XING_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 5;
                    }
                    return 0;

                case WU_XING_ZHI_XUAN_ZU_HE:
                    if (size == 5 && checkDuplicatedPerList(betNumbers)) {
                        return 5 * LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case ZU_XUAN_120:
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 5);
                    }
                    return 0;

                case ZU_XUAN_60:
                    if (size == 2 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 3, betNumbers);
                    }
                    return 0;

                case ZU_XUAN_30:
                    if (size == 2 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.twoCombinationRemoveRepeat(2, 1, betNumbers);
                    }
                    return 0;

                case ZU_XUAN_20:
                    if (size == 2 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 2, betNumbers);
                    }
                    return 0;

                case ZU_XUAN_10:
                case ZU_XUAN_5:
                    if (size == 2 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 1, betNumbers);
                    }
                    return 0;
                case SI_XING_ZHI_XUAN_FU_SHI:
                    if (size == 4 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case SI_XING_ZHI_XUAN_DAN_SHI:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 4;
                    }
                    return 0;

                case SI_XING_ZHI_XUAN_ZU_HE:
                    if (size == 4 && checkDuplicatedPerList(betNumbers)) {
                        return 4 * LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case ZU_XUAN_24:
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 4);
                    }
                    return 0;

                case ZU_XUAN_12:
                    if (size == 2 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 2, betNumbers);
                    }
                    return 0;

                case ZU_XUAN_6:
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case ZU_XUAN_4:
                    if (size == 2 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.twoCombinationRemoveRepeat(1, 1, betNumbers);
                    }
                    return 0;
                case QIAN_SAN_FU_SHI:
                case ZHONG_SAN_FU_SHI:
                case HOU_SAN_FU_SHI:
                    if (size == 3 && checkDuplicatedPerList(betNumbers)) {
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
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
                        return 2 * LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case QIAN_SAN_ZU_LIU:
                case ZHONG_SAN_ZU_LIU:
                case HOU_SAN_ZU_LIU:
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
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
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
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
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
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
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                case HOU_ER_ZHI_XUAN_FU_SHI:
                    if (size == 2 && checkDuplicatedPerList(betNumbers)) {
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
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case QIAN_ER_ZHI_XUAN_HE_ZHI:
                case HOU_ER_ZHI_XUAN_HE_ZHI:
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
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
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
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
                case YI_XING_DING_WEI_DAN:
                    if (size != 0 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.toPlusAll(betNumbers);
                    }
                    return 0;
                case QIAN_SAN_YI_MA:
                case HOU_SAN_YI_MA:
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
                        return betNumbers.get(0).size();
                    }
                    return 0;

                case QIAN_SAN_ER_MA:
                case HOU_SAN_ER_MA:
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case QIAN_ER_DA_XIAO_DAN_SHUANG:
                case HOU_ER_DA_XIAO_DAN_SHUANG:
                    if (size == 2 && checkDuplicatedPerList(betNumbers)) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

                case ZONG_HE_DA_XIAO_DAN_SHUANG:
                case YI_FAN_FENG_SHUN:
                case HAO_SHI_CHENG_SHUANG:
                case SAN_XING_BAO_XI:
                case SI_JI_FA_CAI:
                    if (size == 1 && checkDuplicatedPerList(betNumbers)) {
                        return betNumbers.get(0).size();
                    }
                    return 0;
                default:
                    return 0;
            }
        }
        return 0;
    }


    /**
     * 获取11x5的下注单数
     *
     * @param playId
     * @param betNumbers
     * @return
     */
    private long getLottery11x5BetCount(Long playId, List<List<String>> betNumbers) {
        int size = betNumbers.size();

        Lottery11x5Type lottery11x5Type = Lottery11x5Type.parse(playId);
        if (lottery11x5Type != null) {

            switch (lottery11x5Type) {

                // 一中一
                case FU_SHI_YI_ZHONG_YI:
                case DAN_SHI_YI_ZHONG_YI:

                    // 定单双
                case DING_DAN_SHUANG_0:
                case DING_DAN_SHUANG_1:
                case DING_DAN_SHUANG_2:
                case DING_DAN_SHUANG_3:
                case DING_DAN_SHUANG_4:
                case DING_DAN_SHUANG_5:

                    // 猜中位
                case CAI_ZHONG_WEI_3:
                case CAI_ZHONG_WEI_4:
                case CAI_ZHONG_WEI_5:
                case CAI_ZHONG_WEI_6:
                case CAI_ZHONG_WEI_7:
                case CAI_ZHONG_WEI_8:
                case CAI_ZHONG_WEI_9:

                    // 不定胆
                case QIAN_SAN_YI_MA:

                    if (size == 1) {
                        return betNumbers.get(0).size();
                    }
                    return 0;

                // 二中二
                case FU_SHI_ER_ZHONG_ER:
                case DAN_SHI_ER_ZHONG_ER:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                // 三中三
                case FU_SHI_SAN_ZHONG_SAN:
                case DAN_SHI_SAN_ZHONG_SAN:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 3);
                    }
                    return 0;

                // 四中四
                case FU_SHI_SI_ZHONG_SI:
                case DAN_SHI_SI_ZHONG_SI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 4);
                    }
                    return 0;

                //五中五
                case FU_SHI_WU_ZHONG_WU:
                case DAN_SHI_WU_ZHONG_WU:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 5);
                    }
                    return 0;

                // 六中五
                case FU_SHI_LIU_ZHONG_WU:
                case DAN_SHI_LIU_ZHONG_WU:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 6);
                    }
                    return 0;

                // 七中五
                case FU_SHI_QI_ZHONG_WU:
                case DAN_SHI_QI_ZHONG_WU:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 7);
                    }
                    return 0;

                // 八中五
                case FU_SHI_BA_ZHONG_WU:
                case DAN_SHI_BA_ZHONG_WU:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 8);
                    }
                    return 0;

                // 一星定位胆
                case YI_XING_DING_WEI_DAN:
                    if (size != 0) {
                        return LotteryUtils.toPlusAll(betNumbers);
                    }
                    return 0;

                // 前二直选复式
                case QIAN_ER_ZHI_XUAN_FU_SHI:
                    if (size == 2) {
                        return LotteryUtils.toMultiplyAll(betNumbers) - LotteryUtils.intersectionOfSetNum(betNumbers.get(0), betNumbers.get(1));
                    }
                    return 0;

                //前二直选单式
                case QIAN_ER_ZHI_XUAN_DAN_SHI:
                    //前二组选单式
                case QIAN_ER_ZU_XUAN_DAN_SHI:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 2;
                    }
                    return 0;

                // 前二组选复式
                case QIAN_ER_ZU_XUAN_FU_SHI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                // 前三直选单式
                case QIAN_SAN_ZHI_XUAN_DAN_SHI:
                    // 前三组选单式
                case QIAN_SAN_ZU_XUAN_DAN_SHI:
                    if (size == 1) {
                        return betNumbers.get(0).size() / 3;
                    }
                    return 0;
                // 前三直选复式
                case QIAN_SAN_ZHI_XUAN_FU_SHI:
                    //TODO
                    return getQianSanZhiXuanFuShiBetCount(betNumbers);

                case QIAN_SAN_ZU_XUAN_FU_SHI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 3);
                    }
                    return 0;

                default:
                    return 0;
            }
        }

        return 0;
    }

    /**
     * 获取11x5的下注单数
     *
     * @param playId
     * @param betNumbers
     * @return
     */
    private long getLottery11x5DoubleBetCount(Long playId, List<List<String>> betNumbers) {
        int size = betNumbers.size();
        int betCount = 0;
        if (size != 1) {
            return 0;
        }
        Lottery11x5DoubleType lottery11x5DoubleType = Lottery11x5DoubleType.parse(playId);
        if (lottery11x5DoubleType != null) {

            switch (lottery11x5DoubleType) {

                case QIAN_ER_ZU_XUAN:
                    if (LotteryUtils.getDupStr(betNumbers.get(0)).size() > 0) {
                        return 0;
                    }
                    betCount = (int) LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    break;
                case QIAN_SAN_ZU_XUAN:
                    if (LotteryUtils.getDupStr(betNumbers.get(0)).size() > 0) {
                        return 0;
                    }
                    betCount = (int) LotteryUtils.combination(betNumbers.get(0).size(), 3);
                    break;
                case QIAN_ER_ZHI_XUAN:
                    betCount = betNumbers.get(0).size() / 2;
                    break;
                case QIAN_SAN_ZHI_XUAN:
                    betCount = betNumbers.get(0).size() / 3;
                    break;

                case LIAN_MA_ER_ZHONG_ER:
                    if (betNumbers.get(0).size() == 2 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    break;
                case LIAN_MA_SAN_ZHONG_SAN:
                    if (betNumbers.get(0).size() == 3 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    break;
                case LIAN_MA_SI_ZHONG_SI:
                    if (betNumbers.get(0).size() == 4 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    break;
                case LIAN_MA_WU_ZHONG_WU:
                    if (betNumbers.get(0).size() == 5 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    break;
                case LIAN_MA_LIU_ZHONG_WU:
                    if (betNumbers.get(0).size() == 6 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    break;
                case LIAN_MA_QI_ZHONG_WU:
                    if (betNumbers.get(0).size() == 7 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    break;
                case LIAN_MA_BA_ZHONG_WU:
                    if (betNumbers.get(0).size() == 8 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    break;

                case ZONG_HE_DA:
                case ZONG_HE_XIAO:
                case ZONG_HE_DAN:
                case ZONG_HE_SHUANG:
                case ZONG_HE_WEI_XIAO:
                case ZONG_HE_WEI_DA:
                case ZONG_HE_LONG:
                case ZONG_HE_HU:

                    betCount = 1;
                    break;
                default:
                    if (betNumbers.get(0).size() == 1 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    return 0;
            }
        }
        return betCount;
    }

    private long getLotteryKuai3BetCount(Long playId, List<List<String>> betNumbers) {

        int size = betNumbers.size();

        LotteryKuai3Type lotteryKuai3Type = LotteryKuai3Type.parse(playId);
        if (lotteryKuai3Type != null) {

            switch (lotteryKuai3Type) {

                // 二同号复选
                case ER_TONG_HAO_FU_XUAN:
                    // 三同号单选
                case SAN_TONG_HAO_DAN_XUAN:
                    // 和值点数
                case HE_ZHI_DIAN_SHU:
                    //和值大小单双
                case HE_ZHI_DA_XIAO:
                case HE_ZHI_DAN_SHUANG:

                    //一号中奖不定胆
                case YI_HAO_DING_WEI_DAN:
                    return betNumbers.get(0).size();

                // 三不同号标准选号
                case SAN_BU_TONG_HAO_FU_SHI:
                    return LotteryUtils.combination(size, 3);

                // 三不同号手选
                case SAN_BU_TONG_HAO_DAN_SHI:
                    // 二同号单式
                case ER_TONG_HAO_DAN_SHI:
                    return betNumbers.get(0).size() / 3;

                //三不同号胆拖选号
                case SAN_BU_TONG_HAO_DAN_TUO:
                    // 二不同号胆拖
                case ER_BU_TONG_HAO_DAN_TUO:
                    // 二同号单选
                case ER_TONG_HAO_FU_SHI:
                    return LotteryUtils.toMultiplyAll(betNumbers);

                // 三同号通选
                case SAN_TONG_HAO_TONG_XUAN:
                    // 三连号通选
                case SAN_LIAN_HAO_TONG_XUAN:
                    return 1;

                // 二不同号标准
                case ER_BU_TONG_HAO_FU_SHI:
                    return LotteryUtils.combination(betNumbers.get(0).size(), 2);

                // 二不同号手动号
                case ER_BU_TONG_HAO_DAN_SHI:
                    return betNumbers.get(0).size() / 2;

                default:
                    return 0;
            }
        }
        return 0;
    }

    private long getLotteryKuai3DoubleBetCount(Long playId, List<List<String>> betNumbers) {

        int size = betNumbers.size();
        if (size != 1) {
            return 0;
        }
        LotteryKuai3DoubleType lotteryKuai3DoubleType = LotteryKuai3DoubleType.parse(playId);
        if (lotteryKuai3DoubleType != null) {

            switch (lotteryKuai3DoubleType) {

                // 三同号
                case WEI_SHAI_1:
                case WEI_SHAI_2:
                case WEI_SHAI_3:
                case WEI_SHAI_4:
                case WEI_SHAI_5:
                case WEI_SHAI_6:
                    if (betNumbers.get(0).size() == 3 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 1) {
                        return 1;
                    }
                    break;

                case QUAN_SHAI:
                    if (betNumbers.get(0).contains("全骰")) {
                        return 1;
                    }
                    break;

                case CHANG_PAI_12:
                case CHANG_PAI_13:
                case CHANG_PAI_14:
                case CHANG_PAI_15:
                case CHANG_PAI_16:
                case CHANG_PAI_23:
                case CHANG_PAI_24:
                case CHANG_PAI_25:
                case CHANG_PAI_26:
                case CHANG_PAI_34:
                case CHANG_PAI_35:
                case CHANG_PAI_36:
                case CHANG_PAI_45:
                case CHANG_PAI_46:
                case CHANG_PAI_56:

                    if (betNumbers.get(0).size() == 2 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 0) {
                        return 1;
                    }
                    break;

                case DUAN_PAI_1:
                case DUAN_PAI_2:
                case DUAN_PAI_3:
                case DUAN_PAI_4:
                case DUAN_PAI_5:
                case DUAN_PAI_6:
                    if (betNumbers.get(0).size() == 2 && LotteryUtils.getDupStr(betNumbers.get(0)).size() == 1) {
                        return 1;
                    }
                    break;

                default:
                    if (betNumbers.get(0).size() == 1) {
                        return 1;
                    }
                    return 0;
            }
        }
        return 0;
    }

    /**
     * 获取PK10的下注单数
     *
     * @param playId
     * @param betNumbers
     * @return
     */

    private long getLotteryPK10BetCount(Long playId, List<List<String>> betNumbers) {
        int size = betNumbers.size();

        LotteryPK10Type lotteryPK10Type = LotteryPK10Type.parse(playId);
        if (lotteryPK10Type != null) {

            switch (lotteryPK10Type) {

                // 冠军复式
                case GUAN_JUN_FU_SHI:

                    // 龙虎
                case DAN_HAO_GUAN_LONG_HU:
                case DAN_HAO_YA_LONG_HU:
                case DAN_HAO_THIRD_LONG_HU:
                case DAN_HAO_FORTH_LONG_HU:
                case DAN_HAO_FIFTH_LONG_HU:

                    // 大小单双
                case GUAN_DA_XIAO_DAN_SHUANG:
                case YA_DA_XIAO_DAN_SHUANG:
                case THIRD_DA_XIAO_DAN_SHUANG:

                    // 和值
                case QIAN_SAN_HE_ZHI:
                case HOU_SAN_HE_ZHI:
                case QIAN_ER_HE_ZHI:
                case ZHONG_ER_HE_ZHI:
                case HOU_ER_HE_ZHI:

                    if (size == 1) {
                        return betNumbers.get(0).size();
                    }
                    return 0;

                //定位胆
                case DING_WEI_DAN:
                    if (size != 0) {
                        return LotteryUtils.toPlusAll(betNumbers);
                    }
                    return 0;

                //竞速
                case JING_SU:

                    return size;


                // 前二单式
                case QIAN_ER_DAN_SHI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                // 前三单式
                case QIAN_SAN_DAN_SHI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 3);
                    }
                    return 0;

                // 前四单式
                case QIAN_SI_DAN_SHI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 4);
                    }
                    return 0;

                //前五单式
                case QIAN_WU_DAN_SHI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 5);
                    }
                    return 0;

                // 前六单式
                case QIAN_LIU_DAN_SHI:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 6);
                    }
                    return 0;

                // 前二复式
                case QIAN_ER_FU_SHI:

                    if (size == 2) {
                        return LotteryUtils.toMultiplyAll(betNumbers) - LotteryUtils.intersectionOfSetNum(betNumbers.get(0), betNumbers.get(1));
                    }
                    return 0;

                // 前三复式
                case QIAN_SAN_FU_SHI:

                    return getQianSanZhiXuanFuShiBetCount(betNumbers);

                // 复式
                case QIAN_SI_FU_SHI:
                case QIAN_WU_FU_SHI:
                case QIAN_LIU_FU_SHI:

                    // TODO

                default:
                    return 0;
            }
        }

        return 0;
    }

    /**
     * 获取六合彩的下注单数
     *
     * @param playId
     * @param betNumbers
     * @return
     */

    private long getLotteryMark6DoubleBetCount(Long playId, List<List<String>> betNumbers) {
        int size = betNumbers.size();
        if (size == 0) {
            return 0;
        }
        LotteryMark6DoubleType lotteryMark6DoubleType = LotteryMark6DoubleType.parse(playId);
        if (lotteryMark6DoubleType != null) {

            switch (lotteryMark6DoubleType) {

                // 连码 二全中、二中特、特串
                case LIAN_MA_ER_QUAN_ZHONG:
                case LIAN_MA_ER_ZHONG_TE:
                case LIAN_MA_ER_ZHONG_ER:
                case LIAN_MA_TE_CHUAN:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                // 连码 三全中、三中二
                case LIAN_MA_SAN_QUAN_ZHONG:
                case LIAN_MA_SAN_ZHONG_ER:
                case LIAN_MA_SAN_ZHONG_SAN:

                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 3);
                    }
                    return 0;

                // 连码 四全中
                case LIAN_MA_SI_QUAN_ZHONG:

                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 4);
                    }
                    return 0;

                // 合肖
                case HE_XIAO_ER:
                    if (size == 1 && betNumbers.get(0).size() == 2) {
                        return 1;
                    }
                    return 0;

                case HE_XIAO_SAN:
                    if (size == 1 && betNumbers.get(0).size() == 3) {
                        return 1;
                    }
                    return 0;
                case HE_XIAO_SI:
                    if (size == 1 && betNumbers.get(0).size() == 4) {
                        return 1;
                    }
                    return 0;
                case HE_XIAO_WU:
                    if (size == 1 && betNumbers.get(0).size() == 5) {
                        return 1;
                    }
                    return 0;
                case HE_XIAO_LIU:
                    if (size == 1 && betNumbers.get(0).size() == 6) {
                        return 1;
                    }
                    return 0;
                case HE_XIAO_QI:
                    if (size == 1 && betNumbers.get(0).size() == 7) {
                        return 1;
                    }
                    return 0;
                case HE_XIAO_BA:
                    if (size == 1 && betNumbers.get(0).size() == 8) {
                        return 1;
                    }
                    return 0;
                case HE_XIAO_JIU:
                    if (size == 1 && betNumbers.get(0).size() == 9) {
                        return 1;
                    }
                    return 0;
                case HE_XIAO_SHI:
                    if (size == 1 && betNumbers.get(0).size() == 10) {
                        return 1;
                    }
                    return 0;
                case HE_XIAO_SHI_YI:
                    if (size == 1 && betNumbers.get(0).size() == 11) {
                        return 1;
                    }
                    return 0;

                default:
                    return 1;
            }
        }
        return 0;
    }

    /**
     * 前三组选复式
     *
     * @param betNumbers 第一位数量a,第二位数量b,第三位c，ab交集j,bc交集k,ac交集l,abc交集m
     *                   公式为 abc-ak-bl-cj+2m
     * @return
     */
    private long getQianSanZhiXuanFuShiBetCount(List<List<String>> betNumbers) {

        long betCount = 0;
        if (betNumbers.size() != 3) {
            return betCount;
        }

        betCount = LotteryUtils.toMultiplyAll(betNumbers) - LotteryUtils.intersectionOfSetNum(betNumbers.get(0), betNumbers.get(1)) * betNumbers.get(2).size() - LotteryUtils.intersectionOfSetNum(betNumbers.get(1), betNumbers.get(2)) * betNumbers.get(0).size() - LotteryUtils.intersectionOfSetNum(betNumbers.get(0), betNumbers.get(2)) * betNumbers.get(1).size() + 2 * LotteryUtils.intersectionOfSetNum(betNumbers.get(0), betNumbers.get(1), betNumbers.get(2));

        return betCount;
    }

    /**
     * 校验注单的每一行是否有重复（true-有重复）
     *
     * @param betList
     * @return
     */
    private boolean checkDuplicatedPerList(List<List<String>> betList) {

        if (betList.size() == 0) {
            return false;
        } else {
            for (List<String> betLine : betList) {

                Set<String> betSet = new HashSet<>();
                betSet.addAll(betLine);
                if (betLine.size() != betSet.size()) {
                    return false;
                }
            }
        }
        return true;
    }
}
