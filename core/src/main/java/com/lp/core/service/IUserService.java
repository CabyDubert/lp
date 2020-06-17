package com.lp.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lp.core.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
    public List<User> getUserList();
}
