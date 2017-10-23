package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/10/13.
 */
// 双面盘PK10
public enum LotteryPK10DoubleType implements LotteryType {

    // 冠亚和值
    GUAN_YA_HE_DA(61601L, "冠亚和值大"),
    GUAN_YA_HE_XIAO(61602L, "冠亚和值小"),
    GUAN_YA_HE_DAN(61603L, "冠亚和值单"),
    GUAN_YA_HE_SHUANG(61604L, "冠亚和值双"),

    GUAN_YA_HE_3(61503L, "冠亚和值3"),
    GUAN_YA_HE_4(61504L, "冠亚和值4"),
    GUAN_YA_HE_5(61505L, "冠亚和值5"),
    GUAN_YA_HE_6(61506L, "冠亚和值6"),
    GUAN_YA_HE_7(61507L, "冠亚和值7"),
    GUAN_YA_HE_8(61508L, "冠亚和值8"),
    GUAN_YA_HE_9(61509L, "冠亚和值9"),
    GUAN_YA_HE_10(61510L, "冠亚和值10"),
    GUAN_YA_HE_11(61511L, "冠亚和值11"),
    GUAN_YA_HE_12(61512L, "冠亚和值12"),
    GUAN_YA_HE_13(61513L, "冠亚和值13"),
    GUAN_YA_HE_14(61514L, "冠亚和值14"),
    GUAN_YA_HE_15(61515L, "冠亚和值15"),
    GUAN_YA_HE_16(61516L, "冠亚和值16"),
    GUAN_YA_HE_17(61517L, "冠亚和值17"),
    GUAN_YA_HE_18(61518L, "冠亚和值18"),
    GUAN_YA_HE_19(61519L, "冠亚和值19"),

    // 单号冠军
    DAN_HAO_GUAN_DA(61701L, "冠军大"),
    DAN_HAO_GUAN_XIAO(61702L, "冠军小"),
    DAN_HAO_GUAN_DAN(61703L, "冠军单"),
    DAN_HAO_GUAN_SHUANG(61704L, "冠军双"),
    DAN_HAO_GUAN_LONG(61705L, "冠军龙"),
    DAN_HAO_GUAN_HU(61706L, "冠军虎"),

    DAN_HAO_GUAN_1(61801L, "冠军1号"),
    DAN_HAO_GUAN_2(61802L, "冠军2号"),
    DAN_HAO_GUAN_3(61803L, "冠军3号"),
    DAN_HAO_GUAN_4(61804L, "冠军4号"),
    DAN_HAO_GUAN_5(61805L, "冠军5号"),
    DAN_HAO_GUAN_6(61806L, "冠军6号"),
    DAN_HAO_GUAN_7(61807L, "冠军7号"),
    DAN_HAO_GUAN_8(61808L, "冠军8号"),
    DAN_HAO_GUAN_9(61809L, "冠军9号"),
    DAN_HAO_GUAN_10(61810L, "冠军10号"),


    // 单号亚军
    DAN_HAO_YA_DA(61901L, "亚军大"),
    DAN_HAO_YA_XIAO(61902L, "亚军小"),
    DAN_HAO_YA_DAN(61903L, "亚军单"),
    DAN_HAO_YA_SHUANG(61904L, "亚军双"),
    DAN_HAO_YA_LONG(61905L, "亚军龙"),
    DAN_HAO_YA_HU(61906L, "亚军虎"),

    DAN_HAO_YA_1(62001L, "亚军1号"),
    DAN_HAO_YA_2(62002L, "亚军2号"),
    DAN_HAO_YA_3(62003L, "亚军3号"),
    DAN_HAO_YA_4(62004L, "亚军4号"),
    DAN_HAO_YA_5(62005L, "亚军5号"),
    DAN_HAO_YA_6(62006L, "亚军6号"),
    DAN_HAO_YA_7(62007L, "亚军7号"),
    DAN_HAO_YA_8(62008L, "亚军8号"),
    DAN_HAO_YA_9(62009L, "亚军9号"),
    DAN_HAO_YA_10(62010L, "亚军10号"),


    // 单号第三名
    DAN_HAO_THIRD_DA(63001L, "第三名大"),
    DAN_HAO_THIRD_XIAO(63002L, "第三名小"),
    DAN_HAO_THIRD_DAN(63003L, "第三名单"),
    DAN_HAO_THIRD_SHUANG(63004L, "第三名双"),
    DAN_HAO_THIRD_LONG(63005L, "第三名龙"),
    DAN_HAO_THIRD_HU(63006L, "第三名虎"),

