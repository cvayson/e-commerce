package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {

    public ShoppingCart findByUser(String user);

}
