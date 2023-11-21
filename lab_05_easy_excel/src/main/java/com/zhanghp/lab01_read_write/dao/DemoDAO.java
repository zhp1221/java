package com.zhanghp.lab01_read_write.dao;

import com.zhanghp.entity.DemoData;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.ListUtils;

import java.util.List;

/**
 * 假设这个是你的DAO存储。当然还要这个类让spring管理，当然你不用需要存储，也不需要这个类。
 *
 * @author Jiaju Zhuang
 **/
public class DemoDAO {

	public void save(List<DemoData> list) {
		// 如果是mybatis,尽量别直接调用多次insert,自己写一个mapper里面新增一个方法batchInsert,所有数据一次性插入
		if (list == null || list.size() == 0) {
			return;
		}
		list.forEach(System.out::println);
		System.out.println("------");
	}

}
