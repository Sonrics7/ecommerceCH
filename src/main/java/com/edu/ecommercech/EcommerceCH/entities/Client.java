package com.edu.ecommercech.EcommerceCH.entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

//Aqui se usa la entidad Client, metodos getter, setter y toString
@Entity
@Table(name = "clients")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idClients")
    private Long id;

    @Column(length = 75)
    @Size(min = 2, max = 75, message = "El nombre debe tener entre 2 y 75 caracteres")
    @NotNull
    private String name;

    @Column(length = 75)
    @Size(min = 2, max = 75, message = "El apellido debe tener entre 2 y 75 caracteres")
    @NotNull
    private String lastname;

    @Column(unique = true, length = 11)
    @NotNull
    @Size(min = 1, max = 11, message = "El docnumber debe tener entre 1 y 11 caracteres")
    private String docnumber;


    public Client() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDocnumber() {
        return docnumber;
    }

    public void setDocnumber(String docnumber) {
        this.docnumber = docnumber;
    }



    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", docnumber='" + docnumber + '\'' +
                '}';
    }
}
