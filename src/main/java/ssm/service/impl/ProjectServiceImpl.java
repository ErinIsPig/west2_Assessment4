package ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.mapper.ProjectMapper;
import ssm.pojo.Project;
import ssm.service.ProjectService;

import java.util.List;
@Transactional
@Service("projectService")
public class ProjectServiceImpl implements ProjectService {


    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Project> getProject(String portion) {
        return projectMapper.searchProject(portion);
    }

    @Override
    public PageInfo<Project> getProjectList(Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<Project> list = projectMapper.getAllProject();
        PageInfo<Project> page = new PageInfo<>(list, 5);
        return page;
    }

    @Override
    public Project getProjectByName(String projectName) {
        return projectMapper.searchProjectByName(projectName);
    }
}
