package com.example.sunyi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author 瑞
 * @since 2022-10-26
 */
@Getter
@Setter
@ApiModel(value = "Contact对象", description = "")
public class Contact implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "contactId", type = IdType.AUTO)
    private Long contactId;

    private Long userId;

    private Long friendId;

    private Long recordGroupId;


}
