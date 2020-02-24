package com.carrotglobal.restsample.service;

import java.util.List;

import com.carrotglobal.restsample.vo.InfoVO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RestSampleMapper {

    @Select("SELECT idx, info FROM info WHERE idx = #{idx}")
    public InfoVO selectIdx(@Param("idx") int idx);

    public List<InfoVO> getAll();
    
    public int insertIdx(@Param("info") String info);

    public int updateIdx(@Param("vo") InfoVO vo);

    public int deleteIdx(@Param("idx") int idx);

}