package board.spring.dto.request;

import board.spring.domain.Board;
import board.spring.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BoardSaveRequest {
    @NotBlank(message = "공백일 수 없습니다.")
    private String title;

    @NotBlank(message = "공백일 수 없습니다.")
    private String content;

    @NotNull(message = "공백일 수 없습니다.")
    private Long memberId;

    public BoardSaveRequest(String title, String content,Long memberId){
        this.title = title;
        this.content = content;
        this.memberId = memberId;
    }

    public Board toEntity(Member member){
        return new Board(title, content, member);
    }

    public Long getMemberId() {
        return memberId;
    }
}
