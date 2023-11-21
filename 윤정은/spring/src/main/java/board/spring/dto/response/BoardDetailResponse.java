package board.spring.dto.response;

import board.spring.domain.Board;
import board.spring.domain.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDetailResponse {

    private String title;
    private String content;
    private String email;
    private List<Comment> comments;

//    public static BoardDetailResponse from(Board board) {
//        return new BoardDetailResponse(board.getTitle(), board.getContent(),board.getMember().getEmail(),board.getComments());
//    }

    @PersistenceContext
    private EntityManager entityManager;

    public BoardDetailResponse(String title, String content, String email, List<Comment> comments) {
        this.title = title;
        this.content = content;
        this.email = email;
        this.comments = comments;
    }


}
