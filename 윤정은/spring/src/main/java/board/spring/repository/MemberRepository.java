package board.spring.repository;

import board.spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
//    Optional<Member> findByEmailAndPassword(String email, String password);

    @Query("SELECT m FROM Member m WHERE m.email = :email AND m.password = :password")
    Member findByEmailAndPassword(@Param("email") String email, @Param("password") String password);
}

