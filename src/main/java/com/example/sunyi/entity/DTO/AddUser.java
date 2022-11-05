package com.example.sunyi.entity.DTO;

import lombok.Data;

/**
 * 加好友数据传输类
 */
@Data
public class AddUser {
    private Long ownId;
    private Long userId;
    private String userAccount;
    private String userName;
}
