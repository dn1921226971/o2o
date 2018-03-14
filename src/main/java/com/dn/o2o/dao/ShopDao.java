package com.dn.o2o.dao;

import com.dn.o2o.entity.Shop;

public interface ShopDao {

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
