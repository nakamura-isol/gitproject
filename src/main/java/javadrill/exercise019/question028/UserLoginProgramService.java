package javadrill.exercise019.question028;



import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;
// logが出力される
@Slf4j
@Service
public class UserLoginProgramService {
	private final UserLoginProgramMapper userLoginProgramMapper;

	UserLoginProgramService(UserLoginProgramMapper userLoginProgramMapper) {
		this.userLoginProgramMapper = userLoginProgramMapper;
	}

	public User getUserData(String userId, String userPassword) {
		return userLoginProgramMapper.selectUserData(userId, userPassword);
	}

	/**
	 * ログインを受け付ける
	 */
	@Transactional
	void takeLogin(String userId, String userPassword) throws InvalidCredentialsException {
		User userData = getUserData(userId, userPassword);
		if (userData == null) {
			  // パスワードはログに出さない
            log.warn("Invalid credentials: userId={}", userId);
			throw new InvalidCredentialsException("ユーザーIDまたはパスワードが不正です。");
		}
		if (userData.getUserId().equals(userId) && userData.getUserPassword().equals(userPassword)) {
			System.out.println("ログインを受け付けます。");
		}
	}
}
