package com.zhanghp.producer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/8/2 19:39
 */
public class Test {

	public static void main(String[] args) {
		List<String> hourList = new ArrayList<>();
		hourList.add("10:00");
		hourList.add("13:00");
		hourList.add("15:00");
		hourList.add("16:00");
		hourList.add("18:00");
		hourList.add("19:20");
		hourList.add("20:20");
		hourList.add("21:00");
		hourList.add("21:30");
		hourList.add("22:30");
		hourList.add("22:30");
		hourList.add("22:30");

		hourList.addAll(hourList);

		hourList.forEach(System.out::println);
	}

}
