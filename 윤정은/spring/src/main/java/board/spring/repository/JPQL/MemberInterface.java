package board.spring.repository.JPQL;

import board.spring.domain.Member;

import java.util.Optional;

public interface MemberInterface {

    void save(Member member);

    Optional<Member> findByEmail(String email);

    Optional<Member> findById(Long memberId);
}
