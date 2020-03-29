package com.sswh.utils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nuanfeng
 */
public class IpUtil {
    /**
     *@description
     *@params [request]
     *@return java.lang.String
     *@author mirac
     *@date 2020/3/22 15:18
     */
    public static String getIpAddress(HttpServletRequest request) {
            String ip = request.getHeader("x-forwarded-for");
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("Proxy-Client-IP");
                }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("WL-Proxy-Client-IP");
                }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("HTTP_CLIENT_IP");
                }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                    ip = request.getRemoteAddr();
                }
            return ip;
        }
}
