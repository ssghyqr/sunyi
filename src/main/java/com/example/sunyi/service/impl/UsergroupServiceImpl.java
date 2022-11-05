package com.example.sunyi.service.impl;

import com.example.sunyi.entity.DTO.SelectGroupMember;
import com.example.sunyi.entity.Usergroup;
import com.example.sunyi.mapper.UsergroupMapper;
import com.example.sunyi.service.IUsergroupService;
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
 * @since 2022-10-27
 */
@Service
public class UsergroupServiceImpl extends ServiceImpl<UsergroupMapper, Usergroup> implements IUsergroupService {
    @Resource UsergroupMapper usergroupMapper;

    @Override
    public List<SelectGroupMember> getUserGroupList(Integer id) {
        List<SelectGroupMember> list = usergroupMapper.getAllUserGroup(id);
        return list;
    }
}
