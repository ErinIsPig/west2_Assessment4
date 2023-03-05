package ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ssm.mapper.ProjectMapper;
import ssm.mapper.ProposerMapper;
import ssm.pojo.Project;
import ssm.pojo.Proposer;
import ssm.service.ProposerService;

import java.util.List;
@Transactional
@Service("proposerService")
public class ProposerServiceImpl implements ProposerService {

    @Autowired
    private ProposerMapper proposerMapper;

    @Autowired
    private ProjectMapper projectMapper;
    @Override
    public void upload(Proposer proposer) {
        proposerMapper.insertInfo(proposer);
    }

    @Override//先判断proposer是否存在，如果不存在，验证失败 再判断proposerId与projectId是否相一致 相一致则验证成功
    public boolean checkProposer(Proposer proposer) {
        int projectId = proposer.getProjectId();
        List<Proposer> proposers = proposerMapper.getAllProposer();
        for (Proposer proposer1 : proposers){
            if((proposer.getProposerId() == proposer1.getProposerId()) && (proposer.getProjectId() == proposer1.getProjectId())){
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateFund(Proposer proposer, int fund) {
        int raisedFund = proposer.getRaisedFund();
        raisedFund = raisedFund + fund;
        //众筹者的酬金增加 项目所需要的资金减少
        proposerMapper.putFund(proposer,raisedFund);
        proposer.setRaisedFund(raisedFund);
        Project project = projectMapper.getProjectById(proposer.getProjectId());
        int requiredFund = project.getRequiredFund();
        if(requiredFund - fund > 0) {
            requiredFund = requiredFund - fund;
        }else{
            requiredFund = 0;
        }
        projectMapper.updateRequiredFund(project,requiredFund);
        project.setRequiredFund(requiredFund);
    }

    @Override
    public int getFund(Proposer proposer) {
        return proposerMapper.getFund(proposer);
    }

    @Override
    public List<Integer> getAllProjectId() {
        return proposerMapper.getAllProjectId();
    }

    @Override
    public void dropProject(Project project) {
        projectMapper.deleteProject(project);
    }
}
