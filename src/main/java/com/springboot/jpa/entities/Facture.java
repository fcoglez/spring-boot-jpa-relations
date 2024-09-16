package com.springboot.jpa.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "factures")
public class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Long total;

    @ManyToOne
    @JoinColumn(name = "id_cliente_temp") //Si no ponemos esta linea, por defecto se crea una clave foranea llamada client_id
    private Client client;



    public Facture() {
    }

    public Facture(String description, Long total) {
        this.description = description;
        this.total = total;
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

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    @Override
    public String toString() {
        return "{id=" + id +
                ", description='" + description +
                ", total=" + total +
                ", client=" + client +
                '}';
    }
}
