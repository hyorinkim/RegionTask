//package com.region.task.data.dao.impl;
//
//import com.region.task.data.dao.ProductDAO;
//import com.region.task.data.entity.ProductEntity;
//import com.region.task.data.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class ProductDAOImpl implements ProductDAO {
//    ProductRepository productRepository;
//
//    @Autowired
//    public ProductDAOImpl(ProductRepository productRepository){
//        this.productRepository=productRepository;
//    }
//
//    @Override
//    public ProductEntity saveProduct(ProductEntity productEntity) {
//        productRepository.save(productEntity);
//        return productEntity;
//    }
//
//    @Override
//    public ProductEntity getProduct(String productId) {
//        ProductEntity productEntity=productRepository.getById(productId);
//        return productEntity;
//    }
//}
