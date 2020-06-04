package com.lp.provider.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.core.dao.UserMapper;
import com.lp.core.entity.User;
import com.lp.core.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> implements IUserService {
}
