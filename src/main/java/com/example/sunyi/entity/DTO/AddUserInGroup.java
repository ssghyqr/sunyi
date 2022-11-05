package com.example.sunyi.entity.DTO;

import lombok.Data;

/**
 * 添加用户进入群聊数据传输类
 */
@Data
public class AddUserInGroup {
    private Long userId;
    private Long groupId;
}
