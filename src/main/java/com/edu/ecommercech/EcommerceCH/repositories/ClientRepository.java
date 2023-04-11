package com.edu.ecommercech.EcommerceCH.repositories;

import com.edu.ecommercech.EcommerceCH.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//Aqui se usa la repository Client, con metodos de JPARepository
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findByDocnumber(String code);

}
