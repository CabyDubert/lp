package com.lp.consumer.service;

import com.lp.core.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Reference(timeout = 60000)
    private IUserService iUserService;

}
