package com.region.task.service.impl;

import com.region.task.controller.ProductController;
import com.region.task.data.dto.ProductDTO;
import com.region.task.data.entity.ProductEntity;
import com.region.task.data.handler.ProductDataHandler;
import com.region.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class ProductServiceImpl implements ProductService {
    ProductDataHandler productDataHandler;

    @Autowired
    public ProductServiceImpl(ProductDataHandler productDataHandler){
        this.productDataHandler=productDataHandler;
    }

    @Override
    public ProductDTO getProduct(String productId) {
        ProductEntity productEntity = productDataHandler.getProductEntity(productId);
        ProductDTO productDto= new ProductDTO(productEntity.getProductId(),productEntity.getProductName(),productEntity.getProductPrice(),productEntity.getProductStock());
        return productDto;
    }

    @Override
    public ProductDTO saveProduct(String productId,String productName, int productPrice, int productStock) {
        ProductEntity productEntity = productDataHandler.saveProductEntity(productId,productName,productPrice,productStock);
        ProductDTO productDto = new ProductDTO(productEntity.getProductId(),productEntity.getProductName(),productEntity.getProductPrice(),productEntity.getProductStock());
        return productDto;
    }

//    @Override
//    public ProductDTO saveProduct(ProductDTO productDto) {
//        return null;
//    }
}
