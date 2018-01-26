package zstu.sjq.dao;

import zstu.sjq.bean.BsOrderItem;
import zstu.sjq.bean.BsOrderItemExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BsOrderItemMapper {
    int countByExample(BsOrderItemExample example);

    int deleteByExample(BsOrderItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsOrderItem record);

    int insertSelective(BsOrderItem record);

    List<BsOrderItem> selectByExample(BsOrderItemExample example);

    BsOrderItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsOrderItem record, @Param("example") BsOrderItemExample example);

    int updateByExample(@Param("record") BsOrderItem record, @Param("example") BsOrderItemExample example);

    int updateByPrimaryKeySelective(BsOrderItem record);

    int updateByPrimaryKey(BsOrderItem record);
}