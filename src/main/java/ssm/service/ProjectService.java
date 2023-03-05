package ssm.service;

import com.github.pagehelper.PageInfo;
import ssm.pojo.Project;

import java.util.List;

public interface ProjectService {
    List<Project> getProject(String portion);

    PageInfo<Project> getProjectList(Integer pageNum);

    Project getProjectByName(String projectName);
}
