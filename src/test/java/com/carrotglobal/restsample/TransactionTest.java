package com.carrotglobal.restsample;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import com.carrotglobal.common.SpringTestSupport;
import com.carrotglobal.restsample.service.RestSampleService;

@AutoConfigureMockMvc
public class TransactionTest extends SpringTestSupport {

	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	private RestSampleService restsampleservice;
	
	@Test
	public void selectInfoTest() throws Exception {
		Assertions.assertThat(restsampleservice.selectIdx(1));
	}
}
