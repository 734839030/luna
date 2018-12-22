package com.seezoon.luna.utils.security;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 签名工具
 * 
 * @author hdf
 *
 */
public class SignatureUtils {

	public static String md5(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		return DigestUtils.md5Hex(data);
	}

	public static String sha1(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		return DigestUtils.sha1Hex(data);
	}

	public static String sha256(String data) {
		if (StringUtils.isEmpty(data)) {
			return null;
		}
		return DigestUtils.sha256Hex(data);
	}
}