    DAN_HAO_THIRD_1(63101L, "第三名1号"),
    DAN_HAO_THIRD_2(63102L, "第三名2号"),
    DAN_HAO_THIRD_3(63103L, "第三名3号"),
    DAN_HAO_THIRD_4(63104L, "第三名4号"),
    DAN_HAO_THIRD_5(63105L, "第三名5号"),
    DAN_HAO_THIRD_6(63106L, "第三名6号"),
    DAN_HAO_THIRD_7(63107L, "第三名7号"),
    DAN_HAO_THIRD_8(63108L, "第三名8号"),
    DAN_HAO_THIRD_9(63109L, "第三名9号"),
    DAN_HAO_THIRD_10(63110L, "第三名10号"),

    // 单号第四名
    DAN_HAO_FORTH_DA(64101L, "第四名大"),
    DAN_HAO_FORTH_XIAO(64102L, "第四名小"),
    DAN_HAO_FORTH_DAN(64103L, "第四名单"),
    DAN_HAO_FORTH_SHUANG(64104L, "第四名双"),
    DAN_HAO_FORTH_LONG(64105L, "第四名龙"),
    DAN_HAO_FORTH_HU(64106L, "第四名虎"),

    DAN_HAO_FORTH_1(64201L, "第四名1号"),
    DAN_HAO_FORTH_2(64202L, "第四名2号"),
    DAN_HAO_FORTH_3(64203L, "第四名3号"),
    DAN_HAO_FORTH_4(64204L, "第四名4号"),
    DAN_HAO_FORTH_5(64205L, "第四名5号"),
    DAN_HAO_FORTH_6(64206L, "第四名6号"),
    DAN_HAO_FORTH_7(64207L, "第四名7号"),
    DAN_HAO_FORTH_8(64208L, "第四名8号"),
    DAN_HAO_FORTH_9(64209L, "第四名9号"),
    DAN_HAO_FORTH_10(64210L, "第四名10号"),

    // 单号第五名
    DAN_HAO_FIFTH_DA(65101L, "第五名大"),
    DAN_HAO_FIFTH_XIAO(65102L, "第五名小"),
    DAN_HAO_FIFTH_DAN(65103L, "第五名单"),
    DAN_HAO_FIFTH_SHUANG(65104L, "第五名双"),
    DAN_HAO_FIFTH_LONG(65105L, "第五名龙"),
    DAN_HAO_FIFTH_HU(65106L, "第五名虎"),

    DAN_HAO_FIFTH_1(65201L, "第五名1号"),
    DAN_HAO_FIFTH_2(65202L, "第五名2号"),
    DAN_HAO_FIFTH_3(65203L, "第五名3号"),
    DAN_HAO_FIFTH_4(65204L, "第五名4号"),
    DAN_HAO_FIFTH_5(65205L, "第五名5号"),
    DAN_HAO_FIFTH_6(65206L, "第五名6号"),
    DAN_HAO_FIFTH_7(65207L, "第五名7号"),
    DAN_HAO_FIFTH_8(65208L, "第五名8号"),
    DAN_HAO_FIFTH_9(65209L, "第五名9号"),
    DAN_HAO_FIFTH_10(65210L, "第五名10号"),

    // 单号第六名
    DAN_HAO_SIXTH_DA(66101L, "第六名大"),
    DAN_HAO_SIXTH_XIAO(66102L, "第六名小"),
    DAN_HAO_SIXTH_DAN(66103L, "第六名单"),
    DAN_HAO_SIXTH_SHUANG(66104L, "第六名双"),

    DAN_HAO_SIXTH_1(66201L, "第六名1号"),
    DAN_HAO_SIXTH_2(66202L, "第六名2号"),
    DAN_HAO_SIXTH_3(66203L, "第六名3号"),
    DAN_HAO_SIXTH_4(66204L, "第六名4号"),
    DAN_HAO_SIXTH_5(66205L, "第六名5号"),
    DAN_HAO_SIXTH_6(66206L, "第六名6号"),
    DAN_HAO_SIXTH_7(66207L, "第六名7号"),
    DAN_HAO_SIXTH_8(66208L, "第六名8号"),
    DAN_HAO_SIXTH_9(66209L, "第六名9号"),
    DAN_HAO_SIXTH_10(66210L, "第六名10号"),

    // 单号第七名
    DAN_HAO_SEVENTH_DA(67101L, "第七名大"),
    DAN_HAO_SEVENTH_XIAO(67102L, "第七名小"),
    DAN_HAO_SEVENTH_DAN(67103L, "第七名单"),
    DAN_HAO_SEVENTH_SHUANG(67104L, "第七名双"),

