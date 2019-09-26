package com.springboot.my_qq.controller;

import com.springboot.my_qq.dao.AddFriendMapper;
import com.springboot.my_qq.model.AddFriend;
import com.springboot.my_qq.model.Friend;
import com.springboot.my_qq.model.User;
import com.springboot.my_qq.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class FriendRestController {
    @Autowired
    private FriendService friendService;

    @RequestMapping(value = "/api/friends/{user_id}", method = RequestMethod.GET)
    public List<User> findOneCity(@PathVariable("user_id") int user_id) {
        return friendService.findFriend(user_id);
    }
    @RequestMapping(value = "/api/friends", method = RequestMethod.POST)
    public int beFriend(@RequestBody Friend record) {
        return friendService.beFriends(record);
    }



    @RequestMapping(value = "/api/addfriends/{user_id}", method = RequestMethod.GET)
    public List<AddFriend> get_AddFriend_record(@PathVariable("user_id") int user_id) {
        return friendService.get_report_friend(user_id);
    }

    @RequestMapping(value = "/api/addfriends", method = RequestMethod.POST)
    public int addmessage(@RequestBody AddFriend record) {
        return friendService.add_report_friend(record);
    }

    @RequestMapping(value = "/api/addfriends", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody AddFriend record) {
        friendService.change_report_friend(record);
    }

}
