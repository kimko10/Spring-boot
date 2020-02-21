package com.carrotglobal.restsample.controller;

import com.carrotglobal.restsample.service.restSampleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * restSample
 */
@RestController
@RequestMapping("/rest")
public class restSampleController {

    @Autowired
    restSampleService restsampleservice;

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

   
}