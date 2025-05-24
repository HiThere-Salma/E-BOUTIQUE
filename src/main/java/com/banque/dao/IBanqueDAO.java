package com.banque.dao;

import com.banque.metier.entities.*;

import java.util.List;

public interface IBanqueDAO {

    // Clients
    void addClient(Client client);
    List<Client> getClients();
    List<Client> searchClientsByKeyword(String keyword);

    // Employés
    void addEmploye(Employe e);
    List<Employe> getEmployes();

    // Groupes
    void addGroupe(Groupe g);
    void addEmployeToGroupe(String codeEmp, String codeGrp);
    List<Groupe> getGroupes();
    List<Employe> getEmployesByGroupe(String codeGrp);

    // Comptes
    void addCompte(Compte c);
    Compte getCompte(String codeCompte);
    List<Compte> getComptesByClient(String codeClient);
    List<Compte> getComptesByEmploye(String codeEmploye);

    // Opérations
    void addOperation(Operation op);
    List<Operation> getOperations(String codeCompte);
    void verser(String codeCompte, double montant, String codeEmploye);
    void retirer(String codeCompte, double montant, String codeEmploye);
    void virement(String cpte1, String cpte2, double montant, String codeEmploye);
}
