package com.zhanghp.utils;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.map.MapUtil;

import java.util.List;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/6/26 13:31
 */
public class CommonUtil {
    /**
     * List打印
     *
     * @param list 集合
     */
    public static void printList(List<?> list) {
        if (IterUtil.isNotEmpty(list)) {
            list.forEach(System.out::println);
        }
    }

    /**
     * Map打印
     *
     * @param map 集合
     */
    public static void printMap(Map<?, ?> map) {
        if (MapUtil.isNotEmpty(map)) {
            map.entrySet().forEach(it -> {
                System.out.println(it.getKey() + ":" + it.getValue());
            });
        }
    }
}
