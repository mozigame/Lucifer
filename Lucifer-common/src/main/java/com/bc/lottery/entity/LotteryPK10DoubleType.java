package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/10/13.
 */
// 双面盘PK10
public enum LotteryPK10DoubleType implements LotteryType {

    // 冠亚和值
    GUAN_YA_HE_DA(82501L, "冠亚和值大"),
    GUAN_YA_HE_XIAO(82502L, "冠亚和值小"),
    GUAN_YA_HE_DAN(82503L, "冠亚和值单"),
    GUAN_YA_HE_SHUANG(82504L, "冠亚和值双"),

    GUAN_YA_HE_3(82101L, "冠亚和值3"),
    GUAN_YA_HE_4(82102L, "冠亚和值4"),
    GUAN_YA_HE_5(82103L, "冠亚和值5"),
    GUAN_YA_HE_6(82104L, "冠亚和值6"),
    GUAN_YA_HE_7(82105L, "冠亚和值7"),
    GUAN_YA_HE_8(82106L, "冠亚和值8"),
    GUAN_YA_HE_9(82107L, "冠亚和值9"),
    GUAN_YA_HE_10(82108L, "冠亚和值10"),
    GUAN_YA_HE_11(82109L, "冠亚和值11"),
    GUAN_YA_HE_12(82110L, "冠亚和值12"),
    GUAN_YA_HE_13(82111L, "冠亚和值13"),
    GUAN_YA_HE_14(82112L, "冠亚和值14"),
    GUAN_YA_HE_15(82113L, "冠亚和值15"),
    GUAN_YA_HE_16(82114L, "冠亚和值16"),
    GUAN_YA_HE_17(82115L, "冠亚和值17"),
    GUAN_YA_HE_18(82116L, "冠亚和值18"),
    GUAN_YA_HE_19(82117L, "冠亚和值19"),

    // 单号冠军
    DAN_HAO_GUAN_DA(81101L, "冠军大"),
    DAN_HAO_GUAN_XIAO(81102L, "冠军小"),
    DAN_HAO_GUAN_DAN(81103L, "冠军单"),
    DAN_HAO_GUAN_SHUANG(81104L, "冠军双"),
    DAN_HAO_GUAN_LONG(81105L, "冠军龙"),
    DAN_HAO_GUAN_HU(81106L, "冠军虎"),

    DAN_HAO_GUAN_1(83101L, "冠军1号"),
    DAN_HAO_GUAN_2(83102L, "冠军2号"),
    DAN_HAO_GUAN_3(83103L, "冠军3号"),
    DAN_HAO_GUAN_4(83104L, "冠军4号"),
    DAN_HAO_GUAN_5(83105L, "冠军5号"),
    DAN_HAO_GUAN_6(83106L, "冠军6号"),
    DAN_HAO_GUAN_7(83107L, "冠军7号"),
    DAN_HAO_GUAN_8(83108L, "冠军8号"),
    DAN_HAO_GUAN_9(83109L, "冠军9号"),
    DAN_HAO_GUAN_10(83110L, "冠军10号"),


    // 单号亚军
    DAN_HAO_YA_DA(81201L, "亚军大"),
    DAN_HAO_YA_XIAO(81202L, "亚军小"),
    DAN_HAO_YA_DAN(81203L, "亚军单"),
    DAN_HAO_YA_SHUANG(81204L, "亚军双"),
    DAN_HAO_YA_LONG(81205L, "亚军龙"),
    DAN_HAO_YA_HU(81206L, "亚军虎"),

    DAN_HAO_YA_1(83201L, "亚军1号"),
    DAN_HAO_YA_2(83202L, "亚军2号"),
    DAN_HAO_YA_3(83203L, "亚军3号"),
    DAN_HAO_YA_4(83204L, "亚军4号"),
    DAN_HAO_YA_5(83205L, "亚军5号"),
    DAN_HAO_YA_6(83206L, "亚军6号"),
    DAN_HAO_YA_7(83207L, "亚军7号"),
    DAN_HAO_YA_8(83208L, "亚军8号"),
    DAN_HAO_YA_9(83209L, "亚军9号"),
    DAN_HAO_YA_10(83210L, "亚军10号"),

    // 单号第三名
    DAN_HAO_THIRD_DA(81301L, "第三名大"),
    DAN_HAO_THIRD_XIAO(81302L, "第三名小"),
    DAN_HAO_THIRD_DAN(81303L, "第三名单"),
    DAN_HAO_THIRD_SHUANG(81304L, "第三名双"),
    DAN_HAO_THIRD_LONG(81305L, "第三名龙"),
    DAN_HAO_THIRD_HU(81306L, "第三名虎"),

