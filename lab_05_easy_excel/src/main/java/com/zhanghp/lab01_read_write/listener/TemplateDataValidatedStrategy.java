package com.zhanghp.lab01_read_write.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.zhanghp.entity.DemoData;
import com.zhanghp.utils.EasyExcelUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/8/24 15:59
 */
@Getter
@AllArgsConstructor
public enum TemplateDataValidatedStrategy {

	EXTERNAL_ORDER(new ReadListener() {
		@Override
		public void invokeHead(Map headMap, AnalysisContext context) {
			EasyExcelUtils.checkTemplateTitle(headMap, DemoData.class);
			Integer approximateTotalRowNumber = context.readSheetHolder().getApproximateTotalRowNumber();
			System.out.println(approximateTotalRowNumber);
			System.out.println("ye");
		}

		@Override
		public void invoke(Object o, AnalysisContext analysisContext) {
		}

		@Override
		public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		}
	}), SUMMARY(new ReadListener() {
		@Override
		public void invokeHead(Map headMap, AnalysisContext context) {
			ReadListener.super.invokeHead(headMap, context);
		}

		@Override
		public void invoke(Object o, AnalysisContext analysisContext) {
		}

		@Override
		public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		}
	}), DETAIL(new ReadListener() {
		@Override
		public void invokeHead(Map headMap, AnalysisContext context) {
			ReadListener.super.invokeHead(headMap, context);
		}

		@Override
		public void invoke(Object o, AnalysisContext analysisContext) {
		}

		@Override
		public void doAfterAllAnalysed(AnalysisContext analysisContext) {
		}
	}),;

	private final ReadListener readListener;

}
