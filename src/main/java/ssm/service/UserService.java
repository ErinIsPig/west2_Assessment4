package ssm.service;

import ssm.pojo.User;

public interface UserService {
    boolean existUser(String userId);

    boolean judgePassword(String userId, String password);

    void saveUser(User user);

    int getUserBalance(User user);

    void saveBalanceInfo(User user, int fund);
}
