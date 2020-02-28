package com.carrotglobal.restsample.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carrotglobal.common.service.AbstractService;
import com.carrotglobal.restsample.dto.InfoDTO;
import com.carrotglobal.restsample.mapper.RestSampleMapper;
import com.carrotglobal.restsample.vo.InfoVO;

import lombok.extern.slf4j.Slf4j;

/**
 * restSampleService
 */
@Service
@Slf4j
public class RestSampleService extends AbstractService {

	@Autowired(required=false)
	private RestSampleMapper restSampleMapper;

	private Logger logger = LoggerFactory.getLogger(RestSampleService.class);
	/**
	 * info 테이블에서 값 가져오기
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public InfoVO selectIdx(int idx) throws Exception {

		InfoVO info = restSampleMapper.selectIdx(idx);
		logger.debug("으아아아아아아아아");
		logger.info("으아아아아아아아아ddddddddddddddd");
		log.info("selectIdx : " + info.toString());
		return info;
	}

	/**
	 * info 테이블에서 전체 값 가져오기
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public List<InfoVO> getAll() throws Exception {
		
		List<InfoVO> infoList = (List<InfoVO>) restSampleMapper.getAll();

		
		log.debug("getAll : " + infoList);
		return infoList;
	}
	
	/**
	 * info 테이블에서 값 추가
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public void insertIdx(InfoDTO dto) throws Exception {

		log.info("insertIdxService");
		restSampleMapper.insertIdx(dto);

	}

	/**
	 * info 테이블에서 값 수정
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public void updateIdx(InfoDTO dto) throws Exception {
		log.info("updateIdxService");
		restSampleMapper.updateIdx(dto);
		// 트랜젝션 테스트 용
		//throw new NullPointerException();

	}

	/**
	 * info 테이블에서 값 삭제
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public void deleteIdx(int idx) throws Exception {
		log.info("deleteIdxService");
		restSampleMapper.deleteIdx(idx);
		
	}

   	public void sendPostTest() throws Exception {
		
		URL url = new URL("https://atlas.kuder.com/api/externalapi/GetUserAssessmentItemByCategory"); // 호출할 URL
    	Map<String, Object> params = new LinkedHashMap<>(); // LinkedHashMap은 HashMap과는 key의 순서가 지켜지는 차이가 있음
    	params.put("OrganizationAPIKey", "abe52eca-df09-4cb5-9934-45f37f73887d");
    	params.put("AssessmentCategoryId", 2);
    	params.put("CultureId", 5);
    	params.put("IsAdult", true);
    	
    	StringBuilder postData = new StringBuilder();
    	for(Map.Entry<String, Object> param : params.entrySet()) {
    		if(postData.length() != 0)
    			postData.append('&');
    		
    		postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
    		postData.append('=');
    		postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
    	}
    	
    	byte[] postDataBytes = postData.toString().getBytes("UTF-8");
    	
    	HttpURLConnection conn = (HttpURLConnection)url.openConnection();
    	conn.setRequestMethod("POST");
    	conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    	conn.setRequestProperty("Content-Length",  String.valueOf(postDataBytes.length));
    	conn.setDoOutput(true);
    	conn.getOutputStream().write(postDataBytes); // POST 호출
    	
    	int responseCode = conn.getResponseCode();
    	log.info("URL : " + url.toString());
    	log.info("Parameter : " + postData.toString());
    	log.info("Response Code : " + responseCode);
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    	
    	String inputLine ="";
        while((inputLine = in.readLine()) != null) { // response 출력
            
            log.info("sendGetTest 조회결과 : " + inputLine);
            
    	}
    	
    	
    	in.close();

    }
    
	public void sendGetTest() throws Exception {
    	
		
    	URL url = new URL("https://atlas.kuder.com/api/externalapi/GetAllCultures/abe52eca-df09-4cb5-9934-45f37f73887d");
    	
    	HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    	
    	conn.setRequestProperty("Content-Type", "application/json");
    	conn.setDoOutput(true);
    	conn.setRequestMethod("GET");
    	
    	int responseCode = conn.getResponseCode();
    	log.info("URL : " + url.toString());
    	log.info("Response Code : " + responseCode);
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    	
    	String inputLine;
    	
    	while((inputLine = in.readLine()) != null) {

    		log.info("sendGetTest 조회결과 : " + inputLine);
    		
    	}
    	
    	in.close();
    	
    }
}