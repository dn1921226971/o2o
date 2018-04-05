package com.dn.o2o.dao;

import com.dn.o2o.entity.Product;

public interface ProductDao {
	/**
	 * 插入商品
	 * 
	 * @param product
	 * @return
	 */
	int insertProduct(Product product);
}
