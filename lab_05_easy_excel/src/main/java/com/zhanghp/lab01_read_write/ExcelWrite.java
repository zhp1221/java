package com.zhanghp.lab01_read_write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.zhanghp.entity.DemoData;
import com.zhanghp.utils.FileUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/7/12 15:14
 */
public class ExcelWrite {

	public static void main(String[] args) {
		// 存储路径 + 文件名
		String path = FileUtils.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
		// 写数据
		// EasyExcel.write(path, DemoData.class).sheet("demo").doWrite(ExcelWrite::data);
		System.out.println(path);
		System.out.println("----------");
		try (ExcelWriter excelWriter = EasyExcel.write(path, DemoData.class).build()) {
			// 这里注意 如果同一个sheet只要创建一次
			WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
			// 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
			for (int i = 0; i < 5; i++) {
				// 分页去数据库查询数据 这里可以去数据库查询每一页的数据
				List<DemoData> data = data();
				excelWriter.write(data, writeSheet);
			}
		}
	}

	/**
	 * 制造数据
	 * @return {@link DemoData}
	 */
	public static List<DemoData> data() {
		List<DemoData> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			final DemoData demoData = new DemoData();
			demoData.setName("序号-" + i);
			demoData.setSesssss(i % 2 == 0 ? "男" : "女");
			demoData.setHeight(170.00);
			demoData.setBirth(new Date());
			list.add(demoData);
		}
		return list;
	}

}
