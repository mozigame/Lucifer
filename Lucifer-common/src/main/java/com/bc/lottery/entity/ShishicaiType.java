package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/9/13.
 */
//时时彩传统盘
public enum ShishicaiType implements LotteryType {

    // 五星
    WU_XING_ZHI_XUAN_FU_SHI(111L, "五星直选复式"),
    WU_XING_ZHI_XUAN_DAN_SHI(112L, "五星直选单式"),
    WU_XING_ZHI_XUAN_ZU_HE(113L, "五星直选组合"),

    ZU_XUAN_120(121L, "组选120"),
    ZU_XUAN_60(122L, "组选60"),
    ZU_XUAN_30(123L, "组选30"),
    ZU_XUAN_20(124L, "组选20"),
    ZU_XUAN_10(125L, "组选10"),
    ZU_XUAN_5(126L, "组选5"),

    // 四星
    SI_XING_ZHI_XUAN_FU_SHI(211L, "四星直选复式"),
    SI_XING_ZHI_XUAN_DAN_SHI(212L, "四星直选单式"),
    SI_XING_ZHI_XUAN_ZU_HE(213L, "四星直选组合"),

    ZU_XUAN_24(221L, "组选24"),
    ZU_XUAN_12(222L, "组选12"),
    ZU_XUAN_6(223L, "组选6"),
    ZU_XUAN_4(224L, "组选4"),

    // 三星
    QIAN_SAN_FU_SHI(311L, "前三复式"),
    ZHONG_SAN_FU_SHI(411L, "中三复式"),
    HOU_SAN_FU_SHI(511L, "后三复式"),

    QIAN_SAN_DAN_SHI(312L, "前三单式"),
    ZHONG_SAN_DAN_SHI(412L, "中三单式"),
    HOU_SAN_DAN_SHI(512L, "后三单式"),

    QIAN_SAN_ZHI_XUAN_HE_ZHI(313L, "前三直选和值"),
    ZHONG_SAN_ZHI_XUAN_HE_ZHI(413L, "中三直选和值"),
    HOU_SAN_ZHI_XUAN_HE_ZHI(513L, "后三直选和值"),

    QIAN_SAN_ZU_SAN(321L, "前三组三"),
    ZHONG_SAN_ZU_SAN(421L,"中三组三"),
    HOU_SAN_ZU_SAN(521L, "后三组三"),

    QIAN_SAN_ZU_LIU(322L, "前三组六"),
    ZHONG_SAN_ZU_LIU(422L, "中三组六"),
    HOU_SAN_ZU_LIU(522L, "后三组六"),

    QIAN_SAN_HUN_HE_ZU_XUAN(323L, "前三混合组选"),
    ZHONG_SAN_HUN_HE_ZU_XUAN(423L, "中三混合组选"),
    HOU_SAN_HUN_HE_ZU_XUAN(523L, "后三混合组选"),

    QIAN_SAN_ZU_XUAN_HE_ZHI(324L, "前三组选和值"),
    ZHONG_SAN_ZU_XUAN_HE_ZHI(424L, "中三组选和值"),
    HOU_SAN_ZU_XUAN_HE_ZHI(524L, "后三组选和值"),

    // 二星
    QIAN_ER_ZHI_XUAN_FU_SHI(614L, "前二直选复式"),
    HOU_ER_ZHI_XUAN_FU_SHI(611L, "后二直选复式"),

    QIAN_ER_ZHI_XUAN_DAN_SHI(615L, "前二直选单式"),
    HOU_ER_ZHI_XUAN_DAN_SHI(612L, "后二直选单式"),

    QIAN_ER_ZHI_XUAN_HE_ZHI(616L, "前二直选和值"),
    HOU_ER_ZHI_XUAN_HE_ZHI(613L, "后二直选和值"),

    QIAN_ER_ZU_XUAN_FU_SHI(624L, "前二组选复式"),
    HOU_ER_ZU_XUAN_FU_SHI(621L, "后二组选复式"),

    QIAN_ER_ZU_XUAN_DAN_SHI(625L, "前二组选单式"),
    HOU_ER_ZU_XUAN_DAN_SHI(622L, "后二组选单式"),

    QIAN_ER_ZU_XUAN_HE_ZHI(626L, "前二组选和值"),
    HOU_ER_ZU_XUAN_HE_ZHI(623L, "后二组选和值"),

    // 一星
    YI_XING_DING_WEI_DAN(711L, "一星定位胆"),

    // 不定位
    QIAN_SAN_YI_MA(813L, "前三一码"),
    HOU_SAN_YI_MA(811L, "后三一码"),

    QIAN_SAN_ER_MA(814L, "前三二码"),
    HOU_SAN_ER_MA(812L, "后三二码"),

    // 大小单双
    QIAN_ER_DA_XIAO_DAN_SHUANG(912L, "前二大小单双"),
    HOU_ER_DA_XIAO_DAN_SHUANG(911L, "后二大小单双"),
    ZONG_HE_DA_XIAO_DAN_SHUANG(913L, "总和大小单双"),

    // 趣味
    YI_FAN_FENG_SHUN(101L, "一帆风顺"),
    HAO_SHI_CHENG_SHUANG(102L, "好事成双"),
    SAN_XING_BAO_XI(103L, "三星报喜"),
    SI_JI_FA_CAI(104L, "四季发财");

    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    ShishicaiType(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, ShishicaiType> maps = new HashMap<>();
    static {
        for (ShishicaiType type : ShishicaiType.values())
            maps.put(type.value(), type);
    }

    public static ShishicaiType parse(long value) {
        return maps.get(value);
    }

}
