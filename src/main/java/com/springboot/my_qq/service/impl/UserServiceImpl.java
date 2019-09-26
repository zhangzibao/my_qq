package com.springboot.my_qq.service.impl;

import com.springboot.my_qq.model.User;
import com.springboot.my_qq.dao.UserMapper;
import com.springboot.my_qq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper UserMapper;

    @Override
    public User findUserById(int id) {
        return UserMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> findAllUser(String username) {
        return UserMapper.findAllUser(username);
    }

    @Override
    public int saveUser(User user) {
        return UserMapper.insertSelective(user);
    }

    @Override
    public int updateUser(User user) {
        return UserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteUser(int id) {
        return UserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public String find_password(String username) {
        return UserMapper.find_password(username);
    }

    @Override
    public int get_user_id(String username) {
        return UserMapper.get_user_id(username);
    }

    @Override
    public String get_user_id_by_openId(String open_id) {
        return UserMapper.get_user_id_by_openId(open_id);
    }


}
