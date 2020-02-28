package com.carrotglobal.restsample.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.carrotglobal.restsample.dto.InfoDTO;
import com.carrotglobal.restsample.vo.InfoVO;

@Mapper
public interface RestSampleMapper {

    @Select("SELECT idx, info FROM info WHERE idx = #{idx}")
    public InfoVO selectIdx(@Param("idx") int idx);

    public List<InfoVO> getAll();
    
    public void insertIdx(@Param("dto") InfoDTO dto) throws Exception;

    public void updateIdx(@Param("dto") InfoDTO dto);

    public void deleteIdx(@Param("idx") int idx);

}