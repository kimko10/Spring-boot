package com.carrotglobal.restsample.controller;

import com.carrotglobal.restsample.dto.InfoDTO;
import com.carrotglobal.restsample.service.RestSampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * restSample
 */
@RestController
@RequestMapping("/rest")
public class RestSampleController {

    @Autowired
    RestSampleService restsampleservice;

    @RequestMapping(value="/test", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

    @RequestMapping(value="/post", method = {RequestMethod.GET, RequestMethod.POST})
	public void sendPostTest() throws Exception {
		
		restsampleservice.sendPostTest();

    }
    
	@RequestMapping(value="/get", method = RequestMethod.GET)
	public void sendGetTest() throws Exception {
        
        restsampleservice.sendGetTest();
    	
    }

    @RequestMapping(value="/{idx}", method=RequestMethod.GET)
    public void selectIdx(@PathVariable("idx") int idx) {

        int infoDto = 100;
        System.out.println("HJLOG idx : " + idx);
		try {
			infoDto = restsampleservice.selectIdx(idx);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("selectIdx : " + infoDto);
    }
    

   
}