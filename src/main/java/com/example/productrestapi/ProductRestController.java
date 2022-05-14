package com.example.productrestapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductRestController.class);
    @Autowired
    ProductRespository productRespository;

    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public List<Product> getProduct(){
        return productRespository.findAll();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(value = "id") int id){
        LOGGER.info("Find product by ID:"+id);
        return productRespository.findById(id).get();
    }

    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product){
        return productRespository.save(product);
    }

    @RequestMapping(value = "/product/", method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product){
        return productRespository.save(product);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public void deleteProduct(@PathVariable("id") int id){
         productRespository.deleteById(id);
    }
}
