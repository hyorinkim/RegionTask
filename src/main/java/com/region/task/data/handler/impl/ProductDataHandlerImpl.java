package com.region.task.data.handler.impl;

import com.region.task.data.dao.ProductDAO;
import com.region.task.data.entity.ProductEntity;
import com.region.task.data.handler.ProductDataHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ProductDataHandlerImpl implements ProductDataHandler {
    ProductDAO productDao;

    @Autowired
    public ProductDataHandlerImpl(ProductDAO productDao){
        this.productDao=productDao;
    }


    @Override
    public ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock) {
        ProductEntity productEntity=new ProductEntity(productId,productName,productPrice,productStock);
        return productDao.saveProduct(productEntity);
    }

    @Override
    public ProductEntity getProductEntity(String productId) {
        return productDao.getProduct(productId);
    }
}
