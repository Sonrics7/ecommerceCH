package com.edu.ecommercech.EcommerceCH.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandlerException {

    //Exceptiones de product
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> productNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProductAlreadyExistsException.class)
    public ResponseEntity<?> productAlreadyExistsException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    //Exceptiones de client
    @ExceptionHandler(ClientNotFoundException.class)
    public ResponseEntity<?> clientNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientAlreadyExistException.class)
    public ResponseEntity<?> clientAlreadyExistsException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    //Exceptiones de invoice
    @ExceptionHandler(InvoiceNotFoundException.class)
    public ResponseEntity<?> invoiceNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvoiceAlreadyExistException.class)
    public ResponseEntity<?> invoiceAlreadyExistException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    //Exceptiones de invoiceDetail
    @ExceptionHandler(InvoiceDetailNotFoundException.class)
    public ResponseEntity<?> invoiceDetailNotFoundException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvoiceDetailAlreadyExistException.class)
    public ResponseEntity<?> invoiceDetailAlreadyExistException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    }

    //Excepcion general
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> idNotValidException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
