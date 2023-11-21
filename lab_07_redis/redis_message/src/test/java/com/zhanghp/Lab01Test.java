package com.zhanghp;

import com.zhanghp.lab01.pub.RedisBytePub;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

/**
 * @author zhanghp
 * @date 2023/7/20 20:14
 */
public class Lab01Test extends RedisMessageApplicationTests {

	@Resource
	private RedisBytePub redisPub;

	@Test
	public void pub() {
		redisPub.pubByJedisCon();
	}

	@Test
	public void pub2() {
		redisPub.pubByRedisCon();
	}

}
