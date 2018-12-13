package com.seezoon.luna.utils.codec;

import org.junit.Test;

public class Base64CodecTest {

	@Test
	public void testDecodeToString() {
		System.out.println(Base64Codec.encodeToString("123456"));
	}

	@Test
	public void testEncodeToStringString() {
		System.out.println(Base64Codec.encodeToString(Base64Codec.encodeToString("123456")));;
	}

}
