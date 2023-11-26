package board.spring.repository.JPQL;

import board.spring.domain.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MemberJpaRepository implements MemberInterface {
    @PersistenceContext
    private final EntityManager em;

    public MemberJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Member member) {
        em.persist(member);
    }

    @Override
    public Optional<Member> findByEmail(String email) {
        TypedQuery<Member> query = em.createQuery(
                "SELECT m FROM Member m WHERE m.email = :email", Member.class);
        query.setParameter("email", email);

        try {
            Member member = query.getSingleResult();
            return Optional.of(member);
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Member> findById(Long memberId) {
        Member member = em.find(Member.class, memberId);
        return Optional.ofNullable(member);
    }
}
