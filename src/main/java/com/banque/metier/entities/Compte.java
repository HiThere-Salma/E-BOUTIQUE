package com.banque.metier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CPTE", discriminatorType = DiscriminatorType.STRING)
public abstract class Compte implements Serializable {

    @Id
    private String numero;

    private double solde;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @ManyToOne
    @JoinColumn(name = "CODE_CLI")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private Employe employe;

    @OneToMany(mappedBy = "compte")
    private Collection<Operation> operations;

    public Compte() {}

    public Compte(String numero, double solde, Date dateCreation, Client client, Employe employe) {
        this.numero = numero;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.client = client;
        this.employe = employe;
    }
    public String getNumero() {
        return numero;
    }
    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    public String getType() {
        if (this instanceof CompteCourant) return "Courant";
        if (this instanceof CompteEpargne) return "Epargne";
        return "Inconnu";
    }
    public java.util.Date getDateCreation() {
        return dateCreation;
    }
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
}
