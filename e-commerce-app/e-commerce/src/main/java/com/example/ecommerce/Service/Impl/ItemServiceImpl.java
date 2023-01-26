package com.example.ecommerce.Service.Impl;

import com.example.ecommerce.Model.Item;
import com.example.ecommerce.Model.Review;
import com.example.ecommerce.Payload.ItemRequest;
import com.example.ecommerce.Payload.ItemResponse;
import com.example.ecommerce.Payload.PagedResponse;
import com.example.ecommerce.Payload.ReviewRequest;
import com.example.ecommerce.Repository.ItemRepository;
import com.example.ecommerce.Repository.ReviewRepository;
import com.example.ecommerce.Service.ItemService;
import com.example.ecommerce.Util.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemRepository itemRepo;
    @Autowired
    ReviewRepository reviewRepo;
    ObjectMapper mapper;


    @Override
    public PagedResponse<ItemResponse> get(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Item> items = itemRepo.findAll(pageable);
        List<ItemResponse> response = items.map(item -> {
            return ObjectMapper.ItemToItemResponse(item);
        }).getContent();
        return new PagedResponse<>(response, page, size, false);
    }

    @Override
    public PagedResponse<ItemResponse> getByName(String name, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Item> items = itemRepo.findAllByName(name, pageable);
        List<ItemResponse> response = items.map(item -> {
            return ObjectMapper.ItemToItemResponse(item);
        }).getContent();

        return new PagedResponse<>(response, page, size, false);
    }

    @Override
    public ItemResponse getById(Long id) {
        ItemResponse response = ObjectMapper.ItemToItemResponse(itemRepo.findById(id).get());
        return response;
    }

    @Override
    public PagedResponse<ItemResponse> getByCategory(String category, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Item> items = itemRepo.findAllByCategory(category, pageable);
        List<ItemResponse> response = items.map(item -> {
            return ObjectMapper.ItemToItemResponse(item);
        }).getContent();
        return new PagedResponse<>(response, page, size, false);
    }

    @Override
    public Item save(ItemRequest request) {

        Item item = ObjectMapper.ItemRequestToItem(request);
        return itemRepo.save(item);
    }

    @Override
    public String delete(Long id) {
        Item i = itemRepo.findById(id).get();
        itemRepo.delete(i);
        return "Deleted succesfully";
    }

    @Override
    public Item addReview(Long id, ReviewRequest request) {

        Item item = itemRepo.findById(id).get();
        Review review = ObjectMapper.reviewRequestToReview(request);
        item.addReview(review);
        return itemRepo.save(item);

    }
}
