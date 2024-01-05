package com.example.umcselfpractice.domain.entity;

import com.example.umcselfpractice.domain.common.baseEntity;
import com.example.umcselfpractice.domain.enums.Gender;
import com.example.umcselfpractice.domain.enums.MemberStatus;
import com.example.umcselfpractice.domain.enums.SocialType;
import com.example.umcselfpractice.domain.mapping.MemberAgree;
import com.example.umcselfpractice.domain.mapping.MemberMission;
import com.example.umcselfpractice.domain.mapping.MemberPrefer;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends baseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String specAddress;

    private LocalDate inactiveDate;

    private String email;

    private Integer point;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private SocialType socialType;

    @Enumerated(EnumType.STRING)
    private MemberStatus memberStatus;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberAgree> memberAgreeList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPreferList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}
