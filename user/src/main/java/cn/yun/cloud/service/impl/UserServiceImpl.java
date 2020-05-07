package cn.yun.cloud.service.impl;

import cn.yun.cloud.dao.UserMapper;
import cn.yun.cloud.entity.UserDO;
import cn.yun.cloud.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: Liu Jinyun
 * @date: 2020/5/4/11:53
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
