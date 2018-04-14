package com.dn.o2o.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dn.o2o.dao.ProductDao;
import com.dn.o2o.dao.ProductImgDao;
import com.dn.o2o.dto.ImageHolder;
import com.dn.o2o.dto.ProductExecution;
import com.dn.o2o.entity.Product;
import com.dn.o2o.entity.ProductImg;
import com.dn.o2o.enums.ProductStateEnum;
import com.dn.o2o.exception.ProductOperationException;
import com.dn.o2o.service.ProductService;
import com.dn.o2o.util.ImageUtil;
import com.dn.o2o.util.PageCalculator;
import com.dn.o2o.util.PathUtil;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ProductImgDao productImgDao;

	@Override
	@Transactional
	// 1.处理缩略图,获取缩略图相对路径并赋值给product
	// 2.往tb_product写入商品信息,获取productId
	// 3.结合productId批量处理商品详情图片
	// 4.将商品详情图列表批量插入tb_product_img中
	public ProductExecution addProduct(Product product, ImageHolder thumbnail, List<ImageHolder> productImgHolderList)
			throws ProductOperationException {
		// 空值判断
		if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
			// 给商品设置上默认属性
			product.setCreateTime(new Date());
			product.setLastEditTime(new Date());
			// 默认为上架的状态
			product.setEnableStatus(1);
			// 如果传入的商品缩略图不为空,则添加
			if (thumbnail != null) {
				addThumbnail(product, thumbnail);
			}
			try {
				// 添加商品信息到数据库
				int effectedNum = productDao.insertProduct(product);
				if (effectedNum <= 0) {
					throw new ProductOperationException("创建商品失败");
				}
			} catch (Exception e) {
				throw new ProductOperationException("创建商品失败:" + e.toString());
			}
			// 如果传入的商品详情图不为空,则添加
			if (productImgHolderList != null && productImgHolderList.size() > 0) {
				addProductImgList(product, productImgHolderList);
			}
			return new ProductExecution(ProductStateEnum.SUCCESS, product);
		} else {
			// 传入的参数为空,则返回空值错误信息
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}

	/**
	 * 添加缩略图的方法
	 * 
	 * @param product
	 * @param thumbnail
	 */
	private void addThumbnail(Product product, ImageHolder thumbnail) {
		String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
		String thumbnailAddr = ImageUtil.generateThumbnail(thumbnail, dest);
		product.setImgAddr(thumbnailAddr);
	}

	/**
	 * 批量添加商品详情图片的方法
	 * 
	 * @param product
	 * @param productImgHolderList
	 */
	private void addProductImgList(Product product, List<ImageHolder> productImgHolderList) {
		// 获取图片的存储路径,这里直接放到相应店铺的文件夹下
		String dest = PathUtil.getShopImagePath(product.getShop().getShopId());
		List<ProductImg> productImgList = new ArrayList<ProductImg>();
		// 遍历图片一次去处理,并添加进productImg实体类中
		for (ImageHolder prodcuctImgHolder : productImgHolderList) {
			String imgAddr = ImageUtil.generateNormalImg(prodcuctImgHolder, dest);
			ProductImg productImg = new ProductImg();
			productImg.setImgAddr(imgAddr);
			productImg.setProductId(product.getProductId());
			productImg.setCreateTime(new Date());
			productImgList.add(productImg);
		}
		// 如果productImgList不为空,则批量将productImgList添加到数据库
		if (productImgList.size() > 0) {
			try {
				int effectedNum = productImgDao.batchInsertProductImg(productImgList);
				if (effectedNum <= 0) {
					throw new ProductOperationException("创建商品详情图片失败");
				}
			} catch (Exception e) {
				throw new ProductOperationException("创建商品详情图片失败" + e.toString());
			}
		}
	}

	@Override
	public Product getProductById(long productId) {
		return productDao.queryProductById(productId);
	}

	@Override
	@Transactional
	// 1.如果缩略图参数有值,则处理缩略图
	// 如果原来存在缩略图则先删除再添加新图,之后获取缩略图相对路径并赋值给product
	// 2.如果商品详情图片列表参数有值,则对商品详情图片列表进行同样的操作
	// 3.将tb_product_img下面的该商品原来的商品详情图记录全部清除
	// 4.更新tb_product和tb_product_img的信息
	public ProductExecution modifyProduct(Product product, ImageHolder thumbnail,
			List<ImageHolder> productImgHolderList) throws ProductOperationException {
		// 空值判断
		if (product != null && product.getShop() != null && product.getShop().getShopId() != null) {
			// 给商品设置默认属性
			product.setLastEditTime(new Date());
			// 如果商品缩略图不为空且原有缩略图不为空,则删除原有的缩略图并添加
			if (thumbnail != null) {
				// 先获取一遍原有的信息,因为原有的信息里有原缩略图的地址
				Product tempProduct = productDao.queryProductById(product.getProductId());
				if (tempProduct.getImgAddr() != null) {
					ImageUtil.deleteFileOrPath(tempProduct.getImgAddr());
				}
				addThumbnail(product, thumbnail);
			}
			// 如果有新存入的商品详情图,则将原来的删除,并添加新的图片
			if (productImgHolderList != null && productImgHolderList.size() > 0) {
				deleteProductImgList(product.getProductId());
				addProductImgList(product, productImgHolderList);
			}
			try {
				// 更新商品信息
				int effectedNum = productDao.updateProduct(product);
				if (effectedNum <= 0) {
					throw new ProductOperationException("更新商品信息失败");
				}
				return new ProductExecution(ProductStateEnum.SUCCESS, product);
			} catch (Exception e) {
				throw new ProductOperationException("更新商品信息失败:" + e.toString());
			}
		} else {
			return new ProductExecution(ProductStateEnum.EMPTY);
		}
	}

	private void deleteProductImgList(long productId) {
		// 根据productId获取原来的详情图片的路径
		List<ProductImg> productImgList = productImgDao.queryProductImgList(productId);
		// 删除详情图片
		for (ProductImg productImg : productImgList) {
			ImageUtil.deleteFileOrPath(productImg.getImgAddr());
		}
		// 删除数据库里原来的详情图片信息
		productImgDao.deleteProductImgByProductId(productId);
	}

	@Override
	public ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize) {
		// 页码转换成数据库的行码, 并调用dao层取回指定页码的商品列表
		int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
		List<Product> productList = productDao.queryProductList(productCondition, rowIndex, pageSize);
		// 基于同样的查询条件返回该查询条件下的商品总数
		int count = productDao.queryProductCount(productCondition);
		ProductExecution pe = new ProductExecution();
		pe.setProductList(productList);
		pe.setCount(count);
		return pe;
	}
}
