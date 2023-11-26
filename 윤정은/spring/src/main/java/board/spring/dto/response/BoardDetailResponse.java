package board.spring.dto.response;

import board.spring.domain.Board;
import board.spring.domain.Member;

import java.util.List;

public class BoardDetailResponse {

    private String title;
    private String content;
    private String email;
    private List<CommentResponse> commentResponse;

    public static BoardDetailResponse from(Board board, List<CommentResponse> commentList) {
        return new BoardDetailResponse(board.getTitle(), board.getContent(),board.getMember(),commentList);
    }

    public BoardDetailResponse(String title, String content, Member member, List<CommentResponse> commentList) {
        this.title = title;
        this.content = content;
        this.email = member.getEmail();
        this.commentResponse = commentList;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }

    public List<CommentResponse> getCommentResponse() {
        return commentResponse;
    }

}
