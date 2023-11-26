package board.spring.repository.JPQL;


import board.spring.domain.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CommentJpaRepository implements CommentInterface {

    @PersistenceContext
    private final EntityManager em;

    public CommentJpaRepository(EntityManager em){
        this.em = em;
    }

    @Override
    public void save(Comment comment) {
        em.persist(comment);
    }

    @Override
    public Optional<Comment> findById(Long commentId) {
        Comment comment = em.find(Comment.class, commentId);
        return Optional.ofNullable(comment);
    }

    @Override
    public void deleteById(Long commentId) {
        Comment comment = em.find(Comment.class, commentId);
        if (comment != null) {
            em.remove(comment);
        }
    }
    @Override
    public List<Comment> findAllByBoardId(Long boardId) {
        return em.createQuery("SELECT c FROM Comment c WHERE c.board.id = :boardId", Comment.class)
                .setParameter("boardId", boardId)
                .getResultList();
    }
}
