package com.yg.learn.common.utils;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SmUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.SM2;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class BouncyCastleUtils {

    private final SymmetricCrypto sm4 = SmUtil.sm4();

    public String getEncoded(){
        SecretKey secretKey = sm4.getSecretKey();
        String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());
        System.out.println("密钥:" + encodedKey);
        return encodedKey;
    }

    public String encryptHex(String content) {
        return sm4.encryptHex(content);
    }

    public String decryptStr(String content) {
        return sm4.decryptStr(content, CharsetUtil.CHARSET_UTF_8);
    }

    // 国密算法
    public static void main(String[] args) throws UnsupportedEncodingException {
        BouncyCastleUtils bouncyCastleUtils = new BouncyCastleUtils();
        //String content = new String("test中文".getBytes(),"GBK");
        bouncyCastleUtils.getEncoded();
        String content = "test中文";
        String encryptHex = bouncyCastleUtils.encryptHex(content);
        System.out.println("加密内容:" + encryptHex);
        String decryptStr = bouncyCastleUtils.decryptStr(encryptHex);
        System.out.println("解密内容:" + decryptStr);
    }

}
