package cn.yun.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author: Liu Jinyun
 * @date: 2020/5/4/11:38
 */
@Data
@TableName("user")
public class UserDO {
    @TableId(type = IdType.AUTO)
    private Long id;

    private String userName;

    private String password;

    private String phone;

    private Date createTime;

    private Date updateTime;

    @TableLogic
    private Integer deleted;
}
