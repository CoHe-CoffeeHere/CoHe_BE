package coffeehere.cohe.domain.member.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class AuthResponse {
	
	private final String memberId;
	private final String memberName;
	private final String message;
	
	public static AuthResponse of(String memberId, String memberName, String messsage) {
		return new AuthResponse(memberId, memberName, messsage);
	}
}
