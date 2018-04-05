package com.dn.o2o.service;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dn.o2o.BaseTest;
import com.dn.o2o.dto.ShopExecution;
import com.dn.o2o.entity.Area;
import com.dn.o2o.entity.PersonInfo;
import com.dn.o2o.entity.Shop;
import com.dn.o2o.entity.ShopCategory;
import com.dn.o2o.enums.ShopStateEnum;
import com.dn.o2o.exception.ShopOperationException;

public class ShopServiceTest extends BaseTest {
	@Autowired
	private ShopService shopService;
	
	@Test
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		ShopCategory sc = new ShopCategory();
		sc.setShopCategoryId(1L);
		shopCondition.setShopCategory(sc);
		ShopExecution se = shopService.getShopList(shopCondition, 3, 2);
		System.out.println("店铺列表数为：" + se.getShopList().size());
		System.out.println("店铺总数为：" + se.getCount());
	}
	@Test
	public void testModifyShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		shop.setShopId(33L);
		shop.setShopName("修改后的店铺名称");
		File shopImg = new File("F:/image/dabai.jpg");
		InputStream is = new FileInputStream(shopImg);
		ShopExecution shopExecution = shopService.modifyShop(shop, is, "dabai.jpg");
		System.out.println("新的图片地址:" + shopExecution.getShop().getShopImg());
	}
	
	@Test
	public void testAddShop() throws ShopOperationException, FileNotFoundException {
		Shop shop = new Shop();
		PersonInfo owner = new PersonInfo();
		Area area = new Area();
		ShopCategory shopCategory = new ShopCategory();
		owner.setUserId(1L);
		area.setAreaId(2);
		shopCategory.setShopCategoryId(1L);
		shop.setOwner(owner);
		shop.setArea(area);
		shop.setShopCategory(shopCategory);
		shop.setShopName("测试的店铺名3");
		shop.setShopDesc("test3");
		shop.setShopAddr("test3");
		shop.setPhone("test3");

		// new Date() 表示当前的时间
		shop.setCreateTime(new Date());
		shop.setEnableStatus(ShopStateEnum.CHECK.getState());
		shop.setAdvice("审核中");
		File shopImg = new File("F:/image/xiaohuangren.jpg");
		InputStream is = new FileInputStream(shopImg);
		ShopExecution se = shopService.addShop(shop, is, shopImg.getName());
		assertEquals(ShopStateEnum.CHECK.getState(), se.getState());
	}

}
