package com.example.ecommerce.Payload;

import lombok.Data;

@Data
public class ShoppingCartRequest {

    private String user;
    private Boolean empty;

}
