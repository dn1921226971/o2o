package com.dn.o2o.service;

import java.io.InputStream;

import com.dn.o2o.dto.ShopExecution;
import com.dn.o2o.entity.Shop;

public interface ShopService {
	ShopExecution addShop(Shop shop, InputStream shopImgInputStream, String fileName);
}
