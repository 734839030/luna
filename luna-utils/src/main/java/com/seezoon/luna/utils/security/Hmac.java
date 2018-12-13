package com.seezoon.luna.utils.security;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import com.seezoon.luna.utils.codec.Base64Codec;
import com.seezoon.luna.utils.codec.BytesCodec;

public class Hmac {
	
	public static final String HMAC_SHA1_ALGORITHM = "HmacSHA1";
	public static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
	 
	/**
	 * 使用 HMAC-SHA1 签名方法对data进行签名
	 * 
	 * @param data 被签名的字符串
	 * @param key  密钥     
	 * @return  加密后的字符串
	 */
	public static String genHMAC(String data, String key,String algorithm) {
		byte[] result = null;
		try {
			//根据给定的字节数组构造一个密钥,第二参数指定一个密钥算法的名称  
			SecretKeySpec signinKey = new SecretKeySpec(BytesCodec.toBytes(key), algorithm);
			//生成一个指定 Mac 算法 的 Mac 对象  
			Mac mac = Mac.getInstance(algorithm);
			//用给定密钥初始化 Mac 对象  
			mac.init(signinKey);
			//完成 Mac 操作   
			byte[] rawHmac = mac.doFinal(BytesCodec.toBytes(data));
			result = Base64Codec.encodeToByte(rawHmac);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} 
		return BytesCodec.toString(result);
	}
}
