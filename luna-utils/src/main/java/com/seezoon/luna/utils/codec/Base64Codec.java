package com.seezoon.luna.utils.codec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * Base64 工具类
 * 
 * @author hdf
 *
 */
public class Base64Codec {

	public static byte[] decodeToByte(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		return Base64.decodeBase64(data);
	}

	public static byte[] decodeToByte(byte[] data) {
		if (null == data) {
			return null;
		}
		return Base64.decodeBase64(data);
	}

	public static String decodeToString(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		return BytesCodec.toString(Base64.decodeBase64(data));
	}

	public static byte[] encodeToByte(byte[] data) {
		if (null == data) {
			return null;
		}
		return Base64.encodeBase64(data);
	}

	public static String encodeToString(byte[] data) {
		if (null == data) {
			return null;
		}
		return Base64.encodeBase64String(data);
	}

	public static String encodeToString(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		return Base64.encodeBase64String(BytesCodec.toBytes(data));
	}
}
