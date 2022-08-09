package com.zhanghp.generate.service.impl;

import com.zhanghp.generate.dao.entity.Label;
import com.zhanghp.generate.dao.mapper.LabelMapper;
import com.zhanghp.generate.service.LabelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhanghp.generate.model.vo.LabelVO;
import com.zhanghp.generate.model.ro.LabelRO;
import com.zhanghp.generate.model.qo.LabelQO;
import com.zhanghp.generate.model.converter.LabelConverter;
import com.zhanghp.common.converter.utils.ConverterUtil;
import com.zhanghp.common.utils.ObjectUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * <p>
 * 标签 服务实现类
 * </p>
 *
 * @author zhanghp
 * @since 2022-08-09
 */
@Service
public class LabelServiceImpl extends ServiceImpl<LabelMapper, Label> implements LabelService {
    @Override
    public boolean create(LabelRO ro){
        return super.save(ConverterUtil.changeRO(LabelConverter.class, ro));
    }

    @Override
    public boolean delete(Long id){
        return super.removeById(id);
    }

    @Override
    public boolean update(LabelRO ro){
        return super.updateById(ConverterUtil.changeRO(LabelConverter.class, ro));
    }

    @Override
    public LabelVO getById(Long id){

        return ConverterUtil.toVO(LabelConverter.class, super.getById(id));
    }

    @Override
    public List<LabelVO> findList(LabelQO qo){
        return ConverterUtil.toVO(LabelConverter.class, super.list(getQueryWrapper(qo)));
    }

    @Override
    public List<LabelVO> findPage(LabelQO qo){
        Page<Label> page = super.page(new Page(qo.getPageNum(), qo.getPageSize()), getQueryWrapper(qo));
        return ConverterUtil.toVO(LabelConverter.class, page.getRecords());
    }

    public LambdaQueryWrapper<Label> getQueryWrapper(LabelQO qo){
        return Wrappers.<Label>lambdaQuery()
            .eq(ObjectUtils.isNotEmpty(qo.getId()), Label::getId, qo.getId())
            .eq(ObjectUtils.isNotEmpty(qo.getName()), Label::getName, qo.getName())
            .eq(ObjectUtils.isNotEmpty(qo.getSort()), Label::getSort, qo.getSort())
        ;
    }
}
