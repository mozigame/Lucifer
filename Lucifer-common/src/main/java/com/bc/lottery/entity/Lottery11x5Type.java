package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/9/13.
 */
//11选5传统盘
public enum Lottery11x5Type implements LotteryType {

    // 三码
    QIAN_SAN_ZHI_XUAN_FU_SHI(31101L, "前三直选复式"),
    QIAN_SAN_ZHI_XUAN_DAN_SHI(31102L, "前三直选单式"),

    QIAN_SAN_ZU_XUAN_FU_SHI(32101L, "前三组选复式"),
    QIAN_SAN_ZU_XUAN_DAN_SHI(32201L, "前三组选单式"),

    // 二码
    QIAN_ER_ZHI_XUAN_FU_SHI(33101L, "前二直选复式"),
    QIAN_ER_ZHI_XUAN_DAN_SHI(33201L, "前二直选单式"),

    QIAN_ER_ZU_XUAN_FU_SHI(34101L, "前二组选复式"),
    QIAN_ER_ZU_XUAN_DAN_SHI(34201L, "前二组选单式"),

    // 不定胆
    QIAN_SAN_YI_MA(35101L, "前三一码"),

    // 定位胆(前三)
    YI_XING_DING_WEI_DAN(36101L, "定位胆"),

    // 趣味
    DING_DAN_SHUANG_0(37101L, "定单双-0双5单"),
    DING_DAN_SHUANG_1(37102L, "定单双-1双4单"),
    DING_DAN_SHUANG_2(37103L, "定单双-2双3单"),
    DING_DAN_SHUANG_3(37104L, "定单双-3双2单"),
    DING_DAN_SHUANG_4(37105L, "定单双-4双1单"),
    DING_DAN_SHUANG_5(37106L, "定单双-5双0单"),

    CAI_ZHONG_WEI_3(37201L, "猜中位号源3"),
    CAI_ZHONG_WEI_4(37202L, "猜中位号源4"),
    CAI_ZHONG_WEI_5(37203L, "猜中位号源5"),
    CAI_ZHONG_WEI_6(37204L, "猜中位号源6"),
    CAI_ZHONG_WEI_7(37205L, "猜中位号源7"),
    CAI_ZHONG_WEI_8(37206L, "猜中位号源8"),
    CAI_ZHONG_WEI_9(37207L, "猜中位号源9"),

    // 任选复式
    FU_SHI_YI_ZHONG_YI(38101L, "任选复式一中一"),
    FU_SHI_ER_ZHONG_ER(38201L, "任选复式二中二"),
    FU_SHI_SAN_ZHONG_SAN(38301L, "任选复式三中三"),
    FU_SHI_SI_ZHONG_SI(38401L, "任选复式四中四"),
    FU_SHI_WU_ZHONG_WU(38501L, "任选复式五中五"),
    FU_SHI_LIU_ZHONG_WU(38601L, "任选复式六中五"),
    FU_SHI_QI_ZHONG_WU(38701L, "任选复式七中五"),
    FU_SHI_BA_ZHONG_WU(38801L, "任选复式八中五"),

    // 任选单式
    DAN_SHI_YI_ZHONG_YI(39101L, "任选单式一中一"),
    DAN_SHI_ER_ZHONG_ER(39201L, "任选单式二中二"),
    DAN_SHI_SAN_ZHONG_SAN(39301L, "任选单式三中三"),
    DAN_SHI_SI_ZHONG_SI(39401L, "任选单式四中四"),
    DAN_SHI_WU_ZHONG_WU(39501L, "任选单式五中五"),
    DAN_SHI_LIU_ZHONG_WU(39601L, "任选单式六中五"),
    DAN_SHI_QI_ZHONG_WU(39701L, "任选单式七中五"),
    DAN_SHI_BA_ZHONG_WU(39801L, "任选单式八中五");

    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    Lottery11x5Type(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, Lottery11x5Type> maps = new HashMap<>();

    static {
        for (Lottery11x5Type type : Lottery11x5Type.values())
            maps.put(type.value(), type);
    }

    public static Lottery11x5Type parse(long value) {
        return maps.get(value);
    }

}
