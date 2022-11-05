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
 * 群聊聊天记录列表实体
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@Getter
@Setter
  @ApiModel(value = "Chattingrecordgroup对象", description = "")
public class Chattingrecordgroup implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "ChattingRecordGroupId", type = IdType.AUTO)
      private Long chattingRecordGroupId;

    private String chattingRecordGroupDesc;


}
