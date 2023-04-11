package com.edu.ecommercech.EcommerceCH.controllers;

import com.edu.ecommercech.EcommerceCH.entities.InvoiceDetail;
import com.edu.ecommercech.EcommerceCH.exception.InvoiceDetailAlreadyExistException;
import com.edu.ecommercech.EcommerceCH.services.InvoiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Aqui se usa el controller invoice detail, con ruta de api para llamar en postman, post, put, getmapping(id), getmapping(all)

@RestController
@RequestMapping(path = "api/ecommerce/invoiceDetail")
public class InvoiceDetailController {

    @Autowired
    private InvoiceDetailService invoiceDetailService;

    @PostMapping(path = "/")
    public ResponseEntity<InvoiceDetail> create(@RequestBody InvoiceDetail invoiceDetail) throws InvoiceDetailAlreadyExistException {
        return new ResponseEntity<>(this.invoiceDetailService.create(invoiceDetail), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<InvoiceDetail> update(@RequestBody InvoiceDetail invoiceDetail, @PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.invoiceDetailService.update(invoiceDetail,id), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<InvoiceDetail> findById(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(this.invoiceDetailService.findById(id), HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<InvoiceDetail>> findAll(){
        return new ResponseEntity<>(this.invoiceDetailService.findAll(), HttpStatus.OK);
    }
}
