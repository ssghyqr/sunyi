package com.example.sunyi.service.impl;

import com.example.sunyi.entity.DTO.SelectGroupMember;
import com.example.sunyi.entity.Groupmember;
import com.example.sunyi.mapper.GroupmemberMapper;
import com.example.sunyi.service.IGroupmemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
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
public class GroupmemberServiceImpl extends ServiceImpl<GroupmemberMapper, Groupmember> implements IGroupmemberService {
    @Resource
    private GroupmemberMapper groupmemberMapper;

    @Override
    public List<SelectGroupMember> getAllGroupMember(Integer id) {
        List<SelectGroupMember> list = groupmemberMapper.getAllMember(id);
        return list;
    }
}
