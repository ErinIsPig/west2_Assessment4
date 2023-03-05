
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ssm.mapper.UserMapper;
import java.util.List;

public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testUser(){
        List<String> userIds = userMapper.getAllUserId();
        for (String userId:userIds){
            System.out.println(userId);
        }


    }
}
