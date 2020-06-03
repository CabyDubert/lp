package com.lp.provider.controller;

import com.lp.provider.service.UserService;
import com.lp.core.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authUser")
public class AuthUserController {

    private UserService userService;

    public AuthUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/query")
    public Result query() {
        String tag = "find user";
        return Result.succ(tag, userService.list());
    }
}
