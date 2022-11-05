package com.example.sunyi.controller;


import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.sunyi.common.Result;
import com.example.sunyi.entity.Chattingrecord;
import com.example.sunyi.service.IChattingrecordService;
import com.example.sunyi.service.IUserService;
import com.example.sunyi.utils.DateTransferToLocaltiem;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  用户私聊记录
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@RestController
@RequestMapping("/chattingrecord")
public class ChattingrecordController {
    @Resource
    private IUserService userService;

    @Resource
    private IChattingrecordService chattingrecordService;

//    保存消息信息
    @PostMapping("/saveRecord")
    public Result saveRecord(@RequestBody Chattingrecord chattingrecord) {
        chattingrecord.setGroupRecordTime(DateTransferToLocaltiem.Transfer(new Date()));
        chattingrecordService.save(chattingrecord);
        return Result.success(chattingrecord);
    }

    @GetMapping("/getRecord")
    public Result getRecord(Integer recordGroupId) {
//        获取消息
        Chattingrecord chattingrecord = new Chattingrecord();
        LambdaQueryWrapper<Chattingrecord> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Chattingrecord::getGroupRecordTime);
//        limit的sql查询
        queryWrapper.last("limit 10");
        List<Chattingrecord> list = chattingrecordService.list(queryWrapper);
        return Result.success(list);
    }
}

