package com.zhanghp.common.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author: zhanghp
 * @date: 2022-06-23 21:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@SuppressWarnings("all")
public class R<T> implements Serializable {

    /**
     * HTTP状态码
     */
    @ApiModelProperty(value = "状态码")
    private Integer code;
    /**
     * 详细状态码
     */
    @ApiModelProperty(value = "状态码")
    private String innerCode;
    /**
     * 信息
     */
    @ApiModelProperty(value = "信息")
    private String msg;
    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回的数据")
    private T data;

    /**
     * Success
     * <p>Custom the 'data'</p>
     *
     * @param data Returned Data
     * @param <T>  Type Of Data
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> R success(T data) {
        return new R()
                .setCode(200)
                .setInnerCode(CodeEnum.SUCCESS.getCode())
                .setMsg(CodeEnum.SUCCESS.getMsg())
                .setData(data);
    }

    /**
     * Fail
     * <p>Custom the 'data'</p>
     *
     * @param data Returned Data
     * @param <T>  Type Of Data
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> R fail(T data) {
        return new R().setInnerCode(CodeEnum.FAIL.getCode())
                .setMsg(CodeEnum.FAIL.getMsg())
                .setData(data);
    }

    /**
     * Success
     * <p>No Data</p>
     *
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"rawtypes"})
    public static R success() {
        return new R()
                .setCode(200)
                .setInnerCode(CodeEnum.SUCCESS.getCode())
                .setMsg(CodeEnum.SUCCESS.getMsg());
    }

    /**
     * Fail
     * <p>No Data</p>
     *
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"rawtypes"})
    public static R fail() {
        return new R()
                .setCode(500)
                .setInnerCode(CodeEnum.FAIL.getCode())
                .setMsg(CodeEnum.FAIL.getMsg());
    }

    /**
     * Success
     * <p>Custom the 'msg' and the 'data'</p>
     *
     * @param msg  Custom Message
     * @param data Returned Data
     * @param <T>  Type Of Data
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> R success(String msg, T data) {
        return new R()
                .setCode(200)
                .setInnerCode(CodeEnum.SUCCESS.getCode())
                .setMsg(msg)
                .setData(data);
    }

    /**
     * Fail
     * <p>Custom the 'msg' and the 'data'</p>
     *
     * @param msg  Custom Message
     * @param data Returned Data
     * @param <T>  Type Of Data
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> R fail(String msg, T data) {
        return new R()
                .setCode(500)
                .setInnerCode(CodeEnum.FAIL.getCode())
                .setMsg(msg)
                .setData(data);
    }

    /**
     * Success
     * <p>Custom the 'code', 'msg' and the 'data'</p>
     *
     * @param code Status Code
     * @param msg  Custom Message
     * @param data Returned Data
     * @param <T>  Type Of Data
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> R success(String code, String msg, T data) {
        return new R()
                .setCode(200)
                .setInnerCode(code)
                .setMsg(msg)
                .setData(data);
    }

    /**
     * Fail
     * <p>Custom the 'code', 'msg' and the 'data'</p>
     *
     * @param code Status Code
     * @param msg  Custom Message
     * @param data Returned Data
     * @param <T>  Type Of Data
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> R fail(String code, String msg, T data) {
        return new R()
                .setCode(500)
                .setInnerCode(code)
                .setMsg(msg)
                .setData(data);
    }

    /**
     * Fail
     * <p>Custom the 'code', 'msg' and the 'data'</p>
     *
     * @param code Status Code
     * @param msg  Custom Message
     * @param <T>  Type Of Data
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> R failCodeMsg(String code, String msg) {
        return new R()
                .setCode(500)
                .setInnerCode(code)
                .setMsg(msg);
    }

    /**
     * Fail
     *
     * @param codeEnum custom code enum
     * @param <T>      Type Of Data
     * @return The Instance Of 'R'
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> R failCodeEnum(@NotNull CodeEnum codeEnum) {
        return new R()
                .setCode(500)
                .setInnerCode(codeEnum.getCode())
                .setMsg(codeEnum.getMsg())
                .setData("");
    }


    /**
     * judge the return of R via flag
     *
     * @param flag flag
     * @param msg  message
     * @return the instance of R
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static R judgeR(boolean flag, String msg) {
        return new R()
                .setCode(flag ? 200 : 500)
                .setMsg(msg)
                .setData("");
    }

    /**
     * judge the return of R via flag
     *
     * @param flag flag
     * @return the instance of R
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static R judgeR(boolean flag) {
        return new R()
                .setCode(flag ? 200 : 500);
    }
}
