package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/10/13.
 */
// 传统盘PK10
public enum LotteryPK10Type implements LotteryType {

    GUAN_JUN_FU_SHI(61601L, "冠军复式"),

    QIAN_ER_FU_SHI(61602L, "前二复式"),
    QIAN_ER_DAN_SHI(61603L, "前二单式"),

    QIAN_SAN_FU_SHI(61604L, "前三复式"),
    QIAN_SAN_DAN_SHI(61503L, "前三单式"),

    QIAN_SI_FU_SHI(61504L, "前四复式"),
    QIAN_SI_DAN_SHI(61505L, "前四单式"),

    QIAN_WU_FU_SHI(61506L, "前五复式"),
    QIAN_WU_DAN_SHI(61507L, "前五单式"),

    QIAN_LIU_FU_SHI(61508L, "前六复式"),
    QIAN_LIU_DAN_SHI(61509L, "前六单式"),

    DING_WEI_DAN(61510L, "定位胆"),

    QIAN_SAN_HE_ZHI(61511L, "前三和值"),
    HOU_SAN_HE_ZHI(61512L, "后三和值"),

    // 大小单双
    GUAN_DA_XIAO_DAN_SHUANG(61701L, "冠军大小单双"),
    YA_DA_XIAO_DAN_SHUANG(61702L, "亚军大小单双"),
    THIRD_DA_XIAO_DAN_SHUANG(61703L, "季军大小单双"),

    DAN_HAO_GUAN_LONG_HU(61904L, "冠军龙虎"),
    DAN_HAO_YA_LONG_HU(61905L, "亚军龙虎"),
    DAN_HAO_THIRD_LONG_HU(61906L, "第三名龙虎"),
    DAN_HAO_FORTH_LONG_HU(63005L, "第四名龙虎"),
    DAN_HAO_FIFTH_LONG_HU(63006L, "第五名龙虎"),

    JING_SU(61801L, "竞速");

    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    LotteryPK10Type(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, LotteryPK10Type> maps = new HashMap<>();

    static {
        for (LotteryPK10Type type : LotteryPK10Type.values())
            maps.put(type.value(), type);
    }

    public static LotteryPK10Type parse(long value) {
        return maps.get(value);
    }

}
