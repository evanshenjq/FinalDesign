package zstu.sjq.dao;

import zstu.sjq.bean.BsBookCat;
import zstu.sjq.bean.BsBookCatExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BsBookCatMapper {
    int countByExample(BsBookCatExample example);

    int deleteByExample(BsBookCatExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsBookCat record);

    int insertSelective(BsBookCat record);

    List<BsBookCat> selectByExample(BsBookCatExample example);

    BsBookCat selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsBookCat record, @Param("example") BsBookCatExample example);

    int updateByExample(@Param("record") BsBookCat record, @Param("example") BsBookCatExample example);

    int updateByPrimaryKeySelective(BsBookCat record);

    int updateByPrimaryKey(BsBookCat record);
}