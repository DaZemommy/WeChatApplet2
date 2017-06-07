package org.wechatapplet.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.wechatapplet.model.Detail;
import org.wechatapplet.model.DetailExample;

public interface DetailDao {
    int countByExample(DetailExample example);

    int deleteByExample(DetailExample example);

    int deleteByPrimaryKey(Integer did);

    int insert(Detail record);

    int insertSelective(Detail record);

    List<Detail> selectByExampleWithBLOBs(DetailExample example);

    List<Detail> selectByExample(DetailExample example);

    Detail selectByPrimaryKey(Integer did);

    int updateByExampleSelective(@Param("record") Detail record, @Param("example") DetailExample example);

    int updateByExampleWithBLOBs(@Param("record") Detail record, @Param("example") DetailExample example);

    int updateByExample(@Param("record") Detail record, @Param("example") DetailExample example);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKeyWithBLOBs(Detail record);

    int updateByPrimaryKey(Detail record);
}