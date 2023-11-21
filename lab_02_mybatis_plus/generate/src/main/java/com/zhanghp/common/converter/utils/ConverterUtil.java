package com.zhanghp.common.converter.utils;

import com.zhanghp.common.converter.CommonConverter;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * ͨ��ӳ�乤����
 *
 * @author zhanghp
 * @date 2022-07-17 14:08
 */
public final class ConverterUtil {

	/**
	 * ͨ��roӳ��po
	 * @param clz ӳ����
	 * @param ro ro
	 * @param <E> ʵ�巺��
	 * @param <V> VO��Ӧ
	 * @param <C> ӳ���෺��
	 * @return po
	 */
	public static <E, R, V, C extends CommonConverter<E, R, V>> E changeRO(Class<C> clz, R ro) {
		// ��ʼ��ָ�����ӳ��ʵ��
		final C CONVERTER = Mappers.getMapper(clz);
		// ro ӳ�� po
		return CONVERTER.changeRO(ro);
	}

	/**
	 * ͨ��roӳ��po
	 * @param clz ӳ����
	 * @param list ro lsit
	 * @param <E> ʵ�巺��
	 * @param <V> VO��Ӧ
	 * @param <C> ӳ���෺��
	 * @return po list
	 */
	public static <E, R, V, C extends CommonConverter<E, R, V>> List<E> changeRO(Class<C> clz, List<R> list) {
		// ��ʼ��ָ�����ӳ��ʵ��
		final C CONVERTER = Mappers.getMapper(clz);
		// ro list ӳ�� po list
		return CONVERTER.changeRO(list);
	}

	/**
	 * ͨ��poӳ��vo
	 * @param clz ӳ����
	 * @param po ʵ��
	 * @param <E> ʵ�巺��
	 * @param <V> VO��Ӧ
	 * @param <C> ӳ���෺��
	 * @return VO
	 */
	public static <E, R, V, C extends CommonConverter<E, R, V>> V toVO(Class<C> clz, E po) {
		// ��ʼ��ָ�����ӳ��ʵ��
		final C CONVERTER = Mappers.getMapper(clz);
		// po ӳ�� vo
		return CONVERTER.toVO(po);
	}

	/**
	 * ͨ�� po list ӳ�� vo list
	 * @param clz ӳ����
	 * @param po ʵ��
	 * @param <E> ʵ�巺��
	 * @param <V> VO��Ӧ
	 * @param <C> ӳ���෺��
	 * @return VO list
	 */
	public static <E, R, V, C extends CommonConverter<E, R, V>> List<V> toVO(Class<C> clz, List<E> po) {
		// ��ʼ��ָ�����ӳ��ʵ��
		final C CONVERTER = Mappers.getMapper(clz);
		// po list ӳ�� vo list
		return CONVERTER.toVO(po);
	}

}
