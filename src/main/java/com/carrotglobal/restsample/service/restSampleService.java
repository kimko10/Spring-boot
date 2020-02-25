package com.carrotglobal.restsample.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.carrotglobal.restsample.dto.InfoDTO;
import com.carrotglobal.restsample.vo.InfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * restSampleService
 */
@Service
@Slf4j
public class RestSampleService {

	@Autowired(required=false)
	private RestSampleMapper restSampleMapper;

	public InfoVO selectIdx(int idx) throws Exception {

		InfoVO info = restSampleMapper.selectIdx(idx);
		System.out.println("HJLOG selectIdx : " + info.toString());
		return info;
	}

	public List<InfoVO> getAll() throws Exception {
		
		List<InfoVO> infoList = (List<InfoVO>) restSampleMapper.getAll();

		
		System.out.println("HJLOG getAll : " + infoList);
		return infoList;
	}

	public int insertIdx(String info) throws Exception {

		System.out.println("HJLOG insertIdxService");
		return restSampleMapper.insertIdx(info);

	}

	public int updateIdx(InfoDTO vo) throws Exception {
		System.out.println("HJLOG updateIdxService");
		return restSampleMapper.updateIdx(vo);

	}

	public int deleteIdx(int idx) throws Exception {
		System.out.println("HJLOG deleteIdxService");
		return restSampleMapper.deleteIdx(idx);
		
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
    	System.out.println("URL : " + url.toString());
    	System.out.println("Parameter : " + postData.toString());
    	System.out.println("Response Code : " + responseCode);
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    	
    	String inputLine ="";
        while((inputLine = in.readLine()) != null) { // response 출력
            
            System.out.println("sendGetTest 조회결과 : " + inputLine);
            
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
    	System.out.println("URL : " + url.toString());
    	System.out.println("Response Code : " + responseCode);
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    	
    	String inputLine;
    	
    	while((inputLine = in.readLine()) != null) {

    		System.out.println("sendGetTest 조회결과 : " + inputLine);
    		
    	}
    	
    	in.close();
    	
    }
}