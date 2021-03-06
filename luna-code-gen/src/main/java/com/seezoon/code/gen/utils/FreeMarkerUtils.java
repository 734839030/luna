package com.seezoon.code.gen.utils;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerUtils {

	public static final String DEFAULT_DIRECTORY = "template";
	private static Configuration cfg = buildConfiguration(DEFAULT_DIRECTORY);

	public static Configuration buildConfiguration(String directory) {
		Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		cfg.setDefaultEncoding("utf-8");
		cfg.setClassLoaderForTemplateLoading(FreeMarkerUtils.class.getClassLoader(), DEFAULT_DIRECTORY);
		return cfg;
	}

	/**
	 * 
	 * @param name
	 *            相对路径下的模板
	 * @param data
	 *            数据
	 * @param out
	 *            输出流
	 */
	public static void renderTemplate(String name, Object data, Writer out) {
		try {
			Template template = cfg.getTemplate(name);
			template.process(data, out);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 获取渲染后的文本
	 * @param name
	 *            相对路径下的模板
	 * @param data
	 *            数据
	 * @param out
	 *            输出流
	 */
	public static String renderTemplate(String name, Object data) {
		String result = null;
		try {
			Template template = cfg.getTemplate(name);
			StringWriter out = new StringWriter();
			template.process(data, out);
			result = out.toString();
			out.close();
			return result;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	/**
	 * 模板内容
	 * @param name
	 *            相对路径下的模板
	 */
	public static String readTemplate(String name) {
		try {
			Template template = cfg.getTemplate(name);
			return template.toString();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * 字符串模板
	 * @param templateString
	 * @param data
	 * @return
	 */
	public static String renderStringTemplate(String templateString, Object data) {
		Template template;
		String result = null;
		try {
			template = new Template(null, new StringReader(templateString), cfg);
			StringWriter sw = new StringWriter();
			template.process(data, sw);
			result = sw.toString();
			sw.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return result;
	}
}
