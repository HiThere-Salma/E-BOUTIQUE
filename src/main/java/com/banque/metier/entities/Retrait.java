package com.banque.metier.entities;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("R")
public class Retrait extends Operation {
    public Retrait() {
        super();
    }

    public Retrait(java.util.Date dateOperation, double montant, Compte compte, Employe employe) {
        super(dateOperation, montant, compte, employe);
    }
}
