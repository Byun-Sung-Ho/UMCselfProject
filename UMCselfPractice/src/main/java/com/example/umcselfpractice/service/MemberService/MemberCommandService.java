package com.example.umcselfpractice.service.MemberService;

import com.example.umcselfpractice.domain.entity.Member;
import com.example.umcselfpractice.dto.MemberRequestDto;

public interface MemberCommandService {
    public Member joinMember(MemberRequestDto.JoinDto request);
}
