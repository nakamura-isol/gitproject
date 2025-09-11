package javadrill.exercise019.question029;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsertUserDataMapper {

	String selectUserId(String userId);

	int insertUserData(User user);

}
