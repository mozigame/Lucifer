package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/9/13.
 */
// 双面盘11选5
public enum Lottery11x5DoubleType implements LotteryType {

    ZONG_HE_DA(41601L, "总和大"),
    ZONG_HE_XIAO(41602L, "总和小"),
    ZONG_HE_DAN(41603L, "总和单"),
    ZONG_HE_SHUANG(41604L, "总和双"),
    ZONG_HE_WEI_DA(41605L, "总和尾大"),
    ZONG_HE_WEI_XIAO(41606L, "总和尾小"),
    ZONG_HE_LONG(41607L, "总和龙"),
    ZONG_HE_HU(41608L, "总和虎"),

    YI_QIU_DA(41101L, "一球大"),
    YI_QIU_XIAO(41102L, "一球小"),
    YI_QIU_DAN(41103L, "一球单"),
    YI_QIU_SHUANG(41104L, "一球双"),

    ER_QIU_DA(41201L, "二球大"),
    ER_QIU_XIAO(41202L, "二球小"),
    ER_QIU_DAN(41203L, "二球单"),
    ER_QIU_SHUANG(41204L, "二球双"),

    SAN_QIU_DA(41301L, "三球大"),
    SAN_QIU_XIAO(41302L, "三球小"),
    SAN_QIU_DAN(41303L, "三球单"),
    SAN_QIU_SHUANG(41304L, "三球双"),

    SI_QIU_DA(41401L, "四球大"),
    SI_QIU_XIAO(41402L, "四球小"),
    SI_QIU_DAN(41403L, "四球单"),
    SI_QIU_SHUANG(41404L, "四球双"),

    WU_QIU_DA(41501L, "五球大"),
    WU_QIU_XIAO(41502L, "五球小"),
    WU_QIU_DAN(41503L, "五球单"),
    WU_QIU_SHUANG(41504L, "五球双"),

    YI_ZHONG_YI_1(42601L, "一中一1"),
    YI_ZHONG_YI_2(42602L, "一中一2"),
    YI_ZHONG_YI_3(42603L, "一中一3"),
    YI_ZHONG_YI_4(42604L, "一中一4"),
    YI_ZHONG_YI_5(42605L, "一中一5"),
    YI_ZHONG_YI_6(42606L, "一中一6"),
    YI_ZHONG_YI_7(42607L, "一中一7"),
    YI_ZHONG_YI_8(42608L, "一中一8"),
    YI_ZHONG_YI_9(42609L, "一中一9"),
    YI_ZHONG_YI_10(42610L, "一中一10"),
    YI_ZHONG_YI_11(42611L, "一中一11"),

    YI_QIU_DING_WEI_DAN_1(42101L, "一球定位胆1"),
    YI_QIU_DING_WEI_DAN_2(42102L, "一球定位胆2"),
    YI_QIU_DING_WEI_DAN_3(42103L, "一球定位胆3"),
    YI_QIU_DING_WEI_DAN_4(42104L, "一球定位胆4"),
    YI_QIU_DING_WEI_DAN_5(42105L, "一球定位胆5"),
    YI_QIU_DING_WEI_DAN_6(42106L, "一球定位胆6"),
    YI_QIU_DING_WEI_DAN_7(42107L, "一球定位胆7"),
    YI_QIU_DING_WEI_DAN_8(42108L, "一球定位胆8"),
    YI_QIU_DING_WEI_DAN_9(42109L, "一球定位胆9"),
    YI_QIU_DING_WEI_DAN_10(42110L, "一球定位胆10"),
    YI_QIU_DING_WEI_DAN_11(42111L, "一球定位胆11"),

    ER_QIU_DING_WEI_DAN_1(42201L, "二球定位胆1"),
    ER_QIU_DING_WEI_DAN_2(42202L, "二球定位胆2"),
    ER_QIU_DING_WEI_DAN_3(42203L, "二球定位胆3"),
    ER_QIU_DING_WEI_DAN_4(42204L, "二球定位胆4"),
    ER_QIU_DING_WEI_DAN_5(42205L, "二球定位胆5"),
    ER_QIU_DING_WEI_DAN_6(42206L, "二球定位胆6"),
    ER_QIU_DING_WEI_DAN_7(42207L, "二球定位胆7"),
    ER_QIU_DING_WEI_DAN_8(42208L, "二球定位胆8"),
    ER_QIU_DING_WEI_DAN_9(42209L, "二球定位胆9"),
    ER_QIU_DING_WEI_DAN_10(42210L, "二球定位胆10"),
    ER_QIU_DING_WEI_DAN_11(42211L, "二球定位胆11"),

