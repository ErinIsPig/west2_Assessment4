package ssm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import ssm.pojo.Proposer;

import java.util.List;
@Mapper
public interface ProposerMapper {
    void insertInfo(@Param("proposer") Proposer proposer);

    List<Proposer> getAllProposer();

    void putFund(@Param("proposer") Proposer proposer, @Param("raisedFund") int raisedFund);

    int getFund(@Param("proposer") Proposer proposer);

    List<Integer> getAllProjectId();

}
