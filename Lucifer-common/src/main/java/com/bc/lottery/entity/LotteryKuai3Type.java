package com.bc.lottery.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by clion on 2017/10/13.
 */
// 传统盘快3
public enum LotteryKuai3Type implements LotteryType {

    ER_TONG_HAO_FU_XUAN(61101L, "二同号复选"),

    SAN_BU_TONG_HAO_DAN_SHI(61424L, "三不同号手输单式"),
    SAN_BU_TONG_HAO_FU_SHI(61425L, "三不同号标准选号"),
    SAN_BU_TONG_HAO_DAN_TUO(61415L, "三不同号胆拖选号"),

    SAN_TONG_HAO_DAN_XUAN(61426L, "三同号单选"),

    SAN_TONG_HAO_TONG_XUAN(61501L, "三同号通选"),

    ER_BU_TONG_HAO_FU_SHI(61419L, "二不同号复式"),
    ER_BU_TONG_HAO_DAN_SHI(61500L, "二不同号单式"),
    ER_BU_TONG_HAO_DAN_TUO(61560L, "二不同号胆拖"),

    ER_TONG_HAO_FU_SHI(61501L, "二同号单选复式"),
    ER_TONG_HAO_DAN_SHI(61502L, "二同号单式"),

    YI_HAO_DING_WEI_DAN(61503L, "一号中奖"),

    SAN_LIAN_HAO_TONG_XUAN(61504L, "三连号通选"),

    HE_ZHI_DIAN_SHU(61502L, "和值点数"),
    HE_ZHI_DA_XIAO(61506L, "和值大小"),
    HE_ZHI_DAN_SHUANG(61505L, "和值单双");

    private long value;
    private String desc;

    public long value() {
        return value;
    }

    public String desc() {
        return desc;
    }

    LotteryKuai3Type(Long value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    private static Map<Long, LotteryKuai3Type> maps = new HashMap<>();

    static {
        for (LotteryKuai3Type type : LotteryKuai3Type.values())
            maps.put(type.value(), type);
    }

    public static LotteryKuai3Type parse(long value) {
        return maps.get(value);
    }

}
