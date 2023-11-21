package com.zhanghp.company.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhanghp
 * @date 2023/7/17 9:31
 */
@Getter
@AllArgsConstructor
public enum PushHourEnum {

	// 13:00、15:00、16:00、19:20、20:20、21:00、22:30、23:30
	THIRTEEN(1, "13", "13:00"), FIFTEEN(2, "15", "15:00"), SIXTEEN(3, "16", "16:00"),
	SEVENTEEN_TWENTY(4, "19", "19:20"), TWENTY_TWENTY(5, "20", "20:20"), TWENTY_ONE(6, "21", "21:00"),
	TWENTY_TWO_THIRTY(7, "22", "22:30"), TWENTY_THREE_THIRTY(8, "23", "23:30");

	private final int code;

	private final String hour;

	private final String detail;

	public static List<String> getDetailList() {
		List<String> result = new ArrayList<>();
		for (PushHourEnum it : PushHourEnum.values()) {
			result.add(it.getDetail());
		}
		return result;
	}

	public static List<PushHourEnum> getListByHour(String hour) {
		List<PushHourEnum> result = new ArrayList<>();
		for (PushHourEnum it : PushHourEnum.values()) {
			if (it.getHour().equals(hour)) {

				for (int i = it.getCode(); i > 0; i--) {
					getByCode(i);
					result.add(getByCode(i));
				}
				result.sort(Comparator.comparing(PushHourEnum::getCode));
			}
		}

		return result;
	}

	public static PushHourEnum getByCode(Integer code) {
		if (code == null) {
			return null;
		}
		for (PushHourEnum it : PushHourEnum.values()) {
			if (it.getCode() == code) {
				return it;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		getDetailList().forEach(System.out::println);
	}

}
