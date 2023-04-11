package com.edu.ecommercech.EcommerceCH.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

//Aqui se usa la entidad Product, metodos getter, setter y toString
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_products")
    private Long id;

    @Column(unique = true, length = 75)
    @NotNull
    @Size(min = 2, max = 75, message = "La descripcion debe tener entre 2 y 75 caracteres")
    private String description;

    @Column(unique = true, length = 50)
    @NotNull
    @Size(min = 2, max = 50, message = "El codigo debe tener entre 2 y 50 caracteres")
    private String code;

    @NotNull
    @Min(0)
    private int stock;

    @NotNull
    @Min(0)
    private double price;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<InvoiceDetail> invoiceDetailList = new ArrayList<>();


    public Product() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                '}';
    }
}
