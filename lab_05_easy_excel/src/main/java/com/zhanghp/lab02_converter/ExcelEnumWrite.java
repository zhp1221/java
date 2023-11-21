package com.zhanghp.lab02_converter;

import com.alibaba.excel.EasyExcel;
import com.zhanghp.entity.DemoData;
import com.zhanghp.entity.EnumHandleData;
import com.zhanghp.lab01_read_write.ExcelWrite;
import com.zhanghp.utils.FileUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/7/12 18:30
 */
public class ExcelEnumWrite {

	public static void main(String[] args) {
		// 存储路径 + 文件名
		String path = FileUtils.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
		// 写数据
		// 之前出现了bug，导出报错，是因为制造的数据指向的是ExcelWrite的data()方法
		EasyExcel.write(path, EnumHandleData.class).sheet("demo").doWrite(ExcelEnumWrite::data);
	}

	/**
	 * 制造数据
	 * @return {@link DemoData}
	 */
	private static List<EnumHandleData> data() {
		List<EnumHandleData> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			final EnumHandleData enumhandleD = new EnumHandleData();
			enumhandleD.setName("序号-" + i);
			enumhandleD.setSex(i % 2 == 0 ? 1 : 2);
			enumhandleD.setHeight(170.00);
			enumhandleD.setBirth(new Date());
			list.add(enumhandleD);
		}
		return list;
	}

}
