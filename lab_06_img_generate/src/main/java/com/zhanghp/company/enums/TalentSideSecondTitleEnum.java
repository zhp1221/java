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
public enum TalentSideSecondTitleEnum {
    NEW_TOTAL("新量合计",new Color(254, 212, 164)),
    OLD_TOTAL("老量合计", null),
    TOTAL("总计", new Color(222, 224, 227)),
    ;

    /**
     * 侧边二级标题
     */
    private final String sideTitle;

    /**
     * 颜色填充
     */
    private final Color color;

}
