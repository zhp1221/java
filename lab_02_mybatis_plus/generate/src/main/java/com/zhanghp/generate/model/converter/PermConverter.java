package com.zhanghp.generate.model.converter;

import com.zhanghp.generate.dao.entity.Perm;
import com.zhanghp.generate.model.vo.PermVO;
import com.zhanghp.generate.model.ro.PermRO;
import com.zhanghp.common.converter.CommonConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * PermConverter
 * </p>
 *
 * @author zhanghp
 * @since 2022-07-29
 */
@Mapper
public interface PermConverter extends CommonConverter<Perm, PermRO, PermVO>{

    /**
    * <p>
    *     po 转 vo
    * </p>
    *
    * @return VO类
    */
    @Override
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "parentId", target = "parentId"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "path", target = "path"),
        @Mapping(source = "code", target = "code"),
        @Mapping(source = "sort", target = "sort"),
        @Mapping(source = "menuType", target = "menuType"),
        @Mapping(source = "systemType", target = "systemType"),
        @Mapping(source = "style", target = "style"),
        @Mapping(source = "remarks", target = "remarks"),
        @Mapping(source = "iconPath", target = "iconPath"),
        @Mapping(source = "switchOperation", target = "switchOperation"),
    })
    PermVO toVO(Perm po);

    /**
    * <p>
    *     po集合 转 vo集合
    * </p>
    *
    * @return VO集合
    */
    @Override
    List<PermVO> toVO(List<Perm> poList);

    /**
    * <p>
    *     ro 转 po
    * </p>
    *
    * @return PO类
    */
    @Override
    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "parentId", target = "parentId"),
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "path", target = "path"),
        @Mapping(source = "code", target = "code"),
        @Mapping(source = "sort", target = "sort"),
        @Mapping(source = "menuType", target = "menuType"),
        @Mapping(source = "systemType", target = "systemType"),
        @Mapping(source = "style", target = "style"),
        @Mapping(source = "remarks", target = "remarks"),
        @Mapping(source = "iconPath", target = "iconPath"),
        @Mapping(source = "switchOperation", target = "switchOperation"),
    })
    Perm changeRO(PermRO ro);

    /**
    * <p>
    *     ro集合 转 po集合
    * </p>
    *
    * @return PO集合
    */
    @Override
    List<Perm> changeRO(List<PermRO> roList);

}