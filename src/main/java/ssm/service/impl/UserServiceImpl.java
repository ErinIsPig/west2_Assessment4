package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.mapper.UserMapper;
import ssm.pojo.User;
import ssm.service.UserService;

import java.util.List;
@Transactional
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public boolean existUser(String userId) {
        List<String> userIds = userMapper.getAllUserId();
        for (String id:userIds){
            if (userId.equals(id)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean judgePassword(String userId, String password) {
        String localPassword = userMapper.getPasswordById(userId);
        if (password.equals(localPassword)){
            return true;
        }
        return false;
    }

    @Override
    public void saveUser(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public int getUserBalance(User user) {
        return userMapper.getBalance(user);
    }

    @Override
    public void saveBalanceInfo(User user, int fund) {
        int balance = user.getBalance() - fund;
        userMapper.updateBalance(fund,user);
        user.setBalance(balance);
    }
}
