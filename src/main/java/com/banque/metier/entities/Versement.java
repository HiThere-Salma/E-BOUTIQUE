package com.banque.metier.entities;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("V")
public class Versement extends Operation {
    public Versement() {
        super();
    }

    public Versement(java.util.Date dateOperation, double montant, Compte compte, Employe employe) {
        super(dateOperation, montant, compte, employe);
    }


}
