package com.example.sunyi.service;

import com.example.sunyi.common.Result;
import com.example.sunyi.entity.Contact;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.sunyi.entity.DTO.SelectFriendList;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 瑞
 * @since 2022-10-26
 */
public interface IContactService extends IService<Contact> {
    List<SelectFriendList> getFriendList(Integer id);
}
