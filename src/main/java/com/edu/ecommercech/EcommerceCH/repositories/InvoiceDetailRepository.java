package com.edu.ecommercech.EcommerceCH.repositories;

import com.edu.ecommercech.EcommerceCH.entities.InvoiceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Aqui se usa la repository Invoice detail, con metodos de JPARepository
@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail, Long> {
}
