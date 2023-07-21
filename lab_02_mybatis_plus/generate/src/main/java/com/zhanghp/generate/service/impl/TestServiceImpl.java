package com.zhanghp.generate.service.impl;

import com.zhanghp.generate.dao.entity.Test;
import com.zhanghp.generate.dao.mapper.TestMapper;
import com.zhanghp.generate.service.TestService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhanghp.generate.model.vo.TestVO;
import com.zhanghp.generate.model.ro.TestRO;
import com.zhanghp.generate.model.qo.TestQO;
import com.zhanghp.generate.model.converter.TestConverter;
import com.zhanghp.common.converter.utils.ConverterUtil;
import com.zhanghp.common.utils.ObjectUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhanghp
 * @since 2023-06-21
 */
@Service
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {
    @Override
    public boolean create(TestRO ro){
        return super.save(ConverterUtil.changeRO(TestConverter.class, ro));
    }

    @Override
    public boolean delete(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean update(TestRO ro){
        return super.updateById(ConverterUtil.changeRO(TestConverter.class, ro));
    }

    @Override
    public TestVO getById(Integer id){

        return ConverterUtil.toVO(TestConverter.class, super.getById(id));
    }

    @Override
    public List<TestVO> findList(TestQO qo){
        return ConverterUtil.toVO(TestConverter.class, super.list(getQueryWrapper(qo)));
    }

    @Override
    public List<TestVO> findPage(TestQO qo){
        Page<Test> page = super.page(new Page(qo.getPageNum(), qo.getPageSize()), getQueryWrapper(qo));
        return ConverterUtil.toVO(TestConverter.class, page.getRecords());
    }

    public LambdaQueryWrapper<Test> getQueryWrapper(TestQO qo){
        return Wrappers.<Test>lambdaQuery()
            .eq(ObjectUtils.isNotEmpty(qo.getId()), Test::getId, qo.getId())
            .eq(ObjectUtils.isNotEmpty(qo.getTime()), Test::getTime, qo.getTime())
            .eq(ObjectUtils.isNotEmpty(qo.getName()), Test::getName, qo.getName())
        ;
    }
}
