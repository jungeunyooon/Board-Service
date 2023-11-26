package board.spring.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class MemberSignInRequest {
    @NotBlank(message = "공백일 수 없습니다.")
    @Email(message = "올바른 이메일 형식이어야 합니다.")
    private String email;
    @NotBlank(message = "공백일 수 없습니다.")
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
