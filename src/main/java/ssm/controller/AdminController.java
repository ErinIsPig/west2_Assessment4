package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ssm.pojo.Project;
import ssm.service.AdminService;

@RestController("AdminController")
public class AdminController {
    @Autowired
    @Qualifier("adminService")
    private AdminService adminService;

    //审核项目
    @RequestMapping(value = "/admin/checkProject",method = RequestMethod.DELETE)
    public String checkProject(Project project){
        boolean check = adminService.checkProject(project);
        if (!check){//审核成功 返回到项目页面 审核失败 则删除项目 再返回到项目页面
            adminService.removeProject(project);
        }

        return "projects";
    };
}
