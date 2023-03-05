package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ssm.pojo.Project;
import ssm.service.ProjectService;

import java.util.List;
//管理平台页面
@RestController("PlatformController")
@RequestMapping("/platform")
public class PlatformController {
    @Autowired
    @Qualifier("projectService")
    private ProjectService projectService;
    @RequestMapping(value = "/searchProject",method = RequestMethod.GET)//通过字符串片断查询项目信息
    public String searchProject(@RequestParam String portion, Model model){
        List<Project> projects = projectService.getProject(portion);
        model.addAttribute("projects",projects);//将查询到的项目数据回显
        return "projects";
    }


}