    DAN_HAO_THIRD_1(83301L, "第三名1号"),
    DAN_HAO_THIRD_2(83302L, "第三名2号"),
    DAN_HAO_THIRD_3(83303L, "第三名3号"),
    DAN_HAO_THIRD_4(83304L, "第三名4号"),
    DAN_HAO_THIRD_5(83305L, "第三名5号"),
    DAN_HAO_THIRD_6(83306L, "第三名6号"),
    DAN_HAO_THIRD_7(83307L, "第三名7号"),
    DAN_HAO_THIRD_8(83308L, "第三名8号"),
    DAN_HAO_THIRD_9(83309L, "第三名9号"),
    DAN_HAO_THIRD_10(83310L, "第三名10号"),

    // 单号第四名
    DAN_HAO_FORTH_DA(81401L, "第四名大"),
    DAN_HAO_FORTH_XIAO(81402L, "第四名小"),
    DAN_HAO_FORTH_DAN(81403L, "第四名单"),
    DAN_HAO_FORTH_SHUANG(81404L, "第四名双"),
    DAN_HAO_FORTH_LONG(81405L, "第四名龙"),
    DAN_HAO_FORTH_HU(81406L, "第四名虎"),

    DAN_HAO_FORTH_1(83401L, "第四名1号"),
    DAN_HAO_FORTH_2(83402L, "第四名2号"),
    DAN_HAO_FORTH_3(83403L, "第四名3号"),
    DAN_HAO_FORTH_4(83404L, "第四名4号"),
    DAN_HAO_FORTH_5(83405L, "第四名5号"),
    DAN_HAO_FORTH_6(83406L, "第四名6号"),
    DAN_HAO_FORTH_7(83407L, "第四名7号"),
    DAN_HAO_FORTH_8(83408L, "第四名8号"),
    DAN_HAO_FORTH_9(83409L, "第四名9号"),
    DAN_HAO_FORTH_10(83410L, "第四名10号"),

    // 单号第五名
    DAN_HAO_FIFTH_DA(81501L, "第五名大"),
    DAN_HAO_FIFTH_XIAO(81502L, "第五名小"),
    DAN_HAO_FIFTH_DAN(81503L, "第五名单"),
    DAN_HAO_FIFTH_SHUANG(81504L, "第五名双"),
    DAN_HAO_FIFTH_LONG(81505L, "第五名龙"),
    DAN_HAO_FIFTH_HU(81506L, "第五名虎"),

    DAN_HAO_FIFTH_1(83501L, "第五名1号"),
    DAN_HAO_FIFTH_2(83502L, "第五名2号"),
    DAN_HAO_FIFTH_3(83503L, "第五名3号"),
    DAN_HAO_FIFTH_4(83504L, "第五名4号"),
    DAN_HAO_FIFTH_5(83505L, "第五名5号"),
    DAN_HAO_FIFTH_6(83506L, "第五名6号"),
    DAN_HAO_FIFTH_7(83507L, "第五名7号"),
    DAN_HAO_FIFTH_8(83508L, "第五名8号"),
    DAN_HAO_FIFTH_9(83509L, "第五名9号"),
    DAN_HAO_FIFTH_10(83510L, "第五名10号"),

    // 单号第六名
    DAN_HAO_SIXTH_DA(81601L, "第六名大"),
    DAN_HAO_SIXTH_XIAO(81602L, "第六名小"),
    DAN_HAO_SIXTH_DAN(81603L, "第六名单"),
    DAN_HAO_SIXTH_SHUANG(81604L, "第六名双"),

    DAN_HAO_SIXTH_1(84101L, "第六名1号"),
    DAN_HAO_SIXTH_2(84102L, "第六名2号"),
    DAN_HAO_SIXTH_3(84103L, "第六名3号"),
    DAN_HAO_SIXTH_4(84104L, "第六名4号"),
    DAN_HAO_SIXTH_5(84105L, "第六名5号"),
    DAN_HAO_SIXTH_6(84106L, "第六名6号"),
    DAN_HAO_SIXTH_7(84107L, "第六名7号"),
    DAN_HAO_SIXTH_8(84108L, "第六名8号"),
    DAN_HAO_SIXTH_9(84109L, "第六名9号"),
    DAN_HAO_SIXTH_10(84110L, "第六名10号"),

