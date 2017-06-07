package org.wechatapplet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wechatapplet.model.Module;
import org.wechatapplet.model.ModuleExample;

public interface ModuleDao {
    long countByExample(ModuleExample example);

    int deleteByExample(ModuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Module record);

    int insertSelective(Module record);

    List<Module> selectByExampleWithBLOBs(ModuleExample example);

    List<Module> selectByExample(ModuleExample example);

    Module selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExampleWithBLOBs(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByExample(@Param("record") Module record, @Param("example") ModuleExample example);

    int updateByPrimaryKeySelective(Module record);

    int updateByPrimaryKeyWithBLOBs(Module record);

    int updateByPrimaryKey(Module record);

    List<Module> selectByUserId(@Param("userId") Long userId);

    List<Module> selectByCateId(@Param("cateId") Long cateId);
}