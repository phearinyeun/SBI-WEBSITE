package com.sbilh.bank.SBIWEBSITE.login.service;

import com.sbilh.bank.SBIWEBSITE.login.dto.Role;
import com.sbilh.bank.SBIWEBSITE.login.dto.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String rolename);
    User getUser(User user);
    List<User> getUsers();
}
