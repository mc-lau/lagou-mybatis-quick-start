package com.lagou.dao;


import com.lagou.pojo.User;

import java.util.List;

public interface IUserMapper {

    User selectOne(int id);

    List<User> selectAll();

    int insert(User user);

    int update(User user);

    List<User> findByIds(int[] ids);
}
