package com.springboot.my_qq.service.impl;

import com.springboot.my_qq.dao.AddFriendMapper;
import com.springboot.my_qq.dao.FriendMapper;
import com.springboot.my_qq.model.AddFriend;
import com.springboot.my_qq.model.Friend;
import com.springboot.my_qq.model.User;
import com.springboot.my_qq.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl implements FriendService {

    @Autowired
    private FriendMapper friendMapper;
    @Autowired
    private AddFriendMapper addfriendMapper;
    @Override
    public List<User> findFriend(int id) {

        return friendMapper.getAllFreinds(id);
    }
    @Override
    public int beFriends(Friend record){
        return friendMapper.insertSelective(record);
    }
    // 添加好友的记录...
    @Override
    public List<AddFriend> get_report_friend(int user_id) {

        return addfriendMapper.selectByPrimaryKey(user_id);
    }

    @Override
    public int add_report_friend(AddFriend record){
        return addfriendMapper.insertSelective(record);
    }
    @Override
    public int change_report_friend(AddFriend record){
        return addfriendMapper.updateByPrimaryKeySelective(record);
    }

}

