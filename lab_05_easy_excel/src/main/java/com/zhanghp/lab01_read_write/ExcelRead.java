package com.zhanghp.lab01_read_write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.zhanghp.enums.CommonEnum;
import com.zhanghp.entity.DemoData;
import com.zhanghp.lab01_read_write.listener.DemoDataListener;
import com.zhanghp.lab01_read_write.listener.TemplateDataValidatedListener;
import com.zhanghp.lab01_read_write.listener.TemplateDataValidatedStrategy;
import com.zhanghp.utils.EasyExcelUtils;
import com.zhanghp.utils.FileUtils;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 阿里自定义的listener:<a>https://gitee.com/easyexcel/easyexcel/blob/master/easyexcel-test/src/test/java/com/alibaba/easyexcel/test/demo/read/DemoDataListener.java<a/>
 * </p>
 * <p>
 * 这里的PageReadListener类，每超过100条excel行记录，会清空
 * </p>
 *
 * @author zhanghp
 * @date 2023/7/12 14:32
 */
public class ExcelRead {

	public static void main(String[] args) {
		// 获取路径
		String path = FileUtils.getPath() + CommonEnum.EXCEL_DIRECOTRY_NAME.getConstant() + "/"
				+ CommonEnum.DEMO_DATA_EXCEl.getConstant();
		// 读数据
		// 也可用自定类的监听器：如DemoDataListener
		// EasyExcel.read(path, DemoData.class, new ReadListener<DemoData>() {
		// @Override
		// public void invokeHead(Map<Integer, ReadCellData<?>> headMap, AnalysisContext
		// context) {
		// EasyExcelUtils.checkTemplateTitle(headMap, DemoData.class);
		// }
		//
		// @Override
		// public void invoke(DemoData data, AnalysisContext context) {
		//
		// }
		//
		// @Override
		// public void doAfterAllAnalysed(AnalysisContext context) {
		//
		// }
		// }).sheet().doRead();

		// System.out.println(rowsAll);
		EasyExcel.read(path, DemoData.class, TemplateDataValidatedStrategy.EXTERNAL_ORDER.getReadListener()).sheet()
				.doRead();
	}

}
