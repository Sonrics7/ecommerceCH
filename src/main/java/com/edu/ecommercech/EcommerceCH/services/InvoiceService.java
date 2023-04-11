package com.edu.ecommercech.EcommerceCH.services;

import com.edu.ecommercech.EcommerceCH.entities.Invoice;
import com.edu.ecommercech.EcommerceCH.exception.InvoiceAlreadyExistException;
import com.edu.ecommercech.EcommerceCH.exception.InvoiceNotFoundException;
import com.edu.ecommercech.EcommerceCH.repositories.InvoiceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Aqui se usa el service factura, con metodos de create, update, findbyId y findAll
@Slf4j
@Service
public class InvoiceService {
    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice create(Invoice newInvoice) throws InvoiceAlreadyExistException {
        Optional<Invoice> invoiceOp = this.invoiceRepository.findById(newInvoice.getId());

        //Validar variables
        boolean invoiceTotal = false;
        if(newInvoice.getTotal() > 0){
            invoiceTotal = true;
        }else{
            invoiceTotal = false;
        }


        if (invoiceOp.isPresent()){
            log.info("Java: La factura que intenta agregar ya existe en la base de datos : " + newInvoice);
            throw new InvoiceAlreadyExistException("Postman: La factura que intenta agregar ya existe en la base de datos");
        } else if(invoiceTotal == false){
            log.info("Java: El total de la factura debe ser mayor a 0" + newInvoice);
            throw new InvoiceAlreadyExistException("Postman: El total de la factura debe ser mayor a 0");
        }
        else {
            return this.invoiceRepository.save(newInvoice);
        }
    }

    public Invoice update(Invoice newInvoice, Long id) throws Exception {
        log.info("ID INGRESANDO : " + id);
        if (id <= 0) {
            throw new Exception("El id brindado no es valido");
        }

        Optional<Invoice> invoiceOp = this.invoiceRepository.findById(id);

        if (invoiceOp.isEmpty()) {
            log.info("Java: La factura que intenta modificar no existe en la base de datos : " + newInvoice);
            throw new InvoiceNotFoundException("Postman: La factura que intenta modificar no existe en la base de datos");
        } else {
            log.info("La factura fue encontrado");

            //Validar variables
            boolean invoiceTotal = false;
            if (newInvoice.getTotal() > 0) {
                invoiceTotal = true;
            } else {
                invoiceTotal = false;
            }

            if(invoiceTotal == false){
                log.info("Java: El total de la factura debe ser mayor a 0" + newInvoice);
                throw new InvoiceAlreadyExistException("Postman: El total de la factura debe ser mayor a 0");
            } else{
                Invoice invoiceDb = invoiceOp.get();

                invoiceDb.setClient(newInvoice.getClient());
                invoiceDb.setCreatedAt(newInvoice.getCreatedAt());
                invoiceDb.setTotal(newInvoice.getTotal());


                log.info("Java: Factura actualizado : " + invoiceDb);

                return this.invoiceRepository.save(invoiceDb);
            }
        }
    }
    public Invoice findById(Long id) throws Exception {
        if (id <= 0){
            throw new Exception("El id brindado no es valido.");
        }

        Optional<Invoice> invoiceOp = this.invoiceRepository.findById(id);

        if (invoiceOp.isEmpty()){
            log.info("Java: La factura con el id brindado no existe en la base de datos : " + id);
            throw new InvoiceNotFoundException("Postman: La factura que intenta solicitar no existe");
        }else {
            return invoiceOp.get();
        }
    }

    public List<Invoice> findAll(){
        return this.invoiceRepository.findAll();
    }

}
