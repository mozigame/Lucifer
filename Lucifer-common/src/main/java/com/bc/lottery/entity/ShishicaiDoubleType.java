package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/9/13.
 */
// 时时彩双面盘
public enum ShishicaiDoubleType implements LotteryType {

    ZONG_HE_DA_XIAO_DAN_SHUANG(2912L, "总和大小单双"),
    ZONG_HE_LONG_HU(2913L, "总和龙虎"),
    ZONG_HE_LONG_HU_HE(2914L, "总和龙虎和"),

    YI_QIU_DA_XIAO_DAN_SHUANG(2915L, "一球大小单双"),
    ER_QIU_DA_XIAO_DAN_SHUANG(2916L, "二球大小单双"),
    SAN_QIU_DA_XIAO_DAN_SHUANG(2917L, "三球大小单双"),
    SI_QIU_DA_XIAO_DAN_SHUANG(2918L, "四球大小单双"),
    WU_QIU_DA_XIAO_DAN_SHUANG(2919L, "五球大小单双"),

    YI_QIU_DING_WEI_DAN(2920L, "一球定位胆"),
    ER_QIU_DING_WEI_DAN(2921L, "二球定位胆"),
    SAN_QIU_DING_WEI_DAN(2922L, "三球定位胆"),
    SI_QIU_DING_WEI_DAN(2923L, "四球定位胆"),
    WU_QIU_DING_WEI_DAN(2924L, "五球定位胆"),


    // 特殊玩法
    QIAN_SAN_BAO_ZI(2111L, "前三豹子"),
    QIAN_SAN_SHUN_ZI(2111L, "前三顺子"),
    QIAN_SAN_DUI_ZI(2111L, "前三对子"),
    QIAN_SAN_BAN_SHUN(2111L, "前三半顺"),
    QIAN_SAN_ZA_LIU(2111L, "前三杂六"),

    ZHONG_SAN_BAO_ZI(2111L, "中三豹子"),
    ZHONG_SAN_SHUN_ZI(2111L, "中三顺子"),
    ZHONG_SAN_DUI_ZI(2111L, "中三对子"),
    ZHONG_SAN_BAN_SHUN(2111L, "中三半顺"),
    ZHONG_SAN_ZA_LIU(2111L, "中三杂六"),

    HOU_SAN_BAO_ZI(2111L, "后三豹子"),
    HOU_SAN_SHUN_ZI(2111L, "后三顺子"),
    HOU_SAN_DUI_ZI(2111L, "后三对子"),
    HOU_SAN_BAN_SHUN(2111L, "后三半顺"),
    HOU_SAN_ZA_LIU(2111L, "后三杂六");

    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    ShishicaiDoubleType(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, ShishicaiDoubleType> maps = new HashMap<>();

    static {
        for (ShishicaiDoubleType type : ShishicaiDoubleType.values())
            maps.put(type.value(), type);
    }

    public static ShishicaiDoubleType parse(long value) {
        return maps.get(value);
    }

}
