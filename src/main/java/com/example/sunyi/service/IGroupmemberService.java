package com.example.sunyi.service;

import com.example.sunyi.entity.DTO.SelectGroupMember;
import com.example.sunyi.entity.Groupmember;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
public interface IGroupmemberService extends IService<Groupmember> {
//    查询群内的所有成员
    List<SelectGroupMember> getAllGroupMember(Integer id);
}
