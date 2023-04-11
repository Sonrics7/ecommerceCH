package com.edu.ecommercech.EcommerceCH.services;

import com.edu.ecommercech.EcommerceCH.entities.InvoiceDetail;
import com.edu.ecommercech.EcommerceCH.exception.InvoiceDetailAlreadyExistException;
import com.edu.ecommercech.EcommerceCH.exception.InvoiceDetailNotFoundException;
import com.edu.ecommercech.EcommerceCH.exception.InvoiceNotFoundException;
import com.edu.ecommercech.EcommerceCH.repositories.InvoiceDetailRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Aqui se usa el service detalle de factura, con metodos de create, update, findbyId y findAll
@Slf4j
@Service
public class InvoiceDetailService {
    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    public InvoiceDetail create(InvoiceDetail newInvoiceDetail) throws InvoiceDetailAlreadyExistException {
        Optional<InvoiceDetail> invoiceDetailOp = this.invoiceDetailRepository.findById(newInvoiceDetail.getId());

        //Validar variables
        boolean InvoiceDetailAmount = false;
        if(newInvoiceDetail.getAmount() > 0){
            InvoiceDetailAmount = true;
        }else{
            InvoiceDetailAmount = false;
        }

        boolean InvoiceDetailPrice = false;
        if(newInvoiceDetail.getPrice() > 0.0){
            InvoiceDetailPrice = true;
        }else{
            InvoiceDetailPrice = false;
        }


        if (invoiceDetailOp.isPresent()){
            log.info("Java: El detalle de la factura que intenta agregar ya existe en la base de datos : " + newInvoiceDetail);
            throw new InvoiceDetailAlreadyExistException("Postman: El detalle de la factura que intenta agregar ya existe en la base de datos");
        }else if(InvoiceDetailAmount == false){
            log.info("Java: La cantidad de detalle de la factura tiene que ser mayor a 0" + newInvoiceDetail);
            throw new InvoiceDetailAlreadyExistException("Postman: La cantidad de detalle de la factura tiene que ser mayor a 0");
        }else if(InvoiceDetailPrice == false){
            log.info("Java: El precio del detalle de la factura tiene que ser mayor a 0" + newInvoiceDetail);
            throw new InvoiceDetailAlreadyExistException("Postman: El precio del detalle de la factura tiene que ser mayor a 0");
        }else {

            //Calcular el precio
            double actualPrice = newInvoiceDetail.getProduct().getPrice();
            newInvoiceDetail.setPrice(actualPrice * newInvoiceDetail.getAmount());

            log.info("Java: El precio actual de la factura es: " + newInvoiceDetail.getPrice());

            return this.invoiceDetailRepository.save(newInvoiceDetail);
        }
    }

    public InvoiceDetail update(InvoiceDetail newInvoiceDetail, Long id) throws Exception {
        log.info("ID INGRESANDO : " + id);
        if (id <= 0) {
            throw new Exception("El id brindado no es valido");
        }

        Optional<InvoiceDetail> invoiceDetailOp = this.invoiceDetailRepository.findById(id);

        if (invoiceDetailOp.isEmpty()) {
            log.info("El detalle de la factura que intenta modificar no existe en la base de datos : " + newInvoiceDetail);
            throw new InvoiceDetailNotFoundException("El detalle de la factura que intenta modificar no existe en la base de datos");
        } else {
            log.info("El detalle de la factura fue encontrado");

            //Validar variables
            boolean InvoiceDetailAmount = false;
            if (newInvoiceDetail.getAmount() > 0) {
                InvoiceDetailAmount = true;
            } else {
                InvoiceDetailAmount = false;
            }

            boolean InvoiceDetailPrice = false;
            if (newInvoiceDetail.getPrice() > 0.0) {
                InvoiceDetailPrice = true;
            } else {
                InvoiceDetailPrice = false;
            }

            if (InvoiceDetailAmount == false) {
                log.info("Java: La cantidad de detalle de la factura tiene que ser mayor a 0" + newInvoiceDetail);
                throw new InvoiceDetailAlreadyExistException("Postman: La cantidad de detalle de la factura tiene que ser mayor a 0");
            } else if (InvoiceDetailPrice == false) {
                log.info("Java: El precio del detalle de la factura tiene que ser mayor a 0" + newInvoiceDetail);
                throw new InvoiceDetailAlreadyExistException("Postman: El precio del detalle de la factura tiene que ser mayor a 0");
            } else {

                InvoiceDetail invoiceDetailDb = invoiceDetailOp.get();

                invoiceDetailDb.setInvoice(newInvoiceDetail.getInvoice());
                invoiceDetailDb.setProduct(newInvoiceDetail.getProduct());
                invoiceDetailDb.setAmount(newInvoiceDetail.getAmount());
                invoiceDetailDb.setPrice(newInvoiceDetail.getPrice());


                log.info("Java: El detalle de la factura ha sido actualizada : " + invoiceDetailDb);

                //Calcular el precio
                double actualPrice = newInvoiceDetail.getProduct().getPrice();
                newInvoiceDetail.setPrice(actualPrice * newInvoiceDetail.getAmount());

                log.info("Java: El precio actual de la factura es: " + newInvoiceDetail.getPrice());

                return this.invoiceDetailRepository.save(invoiceDetailDb);
            }
        }
    }

    public InvoiceDetail findById(Long id) throws Exception {
        if (id <= 0){
            throw new Exception("El id brindado no es valido.");
        }

        Optional<InvoiceDetail> invoiceDetailOp = this.invoiceDetailRepository.findById(id);

        if (invoiceDetailOp.isEmpty()){
            log.info("El detalle de la factura con el id brindado no existe en la base de datos : " + id);
            throw new InvoiceNotFoundException("El detalle de la factura que intenta solicitar no existe");
        }else {
            return invoiceDetailOp.get();
        }
    }

    public List<InvoiceDetail> findAll(){
        return this.invoiceDetailRepository.findAll();
    }

}
