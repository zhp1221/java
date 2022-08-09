package com.zhanghp.generate.model.converter;

import com.zhanghp.generate.dao.entity.Label;
import com.zhanghp.generate.model.vo.LabelVO;
import com.zhanghp.generate.model.ro.LabelRO;
import com.zhanghp.common.converter.CommonConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * LabelConverter
 * </p>
 *
 * @author zhanghp
 * @since 2022-08-09
 */
@Mapper
public interface LabelConverter extends CommonConverter<Label, LabelRO, LabelVO>{

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
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "sort", target = "sort"),
    })
    LabelVO toVO(Label po);

    /**
    * <p>
    *     po集合 转 vo集合
    * </p>
    *
    * @return VO集合
    */
    @Override
    List<LabelVO> toVO(List<Label> poList);

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
        @Mapping(source = "name", target = "name"),
        @Mapping(source = "sort", target = "sort"),
    })
    Label changeRO(LabelRO ro);

    /**
    * <p>
    *     ro集合 转 po集合
    * </p>
    *
    * @return PO集合
    */
    @Override
    List<Label> changeRO(List<LabelRO> roList);

}