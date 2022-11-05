package com.example.sunyi.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sunyi.common.Constants;
import com.example.sunyi.common.Result;
import com.example.sunyi.entity.DTO.AddUserInGroup;
import com.example.sunyi.entity.DTO.SelectGroupMember;
import com.example.sunyi.entity.Groupmember;
import com.example.sunyi.entity.User;
import com.example.sunyi.service.IGroupmemberService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  群聊中管理群成员控制类
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@RestController
@RequestMapping("/groupmember")
public class GroupmemberController {
    @Resource
    private IGroupmemberService groupmemberService;

//    获取用户加入的所有群聊


//    添加群成员
    @PostMapping("/add")
    public Result add(@RequestBody AddUserInGroup addUserInGroup) {
        Long userId = addUserInGroup.getUserId();
        Long groupId = addUserInGroup.getGroupId();
        QueryWrapper<Groupmember> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("groupId", groupId);
        queryWrapper.eq("userId", userId);
        Groupmember check_groupMember = groupmemberService.getOne(queryWrapper);
//        表示用户此时在群聊内
        if(check_groupMember != null) {
            return Result.error(Constants.CODE_400, "用户已存在群聊内");
        }
//        保存群聊成员
        Groupmember groupmember = new Groupmember();
        groupmember.setUserId(userId);
        groupmember.setGroupId(groupId);
        groupmemberService.save(groupmember);

        return Result.success("加入群聊成功", groupmember);
    }

//    获取群内所有人员
    @GetMapping("/getAll")
    public Result getAll(Integer id) {
        List<SelectGroupMember> list = groupmemberService.getAllGroupMember(id);
        return Result.success(list);
    }


}

