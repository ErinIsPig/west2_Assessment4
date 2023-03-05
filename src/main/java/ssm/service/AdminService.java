package ssm.service;

import ssm.pojo.Project;

public interface AdminService {
    boolean checkProject(Project project);

    void removeProject(Project project);
}
