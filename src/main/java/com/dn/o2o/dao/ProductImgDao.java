package com.dn.o2o.dao;

import java.util.List;

import com.dn.o2o.entity.ProductImg;

public interface ProductImgDao {
	/**
	 * 批量插入商品详情图片
	 * 
	 * @param productImgList
	 * @return
	 */
	int batchInsertProductImg(List<ProductImg> productImgList);
}
