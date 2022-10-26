package com.example.sunyi.controller;


import com.example.sunyi.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 瑞
 * @since 2022-10-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private IUserService userService;


}

