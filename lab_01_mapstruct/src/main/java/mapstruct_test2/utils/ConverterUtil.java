package mapstruct_test2.utils;

import mapstruct_test2.common.CommonConverter;
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
	 * 通用po映射vo
	 * @param clz 映射类
	 * @param po 实体
	 * @param <E> 实体泛型
	 * @param <V> VO泛型
	 * @param <C> 映射类泛型
	 * @return VO
	 */
	public static <E, V, C extends CommonConverter<E, V>> V toVO(Class<C> clz, E po) {
		// 初始化指定类的映射实例
		final C CONVERTER = Mappers.getMapper(clz);
		// po 映射 vo
		return CONVERTER.toVO(po);
	}

	/**
	 * 通用 po list 映射 vo list
	 * @param clz 映射类
	 * @param po 实体
	 * @param <E> 实体泛型
	 * @param <V> VO泛型
	 * @param <C> 映射类泛型
	 * @return VO list
	 */
	public static <E, V, C extends CommonConverter<E, V>> List<V> toVO(Class<C> clz, List<E> po) {
		// 初始化指定类的映射实例
		final C CONVERTER = Mappers.getMapper(clz);
		// po list 映射 vo list
		return CONVERTER.toVO(po);
	}

}
