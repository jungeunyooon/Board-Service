package board.spring.dto.request;

import jakarta.validation.constraints.NotBlank;

public class CommentUpdateRequest {

    @NotBlank(message = "공백일 수 없습니다.")
    private String content;

    public String getContent() { return content;}
}
