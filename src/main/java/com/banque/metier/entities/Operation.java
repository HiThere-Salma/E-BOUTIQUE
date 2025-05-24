package com.banque.metier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_OP", discriminatorType = DiscriminatorType.STRING)
public abstract class Operation implements Serializable {

    @Id
    @GeneratedValue
    private Long numero;

    @Temporal(TemporalType.DATE)
    private Date dateOperation;

    private double montant;

    @ManyToOne
    @JoinColumn(name = "CODE_CPTE")
    private Compte compte;

    @ManyToOne
    @JoinColumn(name = "CODE_EMP")
    private Employe employe;

    public Operation() {}

    public Operation(Date dateOperation, double montant, Compte compte, Employe employe) {
        this.dateOperation = dateOperation;
        this.montant = montant;
        this.compte = compte;
        this.employe = employe;
    }

    // Getters and Setters for Operation
    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Date getDateOperation() {
        return dateOperation;
    }

    public void setDateOperation(Date dateOperation) {
        this.dateOperation = dateOperation;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public String getType() {
        if (this instanceof Versement) return "Versement";
        if (this instanceof Retrait) return "Retrait";
        return "Inconnu";
    }


}
