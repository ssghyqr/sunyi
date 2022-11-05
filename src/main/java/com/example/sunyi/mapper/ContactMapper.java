package com.example.sunyi.mapper;

import com.example.sunyi.entity.Contact;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sunyi.entity.DTO.SelectFriendList;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 瑞
 * @since 2022-10-26
 */
public interface ContactMapper extends BaseMapper<Contact> {
//    查询用户添加的所有好友
    public List<SelectFriendList> friendList(Integer id);
}
