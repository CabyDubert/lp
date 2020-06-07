package com.lp.consumer.serviceImpl;

import com.lp.core.entity.User;
import com.lp.core.service.IUserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl {
    /**
     * 超时配置，可以在consumer、reference、method中配置，
     * 优先级：
     * 1-方法有限、引用次之、全局最后
     * 2-同一级别的，消费者优先、提供方次之
     */
    @Reference(timeout = 60000,version = "1.0.0")
    private IUserService iUserService;

    public List<User> getUserList(){
        return iUserService.list();
    }
}
