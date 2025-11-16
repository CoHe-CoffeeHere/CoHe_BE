package coffeehere.cohe.domain.util.password;

public interface PasswordValidator {
	
	boolean matches(String inputPassword, String storePassword);
}
