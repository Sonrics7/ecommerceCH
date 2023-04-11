package com.edu.ecommercech.EcommerceCH.controllers;

import com.edu.ecommercech.EcommerceCH.entities.Client;
import com.edu.ecommercech.EcommerceCH.exception.ClientAlreadyExistException;
import com.edu.ecommercech.EcommerceCH.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Aqui se usa el controller Client, con ruta de api para llamar en postman, post, put, getmapping(id), getmapping(all)

@RestController
@RequestMapping(path = "api/ecommerce/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping(path = "/")
    public ResponseEntity<Client> create(@RequestBody Client client) throws ClientAlreadyExistException {
        return new ResponseEntity<>(this.clientService.create(client), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Client> update(@RequestBody Client client, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.clientService.update(client,id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Client> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.clientService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Client>> findAll(){
        return new ResponseEntity<>(this.clientService.findAll(), HttpStatus.OK);
    }
}
