package com.example.ecommerce.Payload;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ShoppingCartResponse {

    private Long id;
    private String user;
    private double finalPrice;
    private List<ItemResponse> items = new ArrayList<>();
}
