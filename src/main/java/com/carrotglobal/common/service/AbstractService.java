package com.carrotglobal.common.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Transaction 처리 및 공통처리가 필요한 부분
 * @author D83
 *
 */
@Transactional(rollbackFor = {Exception.class})
public abstract class AbstractService {

}
