package com.example.demo.member;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Member findById(Long id) {
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("SELECT m FROM Member m", Member.class)
                .getResultList();  // 멤버 확인 쿼리를 직접 생성. JPA가 멤버 엔티티 조회후 리스트로 반환
    }

    public Member findByLoginId(String loginId) {
        List<Member> result = em.createQuery("SELECT m FROM Member m WHERE m.loginId = :loginId", Member.class)
                .setParameter("loginId", loginId).getResultList(); // 파라미터 바인딩 (:loginId에 값을 바인딩)

        return result.isEmpty() ? null : result.get(0);
    }

    public void save(Member member) {
        em.persist(member); // 멤버 엔티티에 영속상태로 등록
    }

    public void deleteById(Long id) {
        Member member = em.find(Member.class, id);
        em.remove(member);
    }
}
