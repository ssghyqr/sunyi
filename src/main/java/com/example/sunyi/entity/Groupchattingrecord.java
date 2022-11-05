package com.example.sunyi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 聊天室聊天记录
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@Getter
@Setter
@ApiModel(value = "Groupchattingrecord对象", description = "")
public class Groupchattingrecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "groupChattingRecordId", type = IdType.AUTO)
    private Long groupChattingRecordId;

    private Long chattingRecordGroupId;

    private Long groupChattingSenderId;

    private String groupChattingRecordDesc;

    private Boolean groupChattingRecordType;

    private LocalDateTime groupChattingRecordTime;


}
