package com.sswh.Enum;

/**
 * 课程代号
 * @author nuanfeng
 * @date 2020/3/22 23:28
 */
public enum Subject {
    /**
     * 中文
     */
    CHINESE(1),MATH(2),ENGLISH(3),PHYSICS(4),CHEMISTRY(5),HISTORY(6),GEOGRAPHY(7),BIOLOGY(8),POLITY(9);
    private int courseCode;
    Subject(int subject) {
        this.courseCode = subject;
    }
    public int getCourseCode(){
        return courseCode;
    }
}
