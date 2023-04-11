package com.edu.ecommercech.EcommerceCH.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//Aqui se usa la entidad Invoice, metodos getter, setter y toString
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInvoices")
    private Long id;

    @Column(name = "created_at")
    @NotNull
    //@Temporal(TemporalType.TIMESTAMP)
    private LocalDate createdAt;

    @NotNull
    private Double total;

    //bi-directional many-to-one association to Cliente
    @ManyToOne
    @JoinColumn(name = "client_id")
    @JsonDeserialize
    private Client client;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "invoice", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<InvoiceDetail> invoiceDetailList = new ArrayList<>();

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<InvoiceDetail> getInvoiceDetailList() {
        return invoiceDetailList;
    }

    public void setInvoiceDetailList(List<InvoiceDetail> invoiceDetailList) {
        this.invoiceDetailList = invoiceDetailList;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", total=" + total +
                ", client=" + client +
                ", invoiceDetailList=" + invoiceDetailList +
                '}';
    }
}
