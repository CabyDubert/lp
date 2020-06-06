package com.lp.consumer.controller;

import com.lp.consumer.serviceImpl.OrderServiceImpl;
import com.lp.core.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/userList")
    public Result userList() {
        String tag = "find user";
        return Result.succ(tag, orderService.getUserList());
    }
}
