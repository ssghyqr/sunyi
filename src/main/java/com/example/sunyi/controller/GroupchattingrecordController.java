package com.example.sunyi.controller;


import com.example.sunyi.common.Result;
import com.example.sunyi.entity.Chattingrecord;
import com.example.sunyi.entity.Groupchattingrecord;
import com.example.sunyi.service.IGroupchattingrecordService;
import com.example.sunyi.utils.DateTransferToLocaltiem;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 * 群聊记录控制器
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@RestController
@RequestMapping("/groupchattingrecord")
public class GroupchattingrecordController {
    @Resource
    private IGroupchattingrecordService groupchattingrecordService;

    //    添加聊天记录
//    保存消息信息
    @PostMapping("/saveRecord")
    public Result saveRecord(@RequestBody Groupchattingrecord groupchattingrecord) {
        groupchattingrecord.setGroupChattingRecordTime(DateTransferToLocaltiem.Transfer(new Date()));
        groupchattingrecordService.save(groupchattingrecord);
        return Result.success(groupchattingrecord);
    }
}

