package com.zhanghp.dao.mapper;

import com.zhanghp.dao.pojo.Demo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/6/26 22:32
 */
public interface DemoAnnotationMapper {

	/**
	 * 查询全部
	 * @return {@link com.zhanghp.dao.pojo.Demo}
	 */
	@Select("select * from demo")
	List<Demo> queryAll();

	/**
	 * 通过主键查询单条记录
	 * @return {@link com.zhanghp.dao.pojo.Demo}
	 */
	@Select("select * from demo where id = #{id}")
	Demo queryById(@Param(value = "id") Integer id);

	/**
	 * 通过map匹配对应的对象集合
	 * @return {@link com.zhanghp.dao.pojo.Demo}
	 */
	@Select("select * from demo where name = #{map.name} and age = #{map.age}")
	List<Demo> queryByMap(@Param(value = "map") Map<String, Object> map);

	/**
	 * 通过对象指定的信息查询所匹配的集合
	 * @return {@link com.zhanghp.dao.pojo.Demo}
	 */
	@Select("select * from demo where name = #{demo.name} and age = #{demo.age}")
	List<Demo> queryByDemo(@Param(value = "demo") Demo demo);

	/**
	 * 通过map插入
	 * @param map 信息
	 * @return 插入成功的行数
	 */
	@Insert("insert into demo values (#{map.id}, #{map.name}, #{map.age})")
	int insertByMap(@Param(value = "map") Map<String, Object> map);

	/**
	 * 通过对象插入
	 * @param demo 实体类
	 * @return 插入成功行数
	 */
	@Insert("insert into demo values (#{demo.id}, #{demo.name}, #{demo.age})")
	int insertByDemo(@Param(value = "demo") Demo demo);

	/**
	 * 通过指定的几个参数修改
	 * @param name 姓名
	 * @param age 年龄
	 * @param id 主键
	 * @return 修改成功的行数
	 */
	@Update("update demo set name = #{name}, age = #{age} where id = #{id}")
	int updateByParams(@Param(value = "name") String name, @Param(value = "age") Integer age,
			@Param(value = "id") Integer id);

	/**
	 * 通过主键删除对应的记录
	 * @param id 主键
	 * @return 删除成功行数
	 */
	@Delete("delete from demo where id = #{id}")
	int deleteById(@Param(value = "id") Integer id);

}
