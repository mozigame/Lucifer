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
    SAN_JUN_大(61107L, "三军大"),
    SAN_JUN_小(61108L, "三军小"),

    WEI_SHAI_1(61201L, "围骰1"),
    WEI_SHAI_2(61202L, "围骰2"),
    WEI_SHAI_3(61203L, "围骰3"),
    WEI_SHAI_4(61204L, "围骰4"),
    WEI_SHAI_5(61205L, "围骰5"),
    WEI_SHAI_6(61206L, "围骰6"),
    QUAN_SHAI(61207L, "全骰"),

    DIAN_SHU_HE_4(61304L, "点数4"),
    DIAN_SHU_HE_5(61305L, "点数5"),
    DIAN_SHU_HE_6(61306L, "点数6"),
    DIAN_SHU_HE_7(61307L, "点数7"),
    DIAN_SHU_HE_8(61308L, "点数8"),
    DIAN_SHU_HE_9(61309L, "点数9"),
    DIAN_SHU_HE_10(61310L, "点数10"),
    DIAN_SHU_HE_11(61311L, "点数11"),
    DIAN_SHU_HE_12(61312L, "点数12"),
    DIAN_SHU_HE_13(61313L, "点数13"),
    DIAN_SHU_HE_14(61314L, "点数14"),
    DIAN_SHU_HE_15(61315L, "点数15"),
    DIAN_SHU_HE_16(61316L, "点数16"),
    DIAN_SHU_HE_17(61317L, "点数17"),

    CHANG_PAI_12(61412L, "长牌12"),
    CHANG_PAI_13(61413L, "长牌13"),
    CHANG_PAI_14(61414L, "长牌14"),
    CHANG_PAI_15(61415L, "长牌15"),
    CHANG_PAI_16(61416L, "长牌16"),

    CHANG_PAI_23(61417L, "长牌23"),
    CHANG_PAI_24(61418L, "长牌24"),
    CHANG_PAI_25(61419L, "长牌25"),
    CHANG_PAI_26(61420L, "长牌26"),

    CHANG_PAI_34(61421L, "长牌34"),
    CHANG_PAI_35(61422L, "长牌35"),
    CHANG_PAI_36(61423L, "长牌36"),

    CHANG_PAI_45(61424L, "长牌45"),
    CHANG_PAI_46(61425L, "长牌46"),
    CHANG_PAI_56(61426L, "长牌56"),

    DUAN_PAI_1(61501L, "短牌1"),
    DUAN_PAI_2(61502L, "短牌2"),
    DUAN_PAI_3(61503L, "短牌3"),
    DUAN_PAI_4(61504L, "短牌4"),
    DUAN_PAI_5(61505L, "短牌5"),
    DUAN_PAI_6(61506L, "短牌6");

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
