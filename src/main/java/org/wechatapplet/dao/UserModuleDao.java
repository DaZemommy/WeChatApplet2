package org.wechatapplet.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.wechatapplet.model.UserModule;
import org.wechatapplet.model.UserModuleExample;

public interface UserModuleDao {
    long countByExample(UserModuleExample example);

    int deleteByExample(UserModuleExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserModule record);

    int insertSelective(UserModule record);

    List<UserModule> selectByExampleWithBLOBs(UserModuleExample example);

    List<UserModule> selectByExample(UserModuleExample example);

    UserModule selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserModule record, @Param("example") UserModuleExample example);

    int updateByExampleWithBLOBs(@Param("record") UserModule record, @Param("example") UserModuleExample example);

    int updateByExample(@Param("record") UserModule record, @Param("example") UserModuleExample example);

    int updateByPrimaryKeySelective(UserModule record);

    int updateByPrimaryKeyWithBLOBs(UserModule record);

    int updateByPrimaryKey(UserModule record);
    
    UserModule selectById(@Param("id") Long id);
}