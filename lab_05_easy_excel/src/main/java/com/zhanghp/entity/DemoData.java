package com.zhanghp.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * lab01 用到的对象
 *
 * @author zhanghp
 * @date 2023/7/12 14:19
 */
@Data
@EqualsAndHashCode
@ColumnWidth(10)
public class DemoData {

	@ExcelProperty(value = "姓名", index = 0)
	private String name;

	@ExcelProperty(value = "性别", index = 1)
	private String sesssss;

	@ExcelProperty(value = "出生日期", index = 2)
	@DateTimeFormat("yyyy/MM/dd")
	@ColumnWidth(20)
	private Date birth;

	@ExcelProperty(value = "身高", index = 3)
	private Double height;

}
