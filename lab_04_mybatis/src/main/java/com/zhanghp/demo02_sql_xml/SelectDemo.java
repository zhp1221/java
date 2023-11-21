package com.zhanghp.demo02_sql_xml;

import cn.hutool.core.collection.IterUtil;
import cn.hutool.core.map.MapUtil;
import com.zhanghp.connect.ConnectUtil;
import com.zhanghp.dao.pojo.Demo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

/**
 * select demo
 *
 * @author zhanghp
 * @date 2023/6/25 23:30
 */
public class SelectDemo {

	/**
	 * 获取SqlSession
	 */
	private final SqlSession SQLSESSION = ConnectUtil.getSqlSession();

	/**
	 * 获取全部记录，通过List返回
	 */
	public void queryAll() {
		try {
			List<Demo> demoList = SQLSESSION.selectList("selectDemo");
			if (IterUtil.isNotEmpty(demoList)) {
				demoList.forEach(System.out::println);
			}
		}
		finally {
			// 释放资源
			ConnectUtil.release(SQLSESSION);
		}
	}

	/**
	 * 获取全部记录，通过Map返回
	 */
	public void queryReturnMap() {
		try {
			// 第二参数为mapKey：需指定主键名称
			Map<Integer, Demo> demoMap = SQLSESSION.selectMap("queryReturnMap", "id");
			if (MapUtil.isNotEmpty(demoMap)) {
				demoMap.entrySet().forEach(it -> {
					System.out.println(it.getKey() + "：" + it.getValue());
				});
			}
		}
		finally {
			// 释放资源
			ConnectUtil.release(SQLSESSION);
		}
	}

	/**
	 * 通过主键id传参获取对应的一条记录
	 * @param id 主键id
	 */
	public void queryById(Integer id) {
		try {
			// select
			Demo demo = SQLSESSION.selectOne("queryById", 1);
			System.out.println(demo);
		}
		finally {
			// 释放资源
			ConnectUtil.release(SQLSESSION);
		}
	}

	/**
	 * 通过map传参获取记录集合
	 * @param map {@link java.util.Map}
	 */
	public void queryByMap(Map<String, Object> map) {
		try {
			// select
			List<Demo> demoList = SQLSESSION.selectList("queryByMap", map);
			if (IterUtil.isNotEmpty(demoList)) {
				demoList.forEach(System.out::println);
			}
		}
		finally {
			// 释放资源
			ConnectUtil.release(SQLSESSION);
		}

	}

	/**
	 * 通过对象传参获取集合
	 * @param demo {@link com.zhanghp.dao.pojo.Demo}
	 */
	public void queryByDemo(Demo demo) {
		try {
			List<Demo> demoList = SQLSESSION.selectList("queryByDemo", demo);
			if (IterUtil.isNotEmpty(demoList)) {
				demoList.forEach(System.out::println);
			}
		}
		finally {
			// 释放资源
			ConnectUtil.release(SQLSESSION);
		}
	}

}
