package com.sswh.noraml;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import org.junit.Test;

import javax.crypto.SecretKey;
import java.util.Arrays;

/**
 * @author Aaron
 * @date 2020/3/6 13:50
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"}) //加载配置文件*/
public class HuToolTest {

    /**
     * 学习AES加密
     */
    @Test
    public void aesTest(){
        String content = "test中文";


//随机生成密钥
        byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
        String s = Arrays.toString(key);
        System.out.println(s);

//构建
        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);
        SecretKey secretKey = aes.getSecretKey();
        String algorithm = secretKey.getAlgorithm();
        byte[] encoded = secretKey.getEncoded();
        Byte[] bytes = new Byte[10];
        bytes[0] = 'a';
        System.out.println(bytes[0]);

//加密
        byte[] encrypt = aes.encrypt(content);
//解密
        byte[] decrypt = aes.decrypt(encrypt);

//加密为16进制表示
        String encryptHex = aes.encryptHex(content);
        System.out.println(encryptHex);
//解密为字符串
        String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
        System.out.println(decryptStr);

    }

}
