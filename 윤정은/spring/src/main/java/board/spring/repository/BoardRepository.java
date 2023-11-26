package board.spring.repository;

import board.spring.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAllByTitleStartingWith(String title);
    List<Board> findAllListByMemberId(Long id);

}

