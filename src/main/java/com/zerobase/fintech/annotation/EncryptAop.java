package com.zerobase.fintech.annotation;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Aspect
@Component
@RequiredArgsConstructor
public class EncryptAop {

    public static final String alg = "AES/CBC/PKCS5Padding";
    private static final String KEY = "ZEROBASEKEYISZEROBASEKEY";
    private static final String IV = KEY.substring(0,16);

    @Pointcut("execution(* com.zerobase.fintech.repository.UserInfoRepository.save(..))")
    public void beforeSave() {}

    @Pointcut("execution(* com.zerobase.fintech.repository.UserInfoRepository.find*(..))")
    public void afterFind() {}

    @Pointcut("@annotation(com.zerobase.fintech.annotation.Encrypt)")
    public void encrypt() {}

    @Before("encrypt() && beforeSave()")
    public String encrypting(JoinPoint jp) {
        try {
            Object[] args = jp.getArgs();
            String text = String.valueOf(args[0]);

            Cipher cipher = Cipher.getInstance(alg);
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, ivParameterSpec);
            byte[] encrypted = cipher.doFinal(text.getBytes(StandardCharsets.UTF_8));
            return Base64.encodeBase64String(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    @After("afterFind() && encrypt()")
    public void decrypting(JoinPoint jp) {
        try {
            Object[] args = jp.getArgs();
            String cipherText = (String) args[0];

            Cipher cipher = Cipher.getInstance(alg);
            SecretKeySpec keySpec = new SecretKeySpec(KEY.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(IV.getBytes(StandardCharsets.UTF_8));
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParameterSpec);

            byte[] decodedBytes = Base64.decodeBase64(cipherText);
            byte[] decrypted = cipher.doFinal(decodedBytes);

            args[1] = new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