    SAN_QIU_DING_WEI_DAN_1(42301L, "三球定位胆1"),
    SAN_QIU_DING_WEI_DAN_2(42302L, "三球定位胆2"),
    SAN_QIU_DING_WEI_DAN_3(42303L, "三球定位胆3"),
    SAN_QIU_DING_WEI_DAN_4(42304L, "三球定位胆4"),
    SAN_QIU_DING_WEI_DAN_5(42305L, "三球定位胆5"),
    SAN_QIU_DING_WEI_DAN_6(42306L, "三球定位胆6"),
    SAN_QIU_DING_WEI_DAN_7(42307L, "三球定位胆7"),
    SAN_QIU_DING_WEI_DAN_8(42308L, "三球定位胆8"),
    SAN_QIU_DING_WEI_DAN_9(42309L, "三球定位胆9"),
    SAN_QIU_DING_WEI_DAN_10(42310L, "三球定位胆10"),
    SAN_QIU_DING_WEI_DAN_11(42311L, "三球定位胆11"),

    SI_QIU_DING_WEI_DAN_1(42401L, "四球定位胆1"),
    SI_QIU_DING_WEI_DAN_2(42402L, "四球定位胆2"),
    SI_QIU_DING_WEI_DAN_3(42403L, "四球定位胆3"),
    SI_QIU_DING_WEI_DAN_4(42404L, "四球定位胆4"),
    SI_QIU_DING_WEI_DAN_5(42405L, "四球定位胆5"),
    SI_QIU_DING_WEI_DAN_6(42406L, "四球定位胆6"),
    SI_QIU_DING_WEI_DAN_7(42407L, "四球定位胆7"),
    SI_QIU_DING_WEI_DAN_8(42408L, "四球定位胆8"),
    SI_QIU_DING_WEI_DAN_9(42409L, "四球定位胆9"),
    SI_QIU_DING_WEI_DAN_10(42410L, "四球定位胆10"),
    SI_QIU_DING_WEI_DAN_11(42411L, "四球定位胆11"),

    WU_QIU_DING_WEI_DAN_1(42501L, "五球定位胆1"),
    WU_QIU_DING_WEI_DAN_2(42502L, "五球定位胆2"),
    WU_QIU_DING_WEI_DAN_3(42503L, "五球定位胆3"),
    WU_QIU_DING_WEI_DAN_4(42504L, "五球定位胆4"),
    WU_QIU_DING_WEI_DAN_5(42505L, "五球定位胆5"),
    WU_QIU_DING_WEI_DAN_6(42506L, "五球定位胆6"),
    WU_QIU_DING_WEI_DAN_7(42507L, "五球定位胆7"),
    WU_QIU_DING_WEI_DAN_8(42508L, "五球定位胆8"),
    WU_QIU_DING_WEI_DAN_9(42509L, "五球定位胆9"),
    WU_QIU_DING_WEI_DAN_10(42510L, "五球定位胆10"),
    WU_QIU_DING_WEI_DAN_11(42511L, "五球定位胆11"),

    // 特殊玩法
    LIAN_MA_ER_ZHONG_ER(43101L, "连码二中二"),
    LIAN_MA_SAN_ZHONG_SAN(43201L, "连码三中三"),
    LIAN_MA_SI_ZHONG_SI(43301L, "连码四中四"),
    LIAN_MA_WU_ZHONG_WU(43401L, "连码五中五"),
    LIAN_MA_LIU_ZHONG_WU(43501L, "连码六中五"),
    LIAN_MA_QI_ZHONG_WU(43601L, "连码七中五"),
    LIAN_MA_BA_ZHONG_WU(43701L, "连码八中五"),
    QIAN_ER_ZU_XUAN(43801L, "前二组选"),
    QIAN_SAN_ZU_XUAN(43901L, "前三组选"),

    QIAN_ER_ZHI_XUAN(44101L, "前二直选"),
    QIAN_SAN_ZHI_XUAN(44201L, "前三直选");

    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    Lottery11x5DoubleType(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, Lottery11x5DoubleType> maps = new HashMap<>();

    static {
        for (Lottery11x5DoubleType type : Lottery11x5DoubleType.values())
            maps.put(type.value(), type);
    }

    public static Lottery11x5DoubleType parse(long value) {
        return maps.get(value);
    }

}
