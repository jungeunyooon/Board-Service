package board.spring.service;

import board.spring.domain.Member;
import board.spring.dto.request.MemberSignInRequest;
import board.spring.dto.request.MemberSignUpRequest;
import board.spring.repository.JPQL.MemberInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberService {
    private final MemberInterface memberInterface;

    public MemberService(MemberInterface memberInterface) {
        this.memberInterface = memberInterface;
    }
    public void signUp(MemberSignUpRequest request) {
        Member member = request.toEntity();
        memberInterface.save(member);
    }
    public void signIn(MemberSignInRequest request) {
        Member member = memberInterface.findByEmail(request.getEmail()).orElseThrow(
                () -> new RuntimeException("존재하지 않는 회원입니다.")
        );
        if (!member.getPassword().equals(request.getPassword())) throw new RuntimeException("로그인 실패");
    }

    public Member getMemberById(Long memberId) {
        return memberInterface.findById(memberId).orElseThrow(
                () -> new RuntimeException("존재하지 않는 회원입니다.")
        );
    }
}
