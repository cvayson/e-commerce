package com.example.ecommerce.Repository;

import com.example.ecommerce.Model.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {


    @Query(
            value = "select * from items  where items.name like %:name% ",
            nativeQuery = true
    )
    Page<Item> findAllByName(String name, Pageable pageable);


    Page<Item> findAllByCategory(String category, Pageable pageable);


}
