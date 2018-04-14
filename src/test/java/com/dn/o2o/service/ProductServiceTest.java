package com.dn.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dn.o2o.BaseTest;
import com.dn.o2o.dto.ImageHolder;
import com.dn.o2o.dto.ProductExecution;
import com.dn.o2o.entity.Product;
import com.dn.o2o.entity.ProductCategory;
import com.dn.o2o.entity.Shop;
import com.dn.o2o.enums.ProductStateEnum;
import com.dn.o2o.exception.ShopOperationException;

public class ProductServiceTest extends BaseTest {
	@Autowired
	private ProductService productService;

	@Test
	public void testAddProduct() throws ShopOperationException, FileNotFoundException {
		// 创建shopId为3且productCategoryId为2的商品实例并给其成员变量赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(3L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(2L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("测试商品1");
		product.setProductDesc("测试商品1");
		product.setPriority(20);
		product.setCreateTime(new Date());
		product.setEnableStatus(ProductStateEnum.SUCCESS.getState());
		// 创建缩略图文件流
		File thumbnailFile = new File("F:/image/xiaohuangren.jpg");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
		// 创建两个商品详情图文件流并将他们添加到详情图列表中
		File productImg1 = new File("F:/image/xiaohuangren.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("F:/image/dabai.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		ProductExecution pe = productService.addProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}

	@Test
	public void testModifyProduct() throws ShopOperationException, FileNotFoundException {
		// 创建shopId为3且productCategoryId为2的商品实例并给其成员变量赋值
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(3L);
		ProductCategory pc = new ProductCategory();
		pc.setProductCategoryId(2L);
		product.setProductId(6L);
		product.setShop(shop);
		product.setProductCategory(pc);
		product.setProductName("正式的商品");
		product.setProductDesc("正式的商品");
		// 创建缩略图文件流
		File thumbnailFile = new File("F:/image/ercode.jpg");
		InputStream is = new FileInputStream(thumbnailFile);
		ImageHolder thumbnail = new ImageHolder(thumbnailFile.getName(), is);
		// 创建两个商品详情图文件流并将他们添加到详情图列表中
		File productImg1 = new File("F:/image/xiaohuangren.jpg");
		InputStream is1 = new FileInputStream(productImg1);
		File productImg2 = new File("F:/image/dabai.jpg");
		InputStream is2 = new FileInputStream(productImg2);
		List<ImageHolder> productImgList = new ArrayList<ImageHolder>();
		productImgList.add(new ImageHolder(productImg1.getName(), is1));
		productImgList.add(new ImageHolder(productImg2.getName(), is2));
		// 添加商品并验证
		ProductExecution pe = productService.modifyProduct(product, thumbnail, productImgList);
		assertEquals(ProductStateEnum.SUCCESS.getState(), pe.getState());
	}
}
