package coffeehere.cohe.domain.member.service;

import coffeehere.cohe.domain.member.dto.request.LoginRequest;
import coffeehere.cohe.domain.member.dto.request.SignUpRequest;
import coffeehere.cohe.domain.member.dto.response.AuthResponse;
import coffeehere.cohe.domain.member.entity.Member;
import coffeehere.cohe.domain.member.repository.MemberRepository;
import coffeehere.cohe.domain.util.exception.DuplicateMemberException;
import coffeehere.cohe.domain.util.exception.InvalidCredentialsException;
import coffeehere.cohe.domain.util.password.PasswordValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;
	private final PasswordValidator passwordValidator;
	
	@Override
	@Transactional
	public AuthResponse signUp(SignUpRequest request) {
		// 회원 중복 체크
		if (memberRepository.existsByMemberId(request.getMemberId())) {
			throw new DuplicateMemberException("이미 존재하는 아이디입니다.");
		}
		
		// 회원 생성 및 저장
		Member member = Member.builder()
			.memberId(request.getMemberId())
			.password(request.getPassword())
			.memberName(request.getMemberName())
			.build();
		
		memberRepository.save(member);
		
		return AuthResponse.of(member.getMemberId(), member.getMemberName(), "회원가입이 완료되었습니다.");
	}
	
	@Override
	@Transactional(readOnly = true)
	public AuthResponse login(LoginRequest request) {
		// 회원 조회
		Member member = memberRepository.findByMemberId(request.getMemberId())
			.orElseThrow(() -> new InvalidCredentialsException("아이디 또는 비밀번호가 일치하지 않습니다."));
		
		// 비밀번호 검증
		if (!passwordValidator.matches(request.getPassword(), member.getPassword())) {
			throw new InvalidCredentialsException("아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		
		return AuthResponse.of(member.getMemberId(), member.getMemberName(), "로그인에 성공했습니다.");
	}
}
