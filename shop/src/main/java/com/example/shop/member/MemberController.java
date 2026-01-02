package com.example.shop.member;

import com.example.shop.member.service.MemberService;
import com.example.shop.member.dto.MemberCreateRequest;
import com.example.shop.member.dto.MemberUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;

//@Controller
//@ResponseBody
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping
    public ResponseEntity<Void> createMember(@RequestBody @Valid MemberCreateRequest request) //@requestbodys는 json을 객체로 변환 하는 어노테이션
    {
        Long memberId = memberService.createMember(request);
        return ResponseEntity.created(URI.create("/members/" + memberId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Member>> getAllMembers()
    {
        List<Member> members = memberService.getAllMembers();
        return ResponseEntity.ok(members);
    }

    @GetMapping("/{memberId}")
    public ResponseEntity<Member> getMember(@PathVariable Long memberId)
    {
        Member member = memberService.getMemberById(memberId);
        return ResponseEntity.ok(member);
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<Void> UpdateMember(
            @PathVariable Long memberId,
            @RequestBody @Valid MemberUpdateRequest request)
    {
        memberService.updateMember(memberId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId)
    {
        memberService.deleteMember(memberId);
        return ResponseEntity.noContent().build();  // 204 no content
    }
}
