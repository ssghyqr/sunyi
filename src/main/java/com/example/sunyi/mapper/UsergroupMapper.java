package com.example.sunyi.mapper;

import com.example.sunyi.entity.DTO.SelectGroupMember;
import com.example.sunyi.entity.Usergroup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 瑞
 * @since 2022-10-27
 */
public interface UsergroupMapper extends BaseMapper<Usergroup> {
    public List<SelectGroupMember> getAllUserGroup(Integer id);
}
