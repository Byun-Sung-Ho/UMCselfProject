package com.example.umcselfpractice.dto;

import lombok.Getter;

public class StoreRequestDto {
    @Getter
    public static class ReviewDTO {
        String title;
        Float score;
        String body;
    }
}
