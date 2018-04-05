package com.dn.o2o.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.dn.o2o.entity.Shop;

public interface ShopDao {

	/**
	 * 分页查询店铺, 可输入的条件有:店铺名(模糊查询), 店铺状态, 店铺类别, 区域Id, owner
	 * 
	 * @param shopCondition
	 * @param rowIndex
	 *            表示从第几行开始取数据
	 * @param pageSize
	 *            表示要返回多少行数据
	 * @return
	 */
	List<Shop> queryShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
			@Param("pageSize") int pageSize);

	/**
	 * 返回queryShopList总数
	 * 
	 * @param shopCondition
	 * @return
	 */
	int queryShopCount(@Param("shopCondition") Shop shopCondition);

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
