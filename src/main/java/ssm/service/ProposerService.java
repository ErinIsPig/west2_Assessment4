package ssm.service;

import ssm.pojo.Project;
import ssm.pojo.Proposer;

import java.util.List;

public interface ProposerService {
    void upload(Proposer proposer);

    boolean checkProposer(Proposer proposer);

    void updateFund(Proposer proposer, int fund);

    int getFund(Proposer proposer);

    List<Integer> getAllProjectId();

    void dropProject(Project project);
}
