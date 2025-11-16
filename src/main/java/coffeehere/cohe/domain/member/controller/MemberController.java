package coffeehere.cohe.domain.member.controller;

import coffeehere.cohe.domain.member.dto.request.LoginRequest;
import coffeehere.cohe.domain.member.dto.request.SignUpRequest;
import coffeehere.cohe.domain.member.dto.response.AuthResponse;
import coffeehere.cohe.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberController {
	
	private final MemberService memberService;
	
	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> signUp(@Valid @RequestBody SignUpRequest request) {
		AuthResponse response = memberService.signUp(request);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@PostMapping("/login")
	public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
		AuthResponse response = memberService.login(request);
		
		return ResponseEntity.ok(response);
	}
}
