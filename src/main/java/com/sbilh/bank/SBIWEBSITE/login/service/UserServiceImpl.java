package com.sbilh.bank.SBIWEBSITE.login.service;

import com.sbilh.bank.SBIWEBSITE.login.dto.Role;
import com.sbilh.bank.SBIWEBSITE.login.dto.User;
import com.sbilh.bank.SBIWEBSITE.login.repo.RoleRepository;
import com.sbilh.bank.SBIWEBSITE.login.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User saveUser(User user) {
        return null;
    }

    @Override
    public Role saveRole(Role role) {
        return null;
    }

    @Override
    public void addRoleToUser(String username, String rolename) {

    }

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }
}
