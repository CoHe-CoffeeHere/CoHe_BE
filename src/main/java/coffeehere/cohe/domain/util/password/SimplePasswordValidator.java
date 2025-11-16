package coffeehere.cohe.domain.util.password;

import org.springframework.stereotype.Component;

@Component
public class SimplePasswordValidator implements PasswordValidator {
	
	@Override
	public boolean matches(String inputPassword, String storePassword) {
		return inputPassword.equals(storePassword);
	}
}
