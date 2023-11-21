package com.zhanghp.exception;

/**
 * @author zhanghp
 * @date 2022-07-22 17:49
 */
public class ServiceException extends RuntimeException {

	/**
	 * 错误码
	 */
	private Integer code;

	/**
	 * 错误信息
	 */
	private String msg;

	public ServiceException(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public ServiceException() {
	}

}
