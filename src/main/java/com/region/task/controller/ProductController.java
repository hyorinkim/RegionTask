package com.region.task.controller;

import com.region.task.data.dto.ProductDTO;
import com.region.task.service.ProductService;
import com.region.task.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/product-api")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService){
        this.productService=productService;

    }
    @GetMapping(value="/product/{productId}")
    public ProductDTO getProduct(@PathVariable String productId){
        return productService.getProduct(productId);
    }

    @PostMapping(value="/product")
    public ProductDTO createProduct(@RequestBody ProductDTO productDto){
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId,productName,productPrice,productStock);

    }

    @DeleteMapping(value="/product/delete")
    public ProductDTO deleteProduct(@PathVariable String productId){
        return null;
    }
}
