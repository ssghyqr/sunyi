package com.example.sunyi.service.impl;

import com.example.sunyi.entity.User;
import com.example.sunyi.mapper.UserMapper;
import com.example.sunyi.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 瑞
 * @since 2022-10-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
