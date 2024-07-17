package com.lmy.service;

import com.lmy.entity.User;
public interface UserService {
    public User login(User user);
    public int updateUser(User user);
    public int addUser(User user);
    public int deleteUser(String[] pkids);
}
