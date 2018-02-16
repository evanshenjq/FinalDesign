package zstu.sjq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zstu.sjq.bean.BsUserCartItem;
import zstu.sjq.bean.BsUserCartItemExample;

public interface BsUserCartItemMapper {
    int countByExample(BsUserCartItemExample example);

    int deleteByExample(BsUserCartItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsUserCartItem record);

    int insertSelective(BsUserCartItem record);

    List<BsUserCartItem> selectByExample(BsUserCartItemExample example);

    BsUserCartItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsUserCartItem record, @Param("example") BsUserCartItemExample example);

    int updateByExample(@Param("record") BsUserCartItem record, @Param("example") BsUserCartItemExample example);

    int updateByPrimaryKeySelective(BsUserCartItem record);

    int updateByPrimaryKey(BsUserCartItem record);
}