package zstu.sjq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zstu.sjq.bean.BsUserCart;
import zstu.sjq.bean.BsUserCartExample;

public interface BsUserCartMapper {
    int countByExample(BsUserCartExample example);

    int deleteByExample(BsUserCartExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsUserCart record);

    int insertSelective(BsUserCart record);

    List<BsUserCart> selectByExample(BsUserCartExample example);

    BsUserCart selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsUserCart record, @Param("example") BsUserCartExample example);

    int updateByExample(@Param("record") BsUserCart record, @Param("example") BsUserCartExample example);

    int updateByPrimaryKeySelective(BsUserCart record);

    int updateByPrimaryKey(BsUserCart record);
}