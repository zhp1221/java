package com.zhanghp.lab02_converter;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.zhanghp.entity.DemoData;
import com.zhanghp.entity.EnumHandleData;
import com.zhanghp.enums.CommonEnum;
import com.zhanghp.utils.FileUtils;

/**
 * @author zhanghp
 * @date 2023/7/12 18:07
 */
public class ExcelEnumRead {

	public static void main(String[] args) {
		// 获取路径
		String path = FileUtils.getPath() + CommonEnum.EXCEL_DIRECOTRY_NAME.getConstant() + "/"
				+ CommonEnum.DEMO_DATA_EXCEl.getConstant();
		// 读数据
		// 也可用自定类的监听器：如DemoDataListener
		EasyExcel.read(path, EnumHandleData.class, new PageReadListener<EnumHandleData>(list -> {
			for (EnumHandleData it : list) {
				System.out.println(it);
			}
		})).sheet().doRead();
	}

}
