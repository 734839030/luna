package com.seezoon.luna.utils.codec;

import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;

/**
 * 字符串转字节，字节转字符串
 * @author hdf
 *
 */
public class BytesCodec {

	public final static Charset CHARSET = Charset.forName("UTF-8");
	
	public static byte[]  toBytes(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		return data.getBytes(CHARSET);
	}
	public static String toString(byte[] data) {
		if (null == data) {
			return null;
		}
		return new String(data,CHARSET);
	}
}
