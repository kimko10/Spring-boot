package com.carrotglobal.common.service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Transaction ó�� �� ����ó���� �ʿ��� �κ�
 * @author D83
 *
 */
@Transactional(rollbackFor = {Exception.class})
public abstract class AbstractService {

}
