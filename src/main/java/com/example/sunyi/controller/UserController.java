package com.example.sunyi.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sunyi.common.Constants;
import com.example.sunyi.common.Result;
import com.example.sunyi.entity.DTO.LoginUserDTO;
import com.example.sunyi.entity.User;
import com.example.sunyi.service.IUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * <p>
 * 前端控制器
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

    @GetMapping
    public Result findAlluser() {
        return Result.success(userService.list());
    }

//    根据用户名获取用户
    @GetMapping("/findByName")
    public Result findByName(@RequestParam String userName) {
        if(StrUtil.isBlank(userName)) {
            return Result.error(Constants.CODE_400, "查询用户名不能为空");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userName", userName);
        User user = userService.getOne(queryWrapper);
        if(user != null) {
            return Result.success(user);
        } else {
            return Result.error(Constants.CODE_400, "用户不存在");
        }
    }

//    根据id获取用户
    @GetMapping("/{id}")
    public Result findOneuser(@PathVariable Integer id) {
        User user = userService.getById(id);
        if(user != null) {
            return Result.success(user);
        } else {
            return Result.error(Constants.CODE_400, "用户不存在");
        }
    }

    //    登录接口
    @PostMapping("/login")
    public Result login(@RequestBody User userDTO) {
        String username = userDTO.getUserAccount();
        String password = userDTO.getUserPassword();
//        用户名和密码不能为空
        if (StrUtil.isBlank(username) || StrUtil.isBlank(password)) {
            return Result.error(Constants.CODE_400, "用户名和密码不能为空");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userAccount", username);
        queryWrapper.eq("userPassword", password);

        User user = userService.getOne(queryWrapper);
        if (user != null) {
            return Result.success(user);
        } else {
            return Result.error(Constants.CODE_400, "用户名或密码错误");
        }
    }

    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        String userAccount = user.getUserAccount();
        String userName = user.getUserName();
        if (StrUtil.isBlank(userAccount) || StrUtil.isBlank(userName)) {
            return Result.error(Constants.CODE_400, "输入为空");
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        用户账号或者用户名相同都不能注册
        queryWrapper.eq("userAccount", userAccount).or().eq("userName", userName);
        User user_ = userService.getOne(queryWrapper);
        if (user_ != null) {
            return Result.error(Constants.CODE_400, "账户重复");
        } else {
            User one = new User();
            BeanUtil.copyProperties(user, one, true);
            one.setUserName(userName);
            userService.save(one);
            return Result.success("注册成功", one);
        }
    }
}

