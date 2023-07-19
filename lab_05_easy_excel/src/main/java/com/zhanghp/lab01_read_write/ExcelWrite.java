package com.zhanghp.lab01_read_write;

import com.alibaba.excel.EasyExcel;
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
        EasyExcel.write(path, DemoData.class).sheet("demo").doWrite(ExcelWrite::data);
    }

    /**
     * 制造数据
     *
     * @return {@link DemoData}
     */
    public static List<DemoData> data() {
        List<DemoData> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final DemoData demoData = new DemoData();
            demoData.setName("序号-" + i);
            demoData.setSesssss(i%2 == 0 ? "男":"女");
            demoData.setHeight(170.00);
            demoData.setBirth(new Date());
            list.add(demoData);
        }
        return list;
    }
}
