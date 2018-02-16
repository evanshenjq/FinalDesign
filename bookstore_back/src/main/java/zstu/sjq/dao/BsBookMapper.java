package zstu.sjq.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import zstu.sjq.bean.BsBook;
import zstu.sjq.bean.BsBookExample;
@Mapper
public interface BsBookMapper {
    int countByExample(BsBookExample example);

    int deleteByExample(BsBookExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsBook record);

    int insertSelective(BsBook record);

    List<BsBook> selectByExample(BsBookExample example);

    BsBook selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsBook record, @Param("example") BsBookExample example);

    int updateByExample(@Param("record") BsBook record, @Param("example") BsBookExample example);

    int updateByPrimaryKeySelective(BsBook record);

    int updateByPrimaryKey(BsBook record);
}