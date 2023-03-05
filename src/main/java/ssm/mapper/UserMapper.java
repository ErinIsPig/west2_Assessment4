package ssm.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ssm.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {
    List<String> getAllUserId();

    String getPasswordById(@Param("userId") String userId);

    void insertUser(User user);

    int getBalance(User user);

    void updateBalance(@Param("balance") int balance,User user);
}
