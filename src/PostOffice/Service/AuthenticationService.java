package PostOffice.Service;

import PostOffice.Entity.User;
import PostOffice.Repository.UserRepository;

public class AuthenticationService {

	private UserRepository userRepository = null;

	public User authenticate(String username, String password) throws Exception {

		User user = getRepository().findByUsernameAndPassword(username, password);

		if (user == null) {
			throw new Exception("User not found !!!");
		}

		return user;
	}

	protected UserRepository getRepository() {
		if (userRepository == null) {
			userRepository = new UserRepository();
		}
		return userRepository;
	}
}
