package com.dn.o2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dn.o2o.BaseTest;
import com.dn.o2o.entity.Area;
import com.dn.o2o.entity.PersonInfo;
import com.dn.o2o.entity.Shop;
import com.dn.o2o.entity.ShopCategory;

public class ShopDaoTest extends BaseTest {

	@Autowired
	private ShopDao shopDao;

	@Test
	public void testQueryShopListAndCount() {
		Shop shopCondition = new Shop();
		ShopCategory childCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(12L);
		childCategory.setParent(parentCategory);
		shopCondition.setShopCategory(childCategory);
		List<Shop> shopList = shopDao.queryShopList(shopCondition, 0, 6);
		int count = shopDao.queryShopCount(shopCondition);
		System.out.println("店铺列表大小 : " + shopList.size());
		System.out.println("店铺总数 : " + count);
	}

	/*
	 * @Test public void testQueryShopListAndCount() { Shop shopCondition = new
	 * Shop(); PersonInfo owner = new PersonInfo(); owner.setUserId(1L);
	 * shopCondition.setOwner(owner); List<Shop> shopList =
	 * shopDao.queryShopList(shopCondition, 0, 3); int count =
	 * shopDao.queryShopCount(shopCondition); System.out.println("店铺列表的大小" +
	 * shopList.size()); System.out.println("店铺总数" + count); ShopCategory sc = new
	 * ShopCategory(); sc.setShopCategoryId(1L); shopCondition.setShopCategory(sc);
	 * shopList = shopDao.queryShopList(shopCondition, 0, 2);
	 * System.out.println("店铺列表的大小" + shopList.size()); count =
	 * shopDao.queryShopCount(shopCondition); System.out.println("店铺总数" + count); }
	 */

	@Test
	public void testQueryByShopId() {
		long shopId = 3;
		Shop shop = shopDao.queryByShopId(shopId);
		System.out.println("areaId" + shop.getArea().getAreaId());
		System.out.println("areaName" + shop.getArea().getAreaName());
	}

	@Test
	public void testInsertShop() {
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
		shop.setShopName("测试的店铺名");
		shop.setShopDesc("test");
		shop.setShopAddr("test");
		shop.setPhone("test");
		shop.setShopImg("test");

		// new Date() 表示当前的时间
		shop.setCreateTime(new Date());

		shop.setEnableStatus(1);
		shop.setAdvice("审核中");
		int enffectedNum = shopDao.insertShop(shop);
		assertEquals(1, enffectedNum);
	}

	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(3L);
		shop.setShopDesc("测试描述");
		shop.setShopAddr("测试地址");
		shop.setLastEditTime(new Date());
		int enffectedNum = shopDao.updateShop(shop);
		assertEquals(1, enffectedNum);
	}

}
