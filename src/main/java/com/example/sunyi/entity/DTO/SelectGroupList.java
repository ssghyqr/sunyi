package com.example.sunyi.entity.DTO;

import lombok.Data;

/**
 * 查询用户加入群聊
 */
@Data
public class SelectGroupList {
    private Long userId;
    private Long groupId;
    private String groupName;
    private String groupDesc;
}
