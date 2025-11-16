package coffeehere.cohe.domain.member.service;

import coffeehere.cohe.domain.member.dto.request.LoginRequest;
import coffeehere.cohe.domain.member.dto.request.SignUpRequest;
import coffeehere.cohe.domain.member.dto.response.AuthResponse;

public interface MemberService {
	
	AuthResponse signUp(SignUpRequest request);
	
	AuthResponse login(LoginRequest request);
}
