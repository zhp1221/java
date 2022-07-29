package com.zhanghp.common.converter.utils;

import com.zhanghp.common.converter.CommonConverter;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * 通用映射工具类
 *
 * @author zhanghp
 * @date 2022-07-17 14:08
 */
public final class ConverterUtil {

    /**
     * 通用ro映射po
     *
     * @param clz 映射类
     * @param ro  ro
     * @param <E> 实体泛型
     * @param <V> VO反应
     * @param <C> 映射类泛型
     * @return po
     */
    public static <E, R, V, C extends CommonConverter<E, R, V>> E changeRO(Class<C> clz, R ro) {
        // 初始化指定类的映射实例
        final C CONVERTER = Mappers.getMapper(clz);
        // ro 映射 po
        return CONVERTER.changeRO(ro);
    }

    /**
     * 通用ro映射po
     *
     * @param clz  映射类
     * @param list ro lsit
     * @param <E>  实体泛型
     * @param <V>  VO反应
     * @param <C>  映射类泛型
     * @return po list
     */
    public static <E, R, V, C extends CommonConverter<E, R, V>> List<E> changeRO(Class<C> clz, List<R> list) {
        // 初始化指定类的映射实例
        final C CONVERTER = Mappers.getMapper(clz);
        // ro list 映射 po list
        return CONVERTER.changeRO(list);
    }

    /**
     * 通用po映射vo
     *
     * @param clz 映射类
     * @param po  实体
     * @param <E> 实体泛型
     * @param <V> VO反应
     * @param <C> 映射类泛型
     * @return VO
     */
    public static <E, R, V, C extends CommonConverter<E, R, V>> V toVO(Class<C> clz, E po) {
        // 初始化指定类的映射实例
        final C CONVERTER = Mappers.getMapper(clz);
        // po 映射 vo
        return CONVERTER.toVO(po);
    }

    /**
     * 通用 po list 映射 vo list
     *
     * @param clz 映射类
     * @param po  实体
     * @param <E> 实体泛型
     * @param <V> VO反应
     * @param <C> 映射类泛型
     * @return VO list
     */
    public static <E, R, V, C extends CommonConverter<E, R, V>> List<V> toVO(Class<C> clz, List<E> po) {
        // 初始化指定类的映射实例
        final C CONVERTER = Mappers.getMapper(clz);
        // po list 映射 vo list
        return CONVERTER.toVO(po);
    }
}
