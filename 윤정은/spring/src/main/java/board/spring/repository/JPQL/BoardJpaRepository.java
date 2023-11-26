package board.spring.repository.JPQL;

import board.spring.domain.Board;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BoardJpaRepository implements BoardInterface{

    @PersistenceContext
    private final EntityManager em;

    public BoardJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public void save(Board board){
        em.persist(board);
    }

    @Override
    public List<Board> findAll(){
        return em.createQuery("SELECT b FROM Board b", Board.class).getResultList();
    }

    @Override
    public List<Board> findAllByTitleStartingWith(String title){
        return em.createQuery("SELECT b FROM Board b WHERE b.title LIKE :title", Board.class)
                .setParameter("title", title + "%")
                .getResultList();
    }

    @Override
    public List<Board> findAllListByMemberId(Long memberId){
        return em.createQuery("SELECT b FROM Board b WHERE b.member.id = :memberId", Board.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }

    @Override
    public Optional<Board> findById(Long boardId){
        Board board = em.find(Board.class, boardId);
        return Optional.ofNullable(board);
    }

    @Override
    public void deleteById(Long boardId){
        Board board = em.find(Board.class, boardId);
        if (board != null) {
            em.remove(board);
        }
    };
}

