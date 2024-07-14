package com.rr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rr.model.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
List<Product> findAllByCategory_id(int id);

}