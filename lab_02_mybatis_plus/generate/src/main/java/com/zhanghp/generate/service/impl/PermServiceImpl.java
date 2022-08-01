package com.zhanghp.generate.service.impl;

import com.zhanghp.generate.dao.entity.Perm;
import com.zhanghp.generate.dao.mapper.PermMapper;
import com.zhanghp.generate.service.PermService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhanghp.generate.model.vo.PermVO;
import com.zhanghp.generate.model.ro.PermRO;
import com.zhanghp.generate.model.qo.PermQO;
import com.zhanghp.generate.model.converter.PermConverter;
import com.zhanghp.common.converter.utils.ConverterUtil;
import com.zhanghp.common.utils.ObjectUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.stereotype.Service;
import java.util.*;

/**
 * <p>
 * 功能权限表 服务实现类
 * </p>
 *
 * @author zhanghp
 * @since 2022-07-29
 */
@Service
public class PermServiceImpl extends ServiceImpl<PermMapper, Perm> implements PermService {
    @Override
    public boolean create(PermRO ro){
        return super.save(ConverterUtil.changeRO(PermConverter.class, ro));
    }

    @Override
    public boolean delete(Integer id){
        return super.removeById(id);
    }

    @Override
    public boolean update(PermRO ro){
        return super.updateById(ConverterUtil.changeRO(PermConverter.class, ro));
    }

    @Override
    public PermVO getById(Integer id){

        return ConverterUtil.toVO(PermConverter.class, super.getById(id));
    }

    @Override
    public List<PermVO> findList(PermQO qo){
        return ConverterUtil.toVO(PermConverter.class, super.list(getQueryWrapper(qo)));
    }

    @Override
    public List<PermVO> findPage(PermQO qo){
        Page<Perm> page = super.page(new Page(qo.getPageNum(), qo.getPageSize()), getQueryWrapper(qo));
        return ConverterUtil.toVO(PermConverter.class, page.getRecords());
    }

    public LambdaQueryWrapper<Perm> getQueryWrapper(PermQO qo){
        return Wrappers.<Perm>lambdaQuery()
            .eq(ObjectUtils.isNotEmpty(qo.getId()), Perm::getId, qo.getId())
            .eq(ObjectUtils.isNotEmpty(qo.getParentId()), Perm::getParentId, qo.getParentId())
            .eq(ObjectUtils.isNotEmpty(qo.getName()), Perm::getName, qo.getName())
            .eq(ObjectUtils.isNotEmpty(qo.getPath()), Perm::getPath, qo.getPath())
            .eq(ObjectUtils.isNotEmpty(qo.getCode()), Perm::getCode, qo.getCode())
            .eq(ObjectUtils.isNotEmpty(qo.getSort()), Perm::getSort, qo.getSort())
            .eq(ObjectUtils.isNotEmpty(qo.getMenuType()), Perm::getMenuType, qo.getMenuType())
            .eq(ObjectUtils.isNotEmpty(qo.getSystemType()), Perm::getSystemType, qo.getSystemType())
            .eq(ObjectUtils.isNotEmpty(qo.getStyle()), Perm::getStyle, qo.getStyle())
            .eq(ObjectUtils.isNotEmpty(qo.getRemarks()), Perm::getRemarks, qo.getRemarks())
            .eq(ObjectUtils.isNotEmpty(qo.getIconPath()), Perm::getIconPath, qo.getIconPath())
            .eq(ObjectUtils.isNotEmpty(qo.getSwitchOperation()), Perm::getSwitchOperation, qo.getSwitchOperation())
        ;
    }
}
