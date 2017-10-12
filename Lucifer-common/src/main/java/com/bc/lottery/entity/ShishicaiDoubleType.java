package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/9/13.
 */
// 时时彩双面盘
public enum ShishicaiDoubleType implements LotteryType {

    ZONG_HE_DA(2912L, "总和大"),
    ZONG_HE_XIAO(2912L, "总和小"),
    ZONG_HE_DAN(2912L, "总和单"),
    ZONG_HE_SHUANG(2912L, "总和双"),
    ZONG_HE_LONG(2913L, "总和龙"),
    ZONG_HE_HU(2913L, "总和虎"),
    ZONG_HE_HE(2914L, "总和和"),

    YI_QIU_DA(2915L, "一球大"),
    YI_QIU_XIAO(2915L, "一球小"),
    YI_QIU_DAN(2915L, "一球单"),
    YI_QIU_SHUANG(2915L, "一球双"),

    ER_QIU_DA(2916L, "二球大"),
    ER_QIU_XIAO(2916L, "二球小"),
    ER_QIU_DAN(2916L, "二球单"),
    ER_QIU_SHUANG(2916L, "二球双"),

    SAN_QIU_DA(2917L, "三球大"),
    SAN_QIU_XIAO(2917L, "三球小"),
    SAN_QIU_DAN(2917L, "三球单"),
    SAN_QIU_SHUANG(2917L, "三球双"),

    SI_QIU_DA(2918L, "四球大"),
    SI_QIU_XIAO(2918L, "四球小"),
    SI_QIU_DAN(2918L, "四球单"),
    SI_QIU_SHUANG(2918L, "四球双"),

    WU_QIU_DA(2919L, "五球大"),
    WU_QIU_XIAO(2919L, "五球小"),
    WU_QIU_DAN(2919L, "五球单"),
    WU_QIU_SHUANG(2919L, "五球双"),

    YI_QIU_DING_WEI_DAN_0(2920L, "一球定位胆0"),
    YI_QIU_DING_WEI_DAN_1(2920L, "一球定位胆1"),
    YI_QIU_DING_WEI_DAN_2(2920L, "一球定位胆2"),
    YI_QIU_DING_WEI_DAN_3(2920L, "一球定位胆3"),
    YI_QIU_DING_WEI_DAN_4(2920L, "一球定位胆4"),
    YI_QIU_DING_WEI_DAN_5(2920L, "一球定位胆5"),
    YI_QIU_DING_WEI_DAN_6(2920L, "一球定位胆6"),
    YI_QIU_DING_WEI_DAN_7(2920L, "一球定位胆7"),
    YI_QIU_DING_WEI_DAN_8(2920L, "一球定位胆8"),
    YI_QIU_DING_WEI_DAN_9(2920L, "一球定位胆9"),

    ER_QIU_DING_WEI_DAN_0(2921L, "二球定位胆0"),
    ER_QIU_DING_WEI_DAN_1(2921L, "二球定位胆1"),
    ER_QIU_DING_WEI_DAN_2(2921L, "二球定位胆2"),
    ER_QIU_DING_WEI_DAN_3(2921L, "二球定位胆3"),
    ER_QIU_DING_WEI_DAN_4(2921L, "二球定位胆4"),
    ER_QIU_DING_WEI_DAN_5(2921L, "二球定位胆5"),
    ER_QIU_DING_WEI_DAN_6(2921L, "二球定位胆6"),
    ER_QIU_DING_WEI_DAN_7(2921L, "二球定位胆7"),
    ER_QIU_DING_WEI_DAN_8(2921L, "二球定位胆8"),
    ER_QIU_DING_WEI_DAN_9(2921L, "二球定位胆9"),

    SAN_QIU_DING_WEI_DAN_0(2922L, "三球定位胆0"),
    SAN_QIU_DING_WEI_DAN_1(2922L, "三球定位胆1"),
    SAN_QIU_DING_WEI_DAN_2(2922L, "三球定位胆2"),
    SAN_QIU_DING_WEI_DAN_3(2922L, "三球定位胆3"),
    SAN_QIU_DING_WEI_DAN_4(2922L, "三球定位胆4"),
    SAN_QIU_DING_WEI_DAN_5(2922L, "三球定位胆5"),
    SAN_QIU_DING_WEI_DAN_6(2922L, "三球定位胆6"),
    SAN_QIU_DING_WEI_DAN_7(2922L, "三球定位胆7"),
    SAN_QIU_DING_WEI_DAN_8(2922L, "三球定位胆8"),
    SAN_QIU_DING_WEI_DAN_9(2922L, "三球定位胆9"),

    SI_QIU_DING_WEI_DAN_0(2923L, "四球定位胆0"),
    SI_QIU_DING_WEI_DAN_1(2923L, "四球定位胆1"),
    SI_QIU_DING_WEI_DAN_2(2923L, "四球定位胆2"),
    SI_QIU_DING_WEI_DAN_3(2923L, "四球定位胆3"),
    SI_QIU_DING_WEI_DAN_4(2923L, "四球定位胆4"),
    SI_QIU_DING_WEI_DAN_5(2923L, "四球定位胆5"),
    SI_QIU_DING_WEI_DAN_6(2923L, "四球定位胆6"),
    SI_QIU_DING_WEI_DAN_7(2923L, "四球定位胆7"),
    SI_QIU_DING_WEI_DAN_8(2923L, "四球定位胆8"),
    SI_QIU_DING_WEI_DAN_9(2923L, "四球定位胆9"),

    WU_QIU_DING_WEI_DAN_0(2924L, "五球定位胆0"),
    WU_QIU_DING_WEI_DAN_1(2924L, "五球定位胆1"),
    WU_QIU_DING_WEI_DAN_2(2924L, "五球定位胆2"),
    WU_QIU_DING_WEI_DAN_3(2924L, "五球定位胆3"),
    WU_QIU_DING_WEI_DAN_4(2924L, "五球定位胆4"),
    WU_QIU_DING_WEI_DAN_5(2924L, "五球定位胆5"),
    WU_QIU_DING_WEI_DAN_6(2924L, "五球定位胆6"),
    WU_QIU_DING_WEI_DAN_7(2924L, "五球定位胆7"),
    WU_QIU_DING_WEI_DAN_8(2924L, "五球定位胆8"),
    WU_QIU_DING_WEI_DAN_9(2924L, "五球定位胆9"),

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
