package com.springboot.my_qq.dao;

import com.springboot.my_qq.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    List<User> findAllUser(String username);

    int insertSelective(User record);
    int get_user_id(String username);
    String get_user_id_by_openId(String open_id);
    User selectByPrimaryKey(Integer id);
    String find_password(String username);
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
