package com.zhanghp.dao.mapper;

import com.zhanghp.dao.pojo.Demo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/6/26 10:45
 */
public interface DemoMapper {
    /**
     * 查询全部记录
     *
     * @return {@link com.zhanghp.dao.pojo.Demo}
     */
    List<Demo> queryAll();

    /**
     * 通过Demo对象传参，新增一条记录
     *
     * @param demo 所需插入的对象信息
     * @return 插入成功的行数
     */
    int insertOneByDemo(@Param("demo") Demo demo);

    /**
     * 通过Demo对象的传参及指定的id，来进行更新记录
     *
     * @param demo 所需修改的对象信息
     * @return 修改成功的行数
     */
    int updateOneByDemo(@Param("demo") Demo demo);

    /**
     * 根据主键id删除指定的记录
     *
     * @param id 主键id
     * @return 删除成功的行数
     */
    int deleteOneById(@Param("id") Integer id);

    /**
     * 通过单个基本数据类型查询
     *
     * @param name 姓名
     * @return {@link com.zhanghp.dao.pojo.Demo}
     */
    List<Demo> selectBySingleType(@Param("name") String name);

    /**
     * 通过多个基本数据类型查询
     *
     * @param name 姓名
     * @param age  年龄
     * @return {@link com.zhanghp.dao.pojo.Demo}
     */
    List<Demo> selectByMultiType(@Param("name") String name,
                                 @Param("age") Integer age);

    /**
     * 通过实体类查询
     *
     * @param demo 实体类
     * @return {@link com.zhanghp.dao.pojo.Demo}
     */
    List<Demo> selectByBean(@Param("demo") Demo demo);

    /**
     * 通过多个实体类查询
     *
     * @param demo01 实体类1
     * @param demo02 实体类2
     * @return {@link com.zhanghp.dao.pojo.Demo}
     */
    List<Demo> selectByMultiBean(@Param("demo01") Demo demo01,
                                 @Param("demo02") Demo demo02);


    List<Demo> selectByMap(@Param("map") Map<String, Object> map);

    /**
     * 模糊查询
     *
     * @param name 模糊字段
     * @return {@link com.zhanghp.dao.pojo.Demo}
     */
    List<Demo> fuzzyQuery(@Param("name") String name);

// ========================动态sql===============================

    /**
     * 动态sql - if 使用
     *
     * @param name 姓名
     * @return 匹配记录集合
     */
    List<Demo> dynamicIf(@Param(value = "name") String name);

    /**
     * 动态sql - if 使用
     *
     * @param demo 对象
     * @return 匹配记录集合
     */
    List<Demo> dynamicIfByDemo(@Param(value = "demo") Demo demo);

    /***
     * 动态sql - if 模糊查询
     *
     * @param name 名字
     * @return 匹配记录集合
     */
    List<Demo> dynamicIfFuzzy(@Param(value = "name") String name);

    /**
     * 动态sql - choose, when & otherwise 使用
     *
     * @param demo 对象
     * @param name 名字
     * @return 匹配记录集合
     */
    List<Demo> dynamicChooseWhenAndOtherwise(@Param(value = "demo") Demo demo, @Param(value = "name") String name);

    /**
     * 动态sql - where 使用
     *
     * @return 匹配记录集合
     */
    List<Demo> dynamicWhere(@Param(value = "name") String name);

    /**
     * 动态sql - trim 使用
     *
     * @return 集合
     */
    List<Demo> dynamicTrim();

    /**
     * 动态sql - set使用
     *
     * @param age 年龄
     * @param id  主键
     * @return 更新成功的行数
     */
    int dynamicSet(@Param(value = "age") Integer age, @Param(value = "id") Integer id);

    /**
     * 动态sql - foreach 使用
     *
     * @param ids id集合
     * @return 匹配记录
     */
    List<Demo> dynamicForeach(@Param(value = "list") List<Integer> ids);

    /**
     * 动态sql - sql使用
     *
     * @return 集合
     */
    List<Demo> dynamicSql();

    /**
     * 动态sql - bind 使用
     *
     * @param demo 对象
     * @return 集合
     */
    List<Demo> dynamicBind(@Param(value = "demo") Demo demo);

}
