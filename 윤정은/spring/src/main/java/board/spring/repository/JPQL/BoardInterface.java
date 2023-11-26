package board.spring.repository.JPQL;


import board.spring.domain.Board;

import java.util.List;
import java.util.Optional;

public interface BoardInterface {

    void save(Board board);

    List<Board> findAll();

    List<Board> findAllByTitleStartingWith(String title);

    List<Board> findAllListByMemberId(Long memberId);

    Optional<Board> findById(Long boardId);

    void deleteById(Long boardId);
}
