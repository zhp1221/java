package com.zhanghp.common.converter;

import java.util.List;

/**
 * 规范方法
 *
 * @author zhanghp
 * @date 2022-07-17 12:20
 */
public interface CommonConverter<E, R, V> {

    E changeRO(R r);

    List<E> changeRO(List<R> list);

    List<V> toVO(List<E> list);

    V toVO(E t);
}
