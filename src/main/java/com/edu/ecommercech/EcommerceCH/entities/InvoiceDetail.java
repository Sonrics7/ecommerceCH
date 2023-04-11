package com.edu.ecommercech.EcommerceCH.entities;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import com.sun.istack.NotNull;

import javax.persistence.*;

//Aqui se usa la entidad invoice detail, metodos getter, setter y toString
@Entity
@Table(name = "invoice_details")
public class InvoiceDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private Long id;


    @NotNull
    private int amount;

    @NotNull
    private double price;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonDeserialize
    private Invoice invoice;

    @ManyToOne
    @JoinColumn(name = "product_id")
    @JsonDeserialize
    private Product product;


    public InvoiceDetail() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "InvoiceDetail{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                ", invoice=" + invoice +
                ", product=" + product +
                '}';
    }
}
