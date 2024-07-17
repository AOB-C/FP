package com.lmy.mapper;

import com.lmy.entity.User;
import org.springframework.stereotype.Repository;

@Repository("userMapper")
public interface UserMapper {
    User login(User user);
    int updateUser(User user);
    int addUser(User user);
    int deleteByPrimaryKey(String[] pkid);
}
