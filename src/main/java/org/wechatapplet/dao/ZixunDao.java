package org.wechatapplet.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wechatapplet.model.Zixun;
import org.wechatapplet.model.ZixunExample;

public interface ZixunDao {
    int countByExample(ZixunExample example);

    int deleteByExample(ZixunExample example);

    int deleteByPrimaryKey(Integer zid);

    int insert(Zixun record);

    int insertSelective(Zixun record);

    List<Zixun> selectByExample(ZixunExample example);

    Zixun selectByPrimaryKey(Integer zid);

    int updateByExampleSelective(@Param("record") Zixun record, @Param("example") ZixunExample example);

    int updateByExample(@Param("record") Zixun record, @Param("example") ZixunExample example);

    int updateByPrimaryKeySelective(Zixun record);

    int updateByPrimaryKey(Zixun record);
}