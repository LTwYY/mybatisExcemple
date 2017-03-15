package com.weepal.xult.mapper;

import java.util.List;

import com.weepal.xult.po.User;

/**
 * 用户相关操作
 * 
 * @author xult
 * @date 2017年3月15日 下午2:24:07
 */
public interface UserMapper {
    // 根据id查询用户信息
    public User findUserById(int id) throws Exception;

    // 根据用户名查询用户信息
    public List<User> findUserByUsername(String userName) throws Exception;

    // 插入用户信息
    public void insertUser(User user) throws Exception;

    // 删除用户信息
    public void deleteUserById(int id) throws Exception;

    // 更新用户信息
    public void updateUserById(User user) throws Exception;


}
