package com.edu.ecommercech.EcommerceCH.controllers;

import com.edu.ecommercech.EcommerceCH.entities.Invoice;
import com.edu.ecommercech.EcommerceCH.exception.InvoiceAlreadyExistException;
import com.edu.ecommercech.EcommerceCH.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Aqui se usa el controller invoice, con ruta de api para llamar en postman, post, put, getmapping(id), getmapping(all)
@RestController
@RequestMapping(path = "api/ecommerce/invoice")
public class InvoiceController {


    @Autowired
    private InvoiceService invoiceService;

    @PostMapping(path = "/")
    public ResponseEntity<Invoice> create(@RequestBody Invoice invoice) throws InvoiceAlreadyExistException {
        return new ResponseEntity<>(this.invoiceService.create(invoice), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<Invoice> update(@RequestBody Invoice invoice, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.invoiceService.update(invoice,id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Invoice> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.invoiceService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<Invoice>> findAll(){
        return new ResponseEntity<>(this.invoiceService.findAll(), HttpStatus.OK);
    }
}
