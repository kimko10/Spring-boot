package com.carrotglobal.restsample.service;

import com.carrotglobal.restsample.dto.InfoDTO;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface RestSampleMapper {

    @Select("SELECT count(*) FROM info WHERE idx = #{idx}")
    public int selectIdx(@Param("idx") int idx);

}