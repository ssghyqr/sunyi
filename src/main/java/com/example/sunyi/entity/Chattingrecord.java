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
 * 
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
@Getter
@Setter
  @ApiModel(value = "Chattingrecord对象", description = "")
public class Chattingrecord implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "recordId", type = IdType.AUTO)
      private Long recordId;

    private Long recordGroupId;

    private Long groupSenderId;

    private String groupRecordDesc;

    private Boolean groupRecordType;

    private LocalDateTime groupRecordTime;


}
