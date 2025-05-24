package com.banque.metier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Client implements Serializable {

    @Id
    private String code;

    private String nom;

    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;

    public Client() {}

    public Client(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Collection<Compte> getComptes() { return comptes; }
    public void setComptes(Collection<Compte> comptes) { this.comptes = comptes; }

    
}
