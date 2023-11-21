package board.spring.service;

import board.spring.domain.Member;
import board.spring.dto.request.MemberLoginRequest;
import board.spring.dto.request.MemberSaveRequest;
import board.spring.repository.MemberRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
//@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @PersistenceContext
    private EntityManager entityManager;

    // 생성자 주입 (@RequiredArgsConstructor)
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void saveMember(MemberSaveRequest request) {
        Member member = request.toEntity();
        memberRepository.save(member);
    }

//    public boolean loginMember(MemberLoginRequest request) {
//        return memberRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
//                .isPresent();
//    }

    // Spring Data JPA 메서드 → SQL OR JPQL
    public boolean loginMember(MemberLoginRequest request) {
        TypedQuery<Member> query = entityManager.createQuery(
                "SELECT m FROM Member m WHERE m.email = :email AND m.password = :password", Member.class);
        query.setParameter("email", request.getEmail());
        query.setParameter("password", request.getPassword());
        List<Member> result = query.getResultList();
        return !result.isEmpty();
    }
}
