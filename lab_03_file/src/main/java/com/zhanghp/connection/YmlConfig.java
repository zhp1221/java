package com.zhanghp.con;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * 配置注入不进来，待研究...
 *
 * @author zhanghp
 * @date 2022-07-30 16:24
 */
@Component
@ConfigurationProperties(prefix = "file")
@EnableConfigurationProperties(YmlConfig.class)
public class YmlConfig {

    public static void setProfile(String profile) {
        YmlConfig.profile = profile;
    }

    /**
     * 配置
     */
    private static String profile;

    public static String getProfile(){
        return profile;
    }
    /**
     * 获取Win下的基路径
     *
     * @return 文件路径
     */
    public static String getWinUploadPath() {
        return "C:" + File.separator + getProfile();
    }

    /**
     * 获取linux下的基路径
     *
     * @return 文件路径
     */
    public static String getLinuxUploadPath() {
        return File.separator + profile;
    }
}
