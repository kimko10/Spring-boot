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
		log.info("HJLOG selectIdx : " + info.toString());
		return info;
	}

	public List<InfoVO> getAll() throws Exception {
		
		List<InfoVO> infoList = (List<InfoVO>) restSampleMapper.getAll();

		
		log.info("HJLOG getAll : " + infoList);
		return infoList;
	}

	public int insertIdx(String info) throws Exception {

		log.info("HJLOG insertIdxService");
		return restSampleMapper.insertIdx(info);

	}

	public int updateIdx(InfoDTO vo) throws Exception {
		log.info("HJLOG updateIdxService");
		return restSampleMapper.updateIdx(vo);

	}

	public int deleteIdx(int idx) throws Exception {
		log.info("HJLOG deleteIdxService");
		return restSampleMapper.deleteIdx(idx);
		
	}

   	public void sendPostTest() throws Exception {
		
		URL url = new URL("https://atlas.kuder.com/api/externalapi/GetUserAssessmentItemByCategory"); // ȣ���� URL
    	Map<String, Object> params = new LinkedHashMap<>(); // LinkedHashMap�� HashMap���� key�� ������ �������� ���̰� ����
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
    	conn.getOutputStream().write(postDataBytes); // POST ȣ��
    	
    	int responseCode = conn.getResponseCode();
    	log.info("URL : " + url.toString());
    	log.info("Parameter : " + postData.toString());
    	log.info("Response Code : " + responseCode);
    	
    	BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
    	
    	String inputLine ="";
        while((inputLine = in.readLine()) != null) { // response ���
            
            log.info("sendGetTest ��ȸ��� : " + inputLine);
            
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

    		log.info("sendGetTest ��ȸ��� : " + inputLine);
    		
    	}
    	
    	in.close();
    	
    }
}