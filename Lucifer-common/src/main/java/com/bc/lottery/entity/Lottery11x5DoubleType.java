package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/9/13.
 */
// 双面盘11选5
public enum Lottery11x5DoubleType implements LotteryType {

    ZONG_HE_DA(21601L, "总和大"),
    ZONG_HE_XIAO(21602L, "总和小"),
    ZONG_HE_DAN(21603L, "总和单"),
    ZONG_HE_SHUANG(21604L, "总和双"),
    ZONG_HE_WEI_DA(21607L, "总和尾大"),
    ZONG_HE_WEI_XIAO(21607L, "总和尾小"),
    ZONG_HE_LONG(21605L, "总和龙"),
    ZONG_HE_HU(21606L, "总和虎"),

    YI_QIU_DA(21101L, "一球大"),
    YI_QIU_XIAO(21102L, "一球小"),
    YI_QIU_DAN(21103L, "一球单"),
    YI_QIU_SHUANG(21104L, "一球双"),

    ER_QIU_DA(21201L, "二球大"),
    ER_QIU_XIAO(21202L, "二球小"),
    ER_QIU_DAN(21203L, "二球单"),
    ER_QIU_SHUANG(21204L, "二球双"),

    SAN_QIU_DA(21301L, "三球大"),
    SAN_QIU_XIAO(21302L, "三球小"),
    SAN_QIU_DAN(21303L, "三球单"),
    SAN_QIU_SHUANG(21304L, "三球双"),

    SI_QIU_DA(21401L, "四球大"),
    SI_QIU_XIAO(21402L, "四球小"),
    SI_QIU_DAN(21403L, "四球单"),
    SI_QIU_SHUANG(21404L, "四球双"),

    WU_QIU_DA(21501L, "五球大"),
    WU_QIU_XIAO(21502L, "五球小"),
    WU_QIU_DAN(21503L, "五球单"),
    WU_QIU_SHUANG(21504L, "五球双"),

    YI_ZHONG_YI_1(22101L, "一中一1"),
    YI_ZHONG_YI_2(22102L, "一中一2"),
    YI_ZHONG_YI_3(22103L, "一中一3"),
    YI_ZHONG_YI_4(22104L, "一中一4"),
    YI_ZHONG_YI_5(22105L, "一中一5"),
    YI_ZHONG_YI_6(22106L, "一中一6"),
    YI_ZHONG_YI_7(22107L, "一中一7"),
    YI_ZHONG_YI_8(22108L, "一中一8"),
    YI_ZHONG_YI_9(22109L, "一中一9"),
    YI_ZHONG_YI_10(22109L, "一中一10"),
    YI_ZHONG_YI_11(22109L, "一中一11"),

    YI_QIU_DING_WEI_DAN_1(22101L, "一球定位胆1"),
    YI_QIU_DING_WEI_DAN_2(22102L, "一球定位胆2"),
    YI_QIU_DING_WEI_DAN_3(22103L, "一球定位胆3"),
    YI_QIU_DING_WEI_DAN_4(22104L, "一球定位胆4"),
    YI_QIU_DING_WEI_DAN_5(22105L, "一球定位胆5"),
    YI_QIU_DING_WEI_DAN_6(22106L, "一球定位胆6"),
    YI_QIU_DING_WEI_DAN_7(22107L, "一球定位胆7"),
    YI_QIU_DING_WEI_DAN_8(22108L, "一球定位胆8"),
    YI_QIU_DING_WEI_DAN_9(22109L, "一球定位胆9"),
    YI_QIU_DING_WEI_DAN_10(22109L, "一球定位胆10"),
    YI_QIU_DING_WEI_DAN_11(22109L, "一球定位胆11"),

    ER_QIU_DING_WEI_DAN_1(22201L, "二球定位胆1"),
    ER_QIU_DING_WEI_DAN_2(22202L, "二球定位胆2"),
    ER_QIU_DING_WEI_DAN_3(22203L, "二球定位胆3"),
    ER_QIU_DING_WEI_DAN_4(22204L, "二球定位胆4"),
    ER_QIU_DING_WEI_DAN_5(22205L, "二球定位胆5"),
    ER_QIU_DING_WEI_DAN_6(22206L, "二球定位胆6"),
    ER_QIU_DING_WEI_DAN_7(22207L, "二球定位胆7"),
    ER_QIU_DING_WEI_DAN_8(22208L, "二球定位胆8"),
    ER_QIU_DING_WEI_DAN_9(22209L, "二球定位胆9"),
    ER_QIU_DING_WEI_DAN_10(22210L, "二球定位胆10"),
    ER_QIU_DING_WEI_DAN_11(22211L, "二球定位胆11"),

