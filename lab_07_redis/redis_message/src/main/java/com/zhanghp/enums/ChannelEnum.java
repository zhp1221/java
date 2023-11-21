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

	LAB01_BYTE_CHANNEL("lab01_byte_channel"), LAB02_DELEAGTE_CHANNEL("lab02_delegate_channel"),
	LAB03_CONTAINER_CHANNEL("lab03_container_channel"),;

	private final String channel;

}
