package com.springboot.my_qq.service;

import com.springboot.my_qq.model.User;

import java.util.List;

/**
 * 用户业务逻辑接口类
 *
 * Created by bysocket on 07/02/2017.
 */
public interface UserService {


    /**
     * 根据用户 ID,查询用户信息
     *
     * @param id
     * @return
     */
    User findUserById(int id);
    List<User> findAllUser(String username);

    /**
     * 新增用户信息
     *
     * @param User
     * @return
     */
    int saveUser(User User);

    /**
     * 更新用户信息
     *
     * @param User
     * @return
     */
    int updateUser(User User);

    /**
     * 根据用户 ID,删除用户信息
     *
     * @param id
     * @return
     */
    int deleteUser(int id);


    /**
     * 根据用户名 搜索用户密码
     *
     * @param username
     * @return
     */
    String find_password(String username);
    /**
     * 根据用户名 搜索用户id
     *
     * @param username
     * @return
     */
    int get_user_id(String username);

    String get_user_id_by_openId(String open_id);

}
