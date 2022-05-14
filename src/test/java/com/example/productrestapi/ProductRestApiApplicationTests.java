package com.example.productrestapi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;
import static org.junit.Assert.*;

@SpringBootTest
class ProductRestApiApplicationTests {

    @Test
    void contextLoads() {
        RestTemplate restTemplate = new RestTemplate();
        Product product = restTemplate.getForObject("http://localhost:8080/productapi/product/1", Product.class);
        assertNotNull(product);
        assertEquals("Iphone", product.getName());
    }

    @Test
    void PostProduct(){
        RestTemplate restTemplate =  new RestTemplate();
        Product product = new Product();
        product.setName("Samsung Mobile");
        product.setDescription("Worst Mobile ever made");
        product.setPrice(2.0);
        Product newProduct = restTemplate.postForObject("http://localhost:8080/productapi/product/", product, Product.class);
        assertNotNull(newProduct);
        assertEquals("Samsung Mobile", newProduct.getName());
    }

}
