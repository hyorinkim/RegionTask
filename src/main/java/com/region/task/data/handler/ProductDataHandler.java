package com.region.task.data.handler;

import com.region.task.data.entity.ProductEntity;

public interface ProductDataHandler {
    public ProductEntity saveProductEntity(String productId,String productName, int productPrice, int productStock);
    public ProductEntity getProductEntity(String productId);
}
