package com.sswh.util.math;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.StrUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author AaronCos
 * @date 2020/10/15
 */
public class NumberUtil {

    private final static Logger log = LoggerFactory.getLogger(NumberUtil.class);

    /**
     * 获取原生int数值
     * @param obj
     * @return int
     */
    public static int getInt(Object obj){
        int result = 0;
        if (obj == null) {
            return result;
        }
        if(obj instanceof String){
            try {
                result = Integer.parseInt((String) obj);
            } catch (NumberFormatException e) {
                log.error("传入的是非数值型字符串");
                e.printStackTrace();
                return 0;
            }
            return result;
        }
        if (obj instanceof Integer){
            result = (int) obj;
        }
        return result;
    }

    /**
     * 解析转换数字字符串为int型数字，规则如下：
     *
     * <pre>
     * 1、0x开头的视为16进制数字
     * 2、0开头的视为8进制数字
     * 3、其它情况按照10进制转换
     * 4、空串返回0
     * 5、.123形式返回0（按照小于0的小数对待）
     * 6、123.56截取小数点之前的数字，忽略小数部分
     * </pre>
     *
     * @param number 数字，支持0x开头、0开头和普通十进制
     * @return int
     * @throws NumberFormatException 数字格式异常
     * @since 4.1.4
     */
    public static int parseInt(String number) throws NumberFormatException {
        if (StrUtil.isBlank(number)) {
            return 0;
        }

        // 对于带小数转换为整数采取去掉小数的策略
        number = StrUtil.subBefore(number, CharUtil.DOT, false);
        if (StrUtil.isEmpty(number)) {
            return 0;
        }

        if (StrUtil.startWithIgnoreCase(number, "0x")) {
            // 0x04表示16进制数
            return Integer.parseInt(number.substring(2), 16);
        }

        return Integer.parseInt(removeNumberFlag(number));
    }

    /**
     * 去掉数字尾部的数字标识，例如12D，44.0F，22L中的最后一个字母
     *
     * @param number 数字字符串
     * @return 去掉标识的字符串
     */
    private static String removeNumberFlag(String number) {
        // 去掉类型标识的结尾
        final int lastPos = number.length() - 1;
        final char lastCharUpper = Character.toUpperCase(number.charAt(lastPos));
        if ('D' == lastCharUpper || 'L' == lastCharUpper || 'F' == lastCharUpper) {
            number = StrUtil.subPre(number, lastPos);
        }
        return number;
    }
}
