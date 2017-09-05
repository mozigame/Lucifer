package com.bc.lottery.service.impl;

import com.bc.lottery.entity.LotteryType;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.bc.lottery.entity.ShishicaiType.*;

/**
 * ShishicaiServiceImpl Tester.
 *
 * @author clion
 * @version 1.0
 * @since <pre>九月 4, 2017</pre>
 */
public class ShishicaiServiceImplTest {

    ShishicaiServiceImpl shishicaiService = new ShishicaiServiceImpl();

    @Before
    public void before() throws Exception {

        String kj;
        String orderNo; // 注单编号
        LotteryType lotteryType = Wuxing.WU_XING_ZHI_XUAN_DAN_SHI;

        shishicaiService.getBatchBoundsInfoOfLottery(Wuxing.WU_XING_ZHI_XUAN_DAN_SHI, "123", null);
        List<List<String>> betNumbers; // 所选号码组合列表
        String[] twoNumber = {"0", "1"};
        String[] threeNumber = {"2", "3", "4"};
        String[] fourNumber = {"4", "6", "7", "9"};
        String[] fiveNumber = {"1", "3", "5", "7", "9"};
        String[] sixNumber = {"2", "3", "4", "7", "8", "9"};
        List<List<String>> priBetNumbers = new ArrayList<>();
        List<String> priBetNumber0 = new ArrayList<>();
        List<String> priBetNumber1 = new ArrayList<>();
        List<String> priBetNumber2 = new ArrayList<>();
        List<String> priBetNumber3 = new ArrayList<>();
        List<String> priBetNumber4 = new ArrayList<>();
        //五星
        if (lotteryType instanceof Wuxing) {
            Wuxing wuxingType = (Wuxing) lotteryType;
            for (List<String> list : priBetNumbers) {
                list.clear();
            }
            switch (wuxingType) {
                case WU_XING_ZHI_XUAN_ZU_HE:
                case WU_XING_ZHI_XUAN_FU_SHI:
                    priBetNumbers.add(priBetNumber0);
                    priBetNumbers.add(priBetNumber1);
                    priBetNumbers.add(priBetNumber2);
                    priBetNumbers.add(priBetNumber3);
                    priBetNumbers.add(priBetNumber4);
                    priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                    priBetNumbers.get(1).addAll(Arrays.asList(threeNumber));
                    priBetNumbers.get(2).addAll(Arrays.asList(twoNumber));
                    priBetNumbers.get(3).addAll(Arrays.asList(fiveNumber));
                    priBetNumbers.get(4).addAll(Arrays.asList(twoNumber));
                    break;
                case WU_XING_ZHI_XUAN_DAN_SHI:
                    priBetNumbers.add(priBetNumber0);
                    for (int i = 0; i < 10; i++) {
                        priBetNumbers.get(0).add(String.valueOf(i));
                    }
                    break;
                case ZU_XUAN_120:
                    priBetNumbers.add(priBetNumber0);
                    for (int i = 0; i < 7; i++) {
                        priBetNumbers.get(0).add(String.valueOf(i));
                    }
                    break;
                case ZU_XUAN_60:
                    priBetNumbers.add(priBetNumber0);
                    priBetNumbers.add(priBetNumber1);
                    priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                    priBetNumbers.get(1).addAll(Arrays.asList(fourNumber));
                    break;
                case ZU_XUAN_30:
                    priBetNumbers.add(priBetNumber0);
                    priBetNumbers.add(priBetNumber1);

                    priBetNumbers.get(0).addAll(Arrays.asList(threeNumber));
                    priBetNumbers.get(1).addAll(Arrays.asList(twoNumber));
                    break;
                case ZU_XUAN_10:
                    priBetNumbers.add(priBetNumber0);
                    priBetNumbers.add(priBetNumber1);

                    priBetNumbers.get(0).addAll(Arrays.asList(threeNumber));
                    priBetNumbers.get(1).addAll(Arrays.asList(twoNumber));
                    break;
                case ZU_XUAN_5:
                    priBetNumbers.add(priBetNumber0);
                    priBetNumbers.add(priBetNumber1);
                    priBetNumbers.get(0).addAll(Arrays.asList(fourNumber));
                    priBetNumbers.get(1).addAll(Arrays.asList(twoNumber));
                    break;
            }
            //四星
            if (lotteryType instanceof Sixing) {
                Sixing sixingType = (Sixing) lotteryType;
                for (List<String> list : priBetNumbers) {
                    list.clear();
                }
                switch (sixingType) {
                    case SI_XING_ZHI_XUAN_ZU_HE:
                    case SI_XING_ZHI_XUAN_FU_SHI:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.add(priBetNumber1);
                        priBetNumbers.add(priBetNumber2);
                        priBetNumbers.add(priBetNumber3);
                        priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                        priBetNumbers.get(1).addAll(Arrays.asList(threeNumber));
                        priBetNumbers.get(2).addAll(Arrays.asList(twoNumber));
                        priBetNumbers.get(3).addAll(Arrays.asList(fiveNumber));
                        break;
                    case SI_XING_ZHI_XUAN_DAN_SHI:
                        priBetNumbers.add(priBetNumber0);
                        for (int i = 0; i < 8; i++) {
                            priBetNumbers.get(0).add(String.valueOf(i));
                        }
                        break;
                    case ZU_XUAN_24:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).addAll(Arrays.asList(fiveNumber));
                        break;
                    case ZU_XUAN_12:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.add(priBetNumber1);
                        priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                        priBetNumbers.get(1).addAll(Arrays.asList(threeNumber));
                        break;
                    case ZU_XUAN_6:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                        break;
                    case ZU_XUAN_4:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.add(priBetNumber1);
                        priBetNumbers.get(0).addAll(Arrays.asList(threeNumber));
                        priBetNumbers.get(1).addAll(Arrays.asList(fiveNumber));
                        break;
                }
            }
            //三星
            if (lotteryType instanceof Sanxing) {
                Sanxing sanxingType = (Sanxing) lotteryType;
                for (List<String> list : priBetNumbers) {
                    list.clear();
                }
                switch (sanxingType) {
                    case HOU_SAN_FU_SHI:
                    case ZHONG_SAN_FU_SHI:
                    case QIAN_SAN_FU_SHI:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.add(priBetNumber1);
                        priBetNumbers.add(priBetNumber2);
                        priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                        priBetNumbers.get(1).addAll(Arrays.asList(threeNumber));
                        priBetNumbers.get(2).addAll(Arrays.asList(twoNumber));
                        break;
                    case HOU_SAN_DAN_SHI:
                    case ZHONG_SAN_DAN_SHI:
                    case QIAN_SAN_DAN_SHI:
                        priBetNumbers.add(priBetNumber0);
                        for (int i = 0; i < 6; i++) {
                            priBetNumbers.get(0).add(String.valueOf(i));
                        }
                        break;
                    case HOU_SAN_ZHI_XUAN_HE_ZHI:
                    case ZHONG_SAN_ZHI_XUAN_HE_ZHI:
                    case QIAN_SAN_ZHI_XUAN_HE_ZHI:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).add("9");
                        priBetNumbers.get(0).add("2");
                        break;
                    case HOU_SAN_ZU_SAN:
                    case ZHONG_SAN_ZU_SAN:
                    case QIAN_SAN_ZU_SAN:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).add("9");
                        priBetNumbers.get(0).add("6");
                        priBetNumbers.get(0).add("5");
                        break;
                    case HOU_SAN_HUN_HE_ZU_XUAN:
                    case ZHONG_SAN_HUN_HE_ZU_XUAN:
                    case QIAN_SAN_HUN_HE_ZU_XUAN:
                    case HOU_SAN_ZU_LIU:
                    case ZHONG_SAN_ZU_LIU:
                    case QIAN_SAN_ZU_LIU:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).addAll(Arrays.asList(fiveNumber));
                        break;
                    case HOU_SAN_ZU_XUAN_HE_ZHI:
                    case ZHONG_SAN_ZU_XUAN_HE_ZHI:
                    case QIAN_SAN_ZU_XUAN_HE_ZHI:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                        break;
                }
            }
            if (lotteryType instanceof Erxing) {
                Erxing erxingType = (Erxing) lotteryType;
                for (List<String> list : priBetNumbers) {
                    list.clear();
                }
                switch (erxingType) {
                    case HOU_ER_ZHI_XUAN_FU_SHI:
                    case QIAN_ER_ZHI_XUAN_FU_SHI:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.add(priBetNumber1);
                        priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                        priBetNumbers.get(1).addAll(Arrays.asList(threeNumber));
                        break;
                    case HOU_ER_ZU_XUAN_DAN_SHI:
                    case QIAN_ER_ZU_XUAN_DAN_SHI:
                    case HOU_ER_ZHI_XUAN_DAN_SHI:
                    case QIAN_ER_ZHI_XUAN_DAN_SHI:
                        priBetNumbers.add(priBetNumber0);
                        for (int i = 0; i < 4; i++) {
                            priBetNumbers.get(0).add(String.valueOf(i));
                        }
                        break;
                    case HOU_ER_ZU_XUAN_HE_ZHI:
                    case QIAN_ER_ZU_XUAN_HE_ZHI:
                    case HOU_ER_ZU_XUAN_FU_SHI:
                    case QIAN_ER_ZU_XUAN_FU_SHI:
                    case HOU_ER_ZHI_XUAN_HE_ZHI:
                    case QIAN_ER_ZHI_XUAN_HE_ZHI:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).addAll(Arrays.asList(fourNumber));
                        break;
                }
            }
            if (lotteryType instanceof Yixing) {
                Yixing yixingType = (Yixing) lotteryType;
                priBetNumber0.clear();
                switch (yixingType) {
                    case YI_XING_DING_WEI_DAN:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).addAll(Arrays.asList(twoNumber));
                        break;
                }
            }
            if (lotteryType instanceof Budingdan) {
                Budingdan budingdanType = (Budingdan) lotteryType;
                priBetNumber0.clear();
                switch (budingdanType) {
                    case HOU_SAN_ER_MA:
                    case QIAN_SAN_ER_MA:
                    case HOU_SAN_YI_MA:
                    case QIAN_SAN_YI_MA:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).addAll(Arrays.asList(fourNumber));
                        break;
                }
            }
            if (lotteryType instanceof Daxiaodanshuang) {
                Daxiaodanshuang daxiaodanshuangType = (Daxiaodanshuang) lotteryType;
                priBetNumber0.clear();
                priBetNumber1.clear();
                switch (daxiaodanshuangType) {
                    case HOU_ER_DA_XIAO_DAN_SHUANG:
                    case QIAN_ER_DA_XIAO_DAN_SHUANG:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.add(priBetNumber1);
                        priBetNumbers.get(0).add("大");
                        priBetNumbers.get(0).add("双");
                        priBetNumbers.get(1).add("小");
                        priBetNumbers.get(1).add("单");
                        break;
                    case ZONG_HE_DA_XIAO_DAN_SHUANG:
                        priBetNumbers.add(priBetNumber0);
                        priBetNumbers.get(0).add("单");
                        priBetNumbers.get(0).add("小");
                        break;
                }
            }
            if (lotteryType instanceof Quwei) {
                Quwei quweiType = (Quwei) lotteryType;
                priBetNumber0.clear();
                switch (quweiType) {
                    case SI_JI_FA_CAI:
                    case SAN_XING_BAO_XI:
                    case HAO_SHI_CHENG_SHUANG:
                    case YI_FAN_FENG_SHUN:
                        priBetNumber0.addAll(Arrays.asList(sixNumber));
                        priBetNumbers.add(priBetNumber0);
                        break;
                }
            }
        }

    }

    /**
     * Method: getBetCount(List<List<String>> betNumbers, LotteryType lotteryType)
     */
    @Test
    public void testGetBetCount() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<List<String>> betNumbers)
     */
    @Test
    public void testGetBoundsInfoOfLottery() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getBatchBoundsInfoOfLottery(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBatchBoundsInfoOfLottery() throws Exception {
//TODO: Test goes here... 
    }

    /**
     * Method: getBoundsInfoOfWuxing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfWuxing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfWuxing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfSixing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfSixing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfSixing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfSanxing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfSanxing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfSanxing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfErxing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfErxing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfErxing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfYixing(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfYixing() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfYixing", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfBudingdan(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfBudingdan() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfBudingdan", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfDaxiaodanshuang(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfDaxiaodanshuang() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfDaxiaodanshuang", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBoundsInfoOfQuwei(LotteryType lotteryType, String kj, List<LotteryOrder> lotteryOrderList)
     */
    @Test
    public void testGetBoundsInfoOfQuwei() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBoundsInfoOfQuwei", LotteryType.class, String.class, List<LotteryOrder>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: getBetNumbers(LotteryType lotteryType, List<List<String>> betNumbers)
     */
    @Test
    public void testGetBetNumbers() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("getBetNumbers", LotteryType.class, List<List<String>>.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu120(String kjStr)
     */
    @Test
    public void testCheckIsZu120() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu120", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu60(String kjStr)
     */
    @Test
    public void testCheckIsZu60() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu60", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu30(String kjStr)
     */
    @Test
    public void testCheckIsZu30() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu30", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu20(String kjStr)
     */
    @Test
    public void testCheckIsZu20() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu20", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu10(String kjStr)
     */
    @Test
    public void testCheckIsZu10() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu10", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu5(String kjStr)
     */
    @Test
    public void testCheckIsZu5() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu5", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu24(String kjStr)
     */
    @Test
    public void testCheckIsZu24() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu24", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu12(String kjStr)
     */
    @Test
    public void testCheckIsZu12() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu12", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu6(String kjStr)
     */
    @Test
    public void testCheckIsZu6() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu6", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu4(String kjStr)
     */
    @Test
    public void testCheckIsZu4() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu4", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsSanxingZu6(String kjStr)
     */
    @Test
    public void testCheckIsSanxingZu6() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsSanxingZu6", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsSanxingZuHe(String kjStr)
     */
    @Test
    public void testCheckIsSanxingZuHe() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsSanxingZuHe", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsZu3(String kjStr)
     */
    @Test
    public void testCheckIsZu3() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsZu3", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

    /**
     * Method: checkIsErxingFuShi(String kjStr)
     */
    @Test
    public void testCheckIsErxingFuShi() throws Exception {
//TODO: Test goes here... 
/* 
try { 
   Method method = ShishicaiServiceImpl.getClass().getMethod("checkIsErxingFuShi", String.class); 
   method.setAccessible(true); 
   method.invoke(<Object>, <Parameters>); 
} catch(NoSuchMethodException e) { 
} catch(IllegalAccessException e) { 
} catch(InvocationTargetException e) { 
} 
*/
    }

} 
