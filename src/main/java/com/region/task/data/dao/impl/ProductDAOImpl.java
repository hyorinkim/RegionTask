package com.region.task.data.dao.impl;

import com.region.task.data.dao.ProductDAO;
import com.region.task.data.entity.ProductEntity;
import com.region.task.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDAOImpl implements ProductDAO {
    ProductRepository productRepository;

    @Autowired//자동으로 연결시켜준다. 의존성 주입 DI 싱글톤 기반 레퍼지토리가 필요할때마다 객체 생성하는게 아니라 하나의 객체를 여러곳에서 같이 사용한다.

    public ProductDAOImpl(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    @Override
    public ProductEntity saveProduct(ProductEntity productEntity) {
        productRepository.save(productEntity);
        return productEntity;
    }

    @Override
    public ProductEntity getProduct(String productId) {
        System.out.println(productId);
        ProductEntity productEntity=productRepository.getById(productId);
        return productEntity;
    }
}
