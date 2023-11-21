//package board.spring.dto.request;
//
//import board.spring.domain.Member;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.Setter;
//
//@AllArgsConstructor
//@Getter @Setter
//
//public class MemberSaveRequest {
//
//    private String email;
//    private String password;
//    private String nickname;
//
//    public Member toEntity(){
//        return new Member(email,password,nickname);
//    }
//
//}


package board.spring.dto.request;

import board.spring.domain.Member;

public class MemberSaveRequest {

    private String email;
    private String password;
    private String nickname;

    public MemberSaveRequest(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    public Member toEntity() {
        return new Member(email, password, nickname);
    }
}
