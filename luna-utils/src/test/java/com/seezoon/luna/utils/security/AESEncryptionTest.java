package com.seezoon.luna.utils.security;

import org.junit.Test;

public class AESEncryptionTest {

	private String pwd = "111";
	
	@Test
	public void testEncrypt() {
		String encrypt = AESEncryption.encrypt("123456", pwd);
		System.out.println("encrypt:" + encrypt);
		
	}

	@Test
	public void testDecrypt() {
		String encrypt = AESEncryption.encrypt("123456", pwd);
		String decrypt = AESEncryption.decrypt(encrypt, pwd);
		System.out.println("decrypt:" + decrypt);

	}

}
