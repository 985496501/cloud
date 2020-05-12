package cn.yun.cloud.common;

import lombok.Data;

/**
 * 系统统一的返回参数
 *
 * @param <T> 返回的参数类型
 * @author jinyun liu
 * @date 2020/5/8
 */
@Data
public class Result<T> {
    /**
     * 是否成功
     */
    private boolean success;

    /**
     * 状态码
     *
     * @see cn.yun.cloud.common.ResultCode
     */
    private Integer code;

    /**
     * 返回系统信息
     *
     * @see cn.yun.cloud.common.ResultCode
     * 也可以自己定义 BaseException("message")
     */
    private String message;

    /**
     * 返回的数据
     */
    private T data;

    /**
     * 不允许使用构造方法
     */
    private Result() {
    }

    /**
     * 默认请求成功的返回数据体
     *
     * @param t 参数类型
     */
    private Result(T t) {
        this.success = true;
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getDesc();
        this.data = t;
    }

    /**
     * 构建成功返回数据的返回体数据
     * 需要返回值
     *
     * @param t   返回数据
     * @param <T> 参数类型
     * @return 封装体
     */
    public static <T> Result<T> ok(T t) {
        return new Result<>(t);
    }

    /**
     * 构建成功返回数据的返回体数据
     * 无需返回值
     *
     * @return 封装体
     */
    public static Result ok() {
        return new Result<>(null);
    }
}
