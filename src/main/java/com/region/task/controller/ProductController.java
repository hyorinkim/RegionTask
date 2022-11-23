package com.region.task.controller;

import com.region.task.common.Constants;
import com.region.task.common.exception.RegionTaskException;
import com.region.task.data.dto.ProductDTO;
import com.region.task.service.ProductService;
import com.region.task.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/product-api")
public class ProductController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService){
        this.productService=productService;

    }
    @GetMapping(value="/product/{productId}")
    public ProductDTO getProduct(@PathVariable String productId){

        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController] perform {} of API","getProduct");

        ProductDTO productDto = productService.getProduct(productId);

        LOGGER.info("[ProductController] Response:: productId = {}, productName ={}, productPrice={} ,productStock={} , Response Time ={}ms",productDto.getProductId(),productDto.getProductName()
                ,productDto.getProductPrice(),productDto.getProductStock(),(System.currentTimeMillis()-startTime));
        return productDto;

    }

    @PostMapping(value="/product")
    public ResponseEntity<ProductDTO> createProduct(@Valid @RequestBody ProductDTO productDto){
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDTO response = productService.saveProduct(productId,productName,productPrice,productStock);
        LOGGER.info("[createProduct] Response >> productId:{}, productName:{},productPrice:{},productStock:{}"
        ,response.getProductId(),response.getProductName(),response.getProductPrice(),response.getProductStock()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);

    }

    @DeleteMapping(value="/product/delete")
    public ProductDTO deleteProduct(@PathVariable String productId){
        return null;
    }
    @PostMapping(value="/product/exception")
    public void exceptionTest() throws RegionTaskException{
        throw new RegionTaskException(Constants.ExceptionClass.PRODUCT,HttpStatus.FORBIDDEN,"접근이 금지 되었습니다.");
    }
}
