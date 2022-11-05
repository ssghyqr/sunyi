package com.example.sunyi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sunyi.common.Result;
import com.example.sunyi.entity.Contact;
import com.example.sunyi.entity.DTO.SelectGroup;
import com.example.sunyi.service.IContactService;
import com.example.sunyi.service.IUserService;
import com.example.sunyi.service.IUserchattingrecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@RestController
@RequestMapping("/userchattingrecord")
public class UserchattingrecordController {
    @Resource
    private IUserchattingrecordService userchattingrecordService;

    @Resource
    private IUserService userService;

    @Resource
    private IContactService contactService;

//    获取私聊聊天组
    @PostMapping("/getGroup")
    public Result getGroup(@RequestBody SelectGroup selectGroup) {
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", selectGroup.getOwnId());
        queryWrapper.eq("friendId", selectGroup.getUserId());
        Contact contact = contactService.getOne(queryWrapper);
        return Result.success(contact);
    }
}

