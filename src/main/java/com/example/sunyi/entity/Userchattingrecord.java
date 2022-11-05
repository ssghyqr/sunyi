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
 * @since 2022-10-27
 */
@Getter
@Setter
  @ApiModel(value = "Userchattingrecord对象", description = "")
public class Userchattingrecord implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "recordGroupId", type = IdType.AUTO)
      private Long recordGroupId;

    private String recordGroupDesc;


}
