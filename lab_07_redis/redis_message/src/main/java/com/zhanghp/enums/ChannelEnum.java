package com.zhanghp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhanghp
 * @date 2023/7/20 20:08
 */
@Getter
@AllArgsConstructor
public enum ChannelEnum {
    LAB01_CHANNEL("lab01_channel");
    private final String channel;
}