    SAN_QIU_DING_WEI_DAN_1(22301L, "三球定位胆1"),
    SAN_QIU_DING_WEI_DAN_2(22302L, "三球定位胆2"),
    SAN_QIU_DING_WEI_DAN_3(22303L, "三球定位胆3"),
    SAN_QIU_DING_WEI_DAN_4(22304L, "三球定位胆4"),
    SAN_QIU_DING_WEI_DAN_5(22305L, "三球定位胆5"),
    SAN_QIU_DING_WEI_DAN_6(22306L, "三球定位胆6"),
    SAN_QIU_DING_WEI_DAN_7(22307L, "三球定位胆7"),
    SAN_QIU_DING_WEI_DAN_8(22308L, "三球定位胆8"),
    SAN_QIU_DING_WEI_DAN_9(22309L, "三球定位胆9"),
    SAN_QIU_DING_WEI_DAN_10(22309L, "三球定位胆10"),
    SAN_QIU_DING_WEI_DAN_11(22309L, "三球定位胆11"),

    SI_QIU_DING_WEI_DAN_1(22401L, "四球定位胆1"),
    SI_QIU_DING_WEI_DAN_2(22402L, "四球定位胆2"),
    SI_QIU_DING_WEI_DAN_3(22403L, "四球定位胆3"),
    SI_QIU_DING_WEI_DAN_4(22404L, "四球定位胆4"),
    SI_QIU_DING_WEI_DAN_5(22405L, "四球定位胆5"),
    SI_QIU_DING_WEI_DAN_6(22406L, "四球定位胆6"),
    SI_QIU_DING_WEI_DAN_7(22407L, "四球定位胆7"),
    SI_QIU_DING_WEI_DAN_8(22408L, "四球定位胆8"),
    SI_QIU_DING_WEI_DAN_9(22409L, "四球定位胆9"),
    SI_QIU_DING_WEI_DAN_10(22409L, "四球定位胆10"),
    SI_QIU_DING_WEI_DAN_11(22409L, "四球定位胆11"),

    WU_QIU_DING_WEI_DAN_1(22501L, "五球定位胆1"),
    WU_QIU_DING_WEI_DAN_2(22502L, "五球定位胆2"),
    WU_QIU_DING_WEI_DAN_3(22503L, "五球定位胆3"),
    WU_QIU_DING_WEI_DAN_4(22504L, "五球定位胆4"),
    WU_QIU_DING_WEI_DAN_5(22505L, "五球定位胆5"),
    WU_QIU_DING_WEI_DAN_6(22506L, "五球定位胆6"),
    WU_QIU_DING_WEI_DAN_7(22507L, "五球定位胆7"),
    WU_QIU_DING_WEI_DAN_8(22508L, "五球定位胆8"),
    WU_QIU_DING_WEI_DAN_9(22509L, "五球定位胆9"),
    WU_QIU_DING_WEI_DAN_10(22509L, "五球定位胆10"),
    WU_QIU_DING_WEI_DAN_11(22509L, "五球定位胆11"),

    // 特殊玩法
    LIAN_MA_ER_ZHONG_ER(23101L, "连码二中二"),
    LIAN_MA_SAN_ZHONG_SAN(23102L, "连码三中三"),
    LIAN_MA_SI_ZHONG_SI(23103L, "连码四中四"),
    LIAN_MA_WU_ZHONG_WU(23104L, "连码五中五"),
    LIAN_MA_LIU_ZHONG_WU(23105L, "连码六中五"),
    LIAN_MA_QI_ZHONG_WU(23104L, "连码七中五"),
    LIAN_MA_BA_ZHONG_WU(23105L, "连码八中五"),
    QIAN_ER_ZU_XUAN(23104L, "前二组选"),
    QIAN_SAN_ZU_XUAN(23105L, "前三组选"),

    QIAN_ER_ZHI_XUAN(23104L, "前二直选"),
    QIAN_SAN_ZHI_XUAN(23105L, "前三直选");

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
