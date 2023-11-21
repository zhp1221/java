package com.zhanghp.company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author zhanghp
 * @date 2023/7/18 8:08
 */
@Getter
@AllArgsConstructor
public enum ChartPropertyEnum {

	EAXMPLE("例子数"), REPEAT("重复率"), ARRIVE_COUNT("到课数"), ARRIVE_PERCENT("到课率"), CONVERT_ORDER_COUNT("转化订单数"),
	CONVERT_PERCENT("转化率"), ARRIVE_CONVERT_PERCENT("到课转化率"), GMV("GMV"), EXAMPLE_VALUE("例子价值"),
	LISTEN_TEN_MIN("听10min占比"), LISTEN_EIGHTY_MIN("听80min占比");

	private final String name;

}
