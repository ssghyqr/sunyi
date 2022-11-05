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
 * 群聊中群成员实体类
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@Getter
@Setter
  @ApiModel(value = "Groupmember对象", description = "")
public class Groupmember implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "groupMemberId", type = IdType.AUTO)
      private Long groupMemberId;

    private Long groupId;

    private Long userId;


}
