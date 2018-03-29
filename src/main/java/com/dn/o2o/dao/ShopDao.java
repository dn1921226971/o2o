package com.dn.o2o.dao;

import com.dn.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * 通过shopId查询店铺
	 * 
	 * @param shopId
	 * @return
	 */
	Shop queryByShopId(long shopId);

	/**
	 * 增加店铺
	 * 
	 * @param shop
	 * @return
	 */
	int insertShop(Shop shop);

	/**
	 * 修改店铺
	 * 
	 * @param shop
	 * @return
	 */
	int updateShop(Shop shop);
}
