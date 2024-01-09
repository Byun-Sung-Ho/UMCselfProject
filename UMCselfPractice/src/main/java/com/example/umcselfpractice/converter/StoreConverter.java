package com.example.umcselfpractice.converter;

import com.example.umcselfpractice.domain.entity.Review;
import com.example.umcselfpractice.dto.StoreRequestDto;
import com.example.umcselfpractice.dto.StoreResponseDto;

import java.time.LocalDateTime;
import java.util.List;

public class StoreConverter {

    public static Review toReview(StoreRequestDto.ReviewDTO request){
        return Review.builder()
                .title(request.getTitle())
                .score(request.getScore())
                .body(request.getBody())
                .build();
    }

    public static StoreResponseDto.CreateReviewResultDto toCreateReviewResultDTO(Review review){
        return StoreResponseDto.CreateReviewResultDto.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static StoreResponseDto.ReviewPreviewDto reviewPreViewDTO(Review review){
        return null;
    }
    public static StoreResponseDto.ReviewPreviewListDto reviewPreViewListDTO(List<Review> reviewList){
        return null;
    }
}
