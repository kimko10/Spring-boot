package com.carrotglobal.restsample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.carrotglobal.common.SpringTestSupport;
import com.carrotglobal.restsample.dto.InfoDTO;
import com.carrotglobal.restsample.service.RestSampleMapper;

@AutoConfigureMockMvc
public class TransactionTest extends SpringTestSupport {

	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	private RestSampleMapper restsamplemapper;
	
	@Test
	@Transactional
	public void testTransaction() throws Exception {
		InfoDTO dto = new InfoDTO();
		dto.setIdx(3);
		dto.setInfo("JunitTest");
		restsamplemapper.insertIdx(dto);
	}
}
