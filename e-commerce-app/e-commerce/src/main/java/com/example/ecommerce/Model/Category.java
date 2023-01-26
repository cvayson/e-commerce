package com.example.ecommerce.Model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Category {
    @SequenceGenerator(name = "category_generator", sequenceName = "category_generator", allocationSize = 1)
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "category_generator")
    private Long id;
    private String categoryName;
}
