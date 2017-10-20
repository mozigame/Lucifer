package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/10/13.
 */
// 双面盘快3
public enum LotteryKuai3DoubleType implements LotteryType {

    SAN_JUN_1(41601L, "三军1"),
    SAN_JUN_2(41601L, "三军2"),
    SAN_JUN_3(41601L, "三军3"),
    SAN_JUN_4(41601L, "三军4"),
    SAN_JUN_5(41601L, "三军5"),
    SAN_JUN_6(41601L, "三军6"),
    SAN_JUN_大(41601L, "三军大"),
    SAN_JUN_小(41601L, "三军小"),

    WEI_SHAI_1(41602L, "围骰1"),
    WEI_SHAI_2(41602L, "围骰2"),
    WEI_SHAI_3(41602L, "围骰3"),
    WEI_SHAI_4(41602L, "围骰4"),
    WEI_SHAI_5(41602L, "围骰5"),
    WEI_SHAI_6(41602L, "围骰6"),
    QUAN_SHAI(41602L, "全骰"),

    DIAN_SHU_HE_4(41101L, "点数4"),
    DIAN_SHU_HE_5(41101L, "点数5"),
    DIAN_SHU_HE_6(41101L, "点数6"),
    DIAN_SHU_HE_7(41101L, "点数7"),
    DIAN_SHU_HE_8(41101L, "点数8"),
    DIAN_SHU_HE_9(41101L, "点数9"),
    DIAN_SHU_HE_10(41101L, "点数10"),
    DIAN_SHU_HE_11(41101L, "点数11"),
    DIAN_SHU_HE_12(41101L, "点数12"),
    DIAN_SHU_HE_13(41101L, "点数13"),
    DIAN_SHU_HE_14(41101L, "点数14"),
    DIAN_SHU_HE_15(41101L, "点数15"),
    DIAN_SHU_HE_16(41101L, "点数16"),
    DIAN_SHU_HE_17(41101L, "点数17"),

    CHANG_PAI_12(41101L, "长牌12"),
    CHANG_PAI_13(41101L, "长牌13"),
    CHANG_PAI_14(41101L, "长牌14"),
    CHANG_PAI_15(41101L, "长牌15"),
    CHANG_PAI_16(41101L, "长牌16"),

    CHANG_PAI_24(41101L, "长牌24"),
    CHANG_PAI_25(41101L, "长牌25"),
    CHANG_PAI_26(41101L, "长牌26"),

    CHANG_PAI_34(41101L, "长牌34"),
    CHANG_PAI_35(41101L, "长牌35"),
    CHANG_PAI_36(41101L, "长牌36"),

    CHANG_PAI_45(41101L, "长牌45"),
    CHANG_PAI_46(41101L, "长牌46"),
    CHANG_PAI_56(41101L, "长牌56"),

    DUAN_PAI_1(41102L, "短牌1"),
    DUAN_PAI_2(41102L, "短牌2"),
    DUAN_PAI_3(41102L, "短牌3"),
    DUAN_PAI_4(41102L, "短牌4"),
    DUAN_PAI_5(41102L, "短牌5"),
    DUAN_PAI_6(41102L, "短牌6");

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
