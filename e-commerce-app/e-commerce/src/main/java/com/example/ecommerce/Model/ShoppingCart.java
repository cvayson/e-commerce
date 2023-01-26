package com.example.ecommerce.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "shopping_cart")
public class ShoppingCart {

    @SequenceGenerator(name = "cart_generator", sequenceName = "cart_generator", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cart_generator")
    private Long id;
    private String user;
    @ManyToMany
    @JoinColumn(name = "cart_id")
    private List<Item> items = new ArrayList<>();
    private double finalPrice;
    private Boolean empty;

    public ShoppingCart(String user, List<Item> items, double finalPrice) {
        this.user = user;
        this.items = items;
        this.finalPrice = finalPrice;
    }

    public void setFinalPrice() {
        this.finalPrice = 0;

        for (Item i : this.items) {
            this.finalPrice += (i.getPrice() + i.getShippingPrice());
        }
    }
}
