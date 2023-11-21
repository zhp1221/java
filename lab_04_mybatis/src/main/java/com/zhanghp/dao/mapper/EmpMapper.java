package com.zhanghp.dao.mapper;

import com.zhanghp.dao.pojo.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zhanghp 13:58
 */
public interface EmpMapper {

	List<Emp> constructorQuery(@Param(value = "deptno") Integer deptno);

}
