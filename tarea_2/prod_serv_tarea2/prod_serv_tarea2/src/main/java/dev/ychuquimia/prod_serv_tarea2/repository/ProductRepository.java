package dev.ychuquimia.prod_serv_tarea2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.ychuquimia.prod_serv_tarea2.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByNameContainingIgnoreCase(String name);
}