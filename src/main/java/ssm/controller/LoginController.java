package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ssm.service.UserService;

//管理登录页面

@RestController("LoginController")
public class LoginController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;



    @RequestMapping(value = "/login/test",method = RequestMethod.GET)
    public String loginTest(@RequestParam String userId, @RequestParam String password){
        //账号存在且密码正确 登录成功 否则登陆失败
        boolean judge = userService.judgePassword(userId,password);
        if(userService.existUser(userId) && judge){
            return "success";//跳转到登录成功页面 及平台页面
        }
        return "failure";//跳转到登录失败页面
    }
}
