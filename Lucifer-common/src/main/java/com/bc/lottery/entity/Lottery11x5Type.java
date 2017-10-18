package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/9/13.
 */
//11选5传统盘
public enum Lottery11x5Type implements LotteryType {

    // 三码
    QIAN_SAN_ZHI_XUAN_FU_SHI(311L, "前三直选复式"),
    QIAN_SAN_ZHI_XUAN_DAN_SHI(312L, "前三直选单式"),

    QIAN_SAN_ZU_XUAN_FU_SHI(311L, "前三组选复式"),
    QIAN_SAN_ZU_XUAN_DAN_SHI(311L, "前三组选复式"),

    // 二码
    QIAN_ER_ZHI_XUAN_FU_SHI(614L, "前二直选复式"),
    QIAN_ER_ZHI_XUAN_DAN_SHI(615L, "前二直选单式"),

    QIAN_ER_ZU_XUAN_FU_SHI(624L, "前二组选复式"),
    QIAN_ER_ZU_XUAN_DAN_SHI(625L, "前二组选单式"),

    // 不定胆
    QIAN_SAN_YI_MA(813L, "前三一码"),

    // 定位胆(前三)
    YI_XING_DING_WEI_DAN(711L, "定位胆"),

    // 趣味
    DING_DAN_SHUANG(101L, "定单双"),
    CAI_ZHONG_WEI(102L, "猜中位"),

    // 任选复式
    FU_SHI_YI_ZHONG_YI(211L, "任选复式一中一"),
    FU_SHI_ER_ZHONG_ER(211L, "任选复式二中二"),
    FU_SHI_SAN_ZHONG_SAN(211L, "任选复式三中三"),
    FU_SHI_SI_ZHONG_SI(211L, "任选复式四中四"),
    FU_SHI_WU_ZHONG_WU(211L, "任选复式五中五"),
    FU_SHI_LIU_ZHONG_WU(211L, "任选复式六中五"),
    FU_SHI_QI_ZHONG_WU(211L, "任选复式七中五"),
    FU_SHI_BA_ZHONG_WU(211L, "任选复式八中五"),

    // 任选单式
    DAN_SHI_YI_ZHONG_YI(211L, "任选单式一中一"),
    DAN_SHI_ER_ZHONG_ER(211L, "任选单式二中二"),
    DAN_SHI_SAN_ZHONG_SAN(211L, "任选单式三中三"),
    DAN_SHI_SI_ZHONG_SI(211L, "任选单式四中四"),
    DAN_SHI_WU_ZHONG_WU(211L, "任选单式五中五"),
    DAN_SHI_LIU_ZHONG_WU(211L, "任选单式六中五"),
    DAN_SHI_QI_ZHONG_WU(211L, "任选单式七中五"),
    DAN_SHI_BA_ZHONG_WU(211L, "任选单式八中五");

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
