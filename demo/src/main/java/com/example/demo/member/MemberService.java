package com.example.demo.member;

import com.example.demo.member.dto.MemberCreateRequest;
import com.example.demo.member.dto.MemberUpdateRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@RequiredArgsConstructor //생성자 어노테이션
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * id를 받아 존재하는 멤버인지 확인, 있으면 오류 발생
     * 새 멤버 생성 후 저장
     *
     */
    @Transactional
    public Long createMember(MemberCreateRequest request) {
        Member existingMember = memberRepository.findByLoginId(request.getLoginId());
        if (existingMember != null) {
            throw new RuntimeException("이미 존재하는 로그인 아이디입니다: " + request.getLoginId());
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

    @Transactional(readOnly = true)
    public List<Member> getAllMembers()
    {
        return memberRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Member getMemberById(Long id) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        return member;
    }

    @Transactional
    public void updateMember(Long id, MemberUpdateRequest request) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        // 회원 정보 수정 (도메인 객체의 메서드 사용)
        member.updateInfo(request.getPassword(), request.getPhoneNumber(), request.getAddress());
    }

    @Transactional
    public void deleteMember(Long id) {
        Member member = memberRepository.findById(id);

        if (member == null) {
            throw new RuntimeException("회원을 찾을 수 없습니다.");
        }

        // Repository를 통해 삭제
        memberRepository.deleteById(id);
    }
}
