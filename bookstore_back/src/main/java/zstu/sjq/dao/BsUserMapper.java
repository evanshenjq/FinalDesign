package zstu.sjq.dao;

import zstu.sjq.bean.BsUser;
import zstu.sjq.bean.BsUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BsUserMapper {
    int countByExample(BsUserExample example);

    int deleteByExample(BsUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BsUser record);

    int insertSelective(BsUser record);

    List<BsUser> selectByExample(BsUserExample example);

    BsUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") BsUser record, @Param("example") BsUserExample example);

    int updateByExample(@Param("record") BsUser record, @Param("example") BsUserExample example);

    int updateByPrimaryKeySelective(BsUser record);

    int updateByPrimaryKey(BsUser record);
}