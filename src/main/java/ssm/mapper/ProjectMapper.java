package ssm.mapper;


import org.apache.ibatis.annotations.Param;
import ssm.pojo.Project;

import java.util.List;

public interface ProjectMapper {
    List<Project> searchProject(@Param("portion") String portion);

    List<Project> getAllProject();

    Project searchProjectByName(@Param("projectName") String projectName);

    Project getProjectById(@Param("projectId") int projectId);

    void updateRequiredFund(Project project, @Param("requiredFund") int requiredFund);

    void deleteProject(Project project);
}
