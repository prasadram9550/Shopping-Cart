package com.rr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rr.model.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
