package com.zhanghp.lab01_read_write;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/9/6 18:08
 */
public class T {
    public static void main(String[] args) {
        HashMap<Integer, String> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put(1, "张三");
        objectObjectHashMap.put(1, "d ");
        for (Map.Entry<Integer, String> it : objectObjectHashMap.entrySet()) {
            System.out.println(it.getKey());
            System.out.println(it.getValue());
        }

    }
}
