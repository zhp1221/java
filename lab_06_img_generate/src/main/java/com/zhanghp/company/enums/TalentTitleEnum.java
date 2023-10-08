package com.zhanghp.company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/8/2 14:49
 */
@Getter
@AllArgsConstructor
public enum TalentTitleEnum {
    BASIC(new Color(222, 224, 227), "基础信息", Arrays.asList("流量类型", "人群", "统计时间"), 100),
    PROCESS(new Color(217, 245, 214), "过程数据", Arrays.asList("例子数", "重复率", "到课数", "到课率"), 100),
    RESULT(new Color(222, 224, 227), "结果数据", Arrays.asList("转化订单数", "转化率", "到课转化率", "GMV", "例子价值"), 100),
    COURSE(new Color(217, 245, 214), "听课意愿", Arrays.asList("听10m占比", "听80m占比"), 100),
    ;
    /**
     * 填充颜色
     */
    private final Color color;

    /**
     * 二级标题
     */
    private final String secondTitle;

    /**
     * 三级标题
     */
    private final List<String> childTitle;

    /**
     * 单元格宽度
     */
    private final int minCellWidth;

    /**
     * 获取图表整个宽度
     *
     * @return 宽度
     */
    public static int getImgWidth(){
        int imgWidth = 0;
        for (TalentTitleEnum value : TalentTitleEnum.values()) {
            imgWidth += value.getChildTitle().size() * value.getMinCellWidth();
        }
        return imgWidth;
    }
}
