package board.spring.repository.JPQL;

import board.spring.domain.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentInterface {

    void save(Comment comment);

    Optional<Comment> findById(Long commentId);

    void deleteById(Long commentId);

    List<Comment> findAllByBoardId(Long boardId);


}
