/*
 * Copyright (c) 2019
 * Created By : kowama
 * Date :  6/4/2019
 * Time : 7 : 4
 * Project : bookstore
 * Class : CartItemServiceImpl
 * Last modified : 1/9/17 8:21 AM
 */

package com.kowama.bookstore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.kowama.bookstore.domain.*;
import com.kowama.bookstore.repository.BookToCartItemRepository;
import com.kowama.bookstore.repository.CartItemRepository;
import com.kowama.bookstore.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private BookToCartItemRepository bookToCartItemRepository;

    public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
        return cartItemRepository.findByShoppingCart(shoppingCart);
    }

    public CartItem updateCartItem(CartItem cartItem) {
        BigDecimal bigDecimal = new BigDecimal(cartItem.getBook().getOurPrice()).multiply(new BigDecimal(cartItem.getQty()));

        bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        cartItem.setSubtotal(bigDecimal);

        cartItemRepository.save(cartItem);

        return cartItem;
    }

    public CartItem addBookToCartItem(Book book, User user, int qty) {
        List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());

        for (CartItem cartItem : cartItemList) {
            if (book.getId() == cartItem.getBook().getId()) {
                cartItem.setQty(cartItem.getQty() + qty);
                cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(qty)));
                cartItemRepository.save(cartItem);
                return cartItem;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setShoppingCart(user.getShoppingCart());
        cartItem.setBook(book);

        cartItem.setQty(qty);
        cartItem.setSubtotal(new BigDecimal(book.getOurPrice()).multiply(new BigDecimal(qty)));
        cartItem = cartItemRepository.save(cartItem);

        BookToCartItem bookToCartItem = new BookToCartItem();
        bookToCartItem.setBook(book);
        bookToCartItem.setCartItem(cartItem);
        bookToCartItemRepository.save(bookToCartItem);

        return cartItem;
    }

    @Override
    public CartItem findById(Long id) {
        return null;
    }


    public void removeCartItem(CartItem cartItem) {
        bookToCartItemRepository.deleteByCartItem(cartItem);
        cartItemRepository.delete(cartItem);
    }

    public CartItem save(CartItem cartItem) {
        return cartItemRepository.save(cartItem);
    }

    public List<CartItem> findByOrder(Order order) {
        return cartItemRepository.findByOrder(order);
    }
}
