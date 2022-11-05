package com.example.sunyi.service;

import com.example.sunyi.entity.DTO.SelectGroupMember;
import com.example.sunyi.entity.Usergroup;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
public interface IUsergroupService extends IService<Usergroup> {
    List<SelectGroupMember> getUserGroupList(Integer id);
}
