package com.edu.ecommercech.EcommerceCH.repositories;

import com.edu.ecommercech.EcommerceCH.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Aqui se usa la repository Product, con metodos de JPARepository
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
    Optional<Product> findByCode(String code);
    Optional<Product> findByStock(int stock);
    Optional<Product> findByPrice(double price);
}
