package com.example.umcselfpractice.controller;

import com.example.umcselfpractice.base.Code;
import com.example.umcselfpractice.base.ResponseDto;
import com.example.umcselfpractice.converter.MemberConverter;
import com.example.umcselfpractice.domain.entity.Member;
import com.example.umcselfpractice.dto.MemberRequestDto;
import com.example.umcselfpractice.dto.MemberResponseDto;
import com.example.umcselfpractice.service.MemberService.MemberCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ResponseDto<MemberResponseDto.JoinResultDto> join(@Valid @RequestBody MemberRequestDto.JoinDto request) {
        Member member = memberCommandService.joinMember(request);
        return ResponseDto.onSuccess(MemberConverter.toJoinResultDto(member), Code.OK);
    }
}
