package ssm.pojo;

public class Project {
    private int projectId;
    private String projectName;//项目名称
    private int requiredFund;//项目需要筹集的资金

    public Project() {
    }

    public Project(int projectId, String projectName, int requiredFund) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.requiredFund = requiredFund;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public int getRequiredFund() {
        return requiredFund;
    }

    public void setRequiredFund(int requiredFund) {
        this.requiredFund = requiredFund;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", requiredFund=" + requiredFund +
                '}';
    }
}
