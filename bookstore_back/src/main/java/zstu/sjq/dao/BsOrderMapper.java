package zstu.sjq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zstu.sjq.bean.BsOrder;
import zstu.sjq.bean.BsOrderExample;

public interface BsOrderMapper {
    int countByExample(BsOrderExample example);

    int deleteByExample(BsOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsOrder record);

    int insertSelective(BsOrder record);

    List<BsOrder> selectByExample(BsOrderExample example);

    BsOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsOrder record, @Param("example") BsOrderExample example);

    int updateByExample(@Param("record") BsOrder record, @Param("example") BsOrderExample example);

    int updateByPrimaryKeySelective(BsOrder record);

    int updateByPrimaryKey(BsOrder record);
}