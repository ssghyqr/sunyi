package com.example.sunyi.entity.DTO;

import lombok.Data;

/**
 * 查询私聊两个用户所处的聊天室
 */
@Data
public class SelectGroup {
    private Long ownId;
    private Long userId;
}
