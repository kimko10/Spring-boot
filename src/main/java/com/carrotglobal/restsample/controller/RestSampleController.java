package com.carrotglobal.restsample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carrotglobal.restsample.dto.InfoDTO;
import com.carrotglobal.restsample.service.RestSampleService;
import com.carrotglobal.restsample.vo.InfoVO;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;


/**
 * REST SAMPLE PAGE
 * 
 * 
 */
@RestController 
@RequestMapping("/rest")
@Slf4j
public class RestSampleController {

    @Autowired
    RestSampleService restsampleservice;

    @GetMapping(value = "/data/{idx}")
    @ApiOperation(value="테이블 값 가져오기")
    public InfoVO selectIdx(@PathVariable("idx") int idx) throws Exception {

        InfoVO infoVo = null;
        infoVo = restsampleservice.selectIdx(idx);
        log.info("selectIdx : " + infoVo);
       
        return infoVo;
    }

    @GetMapping(value = "/data/")
    @ApiOperation(value="테이블 전체값 가져오기")
    public List<InfoVO> getAll() throws Exception  {
    	
        List<InfoVO> infoList = null;
        infoList = restsampleservice.getAll();
        if (infoList != null) {
            for (InfoVO info : infoList) {

                log.info(" : " + info.toString());

            }
        }
		return infoList;

    }

    @PostMapping(value = "/data/{idx}")
    @ApiOperation(value="테이블 값 추가")
    public void insertIdx(@PathVariable("idx") int idx, @RequestBody InfoDTO dto) throws Exception {

    	dto.setIdx(idx);
        restsampleservice.insertIdx(dto);
        
    }

    @DeleteMapping(value="/data/{idx}")
    @ApiOperation(value="테이블 값 삭제")
    public void deleteIdx(@PathVariable("idx") int idx) throws Exception {

        restsampleservice.deleteIdx(idx);
    	log.debug("deleteIdx : " + idx);
    	
    }

    @PutMapping(value="/data/{idx}")
    @ApiOperation(value="테이블 값 수정")
    public void updateIdx(@PathVariable("idx") int idx, @RequestBody InfoDTO dto) throws Exception {
    	
    	dto.setIdx(idx);
        log.info("update : " + dto.toString());
        restsampleservice.updateIdx(dto);
    	log.debug("updateIdx " + idx);
    	
    }

   
}