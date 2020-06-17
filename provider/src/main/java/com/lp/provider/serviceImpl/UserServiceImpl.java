package com.lp.provider.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lp.core.dao.UserMapper;
import com.lp.core.entity.User;
import com.lp.core.service.IUserService;
import org.apache.dubbo.config.annotation.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    public List<User> getUserList() {
        return this.list();
    }
}
