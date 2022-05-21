package com.springstudy.springcorepractice.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
