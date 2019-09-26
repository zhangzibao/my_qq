package com.springboot.my_qq.service;

import com.springboot.my_qq.model.AddFriend;
import com.springboot.my_qq.model.Friend;
import com.springboot.my_qq.model.User;

import java.util.List;

public interface FriendService {
    /**
     * 根据用户 ID,获取所有好友信息
     *
     * @param id
     * @return 好友列表
     */
    List<User> findFriend(int id);

    List<AddFriend> get_report_friend(int user_id);
    int beFriends(Friend record);
    int add_report_friend(AddFriend record);

    int change_report_friend(AddFriend record);


}
