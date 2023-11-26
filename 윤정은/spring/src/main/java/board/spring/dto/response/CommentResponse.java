package board.spring.dto.response;

import board.spring.domain.Comment;

public class CommentResponse {
    private String content;
    private String email;

    // Comment 객체에서 필요한 정보를 추출하여 CommentResponse 객체로 변환
    public static CommentResponse from(Comment comment) {
        return new CommentResponse(comment.getContent(), comment.getMember().getEmail());
    }

    public CommentResponse(String content, String email) {
        this.content = content;
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public String getEmail() {
        return email;
    }
}

