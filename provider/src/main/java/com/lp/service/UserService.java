package com.lp.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.dao.UserMapper;
import com.lp.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}
