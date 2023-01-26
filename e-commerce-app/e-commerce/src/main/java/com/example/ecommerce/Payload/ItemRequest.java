package com.example.ecommerce.Payload;

import com.example.ecommerce.Model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {

    private String name;
    private String description;
    private Double price;
    private int quantity;
    private Category category;
    private boolean shipping;
    private Double shippingPrice;
}
