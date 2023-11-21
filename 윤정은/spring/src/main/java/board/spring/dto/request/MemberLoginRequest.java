//package board.spring.dto.request;
//
//import board.spring.domain.Member;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//
//@AllArgsConstructor
//@Getter @Setter
//public class MemberLoginRequest {
//    private String email;
//    private String password;
//
//    public Member toEntity(){
//        return new Member(email,password);
//    }
//}

package board.spring.dto.request;

import board.spring.domain.Member;

public class MemberLoginRequest {
    private String email;
    private String password;

    public MemberLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}