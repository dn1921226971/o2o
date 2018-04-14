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

	/**
	 * 根据商品的id删除商品的详情图片
	 * 
	 * @param productId
	 * @return
	 */
	int deleteProductImgByProductId(long productId);

	/**
	 * 根据商品的id查询该商品的详情图片列表
	 * 
	 * @param productId
	 * @return
	 */
	List<ProductImg> queryProductImgList(long productId);
}
