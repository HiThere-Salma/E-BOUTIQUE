package com.banque.metier.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {

    private double decouvert;

    public CompteCourant() {
        super();
    }

    public CompteCourant(String numero, double solde, java.util.Date dateCreation, Client client, Employe employe, double decouvert) {
        super(numero, solde, dateCreation, client, employe);
        this.decouvert = decouvert;
    }

    public double getDecouvert() {
        return decouvert;
    }

    public void setDecouvert(double decouvert) {
        this.decouvert = decouvert;
    }
}
