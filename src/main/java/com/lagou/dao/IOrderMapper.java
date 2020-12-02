package com.lagou.dao;

import com.lagou.pojo.Order;

public interface IOrderMapper {

    Order selectOne(int id);
}
