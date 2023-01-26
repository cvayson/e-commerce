package com.example.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "items")
public class Item {

    @SequenceGenerator(name = "item_generator", sequenceName = "item_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "item_generator")
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;
    private int quantity;
    private boolean shipping;
    private Double shippingPrice;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @OneToMany(orphanRemoval = true, targetEntity = Review.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private List<Review> reviews = new ArrayList<>();

    public Item(String name, String description, Double price, int quantity, Category category,
                boolean shipping, Double shippingPrice, List<Review> reviews) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.shipping = shipping;
        this.shippingPrice = shippingPrice;
        this.reviews = reviews;
    }

    public String addReview(Review review) {
        this.reviews.add(review);
        return "Review successfully added!!!";
    }
}
