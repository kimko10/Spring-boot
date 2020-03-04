package com.carrotglobal.restsample.service;

import java.util.List;

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

	/**
	 * info 값 조회
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public InfoVO selectIdx(int idx) throws Exception {

		log.info("#### [ RestSampleService.selectIdx ] param idx : " + idx);
		InfoVO info = restSampleMapper.selectIdx(idx);
		return info;
		
	}

	/**
	 * info 전체 조회
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public List<InfoVO> getAll() throws Exception {
		
		log.info("#### [ RestSampleService.getAll ]");
		List<InfoVO> infoList = (List<InfoVO>) restSampleMapper.getAll();
		
		return infoList;
	}
	
	/**
	 * info 값 추가
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public void insertIdx(InfoDTO dto) throws Exception {

		log.info("#### [ RestSampleService.insertIdx ] param dto : " + dto);
		restSampleMapper.insertIdx(dto);

	}

	/**
	 * info 값 수정
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public void updateIdx(InfoDTO dto) throws Exception {
		
		log.info("#### [ RestSampleService.updateIdx ] param dto : " + dto);
		restSampleMapper.updateIdx(dto);
		// transaction test
		//throw new NullPointerException();

	}

	/**
	 * info 값 삭제
	 * @param idx
	 * @return
	 * @throws Exception
	 */
	public void deleteIdx(int idx) throws Exception {
		
		log.info("#### [ RestSampleService.deleteIdx ] param idx : " + idx);
		restSampleMapper.deleteIdx(idx);
		
	}

}