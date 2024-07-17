package com.lmy.service.impl;

import com.lmy.entity.User;
import com.lmy.mapper.UserMapper;
import com.lmy.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public User login(User user) {
        return userMapper.login(user);
    }
    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }
    @Override
    public int addUser(User user) {
        if(user.getPkid()==null||user.getPkid()==""){
            user.setPkid(UUID.randomUUID().toString());
        }
        //user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
        return userMapper.addUser(user);
    }
    @Override
    public int deleteUser(String[] pkids) {
        return userMapper.deleteByPrimaryKey(pkids);
    }

}
