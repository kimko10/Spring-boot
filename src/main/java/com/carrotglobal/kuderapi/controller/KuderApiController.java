package com.carrotglobal.kuderapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carrotglobal.kuderapi.service.KuderApiService;

@RestController
@RequestMapping("/kuder")
public class KuderApiController {
	

	@Autowired
	private KuderApiService kuderapiservice;
	
	@RequestMapping(value = "/post", method = { RequestMethod.GET, RequestMethod.POST })
    public void getUserAssessmentItemByCategory() throws Exception {
    	
		kuderapiservice.getUserAssessmentItemByCategory();

    }

    @GetMapping(value = "/get")
    public void getAllCultures() throws Exception {

    	kuderapiservice.getAllCultures();

    }
    
    @GetMapping(value = "/get2")
    public void getAllAssessments() throws Exception {

    	kuderapiservice.getAllAssessments();

    }

}
