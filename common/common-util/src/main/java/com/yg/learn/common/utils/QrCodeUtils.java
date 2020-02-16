package com.yg.learn.common.utils;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;

public class QrCodeUtils {

    public static void main(String[] args) {

        //QrCodeUtil.generate("http://139.9.199.154:8848/nacos/", 300, 300, FileUtil.file("d:/qrcode.jpg"));
        String decode = QrCodeUtil.decode(FileUtil.file("d:/qrcode.jpg"));
        System.out.println(decode);
    }

}
