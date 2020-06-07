package com.lp.provider.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.core.dao.UserMapper;
import com.lp.core.entity.User;
import com.lp.core.service.IUserService;
import org.apache.dubbo.config.annotation.Service;

@Service(version = "1.0.1")
public class UserServiceImpl02 extends ServiceImpl<UserMapper, User> implements IUserService {

}
