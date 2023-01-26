package com.example.ecommerce.Util;

import com.example.ecommerce.Model.Item;
import com.example.ecommerce.Model.Review;
import com.example.ecommerce.Model.ShoppingCart;
import com.example.ecommerce.Payload.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ObjectMapper {

    public static ItemResponse ItemToItemResponse(Item item) {
        ItemResponse response = new ItemResponse();
        response.setId(item.getId());
        response.setCategory(item.getCategory());
        response.setName(item.getName());
        response.setPrice(item.getPrice());
        response.setShipping(item.isShipping());
        response.setDescription(item.getDescription());
        response.setQuantity(item.getQuantity());
        response.setShippingPrice(item.getShippingPrice());

        List<ReviewResponse> reviews = item.getReviews().stream().map(review -> {

            ReviewResponse temp = ObjectMapper.ReviewToReviewResponse(review);

            return temp;
        }).collect(Collectors.toList());
        response.setReviews(reviews);


        return response;
    }

    public static Item ItemRequestToItem(ItemRequest itemRequest) {
        Item item = new Item();

        item.setName(itemRequest.getName());
        item.setPrice(itemRequest.getPrice());
        item.setShipping(itemRequest.isShipping());
        item.setDescription(itemRequest.getDescription());
        item.setShippingPrice(item.getShippingPrice());
        item.setQuantity(itemRequest.getQuantity());
        item.setCategory(itemRequest.getCategory());

        return item;
    }

    public static ReviewResponse ReviewToReviewResponse(Review review) {
        ReviewResponse response = new ReviewResponse();
        response.setComment(review.getComment());
        response.setRating(review.getRating());
        response.setId(review.getId());
        return response;

    }

    public static Review reviewRequestToReview(ReviewRequest request) {
        Review review = new Review(request.getRating(), request.getComment());
        return review;
    }

    public static ShoppingCartResponse shoppingCartToShoppingCartResponse(ShoppingCart shoppingCart) {
        ShoppingCartResponse response = new ShoppingCartResponse();

        response.setId(shoppingCart.getId());
        response.setUser(shoppingCart.getUser());

        List<ItemResponse> items = shoppingCart.getItems().stream().map(item -> {
            ItemResponse temp = ObjectMapper.ItemToItemResponse(item);
            return temp;
        }).collect(Collectors.toList());

        response.setItems(items);
        response.setFinalPrice(shoppingCart.getFinalPrice());

        return response;
    }

    public static ShoppingCart shoppingCartRequestToShoppingCart(ShoppingCartRequest request) {

        ShoppingCart cart = new ShoppingCart();

        cart.setUser(request.getUser());
        cart.setEmpty(request.getEmpty());

        return cart;
    }
}
