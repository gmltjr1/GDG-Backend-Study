package com.example.shop.member.service;

import com.example.shop.common.exception.BadRequestException;
import com.example.shop.common.exception.NotFoundException;
import com.example.shop.common.message.ErrorMessage;
import com.example.shop.member.Member;
import com.example.shop.member.repository.MemberRepository;
import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor //생성자 어노테이션
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    /**
     * id를 받아 존재하는 멤버인지 확인, 있으면 오류 발생
     * 새 멤버 생성 후 저장
     *
     */
    @Override
    @Transactional
    public Long createMember(MemberCreateRequest request) {
        Member existingMember = memberRepository.findByLoginId(request.getLoginId());
        if (existingMember != null) {
            throw new BadRequestException(ErrorMessage.MEMBER_ALREADY_EXISTS);
        }

        Member member = new Member(
                request.getLoginId(),
                request.getPassword(),
                request.getPhoneNumber(),
                request.getAddress()
        );

        memberRepository.save(member);

        return member.getId();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Member> getAllMembers()
    {
        return memberRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Member getMemberById(Long id) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND);
        }

        return member;
    }

    @Override
    @Transactional
    public void updateMember(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND);
        }

        String password = (request.getPassword() != null)
                ? request.getPassword()
                : member.getPassword();
        String phoneNumber = (request.getPhoneNumber() != null)
                ? request.getPhoneNumber()
                : member.getPhoneNumber();
        String address =  (request.getAddress() != null)
                ? request.getAddress()
                : member.getAddress();

        // 회원 정보 수정 (도메인 객체의 메서드 사용)
        member.updateInfo(password, phoneNumber, address);
    }

    @Override
    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new NotFoundException(ErrorMessage.MEMBER_NOT_FOUND);
        }

        // Repository를 통해 삭제
        memberRepository.deleteById(id);
    }
}
