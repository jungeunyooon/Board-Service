package board.spring.dto.request;

import board.spring.domain.Member;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class MemberSignUpRequest {

    @NotBlank(message = "공백일 수 없습니다.")
    @Email(message = "올바른 이메일 형식이어야 합니다.")
    private String email;
    @NotBlank(message = "공백일 수 없습니다.")
    private String password;

    @NotBlank(message = "공백일 수 없습니다.")
    private String nickname;

    public MemberSignUpRequest(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public Member toEntity() {
        return new Member(email, password, nickname);
    }
}
