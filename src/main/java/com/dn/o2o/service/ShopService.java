package com.dn.o2o.service;

import java.io.File;

import com.dn.o2o.dto.ShopExecution;
import com.dn.o2o.entity.Shop;

public interface ShopService {
	ShopExecution addShop(Shop shop, File shopImg);
}
