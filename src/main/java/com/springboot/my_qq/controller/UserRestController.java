package com.springboot.my_qq.controller;

import com.springboot.my_qq.model.User;
import com.springboot.my_qq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.alibaba.fastjson.*;
import com.springboot.my_qq.myutils.Jwt;

import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserRestController {

    @Autowired
    private UserService userService;

    // 注册接口
    @RequestMapping(value = "/api/register", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> register(@RequestBody JSONObject json) {
        String username = json.getString("username");
        String nickname = username;
        String password = json.getString("password");
        if (userService.find_password(username) != null) {
            // 状态码406
            return new ResponseEntity<>("用户名已存在", HttpStatus.NOT_ACCEPTABLE);
        }

        User user = new User();
        user.setuName(username);
        user.setuPassword(password);
        user.setNickname(nickname);
        if (userService.saveUser(user) == 1) {
            JSONObject back = new JSONObject();
            back.put("username", username);
            // 有效期一个小时
            String token = Jwt.sign(back, 60L * 1000L * 60L);
            back.put("token", token);
            return new ResponseEntity<>(back.toJSONString(), HttpStatus.OK);

        } else {
            return new ResponseEntity<>("注册失败", HttpStatus.NOT_ACCEPTABLE);
        }
    }

    // 登录接口
    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody JSONObject json) {
        String username = json.getString("username");
        String password = json.getString("password");
        if (userService.find_password(username) == null) {
            // 状态码406
            return new ResponseEntity<>("用户名不存在", HttpStatus.NOT_ACCEPTABLE);

        } else if (userService.find_password(username).equals(password)) {
            JSONObject response = new JSONObject();
            int user_id = userService.get_user_id(username);
            response.put("username", username);
            response.put("user_id", user_id);
            // 有效期7天
            String token = Jwt.sign(response, 60L * 1000L * 60L * 24L * 7L);
            response.put("token", token);
            return new ResponseEntity<>(response.toJSONString(), HttpStatus.OK);
        } else {
            // 状态码406
            return new ResponseEntity<>("密码错误", HttpStatus.NOT_ACCEPTABLE);

        }
    }

//    @RequestMapping(value = "/api/logout", method = RequestMethod.POST)
//    public void logout(@RequestBody JSONObject json) {
//        String username = json.getString("username");
//        String password = json.getString("password");
//    }

    // 获取用户信息
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.GET)
    public User findOneCity(@PathVariable("id") int id) {
        return userService.findUserById(id);
    }

    // 修改用户信息
    @RequestMapping(value = "/api/user", method = RequestMethod.PUT)
    public void modifyCity(@RequestBody User User) {
        userService.updateUser(User);
    }

    // 删除用户，后台管理可能需要
    @RequestMapping(value = "/api/user/{id}", method = RequestMethod.DELETE)
    public void modifyCity(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }

    // 搜索用户
    @RequestMapping(value = "/api/Alluser/{username}", method = RequestMethod.GET)
    public List<User> findAllUser(@PathVariable("username") String username) {
        return userService.findAllUser(username);
    }

    // 第三方登录
    @RequestMapping(value = "/api/oauth", method = RequestMethod.POST)
    public ResponseEntity<String> Ooauth(@RequestBody JSONObject userInfo) {
        String openId = userInfo.getString("openId");


        long nowDate = new Date().getTime();
        String username = Integer.toHexString((int) nowDate);

        if (userService.get_user_id_by_openId(openId) == null) {
            // 注册
            String nickName = userInfo.getString("nickName");
            String avatarUrl = userInfo.getString("avatarUrl");
            String gender = userInfo.getString("gender");
            String province = userInfo.getString("province");
            String city = userInfo.getString("city");
            String password = "00000000";
            User new_user = new User();
            new_user.setuName(username);
            new_user.setNickname(nickName);
            new_user.setuPassword(password);
            new_user.setOpenId(openId);
            new_user.setuGender(gender);
            new_user.setuAvatar(avatarUrl);
            new_user.setuAddress(province + city);
            userService.saveUser(new_user);
        }
        JSONObject response = new JSONObject();
        response.put("user_id", userService.get_user_id_by_openId(openId));
        // 有效期7天
        response.put("token", Jwt.sign(response, 60L * 1000L * 60L * 24L * 7L));
        return new ResponseEntity<>(response.toJSONString(), HttpStatus.OK);


    }
}
