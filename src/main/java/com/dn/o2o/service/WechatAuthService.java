package com.dn.o2o.service;

import com.dn.o2o.dto.WechatAuthExecution;
import com.dn.o2o.entity.WechatAuth;
import com.dn.o2o.exception.WechatAuthOperationException;

public interface WechatAuthService {
	/**
	 * 通过openId查找平台对应的微信帐号
	 * 
	 * @param openId
	 * @return
	 */
	WechatAuth getWechatAuthByOpenId(String openId);

	/**
	 * 注册本平台的微信帐号
	 * 
	 * @param wechatAuth
	 * @param profileImg
	 * @return
	 * @throws RuntimeException
	 */
	WechatAuthExecution register(WechatAuth wechatAuth) throws WechatAuthOperationException;
}
