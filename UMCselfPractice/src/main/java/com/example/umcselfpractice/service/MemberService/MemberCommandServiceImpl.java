package com.example.umcselfpractice.service.MemberService;

import com.example.umcselfpractice.base.Code;
import com.example.umcselfpractice.base.exception.handler.FoodCategoryHandler;
import com.example.umcselfpractice.converter.MemberConverter;
import com.example.umcselfpractice.domain.entity.FoodCategory;
import com.example.umcselfpractice.domain.entity.Member;
import com.example.umcselfpractice.domain.mapping.MemberPrefer;
import com.example.umcselfpractice.dto.MemberRequestDto;
import com.example.umcselfpractice.repository.FoodCategoryRepository;
import com.example.umcselfpractice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberCommandServiceImpl implements MemberCommandService {
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    @Override
    @Transactional
    public Member joinMember(MemberRequestDto.JoinDto request) {
        Member member = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category)
                            .orElseThrow(() -> new FoodCategoryHandler(Code.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(member);});
        return memberRepository.save(member);
    }
}
