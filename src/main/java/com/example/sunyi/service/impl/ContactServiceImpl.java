package com.example.sunyi.service.impl;

import com.example.sunyi.common.Result;
import com.example.sunyi.entity.Contact;
import com.example.sunyi.entity.DTO.SelectFriendList;
import com.example.sunyi.mapper.ContactMapper;
import com.example.sunyi.service.IContactService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 瑞
 * @since 2022-10-26
 */
@Service
public class ContactServiceImpl extends ServiceImpl<ContactMapper, Contact> implements IContactService {
    @Resource
    private ContactMapper contactMapper;

    @Override
    public List<SelectFriendList> getFriendList(Integer id) {
        List<SelectFriendList> list = contactMapper.friendList(id);
        return list;
    }
}
