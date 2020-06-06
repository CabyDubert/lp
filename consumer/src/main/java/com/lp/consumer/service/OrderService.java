package com.lp.consumer.service;

import com.lp.core.entity.User;
import com.lp.core.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Reference(timeout = 60000)
    private IUserService iUserService;

    public List<User> getUserList(){
        return iUserService.list();
    }
}
