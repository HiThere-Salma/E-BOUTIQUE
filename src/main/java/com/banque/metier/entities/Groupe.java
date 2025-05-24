package com.banque.metier.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Groupe implements Serializable {

    @Id
    private String code;

    private String nom;

    @ManyToMany
    @JoinTable(name = "EMP_GRP",
            joinColumns = @JoinColumn(name = "CODE_GRP"),
            inverseJoinColumns = @JoinColumn(name = "CODE_EMP"))
    private Collection<Employe> employes;

    public Groupe() {}

    public Groupe(String code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public Collection<Employe> getEmployes() { return employes; }
    public void setEmployes(Collection<Employe> employes) { this.employes = employes; }
}
