package com.example.productrestapi;

import com.example.productrestapi.Product;
import com.example.productrestapi.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestController {

    @Autowired
    ProductRespository productRespository;

    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public List<Product> getProduct(){
        return productRespository.findAll();
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public Product getProduct(@PathVariable(value = "id") int id){
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
