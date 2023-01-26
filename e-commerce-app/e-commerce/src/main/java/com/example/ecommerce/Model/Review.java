package com.example.ecommerce.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {

    @SequenceGenerator(name = "review_generator", sequenceName = "review_generator", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_generator")
    @Id
    private Long id;
    private Double rating;
    private String comment;


    public Review(Double rating, String comment) {
        this.rating = rating;
        this.comment = comment;
    }
}
