package com.zhanghp.lab02_converter.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.metadata.data.WriteCellData;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import com.zhanghp.lab02_converter.annotation.ExcelEnum;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author zhanghp
 * @date 2023/7/12 16:43
 */
public class ExcelEnumConverter implements Converter<Integer> {

	@Override
	public Class<?> supportJavaTypeKey() {
		// 指定java属性的类型
		return Integer.class;
	}

	@Override
	public CellDataTypeEnum supportExcelTypeKey() {
		// 指定excel支持的类型
		return CellDataTypeEnum.STRING;
	}

	@Override
	public Integer convertToJavaData(ReadCellData<?> cellData, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) throws Exception {
		// 处理excel内容并转换到java属性
		return handleName(contentProperty, cellData.getStringValue());
	}

	@Override
	public WriteCellData<?> convertToExcelData(Integer value, ExcelContentProperty contentProperty,
			GlobalConfiguration globalConfiguration) throws Exception {
		// 处理java数据并转换到excel内容
		return new WriteCellData<>(handleType(contentProperty, value));
	}

	/**
	 * 处理excel内容并转换到java属性
	 * @param property {@link ExcelContentProperty}
	 * @param type 对象中的属性
	 * @return 匹配的枚举
	 */
	private String handleType(ExcelContentProperty property, Integer type) {
		String result = "";
		final Field field = property.getField();
		final ExcelEnum annotation = field.getAnnotation(ExcelEnum.class);
		final Class<? extends Enum<?>> enumClass = annotation.enumClass();
		try {
			final Method method = enumClass.getMethod("getName", Integer.class);
			Object obj = method.invoke(enumClass, type);
			if (Objects.nonNull(obj)) {
				result = (String) obj;
			}

		}
		catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

	/**
	 * 处理java数据并转换到excel内容
	 * @param property {@link ExcelContentProperty}
	 * @param name excel中的内容
	 * @return 匹配枚举
	 */
	private Integer handleName(ExcelContentProperty property, String name) {
		Integer result = null;
		final Field field = property.getField();
		final ExcelEnum annotation = field.getAnnotation(ExcelEnum.class);
		final Class<? extends Enum<?>> enumClass = annotation.enumClass();
		try {
			final Method method = enumClass.getMethod("getType", String.class);
			Object obj = method.invoke(enumClass, name);
			if (Objects.nonNull(obj)) {
				result = ((Integer) obj);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			return result;
		}
		return result;
	}

}
