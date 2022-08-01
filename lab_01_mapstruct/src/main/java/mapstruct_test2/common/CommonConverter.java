package mapstruct_test2.common;

import java.util.List;

/**
 * 规范方法
 *
 * @author zhanghp
 * @date 2022-07-17 12:20
 */
public interface CommonConverter<E, V> {

    List<V> toVO(List<E> list);

    V toVO(E t);
}
