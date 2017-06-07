package org.wechatapplet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wechatapplet.model.ModuleCate;
import org.wechatapplet.model.ModuleCateExample;

public interface ModuleCateDao {
    long countByExample(ModuleCateExample example);

    int deleteByExample(ModuleCateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ModuleCate record);

    int insertSelective(ModuleCate record);

    List<ModuleCate> selectByExample(ModuleCateExample example);

    ModuleCate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ModuleCate record, @Param("example") ModuleCateExample example);

    int updateByExample(@Param("record") ModuleCate record, @Param("example") ModuleCateExample example);

    int updateByPrimaryKeySelective(ModuleCate record);

    int updateByPrimaryKey(ModuleCate record);
}