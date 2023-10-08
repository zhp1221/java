package com.zhanghp.lab01_read_write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.zhanghp.entity.DemoData;
import com.zhanghp.lab01_read_write.listener.TemplateDataValidatedStrategy;
import com.zhanghp.utils.FileUtils;
import lombok.AllArgsConstructor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/8/29 14:12
 */
public class ExcelWrite_NotOverride {
    public static void main(String[] args) {
        String filePath = "D:\\work_space\\my_gitee\\java\\lab_05_easy_excel\\src\\main\\resources\\excel\\demo_data.xlsx"; // 替换为现有文件路径
        String sheetName = "test"; // 替换为工作表名称

        List<MyData> newDataBatch = new ArrayList<>();
        newDataBatch.add(new MyData("John", 30));
        newDataBatch.add(new MyData("Jane", 25));

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.out.println("Sheet not found.");
                return;
            }

            int lastRowNum = sheet.getLastRowNum();
            int newRowNum = lastRowNum + 1;

            for (MyData newData : newDataBatch) {
                Row newRow = sheet.createRow(newRowNum);
                Cell cellName = newRow.createCell(0);
                Cell cellAge = newRow.createCell(1);

                cellName.setCellValue(newData.getName());
                cellAge.setCellValue(newData.getAge());

                newRowNum++;
            }

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyData {
    private String name;
    private int age;

    public MyData(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
