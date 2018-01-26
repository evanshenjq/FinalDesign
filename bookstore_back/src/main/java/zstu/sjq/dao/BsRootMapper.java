package zstu.sjq.dao;

import zstu.sjq.bean.BsRoot;
import zstu.sjq.bean.BsRootExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BsRootMapper {
    int countByExample(BsRootExample example);

    int deleteByExample(BsRootExample example);

    int deleteByPrimaryKey(Long rId);

    int insert(BsRoot record);

    int insertSelective(BsRoot record);

    List<BsRoot> selectByExample(BsRootExample example);

    BsRoot selectByPrimaryKey(Long rId);

    int updateByExampleSelective(@Param("record") BsRoot record, @Param("example") BsRootExample example);

    int updateByExample(@Param("record") BsRoot record, @Param("example") BsRootExample example);

    int updateByPrimaryKeySelective(BsRoot record);

    int updateByPrimaryKey(BsRoot record);
}