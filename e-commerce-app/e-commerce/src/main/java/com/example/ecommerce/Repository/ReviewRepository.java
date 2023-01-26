package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {

}
