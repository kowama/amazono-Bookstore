/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 4
 * Project : bookstore
 * Class : OrderServiceImpl
 * Last modified : 1/8/17 9:28 PM
 */

package com.kowama.bookstore.service.impl;

import java.util.Calendar;
import java.util.List;

import com.kowama.bookstore.domain.*;
import com.kowama.bookstore.repository.OrderRepository;
import com.kowama.bookstore.service.CartItemService;
import com.kowama.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartItemService cartItemService;

    public synchronized Order createOrder(ShoppingCart shoppingCart,
                                          ShippingAddress shippingAddress,
                                          BillingAddress billingAddress,
                                          Payment payment,
                                          String shippingMethod,
                                          User user) {
        Order order = new Order();
        order.setBillingAddress(billingAddress);
        order.setOrderStatus("created");
        order.setPayment(payment);
        order.setShippingAddress(shippingAddress);
        order.setShippingMethod(shippingMethod);

        List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);

        for (CartItem cartItem : cartItemList) {
            Book book = cartItem.getBook();
            cartItem.setOrder(order);
            book.setInStockNumber(book.getInStockNumber() - cartItem.getQty());
        }

        order.setCartItemList(cartItemList);
        order.setOrderDate(Calendar.getInstance().getTime());
        order.setOrderTotal(shoppingCart.getGrandTotal());
        shippingAddress.setOrder(order);
        billingAddress.setOrder(order);
        payment.setOrder(order);
        order.setUser(user);
        order = orderRepository.save(order);

        return order;
    }

    @Override
    public Order findOne(Long id) {
        return null;
    }


}
