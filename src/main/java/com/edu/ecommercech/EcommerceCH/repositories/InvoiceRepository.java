package com.edu.ecommercech.EcommerceCH.repositories;

import com.edu.ecommercech.EcommerceCH.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Aqui se usa la repository Invoice, con metodos de JPARepository
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findById(Long id);
}
