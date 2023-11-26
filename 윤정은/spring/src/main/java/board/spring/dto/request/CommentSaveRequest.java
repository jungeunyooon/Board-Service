package board.spring.dto.request;

import board.spring.domain.Board;
import board.spring.domain.Comment;
import board.spring.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CommentSaveRequest {

    @NotBlank(message = "공백일 수 없습니다.")
    private String content;

    @NotNull(message = "공백일 수 없습니다.")
    private Long memberId;

    @NotNull(message = "공백일 수 없습니다.")
    private Long boardId;

    public CommentSaveRequest(String content, Long memberId, Long boardId){
        this.content = content;
        this.memberId = memberId;
        this.boardId = boardId;
    }
    public Comment toEntity(Member member, Board board) {
        return new Comment(content, member, board);
    }

    public Long getMemberId() {
        return memberId;
    }

    public Long getBoardId() {
        return boardId;
    }
}
