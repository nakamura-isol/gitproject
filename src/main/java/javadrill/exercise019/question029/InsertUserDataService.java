package javadrill.exercise019.question029;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InsertUserDataService {

	private final InsertUserDataMapper insertUserDataMapper;

	public InsertUserDataService(InsertUserDataMapper insertUserDataMapper) {
		this.insertUserDataMapper = insertUserDataMapper;
	}

	public String getUserId(String userId) {
		return insertUserDataMapper.selectUserId(userId);

	}

	/**
	 * ユーザデータ登録メソッド
	 * 
	 */
	@Transactional
	public void registerUserData(User user) {
		checkUserData(user);
		try {
			insertUserData(user);
			System.out.println("登録が完了しました。");
		} catch (DuplicateKeyException e) {
			throw new DataIntegrityViolationException("そのユーザーIDは既に使われています。", e);
		}

	}

	/**
	 * 入力値チェックメソッド
	 * 
	 */
	private void checkUserData(User user) {
		String duplicationUserId = getUserId(user.getUserId());
		if (duplicationUserId != null) {
			throw new DataIntegrityViolationException("そのユーザIDは既に使われています。");
		}
	}

	/**
	 * ユーザデータDB登録メソッド
	 * @param user
	 */
	private void insertUserData(User user) {
		int affectedRows = insertUserDataMapper.insertUserData(user);
		if (affectedRows == 0) {
			throw new IllegalStateException("更新に失敗しました。");
		}

	}
}
