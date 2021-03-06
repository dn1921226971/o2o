package com.dn.o2o.service;

import java.util.List;

import com.dn.o2o.dto.ImageHolder;
import com.dn.o2o.dto.ProductExecution;
import com.dn.o2o.entity.Product;
import com.dn.o2o.exception.ProductOperationException;

public interface ProductService {

	ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgList)
			throws ProductOperationException;

	/**
	 * 根据商品Id查询商品的信息
	 * 
	 * @param productId
	 * @return
	 */
	Product getProductById(long productId);

	/**
	 * 修改商品信息以及图片的处理
	 * 
	 * @param product
	 * @param thumbnail
	 * @param productImgHolderList
	 * @return
	 * @throws ProductOperationException
	 */
	ProductExecution modifyProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException;

	/**
	 * 查询商品列表并分页,可输入的条件有:商品名(模糊), 商品状态, 店铺Id, 商品类别
	 * 
	 * @param productCondition
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize);
}
