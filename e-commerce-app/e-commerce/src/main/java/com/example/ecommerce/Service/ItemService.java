package com.example.ecommerce.Service;

import com.example.ecommerce.Model.Item;
import com.example.ecommerce.Model.Review;
import com.example.ecommerce.Payload.ItemRequest;
import com.example.ecommerce.Payload.ItemResponse;
import com.example.ecommerce.Payload.PagedResponse;
import com.example.ecommerce.Payload.ReviewRequest;

import java.util.List;

public interface ItemService {


    PagedResponse<ItemResponse> get(int page, int size);

    PagedResponse<ItemResponse> getByName(String name, int page, int size);

    PagedResponse<ItemResponse> getByCategory(String category, int page, int size);

    ItemResponse getById(Long id);

    Item save(ItemRequest item);

    String delete(Long id);

    Item addReview(Long id, ReviewRequest request);


}
