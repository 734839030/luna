package com.seezoon.luna.utils.codec;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import org.apache.commons.lang3.StringUtils;

/**
 * url 编解码
 * @author hdf
 *
 */
public class UrlCodec {

	private static final String DEFAULT_URL_ENCODING = "UTF-8";

	/**
	 * url编码
	 * 
	 * @param text
	 * @return
	 */
	public static String urlEncode(String text) {
		if (StringUtils.isEmpty(text)) {
			return null;
		}
		try {
			return URLEncoder.encode(text, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {

		}
		return null;
	}

	/**
	 * url解码
	 * 
	 * @param text
	 * @return
	 */
	public static String urlDecode(String text) {
		if (StringUtils.isEmpty(text)) {
			return null;
		}
		try {
			return URLDecoder.decode(text, DEFAULT_URL_ENCODING);
		} catch (UnsupportedEncodingException e) {

		}
		return null;
	}
	
}
