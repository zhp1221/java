package com.zhanghp.utils;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.StrUtil;

import java.util.Map;

/**
 * @author: zhanghp
 * @date: 2022-06-25 15:28
 */
@SuppressWarnings({ "rawtypes" })
public class ObjectUtils {

	/**
	 * 判空： 1. CharSquence(String, StringBuilder, StringBuffer) 2. Map 3. Iterable(集合) 3.
	 * Array 4. boolean 5. 空对象,包装类，日期等
	 * @param obj
	 * @return
	 */
	public static boolean isEmpty(Object obj) {
		// 包装类及日期等在这一层判断
		if (obj == null) {
			return true;
		}

		if (obj instanceof CharSequence) {
			return StrUtil.isEmpty((CharSequence) obj);
		}
		else if (obj instanceof Map) {
			return MapUtil.isEmpty((Map) obj);
		}
		else if (obj instanceof Iterable) {
			return IterUtil.isEmpty((Iterable) obj);
		}
		else if (obj.getClass().isArray()) {
			return ArrayUtil.isEmpty(obj);
		}
		else if (obj instanceof Boolean) {
			return (Boolean) obj;
		}
		return false;
	}

	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}

}
