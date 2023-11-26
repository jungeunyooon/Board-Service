package board.spring.controller;

import board.spring.dto.request.MemberSignInRequest;
import board.spring.dto.request.MemberSignUpRequest;
import board.spring.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<Void> signUp(@RequestBody @Valid MemberSignUpRequest request) {
        memberService.signUp(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/signin")
    public ResponseEntity<Void> signIn(@RequestBody @Valid MemberSignInRequest request) {
        memberService.signIn(request);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}