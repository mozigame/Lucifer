package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/9/13.
 */
// 时时彩双面盘
public enum ShishicaiDoubleType implements LotteryType {

    ZONG_HE_DA(21601L, "总和大"),
    ZONG_HE_XIAO(21602L, "总和小"),
    ZONG_HE_DAN(21603L, "总和单"),
    ZONG_HE_SHUANG(21604L, "总和双"),
    ZONG_HE_LONG(21605L, "总和龙"),
    ZONG_HE_HU(21606L, "总和虎"),
    ZONG_HE_HE(21607L, "总和和"),

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

    YI_QIU_DING_WEI_DAN_0(22110L, "一球定位胆0"),
    YI_QIU_DING_WEI_DAN_1(22101L, "一球定位胆1"),
    YI_QIU_DING_WEI_DAN_2(22102L, "一球定位胆2"),
    YI_QIU_DING_WEI_DAN_3(22103L, "一球定位胆3"),
    YI_QIU_DING_WEI_DAN_4(22104L, "一球定位胆4"),
    YI_QIU_DING_WEI_DAN_5(22105L, "一球定位胆5"),
    YI_QIU_DING_WEI_DAN_6(22106L, "一球定位胆6"),
    YI_QIU_DING_WEI_DAN_7(22107L, "一球定位胆7"),
    YI_QIU_DING_WEI_DAN_8(22108L, "一球定位胆8"),
    YI_QIU_DING_WEI_DAN_9(22109L, "一球定位胆9"),

    ER_QIU_DING_WEI_DAN_0(22210L, "二球定位胆0"),
    ER_QIU_DING_WEI_DAN_1(22201L, "二球定位胆1"),
    ER_QIU_DING_WEI_DAN_2(22202L, "二球定位胆2"),
    ER_QIU_DING_WEI_DAN_3(22203L, "二球定位胆3"),
    ER_QIU_DING_WEI_DAN_4(22204L, "二球定位胆4"),
    ER_QIU_DING_WEI_DAN_5(22205L, "二球定位胆5"),
    ER_QIU_DING_WEI_DAN_6(22206L, "二球定位胆6"),
    ER_QIU_DING_WEI_DAN_7(22207L, "二球定位胆7"),
    ER_QIU_DING_WEI_DAN_8(22208L, "二球定位胆8"),
    ER_QIU_DING_WEI_DAN_9(22209L, "二球定位胆9"),

    SAN_QIU_DING_WEI_DAN_0(22310L, "三球定位胆0"),
    SAN_QIU_DING_WEI_DAN_1(22301L, "三球定位胆1"),
    SAN_QIU_DING_WEI_DAN_2(22302L, "三球定位胆2"),
    SAN_QIU_DING_WEI_DAN_3(22303L, "三球定位胆3"),
    SAN_QIU_DING_WEI_DAN_4(22304L, "三球定位胆4"),
    SAN_QIU_DING_WEI_DAN_5(22305L, "三球定位胆5"),
    SAN_QIU_DING_WEI_DAN_6(22306L, "三球定位胆6"),
    SAN_QIU_DING_WEI_DAN_7(22307L, "三球定位胆7"),
    SAN_QIU_DING_WEI_DAN_8(22308L, "三球定位胆8"),
    SAN_QIU_DING_WEI_DAN_9(22309L, "三球定位胆9"),

    SI_QIU_DING_WEI_DAN_0(22410L, "四球定位胆0"),
    SI_QIU_DING_WEI_DAN_1(22401L, "四球定位胆1"),
    SI_QIU_DING_WEI_DAN_2(22402L, "四球定位胆2"),
    SI_QIU_DING_WEI_DAN_3(22403L, "四球定位胆3"),
    SI_QIU_DING_WEI_DAN_4(22404L, "四球定位胆4"),
    SI_QIU_DING_WEI_DAN_5(22405L, "四球定位胆5"),
    SI_QIU_DING_WEI_DAN_6(22406L, "四球定位胆6"),
    SI_QIU_DING_WEI_DAN_7(22407L, "四球定位胆7"),
    SI_QIU_DING_WEI_DAN_8(22408L, "四球定位胆8"),
    SI_QIU_DING_WEI_DAN_9(22409L, "四球定位胆9"),

    WU_QIU_DING_WEI_DAN_0(22510L, "五球定位胆0"),
    WU_QIU_DING_WEI_DAN_1(22501L, "五球定位胆1"),
    WU_QIU_DING_WEI_DAN_2(22502L, "五球定位胆2"),
    WU_QIU_DING_WEI_DAN_3(22503L, "五球定位胆3"),
    WU_QIU_DING_WEI_DAN_4(22504L, "五球定位胆4"),
    WU_QIU_DING_WEI_DAN_5(22505L, "五球定位胆5"),
    WU_QIU_DING_WEI_DAN_6(22506L, "五球定位胆6"),
    WU_QIU_DING_WEI_DAN_7(22507L, "五球定位胆7"),
    WU_QIU_DING_WEI_DAN_8(22508L, "五球定位胆8"),
    WU_QIU_DING_WEI_DAN_9(22509L, "五球定位胆9"),

    // 特殊玩法
    QIAN_SAN_BAO_ZI(23101L, "前三豹子"),
    QIAN_SAN_SHUN_ZI(23102L, "前三顺子"),
    QIAN_SAN_DUI_ZI(23103L, "前三对子"),
    QIAN_SAN_BAN_SHUN(23104L, "前三半顺"),
    QIAN_SAN_ZA_LIU(23105L, "前三杂六"),

    ZHONG_SAN_BAO_ZI(23201L, "中三豹子"),
    ZHONG_SAN_SHUN_ZI(23202L, "中三顺子"),
    ZHONG_SAN_DUI_ZI(23203L, "中三对子"),
    ZHONG_SAN_BAN_SHUN(23204L, "中三半顺"),
    ZHONG_SAN_ZA_LIU(23205L, "中三杂六"),

    HOU_SAN_BAO_ZI(23301L, "后三豹子"),
    HOU_SAN_SHUN_ZI(23302L, "后三顺子"),
    HOU_SAN_DUI_ZI(23303L, "后三对子"),
    HOU_SAN_BAN_SHUN(23304L, "后三半顺"),
    HOU_SAN_ZA_LIU(23305L, "后三杂六");

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
