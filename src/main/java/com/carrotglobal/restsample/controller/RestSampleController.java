package com.carrotglobal.restsample.controller;

import java.util.List;

import com.carrotglobal.restsample.dto.InfoDTO;
import com.carrotglobal.restsample.service.RestSampleService;
import com.carrotglobal.restsample.vo.InfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


/**
 * restSample
 */
@RestController 
@RequestMapping("/rest")
@Slf4j
public class RestSampleController {

    @Autowired
    RestSampleService restsampleservice;

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/post", method = { RequestMethod.GET, RequestMethod.POST })
    public void sendPostTest() throws Exception {
    	
        restsampleservice.sendPostTest();

    }

    @GetMapping(value = "/get")
    public void sendGetTest() throws Exception {

        restsampleservice.sendGetTest();

    }

    @GetMapping(value = "/{idx}")
    public void selectIdx(@PathVariable("idx") int idx) {

        InfoVO infoVo = null;
        log.info("idx : " + idx);
        try {
            infoVo = restsampleservice.selectIdx(idx);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("selectIdx() ERROR");
        }
        log.info("selectIdx : " + infoVo);
    }

    @GetMapping(value = "/")
    public void getAll() {
        List<InfoVO> infoList;
        try {
            infoList = restsampleservice.getAll();
            if (infoList != null) {
                for (InfoVO info : infoList) {

                    log.info(" : " + info.toString());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @PostMapping(value = "/{idx}")
    public void insertIdx(@PathVariable("idx") int idx, @RequestBody InfoDTO dto) {

        try {
        	dto.setIdx(idx);
            restsampleservice.insertIdx(dto);
        } catch (Exception e) {
        	log.debug("insertIdx : " + dto);
            e.printStackTrace();
        }
    }

    @DeleteMapping(value="/{idx}")
    public void deleteIdx(@PathVariable("idx") int idx) {

        try {
            restsampleservice.deleteIdx(idx);
        } catch (Exception e) {
        	log.debug("deleteIdx : " + idx);
            e.printStackTrace();
        }
    }

    @PutMapping(value="/{idx}")
    public void updateIdx(@PathVariable("idx") int idx, @RequestBody InfoDTO dto) {
    	dto.setIdx(idx);
        log.info("update : " + dto.toString());
        try {
            restsampleservice.updateIdx(dto);
        } catch (Exception e) {
        	log.debug("updateIdx " + idx);
            e.printStackTrace();
        }
    }

   
}