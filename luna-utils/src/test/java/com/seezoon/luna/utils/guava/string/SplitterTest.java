package com.seezoon.luna.utils.guava.string;

import java.util.HashMap;
import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;

public class SplitterTest {

	public static void main(String[] args) {
		Iterable<String> splitResults = Splitter.onPattern("[,，]{1,}").trimResults().omitEmptyStrings()
				.split("hello,word,,世界，水平");

		for (String item : splitResults) {
			System.out.println(item);
		}

		String toSplitString = "a=b;c=d,e=f";
		Map<String, String> kvs = Splitter.onPattern("[,;]{1,}").withKeyValueSeparator('=').split(toSplitString);
		for (Map.Entry<String, String> entry : kvs.entrySet()) {
			System.out.println(String.format("%s=%s", entry.getKey(), entry.getValue()));
		}

		String joinResult = Joiner.on(" ").join(new String[] { "hello", "world" });
		System.out.println(joinResult);

		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "b");
		map.put("c", "d");
		String mapJoinResult = Joiner.on(",").withKeyValueSeparator("=").join(map);
		System.out.println(mapJoinResult);
	}
}
