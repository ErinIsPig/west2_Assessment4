package ssm.controller;


import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ssm.pojo.Project;
import ssm.pojo.Proposer;
import ssm.pojo.User;
import ssm.service.ProjectService;
import ssm.service.ProposerService;
import ssm.service.UserService;

//管理一般用户界面
@RestController("UserController")
public class UserController {
    @Autowired
    @Qualifier("projectService")
    private ProjectService projectService;

    @Autowired
    @Qualifier("userService")
    private UserService userService;

    @Autowired
    @Qualifier("proposerService")
    private ProposerService proposerService;

    //分页
    @RequestMapping(value = "/project/page/{pageNum}", method = RequestMethod.GET)
    public String getProjectList(Model model, @PathVariable("pageNum") Integer pageNum){
        PageInfo<Project> page = projectService.getProjectList(pageNum);
        model.addAttribute("page",page);
        return "allProject";//项目分页界面
    }
    //查看某项目
    @RequestMapping(value = "/project/{projectName}",method = RequestMethod.GET)
    public String getProject(Model model,@PathVariable("projectName") String projectName){
        Project project = projectService.getProjectByName(projectName);
        model.addAttribute("model",model);
        return "project";
    }

    //根据请求参数的user属性出资 修改数据信息
    @RequestMapping(value = "/user/{fund}",method = RequestMethod.PUT)
    public String investFund(@PathVariable("fund") int fund, User user, Proposer proposer){
        int balance = userService.getUserBalance(user);
        if(balance - fund < 0){
            return "investFailure";//余额不够，报错
        }
        userService.saveBalanceInfo(user,fund);
        proposerService.updateFund(proposer,fund);
        return "investSuccess";
    }

}
