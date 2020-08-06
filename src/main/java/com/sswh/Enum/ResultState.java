package com.sswh.Enum;

/**
 * @author nuanfeng
 * @date 2020/8/6 22:44
 */
public enum ResultState {
    SUCCESS(1),
    ERROR(0),
    FAIL(2);
    private final int state;

    ResultState(int code){
        this.state = code;
    }
    public int getStateCode(){
        return state;
    }
}
