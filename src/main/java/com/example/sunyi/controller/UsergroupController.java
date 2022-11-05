package com.example.sunyi.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sunyi.common.Constants;
import com.example.sunyi.common.Result;
import com.example.sunyi.entity.Chattingrecordgroup;
import com.example.sunyi.entity.DTO.AddGroup;
import com.example.sunyi.entity.Usergroup;
import com.example.sunyi.service.IChattingrecordgroupService;
import com.example.sunyi.service.IUsergroupService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 *  群聊控制类
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@RestController
@RequestMapping("/usergroup")
public class UsergroupController {
    @Resource
    private IUsergroupService usergroupService;

    @Resource
    private IChattingrecordgroupService chattingrecordgroupService;

//    按名字得到组id
    @PostMapping("/findNameId")
    public Result findNameId(@RequestParam String groupName) {
        QueryWrapper<Usergroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("groupName", groupName);
        Usergroup usergroup = usergroupService.getOne(queryWrapper);
        if(usergroup == null) {
            return Result.error(Constants.CODE_400, "群聊不存在");
        }
        return Result.success(usergroup);
    }

//    添加群聊
    @PostMapping("/add")
    public Result add(@RequestBody AddGroup addGroup) {
        String groupDesc = addGroup.getGroupDesc();
        String groupName = addGroup.getGroupName();
        if(StrUtil.isBlank(groupName) || StrUtil.isBlank(groupDesc)) {
            return Result.error(Constants.CODE_400, "群聊名或群描述不能为空");
        }

//        查看是否友重复群聊
        QueryWrapper<Usergroup> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("groupName", groupName);
        Usergroup check_usergroup = usergroupService.getOne(queryWrapper);
        if(check_usergroup != null) {
            return Result.error(Constants.CODE_400, "群聊已存在");
        }

//        添加聊天记录组
        Chattingrecordgroup chattingrecordgroup = new Chattingrecordgroup();
        chattingrecordgroup.setChattingRecordGroupDesc(groupDesc);
        chattingrecordgroupService.save(chattingrecordgroup);
//        添加群聊
        Usergroup usergroup = new Usergroup();
        usergroup.setChattingRecordGroupId(chattingrecordgroup.getChattingRecordGroupId());
        usergroup.setGroupName(groupName);
        usergroup.setGroupDesc(groupDesc);
        usergroupService.save(usergroup);

        return Result.success("添加群聊成功", addGroup);
    }

    // 查询用户加入群聊
    @GetMapping("/getUserGroupList")
    public Result getUserGroupList(@RequestParam Integer id) {
        return Result.success(usergroupService.getUserGroupList(id));
    }
}

