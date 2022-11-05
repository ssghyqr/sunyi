package com.example.sunyi.entity.DTO;

import lombok.Data;

@Data
public class SelectGroupMember {
    private Long groupId;
    private Long userId;
    private String userName;
    private String userIntroduction;
}
