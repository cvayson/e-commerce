package com.example.ecommerce.Controller;

import com.example.ecommerce.Model.Item;
import com.example.ecommerce.Model.Review;
import com.example.ecommerce.Payload.ItemRequest;
import com.example.ecommerce.Payload.ItemResponse;
import com.example.ecommerce.Payload.PagedResponse;
import com.example.ecommerce.Payload.ReviewRequest;
import com.example.ecommerce.Service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/item")
public class ItemController {
    public final ItemService service;


    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/get/{page}/{size}")
    public PagedResponse<ItemResponse> get(@PathVariable int page, @PathVariable int size) {

        return service.get(page, size);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getName/{name}/{page}/{size}")
    public PagedResponse<ItemResponse> getByName(@PathVariable String name, @PathVariable int page, @PathVariable int size) {
        return service.getByName(name, page, size);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getId/{id}")
    public ItemResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/getCategory/{category}/{page}/{size}")
    public PagedResponse<ItemResponse> getByCategory(@PathVariable String category, @PathVariable int page, @PathVariable int size) {

        return service.getByCategory(category, page, size);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/save")
    public Item save(@RequestBody ItemRequest request) {
        return service.save(request);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return service.delete(id);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/update")
    public Item update(@RequestBody ItemRequest request) {
        return service.save(request);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/addReview/{id}")
    public Item addReview(@PathVariable Long id, @RequestBody ReviewRequest request) {
        return service.addReview(id, request);
    }
}

