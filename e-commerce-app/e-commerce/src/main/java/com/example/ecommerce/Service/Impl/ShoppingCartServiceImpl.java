package com.example.ecommerce.Service.Impl;

import com.example.ecommerce.Model.Item;
import com.example.ecommerce.Model.ShoppingCart;
import com.example.ecommerce.Payload.ItemRequest;
import com.example.ecommerce.Payload.ShoppingCartRequest;
import com.example.ecommerce.Payload.ShoppingCartResponse;
import com.example.ecommerce.Repository.ShoppingCartRepository;
import com.example.ecommerce.Service.ShoppingCartService;
import com.example.ecommerce.Util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository repo;

    @Override
    public ShoppingCartResponse getByUser(String user) {

        return ObjectMapper.shoppingCartToShoppingCartResponse(repo.findByUser(user));
    }

    @Override
    public ShoppingCartResponse getById(Long id) {

        return ObjectMapper.shoppingCartToShoppingCartResponse(repo.findById(id).get());

    }

    @Override
    public ShoppingCartResponse save(ShoppingCartRequest request) {

        return ObjectMapper.shoppingCartToShoppingCartResponse
                (repo.save(ObjectMapper.shoppingCartRequestToShoppingCart(request)));

    }

    @Override
    public ShoppingCartResponse addItem(Long id, ItemRequest itemRequest) {

        ShoppingCart cart = repo.findById(id).get();
        List<Item> items = cart.getItems();
        items.add(ObjectMapper.ItemRequestToItem(itemRequest));
        return ObjectMapper.shoppingCartToShoppingCartResponse(repo.save(cart));
    }

    @Override
    public String checkOut() {
        return null;
    }

    @Override
    public String removeItem() {
        return null;
    }
}
