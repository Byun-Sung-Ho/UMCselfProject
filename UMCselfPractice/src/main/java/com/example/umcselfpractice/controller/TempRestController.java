package com.example.umcselfpractice.controller;

import com.example.umcselfpractice.base.Code;
import com.example.umcselfpractice.base.ResponseDto;
import com.example.umcselfpractice.converter.TempConverter;
import com.example.umcselfpractice.dto.TempResponse;
import com.example.umcselfpractice.service.TempService.TempQueryService;
import com.example.umcselfpractice.service.TempService.TempQueryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {
    private final TempQueryService tempQueryService;
    @GetMapping("/test")
    public ResponseDto<TempResponse.TempTestDTO> testApi() {
        return ResponseDto.onSuccess(TempConverter.toTempTestDTO(), Code.OK);
    }

    @GetMapping("/exception")
    public ResponseDto<TempResponse.TempExceptionDTO> exceptionApi(@RequestParam Integer flag) {
        tempQueryService.CheckFlag(flag);
        return ResponseDto.onSuccess(TempConverter.toTempExceptionDTO(flag),Code.OK);
    }
}
