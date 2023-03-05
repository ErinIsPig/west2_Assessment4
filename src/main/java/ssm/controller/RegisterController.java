package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ssm.pojo.User;
import ssm.service.UserService;
import ssm.utils.UuidUtil;

import java.util.HashMap;
import java.util.Map;

//管理注册页面
@RestController("RegisterController")
public class RegisterController {

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)//注册页面对账户进行注册
    public String register(@RequestBody User user, Model model) {
        String s = UuidUtil.generateShortUuid();//随机获取uuid账号
        user.setUserId(s);
        userService.saveUser(user);
        Map<String,String> map = new HashMap<>();
        map.put(user.getUserId(),user.getPassword());
        model.addAttribute("map",map);
        return "registerSuccess";//跳转到注册成功页面
    }
}
