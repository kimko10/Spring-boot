package com.carrotglobal.restsample.controller;

import java.util.List;

import com.carrotglobal.restsample.service.RestSampleService;
import com.carrotglobal.restsample.vo.InfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * restSample
 */
@RestController
@RequestMapping("/rest")
public class RestSampleController {

    @Autowired
    RestSampleService restsampleservice;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/post", method = { RequestMethod.GET, RequestMethod.POST })
    public void sendPostTest() throws Exception {

        restsampleservice.sendPostTest();

    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public void sendGetTest() throws Exception {

        restsampleservice.sendGetTest();

    }

    @RequestMapping(value = "/{idx}", method = RequestMethod.GET)
    public void selectIdx(@PathVariable("idx") int idx) {

        InfoVO infoVo = null;
        System.out.println("HJLOG idx : " + idx);
        try {
            infoVo = restsampleservice.selectIdx(idx);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("selectIdx : " + infoVo);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public void getAll() {
        List<InfoVO> infoList;
        try {
            infoList = restsampleservice.getAll();
            if (infoList != null) {
                for (InfoVO info : infoList) {

                    System.out.println("HJLOG  : " + info.toString());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @RequestMapping(value = "/{info}", method = RequestMethod.POST)
    public void insertIdx(@PathVariable("info") String info) {

        try {
            System.out.println("HJLOG insert : " + restsampleservice.insertIdx(info));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/{idx}", method = RequestMethod.DELETE)
    public void deleteIdx(@PathVariable("idx") int idx) {

        try {
            System.out.println("HJLOG delete : " + restsampleservice.deleteIdx(idx));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/{idx}", method = RequestMethod.PUT)
    public void updateIdx(@RequestBody InfoVO vo) {
        System.out.println("HJLOG update : " + vo.toString());
        try {
            System.out.println("HJLOG update : " + restsampleservice.updateIdx(vo));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}