package com.zhanghp;

import com.zhanghp.lab02.pub.MessageDelegatePub;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @date 2023/7/21 16:48
 */
public class Lab02Test extends RedisMessageApplicationTests {

	@Resource
	private MessageDelegatePub messageDelegatePub;

	@Test
	public void pub() {
		messageDelegatePub.pub();
	}

}
