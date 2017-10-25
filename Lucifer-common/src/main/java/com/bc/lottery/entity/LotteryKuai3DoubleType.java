package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/10/13.
 */
// 双面盘快3
public enum LotteryKuai3DoubleType implements LotteryType {

    SAN_JUN_1(61101L, "三军1"),
    SAN_JUN_2(61102L, "三军2"),
    SAN_JUN_3(61103L, "三军3"),
    SAN_JUN_4(61104L, "三军4"),
    SAN_JUN_5(61105L, "三军5"),
    SAN_JUN_6(61106L, "三军6"),

    WEI_SHAI_1(63101L, "围骰1"),
    WEI_SHAI_2(63102L, "围骰2"),
    WEI_SHAI_3(63103L, "围骰3"),
    WEI_SHAI_4(63104L, "围骰4"),
    WEI_SHAI_5(63105L, "围骰5"),
    WEI_SHAI_6(63106L, "围骰6"),
    QUAN_SHAI(63107L, "全骰"),

    DIAN_SHU_HE_4(64101L, "点数4"),
    DIAN_SHU_HE_5(64102L, "点数5"),
    DIAN_SHU_HE_6(64103L, "点数6"),
    DIAN_SHU_HE_7(64104L, "点数7"),
    DIAN_SHU_HE_8(64105L, "点数8"),
    DIAN_SHU_HE_9(64106L, "点数9"),
    DIAN_SHU_HE_10(64107L, "点数10"),
    DIAN_SHU_HE_11(64108L, "点数11"),
    DIAN_SHU_HE_12(64109L, "点数12"),
    DIAN_SHU_HE_13(64110L, "点数13"),
    DIAN_SHU_HE_14(64111L, "点数14"),
    DIAN_SHU_HE_15(64112L, "点数15"),
    DIAN_SHU_HE_16(64113L, "点数16"),
    DIAN_SHU_HE_17(64114L, "点数17"),

    SAN_JUN_大(61115L, "三军大"),
    SAN_JUN_小(61116L, "三军小"),

    CHANG_PAI_12(62101L, "长牌12"),
    CHANG_PAI_13(62102L, "长牌13"),
    CHANG_PAI_14(62103L, "长牌14"),
    CHANG_PAI_15(62104L, "长牌15"),
    CHANG_PAI_16(62105L, "长牌16"),

    CHANG_PAI_23(62106L, "长牌23"),
    CHANG_PAI_24(62107L, "长牌24"),
    CHANG_PAI_25(62108L, "长牌25"),
    CHANG_PAI_26(62109L, "长牌26"),

    CHANG_PAI_34(62110L, "长牌34"),
    CHANG_PAI_35(62111L, "长牌35"),
    CHANG_PAI_36(62112L, "长牌36"),

    CHANG_PAI_45(62113L, "长牌45"),
    CHANG_PAI_46(62114L, "长牌46"),
    CHANG_PAI_56(62115L, "长牌56"),

    DUAN_PAI_1(63201L, "短牌1"),
    DUAN_PAI_2(63202L, "短牌2"),
    DUAN_PAI_3(63203L, "短牌3"),
    DUAN_PAI_4(63204L, "短牌4"),
    DUAN_PAI_5(63205L, "短牌5"),
    DUAN_PAI_6(63206L, "短牌6");

    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    LotteryKuai3DoubleType(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, LotteryKuai3DoubleType> maps = new HashMap<>();

    static {
        for (LotteryKuai3DoubleType type : LotteryKuai3DoubleType.values())
            maps.put(type.value(), type);
    }

    public static LotteryKuai3DoubleType parse(long value) {
        return maps.get(value);
    }

}
