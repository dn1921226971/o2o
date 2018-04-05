package com.dn.o2o.service;

import java.io.InputStream;
import java.util.List;

import com.dn.o2o.dto.ProductExecution;
import com.dn.o2o.entity.Product;
import com.dn.o2o.exception.ProductOperationException;

public interface ProductService {

	ProductExecution addProduct(Product product, InputStream thumbnail, String thumbnailName,
			List<InputStream> productImgList, List<String> productImgNameList) throws ProductOperationException;
}
