package org.wechatapplet.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wechatapplet.model.Renzheng;
import org.wechatapplet.model.RenzhengExample;

public interface RenzhengDao {
    int countByExample(RenzhengExample example);

    int deleteByExample(RenzhengExample example);

    int deleteByPrimaryKey(Integer rid);

    int insert(Renzheng record);

    int insertSelective(Renzheng record);

    List<Renzheng> selectByExample(RenzhengExample example);

    Renzheng selectByPrimaryKey(Integer rid);

    int updateByExampleSelective(@Param("record") Renzheng record, @Param("example") RenzhengExample example);

    int updateByExample(@Param("record") Renzheng record, @Param("example") RenzhengExample example);

    int updateByPrimaryKeySelective(Renzheng record);

    int updateByPrimaryKey(Renzheng record);
}