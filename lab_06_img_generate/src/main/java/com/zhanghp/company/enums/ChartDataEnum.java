package com.zhanghp.company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhanghp
 * @date 2023/7/17 20:43
 */
@Getter
@AllArgsConstructor
public enum ChartDataEnum {
    // 信息流相关
    MESSAGE_EXAMPLE(250, 362, 70, 90, "信息流_新量_13:00_例子数"),
    MESSAGE_NEW_TOTAL_EXAMPLE(250, 362, 210, 230, "信息流_新量合计_23:30_例子数"),
    MESSAGE_OLD_TOTAL_EXAMPLE(250, 362, 230, 250, "信息流_老量合计_23:30_例子数"),
    MESSAGE_TOTAL_EXAMPLE(250, 362, 250, 270, "信息流_总计_23:30_例子数"),
    // 直播相关
    LIVE_NEW_EXAMPLE(250, 362, 270, 290, "直播_新量_13:00_例子数"),
    LIVE_NEW_TOTAL_EXAMPLE(250, 362, 410, 430, "直播_新量合计_23:30_例子数"),
    LIVE_OLD_TOTAL_EXAMPLE(250, 362, 430, 450, "直播_老量合计_23:30_例子数"),
    LIVE_TOTAL_EXAMPLE(250, 362, 450, 470, "直播_总计_23:30_例子数"),
    // 其他流量类型
    OTHER(250, 362, 470, 490, "其他流量类型_23:30_例子数"),
    // 日合计
    DAY_SUM(250, 362, 490, 510, "日合计_23:30_例子数"),
    ;
    private final Integer x1;
    private final Integer x2;
    private final Integer y1;
    private final Integer y2;
    private final String detail;
}
