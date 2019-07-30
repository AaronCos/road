package com.sswh.model.javase;

import cn.hutool.core.io.FileUtil;

import java.io.File;

/**
 * Created by wangchengcheng on 2019/7/29
 */
public class HuTool {
    public static void main(String[] args) {
        File touch = FileUtil.touch("D:\\aaronsfile\\animal\\helloword.txt");
     /*   boolean notEmpty = FileUtil.isNotEmpty(new File("D:\\aaronsfile\\animal\\helloword.txt"));
        //System.out.println(notEmpty);*/
        FileUtil.appendString("英雄的任务",touch, "utf-8");


    }
}
