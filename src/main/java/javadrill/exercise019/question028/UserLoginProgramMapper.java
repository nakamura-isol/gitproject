package javadrill.exercise019.question028;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserLoginProgramMapper {
	User selectUserData(@Param("userId") String userId, @Param("userPassword") String userPassword);

}
