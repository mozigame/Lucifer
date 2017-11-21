package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 双面盘快8
 * Created by clion on 2017/10/13.
 */
public enum LotteryKuai8DoubleType implements LotteryType {

    ZONG_HE_DA(61101L, "总和大"),
    ZONG_HE_XIAO(61102L, "总和小"),
    ZONG_HE_DAN(61103L, "总和单"),
    ZONG_HE_SHUANG(61104L, "总和双"),
    ZONG_HE_810(61105L, "总和810"),
    ZONG_DA_DAN(61106L, "总大单"),
    ZONG_DA_SHUANG(61106L, "总大双"),
    ZONG_DAXIAO_DAN(61106L, "总小单"),
    ZONG_XIAO_SHUANG(61106L, "总小双"),

    QIAN_DUO(63101L, "前多"),
    HOU_DUO(63102L, "后多"),
    QIAN_HOU_HE(63103L, "前后和"),
    DAN_DUO(63104L, "单多"),
    SHUANG_DUO(63105L, "双多"),
    DAN_SHUANG_HE(63106L, "单双和"),

    JIN(63107L, "金"),
    MU(63107L, "木"),
    SHUI(63107L, "水"),
    HUO(63107L, "火"),
    TU(63107L, "土"),

    ZHENG_MA_1(63201L, "正码1"),
    ZHENG_MA_2(63201L, "正码2"),
    ZHENG_MA_3(63201L, "正码3"),
    ZHENG_MA_4(63201L, "正码4"),
    ZHENG_MA_5(63201L, "正码5"),
    ZHENG_MA_6(63201L, "正码6"),
    ZHENG_MA_7(63201L, "正码7"),
    ZHENG_MA_8(63201L, "正码8"),
    ZHENG_MA_9(63201L, "正码9"),
    ZHENG_MA_10(63201L, "正码10"),

    ZHENG_MA_11(63201L, "正码11"),
    ZHENG_MA_12(63201L, "正码12"),
    ZHENG_MA_13(63201L, "正码13"),
    ZHENG_MA_14(63201L, "正码14"),
    ZHENG_MA_15(63201L, "正码15"),
    ZHENG_MA_16(63201L, "正码16"),
    ZHENG_MA_17(63201L, "正码17"),
    ZHENG_MA_18(63201L, "正码18"),
    ZHENG_MA_19(63201L, "正码19"),
    ZHENG_MA_20(63201L, "正码20"),

    ZHENG_MA_21(63201L, "正码21"),
    ZHENG_MA_22(63201L, "正码22"),
    ZHENG_MA_23(63201L, "正码23"),
    ZHENG_MA_24(63201L, "正码24"),
    ZHENG_MA_25(63201L, "正码25"),
    ZHENG_MA_26(63201L, "正码26"),
    ZHENG_MA_27(63201L, "正码27"),
    ZHENG_MA_28(63201L, "正码28"),
    ZHENG_MA_29(63201L, "正码29"),
    ZHENG_MA_30(63201L, "正码30"),

    ZHENG_MA_31(63201L, "正码31"),
    ZHENG_MA_32(63201L, "正码32"),
    ZHENG_MA_33(63201L, "正码33"),
    ZHENG_MA_34(63201L, "正码34"),
    ZHENG_MA_35(63201L, "正码35"),
    ZHENG_MA_36(63201L, "正码36"),
    ZHENG_MA_37(63201L, "正码37"),
    ZHENG_MA_38(63201L, "正码38"),
    ZHENG_MA_39(63201L, "正码39"),
    ZHENG_MA_40(63201L, "正码40"),

    ZHENG_MA_41(63201L, "正码41"),
    ZHENG_MA_42(63201L, "正码42"),
    ZHENG_MA_43(63201L, "正码43"),
    ZHENG_MA_44(63201L, "正码44"),
    ZHENG_MA_45(63201L, "正码45"),
    ZHENG_MA_46(63201L, "正码46"),
    ZHENG_MA_47(63201L, "正码47"),
    ZHENG_MA_48(63201L, "正码48"),
    ZHENG_MA_49(63201L, "正码49"),
    ZHENG_MA_50(63201L, "正码50"),

    ZHENG_MA_51(63201L, "正码51"),
    ZHENG_MA_52(63201L, "正码52"),
    ZHENG_MA_53(63201L, "正码53"),
    ZHENG_MA_54(63201L, "正码54"),
    ZHENG_MA_55(63201L, "正码55"),
    ZHENG_MA_56(63201L, "正码56"),
    ZHENG_MA_57(63201L, "正码57"),
    ZHENG_MA_58(63201L, "正码58"),
    ZHENG_MA_59(63201L, "正码59"),
    ZHENG_MA_60(63201L, "正码60"),

    ZHENG_MA_61(63201L, "正码61"),
    ZHENG_MA_62(63201L, "正码62"),
    ZHENG_MA_63(63201L, "正码63"),
    ZHENG_MA_64(63201L, "正码64"),
    ZHENG_MA_65(63201L, "正码65"),
    ZHENG_MA_66(63201L, "正码66"),
    ZHENG_MA_67(63201L, "正码67"),
    ZHENG_MA_68(63201L, "正码68"),
    ZHENG_MA_69(63201L, "正码69"),
    ZHENG_MA_70(63201L, "正码70"),

    ZHENG_MA_71(63201L, "正码71"),
    ZHENG_MA_72(63201L, "正码72"),
    ZHENG_MA_73(63201L, "正码73"),
    ZHENG_MA_74(63201L, "正码74"),
    ZHENG_MA_75(63201L, "正码75"),
    ZHENG_MA_76(63201L, "正码76"),
    ZHENG_MA_77(63201L, "正码77"),
    ZHENG_MA_78(63201L, "正码78"),
    ZHENG_MA_79(63201L, "正码79"),
    ZHENG_MA_80(63201L, "正码80");


    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    LotteryKuai8DoubleType(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, LotteryKuai8DoubleType> maps = new HashMap<>();

    static {
        for (LotteryKuai8DoubleType type : LotteryKuai8DoubleType.values())
            maps.put(type.value(), type);
    }

    public static LotteryKuai8DoubleType parse(long value) {
        return maps.get(value);
    }

}
