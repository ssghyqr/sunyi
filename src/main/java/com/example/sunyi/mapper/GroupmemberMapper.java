package com.example.sunyi.mapper;

import com.example.sunyi.entity.DTO.SelectGroupMember;
import com.example.sunyi.entity.Groupmember;
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
public interface GroupmemberMapper extends BaseMapper<Groupmember> {
//    查询一个群内的所有群成员
    public List<SelectGroupMember> getAllMember(Integer id);
}
