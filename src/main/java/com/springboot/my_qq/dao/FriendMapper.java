package com.springboot.my_qq.dao;

import com.springboot.my_qq.model.Friend;
import com.springboot.my_qq.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface FriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Friend record);

    int insertSelective(Friend record);

    Friend selectByPrimaryKey(Integer id);
    List<User> getAllFreinds(int id);
    int updateByPrimaryKeySelective(Friend record);

    int updateByPrimaryKey(Friend record);
}
