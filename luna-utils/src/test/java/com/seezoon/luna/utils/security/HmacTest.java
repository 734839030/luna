package com.seezoon.luna.utils.security;

import org.junit.Test;

public class HmacTest {

	@Test
	public void testGenHMAC() {
		System.out.println(Hmac.genHMAC("1111", "黄到呢风", Hmac.HMAC_SHA1_ALGORITHM));
		System.out.println(Hmac.genHMAC("1111", "2222", Hmac.HMAC_SHA256_ALGORITHM));
	}

}
