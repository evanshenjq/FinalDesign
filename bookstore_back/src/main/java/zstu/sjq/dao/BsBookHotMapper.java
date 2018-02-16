package zstu.sjq.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import zstu.sjq.bean.BsBookHot;
import zstu.sjq.bean.BsBookHotExample;

public interface BsBookHotMapper {
    int countByExample(BsBookHotExample example);

    int deleteByExample(BsBookHotExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsBookHot record);

    int insertSelective(BsBookHot record);

    List<BsBookHot> selectByExample(BsBookHotExample example);

    BsBookHot selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsBookHot record, @Param("example") BsBookHotExample example);

    int updateByExample(@Param("record") BsBookHot record, @Param("example") BsBookHotExample example);

    int updateByPrimaryKeySelective(BsBookHot record);

    int updateByPrimaryKey(BsBookHot record);
}