package cn.yun.cloud.http;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Liu Jinyun
 * @date: 2020/5/4/11:56
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("请求响应参数")
public class Result<T> {

    @ApiModelProperty("状态码")
    private Integer code;

    @ApiModelProperty("响应信息")
    private String message;

    @ApiModelProperty("返回数据参数")
    private T data;
}
