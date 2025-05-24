package com.banque.metier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Employe implements Serializable {

    @Id
    private String code;

    private String nom;

    @ManyToOne
    @JoinColumn(name = "CODE_SUP")
    private Employe superieur;

    @OneToMany(mappedBy = "employe")
    private Collection<Compte> comptes;

    @ManyToMany(mappedBy = "employes")
    private Collection<Groupe> groupes;

    public Employe() {}

    public Employe(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    // Getters & Setters
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Employe getSuperieur() { return superieur; }
    public void setSuperieur(Employe superieur) { this.superieur = superieur; }

    public Collection<Compte> getComptes() { return comptes; }
    public void setComptes(Collection<Compte> comptes) { this.comptes = comptes; }

    public Collection<Groupe> getGroupes() { return groupes; }
    public void setGroupes(Collection<Groupe> groupes) { this.groupes = groupes; }
}
