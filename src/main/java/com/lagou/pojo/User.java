package com.lagou.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {

    private int id;

    private String username;

    private List<Order> orderList;

    private Order order;
}
