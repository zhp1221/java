package com.zhanghp.utils;

import cn.hutool.core.collection.IterUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.metadata.data.ReadCellData;
import com.alibaba.excel.read.metadata.ReadSheet;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author zhanghp
 * @date 2023/8/23 16:28
 */
public class EasyExcelUtils {

    /**
     * 获取总行数（包含标题头）
     *
     * @param file 文件
     * @return 行数
     */
    public static Integer rowNum(File file) {
        if (file == null) {
            throw new RuntimeException("文件为空");
        }
        // 解析
        ExcelReader build = EasyExcel.read(file).build();
        // 获取sheet
        List<ReadSheet> readSheets = build.excelExecutor().sheetList();
        if (IterUtil.isEmpty(readSheets)) {
            throw new RuntimeException("请上传含有数据的excel");
        }
        // 获取分析上下文对象
        AnalysisContext analysisContext = build.analysisContext();
        // 读取第一个
        build.read(readSheets.get(0));
        // 返回
        return analysisContext.readSheetHolder().getApproximateTotalRowNumber();
    }

    /**
     * 模版标题参数校对
     *
     * @param headMap 标题
     * @param cls     excel读取类
     */
    public static void checkTemplateTitle(Map<Integer, ReadCellData<?>> headMap, Class<?> cls) {
        // 标题数量校对参数
        int count = 0;
        List<Field> fieldList = arrToList(cls.getDeclaredFields());
        // 按照excelProperty的index排序
//		insertSortOptimize(fieldList);
        // 遍历字段进行判断
        for (Field it : fieldList) {
            // 获取当前字段上的ExcelProperty注解信息
            ExcelProperty fieldAnnotation = it.getAnnotation(ExcelProperty.class);
            // 判断当前字段上是否存在ExcelProperty注解
            if (fieldAnnotation != null) {
                ++count;
                // 存在ExcelProperty注解则根据注解的index索引到表头中获取对应的表头名
                String headName = headMap.get(fieldAnnotation.index()).getStringValue();
                // 判断表头是否为空或是否和当前字段设置的表头名不相同
                if (!headName.equals(fieldAnnotation.value()[0])) {
                    // 如果为空或不相同，则抛出异常不再往下执行
                    throw new RuntimeException(Msg.TEMPLATE_TITLE_ERROR.msg);
                }
            }
        }
        // 标题数量是否相等
        if (count != headMap.size()) {
            throw new RuntimeException(Msg.TEMPLATE_TITLE_COUNT_ERROR.msg);
        }
    }

    private static void insertSortOptimize(List<Field> fields) {
        // 边界条件
        if (fields == null || fields.size() == 1) {
            return;
        }
        for (int i = 0; i < fields.size(); i++) {
            for (int j = i; ((j - 1) >= 0) && (excelPropertyIndex(fields.get(j)) < excelPropertyIndex(fields.get(j - 1))); j--) {
                swap(fields, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {

    }


    private static List<Field> arrToList(Field[] fields) {
        List<Field> result = new ArrayList<>();
        if (fields == null || fields.length == 0) {
            return result;
        }
        for (Field it : fields) {
            if (it.getAnnotation(ExcelProperty.class) == null) {
                continue;
            }
            result.add(it);
        }
        return result;
    }


    private static int excelPropertyIndex(Field field) {
        ExcelProperty annotation = field.getAnnotation(ExcelProperty.class);
        if (annotation == null) {
            return -1;
        }
        return annotation.index();
    }


    private static void swap(List<Field> fields, int var1, int var2) {
        Field a = fields.get(var1);
        Field b = fields.get(var2);

        fields.set(var1, b);
        fields.set(var2, a);
    }

    @Getter
    @AllArgsConstructor
    private enum Msg {
        TEMPLATE_TITLE_ERROR("[模板错误]：标题文字对应不上，请检查导入模板"),
        TEMPLATE_TITLE_COUNT_ERROR("[模板错误]：标题数量对应不上，请检查导入模板"),
        ;
        private final String msg;
    }

}
