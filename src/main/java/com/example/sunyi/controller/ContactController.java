package com.example.sunyi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sunyi.common.Constants;
import com.example.sunyi.common.Result;
import com.example.sunyi.entity.Contact;
import com.example.sunyi.entity.DTO.AddUser;
import com.example.sunyi.entity.DTO.SelectFriendList;
import com.example.sunyi.entity.User;
import com.example.sunyi.entity.Userchattingrecord;
import com.example.sunyi.service.IContactService;
import com.example.sunyi.service.IUserService;
import com.example.sunyi.service.IUserchattingrecordService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 瑞
 * @since 2022-10-26
 */
@RestController
@RequestMapping("/contact")
public class ContactController {
    @Resource
    private IContactService contactService;

    @Resource
    private IUserService userService;

    @Resource
    private IUserchattingrecordService userchattingrecordService;

//    获取用户全部好友
    @GetMapping("/findAll")
    public Result findAll(@RequestParam Integer id) {
        List<SelectFriendList> list = contactService.getFriendList(id);
        return Result.success(list);
    }

    @PostMapping("/add")
    public Result add(@RequestBody AddUser addUser) {
        Long userId = addUser.getOwnId();
        Long friendId = addUser.getUserId();
        if(userId == friendId) {
            return Result.error(Constants.CODE_400, "不能添加自己");
        }
//        检查是否已经是好友
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("friendId", friendId);
        Contact contactCheck = contactService.getOne(queryWrapper);
        if(contactCheck != null) {
            return Result.error(Constants.CODE_400, "已经是好友");
        }

        //        添加聊天组
        Userchattingrecord userchattingrecord = new Userchattingrecord();
        userchattingrecord.setRecordGroupDesc("私聊");
        userchattingrecordService.save(userchattingrecord);
//        添加好友
        Contact contact = new Contact();
        contact.setUserId(userId);
        contact.setFriendId(friendId);
        contact.setRecordGroupId(userchattingrecord.getRecordGroupId());
        contactService.save(contact);

        Contact contact1 = new Contact();
        contact1.setUserId(friendId);
        contact1.setFriendId(userId);
        contact1.setRecordGroupId(userchattingrecord.getRecordGroupId());
        contactService.save(contact1);

        return Result.success("添加好友成功", userchattingrecord);
    }

    //    查询用户是否为好友
    @PostMapping("/check")
    public Result check(@RequestBody AddUser addUser) {
        Long userId = addUser.getOwnId();
        Long friendId = addUser.getUserId();
        if(userId == friendId) {
            return Result.error(Constants.CODE_400, "不能添加自己");
        }
        Contact contact = new Contact();
        QueryWrapper<Contact> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId", userId);
        queryWrapper.eq("friendId", friendId);
        contact = contactService.getOne(queryWrapper);
        if (contact != null) {
            User friendUser = new User();
            friendUser = userService.getById(friendId);
            return Result.success("已是好友", friendUser);
        } else {
            User friendUser = new User();
            friendUser = userService.getById(friendId);
            return Result.success("可以添加为好友", friendUser);
        }
    }


}

