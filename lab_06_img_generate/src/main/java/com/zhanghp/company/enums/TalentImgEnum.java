package com.zhanghp.company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhanghp
 * @date 2023/8/2 14:49
 */
@Getter
@AllArgsConstructor
public enum TalentImgEnum {
    TITLE_HEIGHT(30, "标题高度"),
    FIXATION_CELL_HEIGHT(20, "单元格高度"),
    FIXATION_CELL_WIDTH(100, "单元格宽度"),
    ;

    private final int num;

    private final String name;

    /**
     * 获取标题尾的y
     *
     * @return endY
     */
    public static int getFixationTitleEndY(){
        return TITLE_HEIGHT.getNum() + FIXATION_CELL_HEIGHT.getNum() * 2;
    }
}