    // 单号第七名
    DAN_HAO_SEVENTH_DA(81701L, "第七名大"),
    DAN_HAO_SEVENTH_XIAO(81702L, "第七名小"),
    DAN_HAO_SEVENTH_DAN(81703L, "第七名单"),
    DAN_HAO_SEVENTH_SHUANG(81704L, "第七名双"),

    DAN_HAO_SEVENTH_1(84201L, "第七名1号"),
    DAN_HAO_SEVENTH_2(84202L, "第七名2号"),
    DAN_HAO_SEVENTH_3(84203L, "第七名3号"),
    DAN_HAO_SEVENTH_4(84204L, "第七名4号"),
    DAN_HAO_SEVENTH_5(84205L, "第七名5号"),
    DAN_HAO_SEVENTH_6(84206L, "第七名6号"),
    DAN_HAO_SEVENTH_7(84207L, "第七名7号"),
    DAN_HAO_SEVENTH_8(84208L, "第七名8号"),
    DAN_HAO_SEVENTH_9(84209L, "第七名9号"),
    DAN_HAO_SEVENTH_10(84210L, "第七名10号"),

    // 单号第八名
    DAN_HAO_EIGHTH_DA(81801L, "第八名大"),
    DAN_HAO_EIGHTH_XIAO(81802L, "第八名小"),
    DAN_HAO_EIGHTH_DAN(81803L, "第八名单"),
    DAN_HAO_EIGHTH_SHUANG(81804L, "第八名双"),

    DAN_HAO_EIGHTH_1(84301L, "第八名1号"),
    DAN_HAO_EIGHTH_2(84302L, "第八名2号"),
    DAN_HAO_EIGHTH_3(84303L, "第八名3号"),
    DAN_HAO_EIGHTH_4(84304L, "第八名4号"),
    DAN_HAO_EIGHTH_5(84305L, "第八名5号"),
    DAN_HAO_EIGHTH_6(84306L, "第八名6号"),
    DAN_HAO_EIGHTH_7(84307L, "第八名7号"),
    DAN_HAO_EIGHTH_8(84308L, "第八名8号"),
    DAN_HAO_EIGHTH_9(84309L, "第八名9号"),
    DAN_HAO_EIGHTH_10(84310L, "第八名10号"),

    // 单号第九名
    DAN_HAO_NINTH_DA(81901L, "第九名大"),
    DAN_HAO_NINTH_XIAO(81902L, "第九名小"),
    DAN_HAO_NINTH_DAN(81903L, "第九名单"),
    DAN_HAO_NINTH_SHUANG(81904L, "第九名双"),

    DAN_HAO_NINTH_1(84401L, "第九名1号"),
    DAN_HAO_NINTH_2(84402L, "第九名2号"),
    DAN_HAO_NINTH_3(84403L, "第九名3号"),
    DAN_HAO_NINTH_4(84404L, "第九名4号"),
    DAN_HAO_NINTH_5(84405L, "第九名5号"),
    DAN_HAO_NINTH_6(84406L, "第九名6号"),
    DAN_HAO_NINTH_7(84407L, "第九名7号"),
    DAN_HAO_NINTH_8(84408L, "第九名8号"),
    DAN_HAO_NINTH_9(84409L, "第九名9号"),
    DAN_HAO_NINTH_10(84410L, "第九名10号"),

    // 单号第十名
    DAN_HAO_TENTH_DA(82401L, "第十名大"),
    DAN_HAO_TENTH_XIAO(82402L, "第十名小"),
    DAN_HAO_TENTH_DAN(82403L, "第十名单"),
    DAN_HAO_TENTH_SHUANG(82404L, "第十名双"),

    DAN_HAO_TENTH_1(84501L, "第十名1号"),
    DAN_HAO_TENTH_2(84502L, "第十名2号"),
    DAN_HAO_TENTH_3(84503L, "第十名3号"),
    DAN_HAO_TENTH_4(84504L, "第十名4号"),
    DAN_HAO_TENTH_5(84505L, "第十名5号"),
    DAN_HAO_TENTH_6(84506L, "第十名6号"),
    DAN_HAO_TENTH_7(84507L, "第十名7号"),
    DAN_HAO_TENTH_8(84508L, "第十名8号"),
    DAN_HAO_TENTH_9(84509L, "第十名9号"),
    DAN_HAO_TENTH_10(84510L, "第十名10号");

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
