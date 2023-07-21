package com.zhanghp.generate.model.converter;

import com.zhanghp.generate.dao.entity.Test;
import com.zhanghp.generate.model.vo.TestVO;
import com.zhanghp.generate.model.ro.TestRO;
import com.zhanghp.common.converter.CommonConverter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * <p>
 * TestConverter
 * </p>
 *
 * @author zhanghp
 * @since 2023-06-21
 */
@Mapper
public interface TestConverter extends CommonConverter<Test, TestRO, TestVO>{

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
        @Mapping(source = "time", target = "time"),
        @Mapping(source = "name", target = "name"),
    })
    TestVO toVO(Test po);

    /**
    * <p>
    *     po集合 转 vo集合
    * </p>
    *
    * @return VO集合
    */
    @Override
    List<TestVO> toVO(List<Test> poList);

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
        @Mapping(source = "time", target = "time"),
        @Mapping(source = "name", target = "name"),
    })
    Test changeRO(TestRO ro);

    /**
    * <p>
    *     ro集合 转 po集合
    * </p>
    *
    * @return PO集合
    */
    @Override
    List<Test> changeRO(List<TestRO> roList);

}