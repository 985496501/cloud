package cn.yun.cloud.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 返回值code
 *
 * @author jinyunliu
 */
@Getter
@AllArgsConstructor
public enum ResultCode {
    /**
     * 统一的返回状态码
     */
    SUCCESS(200, "请求成功"),

    FAILURE(500, "系统异常"),

    ;

    private final Integer code;

    private final String desc;
}
