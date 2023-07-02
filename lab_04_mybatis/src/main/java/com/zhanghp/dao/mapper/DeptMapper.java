package com.zhanghp.dao.mapper;

import com.zhanghp.dao.pojo.Dept;
import org.apache.ibatis.annotations.Param;

/**
 * @author zhanghp
 * @date 2023/6/28 14:20
 */
public interface DeptMapper {

    Dept queryByDeptno(@Param(value = "deptNo") Integer deptNo);
}
