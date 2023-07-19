package com.zhanghp.lab01_read_write;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.zhanghp.enums.CommonEnum;
import com.zhanghp.entity.DemoData;
import com.zhanghp.utils.FileUtils;

/**
 * 阿里自定义的listener:<a>https://gitee.com/easyexcel/easyexcel/blob/master/easyexcel-test/src/test/java/com/alibaba/easyexcel/test/demo/read/DemoDataListener.java<a/>
 * 这里的PageReadListener类，每超过100条excel行记录，会清空
 *
 * @author zhanghp
 * @date 2023/7/12 14:32
 */
public class ExcelRead {
    public static void main(String[] args) {
        // 获取路径
        String path = FileUtils.getPath() + CommonEnum.EXCEL_DIRECOTRY_NAME.getConstant() + "/" + CommonEnum.DEMO_DATA_EXCEl.getConstant();
        // 读数据
        // 也可用自定类的监听器：如DemoDataListener
        EasyExcel.read(path, DemoData.class, new PageReadListener<DemoData>(list -> {
            for (DemoData it : list) {
                System.out.println(it);
            }
        })).sheet().doRead();
    }
}
