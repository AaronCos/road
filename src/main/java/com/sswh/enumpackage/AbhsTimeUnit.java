package com.sswh.enumpackage;

/**
 * 艾宾浩斯时间单元
 * @author nuanfeng
 * @date 2020/8/6 12:36
 */
public enum AbhsTimeUnit {
    /** 一毫秒 */
    MS(1),
    /** 一秒的毫秒数 */
    SECOND(1000),
    /**一分钟的毫秒数 */
    MINUTE(SECOND.getMillis() * 60),
    /**一小时的毫秒数 */
    HOUR(MINUTE.getMillis() * 60),
    /**一天的毫秒数 */
    DAY(HOUR.getMillis() * 24),
    /**一周的毫秒数 */
    WEEK(DAY.getMillis() * 7);

    private final long millis;
    AbhsTimeUnit(long millis){
        this.millis = millis;
    }

    /**
     * @return 单位对应的毫秒数
     */
    public long getMillis(){
        return this.millis;
    }
}
