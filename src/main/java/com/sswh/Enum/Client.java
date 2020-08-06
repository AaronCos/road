package com.sswh.Enum;

/**
 * 客户端
 * @author nuanfeng
 * @date 2020/8/6 22:14
 */
public enum Client {
    /**pc客户端*/
    PC(1),
    /**微信小程序*/
    WXXCX(2),
    /**微信公众号*/
    WXGZH(3),
    /**支付宝小程序*/
    ZFBXCX(4),
    /**短信*/
    DX(5);

    private final int clientCode;

    Client(int code) {
        this.clientCode = code;
    }
    public int getClientCode(){
        return this.clientCode;
    }
}
