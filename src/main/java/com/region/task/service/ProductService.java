package com.region.task.service;

import com.region.task.data.dto.ProductDTO;

public interface ProductService {

    public ProductDTO getProduct(String productId) ;

    public ProductDTO saveProduct(String productId,String productName, int productPrice, int productStock) ;

//    public ProductDTO saveProduct(ProductDTO productDto);

}
