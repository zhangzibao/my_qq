package com.springboot.my_qq.dao;

import com.springboot.my_qq.model.AddFriend;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddFriendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AddFriend record);

    int insertSelective(AddFriend record);

    List<AddFriend> selectByPrimaryKey(int  user_id);

    int updateByPrimaryKeySelective(AddFriend record);

    int updateByPrimaryKey(AddFriend record);
}
