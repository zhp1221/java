package com.zhanghp.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhanghp
 * @date 2023/7/12 14:43
 */
@Getter
@AllArgsConstructor
public enum CommonEnum {

	EXCEL_DIRECOTRY_NAME("excel", "excel归属的文件夹名称"), DEMO_DATA_EXCEl("demo_data.xlsx", "excel文件名：demo_data.xlsx");

	private final String constant;

	private final String name;

}
