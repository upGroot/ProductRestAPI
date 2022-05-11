package com.example.productrestapi;

import com.example.productrestapi.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRespository extends JpaRepository<Product, Integer> {

}