    DAN_HAO_SEVENTH_1(67201L, "第七名1号"),
    DAN_HAO_SEVENTH_2(67202L, "第七名2号"),
    DAN_HAO_SEVENTH_3(67203L, "第七名3号"),
    DAN_HAO_SEVENTH_4(67204L, "第七名4号"),
    DAN_HAO_SEVENTH_5(67205L, "第七名5号"),
    DAN_HAO_SEVENTH_6(67206L, "第七名6号"),
    DAN_HAO_SEVENTH_7(67207L, "第七名7号"),
    DAN_HAO_SEVENTH_8(67208L, "第七名8号"),
    DAN_HAO_SEVENTH_9(67209L, "第七名9号"),
    DAN_HAO_SEVENTH_10(67210L, "第七名10号"),

    // 单号第八名
    DAN_HAO_EIGHTH_DA(68101L, "第八名大"),
    DAN_HAO_EIGHTH_XIAO(68102L, "第八名小"),
    DAN_HAO_EIGHTH_DAN(68103L, "第八名单"),
    DAN_HAO_EIGHTH_SHUANG(68104L, "第八名双"),

    DAN_HAO_EIGHTH_1(68201L, "第八名1号"),
    DAN_HAO_EIGHTH_2(68202L, "第八名2号"),
    DAN_HAO_EIGHTH_3(68203L, "第八名3号"),
    DAN_HAO_EIGHTH_4(68204L, "第八名4号"),
    DAN_HAO_EIGHTH_5(68205L, "第八名5号"),
    DAN_HAO_EIGHTH_6(68206L, "第八名6号"),
    DAN_HAO_EIGHTH_7(68207L, "第八名7号"),
    DAN_HAO_EIGHTH_8(68208L, "第八名8号"),
    DAN_HAO_EIGHTH_9(68209L, "第八名9号"),
    DAN_HAO_EIGHTH_10(68210L, "第八名10号"),

    // 单号第九名
    DAN_HAO_NINTH_DA(69101L, "第九名大"),
    DAN_HAO_NINTH_XIAO(69102L, "第九名小"),
    DAN_HAO_NINTH_DAN(69103L, "第九名单"),
    DAN_HAO_NINTH_SHUANG(69104L, "第九名双"),

    DAN_HAO_NINTH_1(69201L, "第九名1号"),
    DAN_HAO_NINTH_2(69202L, "第九名2号"),
    DAN_HAO_NINTH_3(69203L, "第九名3号"),
    DAN_HAO_NINTH_4(69204L, "第九名4号"),
    DAN_HAO_NINTH_5(69205L, "第九名5号"),
    DAN_HAO_NINTH_6(69206L, "第九名6号"),
    DAN_HAO_NINTH_7(69207L, "第九名7号"),
    DAN_HAO_NINTH_8(69208L, "第九名8号"),
    DAN_HAO_NINTH_9(69209L, "第九名9号"),
    DAN_HAO_NINTH_10(69210L, "第九名10号"),

    // 单号第十名
    DAN_HAO_TENTH_DA(610101L, "第十名大"),
    DAN_HAO_TENTH_XIAO(610102L, "第十名小"),
    DAN_HAO_TENTH_DAN(610103L, "第十名单"),
    DAN_HAO_TENTH_SHUANG(610104L, "第十名双"),

    DAN_HAO_TENTH_1(610201L, "第十名1号"),
    DAN_HAO_TENTH_2(610202L, "第十名2号"),
    DAN_HAO_TENTH_3(610203L, "第十名3号"),
    DAN_HAO_TENTH_4(610204L, "第十名4号"),
    DAN_HAO_TENTH_5(610205L, "第十名5号"),
    DAN_HAO_TENTH_6(610206L, "第十名6号"),
    DAN_HAO_TENTH_7(610207L, "第十名7号"),
    DAN_HAO_TENTH_8(610208L, "第十名8号"),
    DAN_HAO_TENTH_9(610209L, "第十名9号"),
    DAN_HAO_TENTH_10(610210L, "第十名10号");

    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    LotteryPK10DoubleType(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, LotteryPK10DoubleType> maps = new HashMap<>();

    static {
        for (LotteryPK10DoubleType type : LotteryPK10DoubleType.values())
            maps.put(type.value(), type);
    }

    public static LotteryPK10DoubleType parse(long value) {
        return maps.get(value);
    }

}
