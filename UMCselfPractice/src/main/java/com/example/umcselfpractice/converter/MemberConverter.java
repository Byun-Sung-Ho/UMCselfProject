package com.example.umcselfpractice.converter;

import com.example.umcselfpractice.domain.entity.FoodCategory;
import com.example.umcselfpractice.domain.entity.Member;
import com.example.umcselfpractice.domain.enums.Gender;
import com.example.umcselfpractice.domain.mapping.MemberPrefer;
import com.example.umcselfpractice.dto.MemberRequestDto;
import com.example.umcselfpractice.dto.MemberResponseDto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberConverter {
    public static MemberResponseDto.JoinResultDto toJoinResultDto(Member member) {
        return MemberResponseDto.JoinResultDto.builder().
                memberId(member.getId()).
                createAt(LocalDateTime.now()).
                build();
    }

    public static Member toMember(MemberRequestDto.JoinDto request) {
        Gender gender = switch (request.getGender()) {
            case 1 -> Gender.MALE;
            case 2 -> Gender.FEMALE;
            case 3 -> Gender.NONE;
            default -> null;
        };
        return Member.builder().
                address(request.getAddress()).
                specAddress(request.getSpecAddress()).
                gender(gender).
                name(request.getName()).
                memberPreferList(new ArrayList<>()).
                build();
    }

    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
