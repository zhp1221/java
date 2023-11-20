package com.zhanghp.dao.mapper;

import com.zhanghp.dao.bean.Demo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * mybatis - demo表 Mapper 接口
 * </p>
 *
 * @author zhp
 * @since 2023-11-20
 */
@Mapper
public interface DemoMapper extends BaseMapper<Demo> {

}
