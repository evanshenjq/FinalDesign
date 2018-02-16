package zstu.sjq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zstu.sjq.bean.BsBookNew;
import zstu.sjq.bean.BsBookNewExample;

public interface BsBookNewMapper {
    int countByExample(BsBookNewExample example);

    int deleteByExample(BsBookNewExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsBookNew record);

    int insertSelective(BsBookNew record);

    List<BsBookNew> selectByExample(BsBookNewExample example);

    BsBookNew selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsBookNew record, @Param("example") BsBookNewExample example);

    int updateByExample(@Param("record") BsBookNew record, @Param("example") BsBookNewExample example);

    int updateByPrimaryKeySelective(BsBookNew record);

    int updateByPrimaryKey(BsBookNew record);
}