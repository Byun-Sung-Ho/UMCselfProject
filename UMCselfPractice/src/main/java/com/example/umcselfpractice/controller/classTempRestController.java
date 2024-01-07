package com.example.umcselfpractice.controller;

import com.example.umcselfpractice.base.Code;
import com.example.umcselfpractice.base.ResponseDto;
import com.example.umcselfpractice.converter.TempConverter;
import com.example.umcselfpractice.dto.TempResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class classTempRestController {
    @GetMapping("/test")
    public ResponseDto<TempResponse.TempTestDTO> testApi() {
        return ResponseDto.onSuccess(TempConverter.toTempTestDTO(), Code.OK);
    }
}
