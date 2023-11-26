package board.spring.dto.request;

import jakarta.validation.constraints.NotBlank;

public class BoardUpdateRequest {
    @NotBlank(message = "공백일 수 없습니다.")
    private String title;
    @NotBlank(message = "공백일 수 없습니다.")
    private String content;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

