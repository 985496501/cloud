package cn.yun.cloud.dao;

import cn.yun.cloud.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author: Liu Jinyun
 * @date: 2020/5/4/11:54
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
