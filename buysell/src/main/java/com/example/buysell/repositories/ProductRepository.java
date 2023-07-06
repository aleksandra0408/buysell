package com.example.buysell.repositories;

import com.example.buysell.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByTitle(String title);

    @Query(value="select * from products u where u.title like %:keyword% ", nativeQuery=true)
    List<Product> findProductByKeyword(@Param("keyword") String keyword);
}
