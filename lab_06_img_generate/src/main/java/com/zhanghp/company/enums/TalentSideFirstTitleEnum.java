package com.zhanghp.company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhanghp
 * @date 2023/8/2 14:49
 */
@Getter
@AllArgsConstructor
public enum TalentSideFirstTitleEnum {
    MESSAGE(1, "信息流"),
    LIVE(2, "直播间"),
    ;

    private final int type;
    /**
     * 侧边一级标题
     */
    private final String sideTitle;


    public static int getFixation() {
        return TalentImgEnum.TITLE_HEIGHT.getNum() + TalentImgEnum.FIXATION_CELL_HEIGHT.getNum() * 2;
    }
}
