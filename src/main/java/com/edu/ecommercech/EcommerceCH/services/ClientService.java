package com.edu.ecommercech.EcommerceCH.services;

import com.edu.ecommercech.EcommerceCH.entities.Client;
import com.edu.ecommercech.EcommerceCH.exception.ClientAlreadyExistException;
import com.edu.ecommercech.EcommerceCH.exception.ClientNotFoundException;
import com.edu.ecommercech.EcommerceCH.repositories.ClientRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//Aqui se usa el service Client, con metodos de create, update, findbyId y findAll
@Slf4j
@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client create(Client newClient) throws ClientAlreadyExistException {
        Optional<Client> clientOp = this.clientRepository.findByDocnumber(newClient.getDocnumber());

        //-------------------------------Validaciones de variables
        //Validar que nombre tenga mas de 2 caracteres y menor a 75 y que no este vacio
        boolean clientName = false;
         if(newClient.getName().length() >= 2 && newClient.getName().length() <= 5 && !newClient.getName().isEmpty()){
            clientName = true;
        }else{
            clientName = false;
        }

        //Validar que apellido tenga mas de 2 caracteres y menor a 75 y que no este vacio
        boolean clientLastname = false;
        if(newClient.getLastname().length() >= 2 && newClient.getLastname().length() <= 5 && !newClient.getLastname().isEmpty()){
            clientLastname = true;
        }else{
            clientLastname = false;
        }

        //Validar que docnumber sea mayor a 0 y menos a 11
        boolean clientDocnumber = false;
        if(newClient.getDocnumber().length() > 0  && newClient.getDocnumber().length() <= 11 && !newClient.getDocnumber().isEmpty()){
            clientDocnumber = true;
        }else{
            clientDocnumber = false;
        }




        //-------------------------------Validaciones de para insercion y muestra de errores
        if (clientOp.isPresent()){ // && clientOp2.isEmpty() && clientOp3.isEmpty()){
            log.info("El cliente que intenta agregar ya existe en la base de datos : " + newClient);
            throw new ClientAlreadyExistException("El cliente que intenta agregar ya existe en la base de datos");
        } else if (clientName == false){
            log.info("Java: El nombre cliente tiene menos de 2 valores o mayor de 75 o esta vacio" + newClient);
            throw new ClientAlreadyExistException("Postman : El nombre cliente tiene menos de 2 valores o mayor de 75 o esta vacio");
        }
     else if (clientLastname == false){
        log.info("Java: El apellido cliente tiene menos de 2 valores o mayor de 75 o esta vacio" + newClient);
        throw new ClientAlreadyExistException("Postman : El apellido cliente tiene menos de 2 valores o mayor de 75 o esta vacio");
    }
 else if (clientDocnumber == false){
        log.info("Java: El docnumber del cliente tiene menos de 2 valores o mayor de 75 o esta vacio" + newClient);
        throw new ClientAlreadyExistException("Postman : El docnumber del cliente tiene menos de 2 valores o mayor de 75 o esta vacio");
        }
        else {
            return this.clientRepository.save(newClient);
        }
    }

    public Client update(Client newClient, Long id) throws Exception {
        log.info("ID INGRESANDO : " + id);
        if (id <= 0){
            throw new Exception("El id brindado no es valido");
        }


        Optional<Client> clientOp = this.clientRepository.findById(id);
        //Optional<Client> clientOp2 = this.clientRepository.findByDocnumber(newClient.getDocnumber());


        if (clientOp.isEmpty()){
            log.info("El cliente que intenta modificar no existe en la base de datos : " + newClient);
            throw new ClientNotFoundException("El cliente que intenta modificar no existe en la base de datos");
        }
        else {
            log.info("El cliente fue encontrado");

            //-------------------------------Validaciones de variables
            //Validar que nombre tenga mas de 2 caracteres y menor a 75 y que no este vacio
            boolean clientName = false;
            //log.info(String.valueOf("Primer valor de clientop22 " + clientOp22));
            if(newClient.getName().length() >= 2 && newClient.getName().length() <= 5 && !newClient.getName().isEmpty()){
                clientName = true;
            }else{
                clientName = false;
            }
            //Validar que apellido tenga mas de 2 caracteres y menor a 75 y que no este vacio
            boolean clientLastname = false;

            if(newClient.getLastname().length() >= 2 && newClient.getLastname().length() <= 5 && !newClient.getLastname().isEmpty()){
                clientLastname = true;
            }else{
                clientLastname = false;
            }

            //Validar que docnumber sea mayor a 0 y menos a 11 y no vacio
            boolean clientDocnumber = false;
            if(newClient.getDocnumber().length() > 0  && newClient.getDocnumber().length() <= 11 && !newClient.getDocnumber().isEmpty()){
                clientDocnumber = true;
            }else{
                clientDocnumber = false;
            }


            //Validacion para insertar
            if (clientName == false){
                log.info("Java: El nombre cliente tiene menos de 2 valores o mayor de 75 o esta vacio" + newClient);
                throw new ClientAlreadyExistException("Postman : El nombre cliente tiene menos de 2 valores o mayor de 75 o esta vacio");
            }
            else if (clientLastname == false){
                log.info("Java: El apellido cliente tiene menos de 2 valores o mayor de 75 o esta vacio" + newClient);
                throw new ClientAlreadyExistException("Postman : El apellido cliente tiene menos de 2 valores o mayor de 75 o esta vacio");
            }
            else if (clientDocnumber == false){
                log.info("Java: El docnumber del cliente tiene menos de 1 valor o mayor de 11 o esta vacio" + newClient);
                throw new ClientAlreadyExistException("Postman : El docnumber del cliente tiene menos de 1 valor o mayor de 11 o esta vacio");
            }  else {

                Client clientBd = clientOp.get();

                clientBd.setName(newClient.getName());
                clientBd.setLastname(newClient.getLastname());
                clientBd.setDocnumber(newClient.getDocnumber());

                log.info("Java: Cliente actualizado : " + clientBd);

                return this.clientRepository.save(clientBd);
            }
        }
    }

    public Client findById(Long id) throws Exception {
        if (id <= 0){
            throw new Exception("El id brindado no es valido.");
        }

        Optional<Client> clientOp = this.clientRepository.findById(id);

        if (clientOp.isEmpty()){
            log.info("Java: El cliente con el id brindado no existe en la base de datos : " + id);
            throw new ClientNotFoundException("Postman: El cliente que intenta solicitar no existe");
        }else {
            return clientOp.get();
        }
    }

    public List<Client> findAll(){
        return this.clientRepository.findAll();
    }
}