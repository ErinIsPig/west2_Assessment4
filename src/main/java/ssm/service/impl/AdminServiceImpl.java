package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.pojo.Project;
import ssm.service.AdminService;
import ssm.service.ProposerService;

import java.util.List;
@Transactional
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    @Qualifier("proposerService")
    private ProposerService proposerService;
    @Override
    public boolean checkProject(Project project) {
        //审核项目判断是否有众筹者
        List<Integer> projectIds = proposerService.getAllProjectId();
        int projectId = project.getProjectId();
        for (Integer id:projectIds){
            if(projectId == id){
                return true;
            }
        }
        return false;
    }

    @Override
    public void removeProject(Project project) {
        proposerService.dropProject(project);
    }
}
