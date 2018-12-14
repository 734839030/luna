package com.seezoon.luna.utils.security;

import java.util.Map;

import org.junit.Test;

import com.seezoon.luna.utils.codec.Base64Codec;

public class RSAEncryptionTest {

	@Test
	public void test() throws Exception {
		Map<String, Object> genKeyPair = RSAEncryption.genKeyPair();
    	String publicKey = RSAEncryption.getPublicKey(genKeyPair);
    	String privateKey = RSAEncryption.getPrivateKey(genKeyPair);
    	System.out.println("publicKey:" + publicKey);
    	System.out.println("privateKey:" + privateKey);
    	//加解密
    	String content = "123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄12345123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄12123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄12123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄126黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄123456黄";
    	System.out.println(content.getBytes().length);
    	byte[] encryptByPublicKey = RSAEncryption.encryptByPublicKey(content.getBytes(), publicKey);
    	System.out.println(Base64Codec.encodeToString(encryptByPublicKey));
    	byte[] decryptByPrivateKey = RSAEncryption.decryptByPrivateKey(encryptByPublicKey, privateKey);
    	System.out.println(new String(decryptByPrivateKey));
    	//验签名
    	String sign = RSAEncryption.sign(content.getBytes(), privateKey);
    	System.out.println("sign:" + sign);
    	boolean verify = RSAEncryption.verify(content.getBytes(), publicKey, sign);
    	System.out.println("verify:" + verify);
	}
	

}
