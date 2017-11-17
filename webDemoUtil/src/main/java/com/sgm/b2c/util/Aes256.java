package com.sgm.b2c.util;

import com.sgm.b2c.exception.UtilException;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Security;

/**
 * @author Created by Li B.
 * @date Created in 2017/11/16.
 */
public class Aes256 {
    private static final String AES_KEY = "776C4B4E5A7245634D446238395A6149643055626C46584D77684E434A696A423759364832366F5A575A667A54716768776151734F767731375139722B774C47";

    public static String encrypt(String content){
        try {
            //"AES"：请求的密钥算法的标准名称
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            //256：密钥生成参数；securerandom：密钥生成器的随机源
            SecureRandom secureRandom = new SecureRandom(toHash256Deal(AES_KEY));
            keyGenerator.init(256,secureRandom);
            //生成秘密（对称）密钥
            SecretKey secretKey = keyGenerator.generateKey();
            //返回基本编码格式的密钥
            byte[] enCodeFormat = secretKey.getEncoded();
            //根据给定的字节数组构造一个密钥。enCodeFormat：密钥内容；"AES"：与给定的密钥内容相关联的密钥算法的名称
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            //将提供程序添加到下一个可用位置
            Security.addProvider(new BouncyCastleProvider());
            //创建一个实现指定转换的 Cipher对象，该转换由指定的提供程序提供。
            //"AES/ECB/PKCS7Padding"：转换的名称；"BC"：提供程序的名称
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes("utf-8");
            byte[] cryptograph = cipher.doFinal(byteContent);
            return JsonUtil.parseByte2HexStr(Base64.encode(cryptograph));
        } catch (Exception e) {
            throw new UtilException("AES加密异常",e);
        }
    }

    public static String decrypt(String cryptograph) {
        try {
            KeyGenerator kgen = KeyGenerator.getInstance("AES");
            SecureRandom securerandom = new SecureRandom(toHash256Deal(AES_KEY));
            kgen.init(256, securerandom);
            SecretKey secretKey = kgen.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Security.addProvider(new BouncyCastleProvider());
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] content = cipher.doFinal(Base64.decode(JsonUtil.parseHexStr2Byte(cryptograph)));
            return new String(content);
        } catch (Exception e) {
            throw new UtilException("AES解密异常",e);
        }
    }

    private static byte[] toHash256Deal(String str){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            throw new UtilException("toHash256Deal异常",e);
        }
    }

    public static void main(String[] args) {
        String string  = "asdfasdfer534dfasdf==-324dashae";
        String string1 = encrypt(string);
        System.out.println(string1.length());
        System.out.println(decrypt(string1));
    }
}
