package ssm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ssm.pojo.Proposer;
import ssm.service.ProposerService;

@RestController("ProposerController")
public class ProposerController {

    @Autowired
    @Qualifier("proposerService")
    private ProposerService proposerService;

    //上传材料与身份录入
    @RequestMapping(value = "/proposer/upload", method = RequestMethod.POST)
    public String uploadInfo(Proposer proposer) {
        proposerService.upload(proposer);
        return "uploadSuccess";
    }

    //验证 验证成功则通过审核
    @RequestMapping(value = "/proposer/check", method = RequestMethod.GET)
    public String checkIdentity(Proposer proposer) {
        boolean check = proposerService.checkProposer(proposer);
        if (check) {
            return "checkSuccess";
        }
        return "checkFalse";
    }
    //查询筹资
    @RequestMapping(value = "/proposer/fund", method = RequestMethod.GET)
    public String selectFund(Proposer proposer, Model model){
        int raisedFund = proposerService.getFund(proposer);
        model.addAttribute("raisedFund",raisedFund);
        return "fundInfo";
    }
}

