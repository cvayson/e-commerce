package com.example.ecommerce.Service;

import com.example.ecommerce.Model.ShoppingCart;
import com.example.ecommerce.Payload.ItemRequest;
import com.example.ecommerce.Payload.ShoppingCartRequest;
import com.example.ecommerce.Payload.ShoppingCartResponse;
import org.springframework.stereotype.Service;

@Service
public interface ShoppingCartService {

    public ShoppingCartResponse getByUser(String user);

    public ShoppingCartResponse getById(Long id);

    public ShoppingCartResponse save(ShoppingCartRequest request);

    public ShoppingCartResponse addItem(Long id, ItemRequest itemRequest);

    public String checkOut();

    public String removeItem();

}
