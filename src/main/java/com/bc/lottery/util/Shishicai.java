package com.bc.lottery.util;

/**
 * Created by luis on 2017/4/13.
 */

public interface Shishicai extends LotteryType {

    /**
     * 五星
     */
    enum Wuxing implements Shishicai{

        WU_XING_ZHI_XUAN_FU_SHI("五星直选复式"),
        WU_XING_ZHI_XUAN_DAN_SHI("五星直选单式"),
        WU_XING_ZHI_XUAN_ZU_HE("五星直选组合"),

        ZU_XUAN_120("组选120"),
        ZU_XUAN_60("组选60"),
        ZU_XUAN_30("组选30"),
        ZU_XUAN_20("组选20"),
        ZU_XUAN_10("组选10"),
        ZU_XUAN_5("组选5");

        private final String typeName;

        Wuxing(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

    }

    /**
     * 四星
     */
    enum Sixing implements Shishicai{

        SI_XING_ZHI_XUAN_FU_SHI("四星直选复式"),
        SI_XING_ZHI_XUAN_DAN_SHI("四星直选单式"),
        SI_XING_ZHI_XUAN_ZU_HE("四星直选组合"),

        ZU_XUAN_24("组选24"),
        ZU_XUAN_12("组选12"),
        ZU_XUAN_6("组选6"),
        ZU_XUAN_4("组选4");

        private final String typeName;

        Sixing(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

    }

    /**
     * 三星
     */
    enum Sanxing implements Shishicai{

        QIAN_SAN_FU_SHI("前三复式"),
        ZHONG_SAN_FU_SHI("中三复式"),
        HOU_SAN_FU_SHI("后三复式"),

        QIAN_SAN_DAN_SHI("前三单式"),
        ZHONG_SAN_DAN_SHI("中三单式"),
        HOU_SAN_DAN_SHI("后三单式"),

        QIAN_SAN_ZHI_XUAN_HE_ZHI("前三直选和值"),
        ZHONG_SAN_ZHI_XUAN_HE_ZHI("中三直选和值"),
        HOU_SAN_ZHI_XUAN_HE_ZHI("后三直选和值"),

        QIAN_SAN_ZU_SAN("前三组三"),
        ZHONG_SAN_ZU_SAN("中三组三"),
        HOU_SAN_ZU_SAN("后三组三"),

        QIAN_SAN_ZU_LIU("前三组六"),
        ZHONG_SAN_ZU_LIU("中三组六"),
        HOU_SAN_ZU_LIU("后三组六"),

        QIAN_SAN_HUN_HE_ZU_XUAN("前三混合组选"),
        ZHONG_SAN_HUN_HE_ZU_XUAN("中三混合组选"),
        HOU_SAN_HUN_HE_ZU_XUAN("后三混合组选"),

        QIAN_SAN_ZU_XUAN_HE_ZHI("前三组选和值"),
        ZHONG_SAN_ZU_XUAN_HE_ZHI("中三组选和值"),
        HOU_SAN_ZU_XUAN_HE_ZHI("后三组选和值");

        private final String typeName;

        Sanxing(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

    }

    /**
     * 二星
     */
    enum Erxing implements Shishicai{

        QIAN_ER_ZHI_XUAN_FU_SHI("前二直选复式"),
        HOU_ER_ZHI_XUAN_FU_SHI("后二直选复式"),

        QIAN_ER_ZHI_XUAN_DAN_SHI("前二直选单式"),
        HOU_ER_ZHI_XUAN_DAN_SHI("后二直选单式"),

        QIAN_ER_ZHI_XUAN_HE_ZHI("前二直选和值"),
        HOU_ER_ZHI_XUAN_HE_ZHI("后二直选和值"),

        QIAN_ER_ZU_XUAN_FU_SHI("前二组选复式"),
        HOU_ER_ZU_XUAN_FU_SHI("后二组选复式"),

        QIAN_ER_ZU_XUAN_DAN_SHI("前二组选单式"),
        HOU_ER_ZU_XUAN_DAN_SHI("后二组选单式"),

        QIAN_ER_ZU_XUAN_HE_ZHI("前二组选和值"),
        HOU_ER_ZU_XUAN_HE_ZHI("后二组选和值");

        private final String typeName;

        Erxing(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

    }

    /**
     * 一星
     */
    enum Yixing implements Shishicai{

        YI_XING_DING_WEI_DAN("一星定位胆");

        private final String typeName;

        Yixing(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

    }

    /**
     * 不定胆
     */
    enum Budingdan implements Shishicai{

        QIAN_SAN_YI_MA("前三一码"),
        ZHONG_SAN_YI_MA("中三一码"),
        HOU_SAN_YI_MA("后三一码"),
        REN_SAN_YI_MA("任三一码"),
        SI_XING_YI_MA("四星一码"),

        QIAN_SAN_ER_MA("前三二码"),
        HOU_SAN_ER_MA("后三二码"),
        SI_XING_ER_MA("四星二码"),
        WU_XING_ER_MA("五星二码"),

        WU_XING_SAN_MA("五星三码");

        private final String typeName;

        Budingdan(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

    }

    /**
     * 大小单双
     */
    enum Daxiaodanshuang implements Shishicai{

        QIAN_ER_DA_XIAO_DAN_SHUANG("前二大小单双"),
        HOU_ER_DA_XIAO_DAN_SHUANG("后二大小单双"),
        REN_XUAN_ER_DA_XIAO_DAN_SHUANG("任二大小单双"),
        ZONG_HE_DA_XIAO_DAN_SHUANG("总和大小单双"),

        QIAN_SAN_DA_XIAO_DAN_SHUANG("前三大小单双"),
        HOU_SAN_DA_XIAO_DAN_SHUANG("后三大小单双");

        private final String typeName;

        Daxiaodanshuang(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

    }

    /**
     * 趣味
     */
    enum Quwei implements Shishicai{

        YI_FAN_FENG_SHUN("一帆风顺"),
        HAO_SHI_CHENG_SHUANG("好事成双"),
        SAN_XING_BAO_XI("三星报喜"),
        SI_JI_FA_CAI("四季发财");

        private final String typeName;

        Quwei(String typeName) {
            this.typeName = typeName;
        }

        public String getTypeName() {
            return typeName;
        }

    }

}
