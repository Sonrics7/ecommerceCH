package com.edu.ecommercech.EcommerceCH.services;

import com.edu.ecommercech.EcommerceCH.entities.Product;
import com.edu.ecommercech.EcommerceCH.exception.ProductAlreadyExistsException;
import com.edu.ecommercech.EcommerceCH.exception.ProductNotFoundException;
import com.edu.ecommercech.EcommerceCH.repositories.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Aqui se usa el service product, con metodos de create, update, findbyId y findAll
@Slf4j
@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    public Product create(Product newProduct) throws ProductAlreadyExistsException {
        Optional<Product> productOp = this.productRepository.findByCode(newProduct.getCode());

        //Validar variables
        boolean productCode = false;
        if(newProduct.getCode().length() > 0  && newProduct.getCode().length() <= 50 && !newProduct.getCode().isEmpty()){
            productCode = true;
        }else{
            productCode = false;
        }

        boolean productDesc = false;
        if(newProduct.getDescription().length() > 0  && newProduct.getDescription().length() <= 75 && !newProduct.getDescription().isEmpty()){
            productDesc = true;
        }else{
            productDesc = false;
        }

        boolean productStock = false;
        if(newProduct.getStock() > 0){
            productStock = true;
        }else{
            productStock = false;
        }

        boolean productPrice = false;
        if(newProduct.getPrice() > 0.0){
            productPrice = true;
        }else{
            productPrice = false;
        }

        if (productOp.isPresent() ){//&& newProduct.getCode().length() > 0 && newProduct.getCode().length() <= 50 && !newProduct.getCode().isEmpty()){
            log.info("Java: El codigo del producto que intenta agregar ya existe en la base de datos o debe ser mayor a 0 y menor a 50 o esta vacio " + newProduct);
            throw new ProductAlreadyExistsException("Postman: El producto que intenta agregar ya existe en la base de datos o debe ser mayor a 0 y menor a 50 o esta vacio");
        }/*else if(productS.getDescription().length() > 2 && productS.getDescription().length() <= 75 && !productS.getDescription().isEmpty()){
            log.info("Java: La descripcion del producto tiene menor de 2 o mas de 75 caracteres o esta vacio" + newProduct);
            throw new ProductAlreadyExistsException("Postman: La descripcion del producto tiene menor de 2 o mas de 75 caracteres o esta vacio");
        }*/
        else if(productCode == false){
            log.info("Java: El codigo del producto tiene menos de 2 valores o mayor de 50 o esta vacio" + newProduct);
            throw new ProductAlreadyExistsException("Postman: El codigo del producto tiene menos de 2 valores o mayor de 50 o esta vacio");
        }else if(productDesc == false){
            log.info("Java: La descripcion del producto tiene menos de 2 valores o mayor de 75 o esta vacio" + newProduct);
            throw new ProductAlreadyExistsException("Postman: La descripcion del producto tiene menos de 2 valores o mayor de 75 o esta vacio");
        }else if(productStock == false){
            log.info("Java: El stock del producto tiene que ser mayor a 0" + newProduct);
            throw new ProductAlreadyExistsException("Postman: El stock del producto tiene que ser mayor a 0");
        }else if(productPrice == false){
            log.info("Java: El precio del producto tiene que ser mayor a 0" + newProduct);
            throw new ProductAlreadyExistsException("Postman: El precio del producto tiene que ser mayor a 0");
        }
        else {
            return this.productRepository.save(newProduct);
        }
    }

    public Product update(Product newProduct, Long id) throws Exception {
        log.info("ID INGRESANDO : " + id);
        if (id <= 0) {
            throw new Exception("El id brindado no es valido");
        }

        Optional<Product> productOp = this.productRepository.findById(id);

        if (productOp.isEmpty()) {
            log.info("El producto que intenta modificar no existe en la base de datos : " + newProduct);
            throw new ProductNotFoundException("El producto que intenta modificar no existe en la base de datos");
        } else {
            log.info("el producto fue encontrado");

            //Validar variables
            boolean productCode = false;
            if (newProduct.getCode().length() > 0 && newProduct.getCode().length() <= 50 && !newProduct.getCode().isEmpty()) {
                productCode = true;
            } else {
                productCode = false;
            }

            boolean productDesc = false;
            if (newProduct.getDescription().length() > 0 && newProduct.getDescription().length() <= 75 && !newProduct.getDescription().isEmpty()) {
                productDesc = true;
            } else {
                productDesc = false;
            }

            boolean productStock = false;
            if (newProduct.getStock() > 0) {
                productStock = true;
            } else {
                productStock = false;
            }

            boolean productPrice = false;
            if (newProduct.getPrice() > 0.0) {
                productPrice = true;
            } else {
                productPrice = false;
            }
            if (productCode == false) {
                log.info("Java: El codigo del producto tiene menos de 2 valores o mayor de 50 o esta vacio" + newProduct);
                throw new ProductAlreadyExistsException("Postman: El codigo del producto tiene menos de 2 valores o mayor de 50 o esta vacio");
            } else if (productDesc == false) {
                log.info("Java: La descripcion del producto tiene menos de 2 valores o mayor de 75 o esta vacio" + newProduct);
                throw new ProductAlreadyExistsException("Postman: La descripcion del producto tiene menos de 2 valores o mayor de 75 o esta vacio");
            } else if (productStock == false) {
                log.info("Java: El stock del producto tiene que ser mayor a 0" + newProduct);
                throw new ProductAlreadyExistsException("Postman: El stock del producto tiene que ser mayor a 0");
            } else if (productPrice == false) {
                log.info("Java: El precio del producto tiene que ser mayor a 0" + newProduct);
                throw new ProductAlreadyExistsException("Postman: El precio del producto tiene que ser mayor a 0");
            } else {

                Product productBd = productOp.get();

                productBd.setCode(newProduct.getCode());
                productBd.setPrice(newProduct.getPrice());
                productBd.setDescription(newProduct.getDescription());
                productBd.setStock(newProduct.getStock());

                log.info("Producto actualizado : " + productBd);

                return this.productRepository.save(productBd);
            }
        }
    }

    public Product findById(Long id) throws Exception {
        if (id <= 0){
            throw new Exception("El id brindado no es valido.");
        }

        Optional<Product> productOp = this.productRepository.findById(id);

        if (productOp.isEmpty()){
            log.info("Java: El producto con el id brindado no existe en la base de datos : " + id);
            throw new ProductNotFoundException("Postman: El producto que intenta solicitar no existe");
        }else {
            return productOp.get();
        }
    }

    public List<Product> findAll(){
        return this.productRepository.findAll();
    }

}