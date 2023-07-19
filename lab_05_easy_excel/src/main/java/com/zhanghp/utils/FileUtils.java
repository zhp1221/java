package com.zhanghp.utils;

import java.util.Objects;

/**
 * @author zhanghp
 * @date 2023/7/12 15:15
 */
public class FileUtils {

    /**
     * 获取target下的calsses的绝对路径
     *
     * @return 路径名
     */
    public static String getPath(){
        return Objects.requireNonNull(FileUtils.class.getResource("/")).getPath();
    }
}
