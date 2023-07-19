package com.zhanghp.utils;

/**
 * @author zhanghp
 * @date 2023/7/19 14:13
 */
public class FileUtil {
    public static String getPath(){
        return FileUtil.class.getResource("/").getPath();
    }
}
