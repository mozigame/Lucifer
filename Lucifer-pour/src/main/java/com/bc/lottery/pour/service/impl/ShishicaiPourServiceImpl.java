package com.bc.lottery.pour.service.impl;

import com.bc.lottery.entity.ShishicaiType;
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
        int size = betNumbers.size();

        ShishicaiType shishicaiType = ShishicaiType.parse(playId);
        if (shishicaiType != null) {

            switch (shishicaiType) {

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
                case YI_XING_DING_WEI_DAN:
                    if (size != 0) {
                        return LotteryUtils.toPlusAll(betNumbers);
                    }
                    return 0;
                case QIAN_SAN_YI_MA:
                case HOU_SAN_YI_MA:
                    if (size == 1) {
                        return betNumbers.get(0).size();
                    }
                    return 0;

                case QIAN_SAN_ER_MA:
                case HOU_SAN_ER_MA:
                    if (size == 1) {
                        return LotteryUtils.combination(betNumbers.get(0).size(), 2);
                    }
                    return 0;

                case QIAN_ER_DA_XIAO_DAN_SHUANG:
                case HOU_ER_DA_XIAO_DAN_SHUANG:
                    if (size == 2) {
                        return LotteryUtils.toMultiplyAll(betNumbers);
                    }
                    return 0;

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

    @Override
    public List<List<String>> getBetNumbersByType(Long playId) {
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

                    firstList.add(list.get(8));
                    priBetNumbers.add(firstList);
                    priBetNumbers.add(Arrays.asList(threeNumber));
                    break;
                case ZU_XUAN_30:
                case ZU_XUAN_20:
                case ZU_XUAN_12:

                    firstList.add(list.get(8));
                    priBetNumbers.add(Arrays.asList(twoNumber));
                    priBetNumbers.add(firstList);
                    break;

                case ZU_XUAN_10:
                case ZU_XUAN_5:
                case ZU_XUAN_4:

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

    @Override
    public List<List<String>> getLotteryListByType(Long playId, String str) {

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
}
