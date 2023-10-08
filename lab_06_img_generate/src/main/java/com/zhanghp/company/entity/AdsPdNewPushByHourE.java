package com.zhanghp.company.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/7/15 9:50
 */
@Data
public class AdsPdNewPushByHourE {
	/**
	 * 例子数
	 */
	private String example;
	/**
	 * 重复率
	 */
	private String repeatPercent;
	/**
	 * 到课数
	 */
	private String arriveCount;
	/**
	 * 到课率
	 */
	private String arrivePercent;
	/**
	 * 转化订单数
	 */
	private String convertOrderCount;
	/**
	 * 转化率
	 */
	private String convertPercent;
	/**
	 * 到课转化率
	 */
	private String arriveConvertPercent;
	/**
	 * gmv
	 */
	private String gmv;
	/**
	 * 例子价值
	 */
	private String exampleValue;
	/**
	 * 听课大于等于10分钟人数占比
	 */
	private String moreThanTen;
	/**
	 * 听课大于等于80分钟人数占比
	 */
	private String moreThanEighty;
	/**
     * 投放平台
	 */
	private String launchType;

	private String exampleNum;

	private String newGmv;

	public static AdsPdNewPushByHourE generate(String launchType){
		final AdsPdNewPushByHourE result = new AdsPdNewPushByHourE();
		result.setExample("0.00%");
		result.setRepeatPercent("22%");
		result.setArriveCount("100");
		result.setArrivePercent("99%");
		result.setConvertOrderCount("20");
		result.setConvertPercent("89%");
		result.setArriveConvertPercent("11%");
		result.setGmv("1,60o,1000.00");
		result.setExampleValue("10%");
		result.setMoreThanTen("90%");
		result.setMoreThanEighty("20%");
		result.setLaunchType(launchType);
		return result;
	}

	public static List<String> generate2(){
		List<String> result = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			result.add(String.valueOf(i));
		}
		return result;
	}
}
