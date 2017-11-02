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

        if (lotteryId == 1) {
            return getShiShiCaiBetCount(playId, betNumbers);
        } else if (lotteryId == 2 || lotteryId == 12 || lotteryId == 14) {
            return 1;
        } else if (lotteryId == 3) {
            return getLottery11x5BetCount(playId, betNumbers);
        } else if (lotteryId == 4 || lotteryId == 16 || lotteryId == 18) {
            return getLottery11x5DoubleBetCount(playId, betNumbers);
        } else if (lotteryId == 5) {
            return getLotteryKuai3BetCount(playId, betNumbers);
        } else if (lotteryId == 6 || lotteryId == 20 || lotteryId == 22) {
            return 1;
        } else if (lotteryId == 7) {
            return getLotteryPK10BetCount(playId, betNumbers);
        } else if (lotteryId == 8) {
            return 1;
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

    @Override
    public List<List<String>> getLotteryListByType(Long lotteryId, Long playId, String str) {

        List<List<String>> strList = new ArrayList<>();
        if (lotteryId == 1) {
            return getLotteryListByType(playId, str);
        } else if (lotteryId == 2 || lotteryId == 12 || lotteryId == 14) {
            return getLotteryShishicaiDoubleByType(playId, str);
        } else if (lotteryId == 4 || lotteryId == 16 || lotteryId == 18) {
            return getLottery11x5DoubleByType(playId, str);
        } else if (lotteryId == 6 || lotteryId == 20 || lotteryId == 22) {
            return getLotteryKuai3DoubleByType(playId, str);
        } else if (lotteryId == 8) {
            return getLotteryPK10DoubleByType(playId, str);
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
        int betCount = 1;
        if (size == 0) {
            return 0;
        }
        Lottery11x5DoubleType lottery11x5DoubleType = Lottery11x5DoubleType.parse(playId);
        if (lottery11x5DoubleType != null) {

            switch (lottery11x5DoubleType) {

                case QIAN_ER_ZU_XUAN:
                    betCount = (int) LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    break;
                case QIAN_SAN_ZU_XUAN:
                    betCount = (int) LotteryUtils.combination(betNumbers.get(0).size(), 3);
                    break;
                case QIAN_ER_ZHI_XUAN:
                    betCount = betNumbers.get(0).size() / 2;
                    break;
                case QIAN_SAN_ZHI_XUAN:
                    betCount = betNumbers.get(0).size() / 3;
                    break;
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
