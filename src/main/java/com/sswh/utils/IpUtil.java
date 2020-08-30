package com.sswh.utils;

import cn.hutool.core.util.StrUtil;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nuanfeng
 */
public class IpUtil {
    private static final Log logger = LogFactory.getLog(IpUtil.class);

    /**
     * 获取访问的ip
     *
     * @return
     * @Description:TODO(描述这个方法的作用，另外可增加适用条件、调用方式和注意事项相关的内容)
     * @author mirac
     * @date 2020年8月8日下午3:54:56
     */
    public static String getIp() {
        ServletRequestAttributes var0 = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = null;
        if (var0 != null) {
            request = var0.getRequest();
        }
        return getIp(request);
    }

    public static String getIp(HttpServletRequest httpServletRequest) {
        String var1 = getAllIp(httpServletRequest);
        if (StrUtil.isNotEmpty(var1)) {
            var1 = var1.split(",")[0];
        }
        var1 = washIpV6(var1);
        return var1;
    }

    public static String getAllIp(HttpServletRequest httpServletRequest) {
        String a = "x-forwarded-for";
        if (httpServletRequest == null) {
            return "";
        } else {
            String var1 = httpServletRequest.getHeader(a);
            logger.debug("load ip from " + a + " is " + var1);
            String var2 = httpServletRequest.getHeader("http_client_ip");
            logger.debug("load ip from http_client_ip is " + var2);
            String var3 = "unknown";
            String var4 = null;
            if (var1 != null && !var1.equalsIgnoreCase(var3) && var1.trim().length() > 0) {
                var4 = var1;
                logger.debug("get ip from " + a + " is " + var1);
            } else if (var2 != null && !var2.equalsIgnoreCase(var3) && var2.trim().length() > 0) {
                var4 = var2;
                logger.debug("get ip from http_client_ip is " + var2);
            } else {
                var4 = httpServletRequest.getRemoteAddr();
                logger.debug("get ip from RemoteAddr is " + var4);
            }

            return var4;
        }
    }

    public static String washIpV6(String var0) {
        if (StrUtil.isNotEmpty(var0) && var0.indexOf("%") > -1) {
            var0 = var0.split("%")[0];
        }

        return var0;
    }
}
