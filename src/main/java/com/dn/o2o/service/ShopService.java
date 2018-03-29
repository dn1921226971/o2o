package com.dn.o2o.service;

import java.io.InputStream;

import com.dn.o2o.dto.ShopExecution;
import com.dn.o2o.entity.Shop;
import com.dn.o2o.exception.ShopOperationException;

public interface ShopService {
	/**
	 * 通过店铺id获取店铺信息
	 * 
	 * @param shopId
	 * @return
	 */
	Shop getByShopId(long shopId);

	/**
	 * 修改店铺信息,包括图片的处理
	 * 
	 * @param shop
	 * @param shopImgInputStream
	 * @param fileName
	 * @return
	 * @throws ShopOperationException
	 */
	ShopExecution modifyShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;

	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName) throws ShopOperationException;
}
