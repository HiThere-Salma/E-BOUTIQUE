package com.banque.metier.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {

    private double taux;

    public CompteEpargne() {
        super();
    }

    public CompteEpargne(String numero, double solde, java.util.Date dateCreation, Client client, Employe employe, double taux) {
        super(numero, solde, dateCreation, client, employe);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
