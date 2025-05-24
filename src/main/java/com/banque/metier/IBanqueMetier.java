package com.banque.metier;

import com.banque.metier.entities.*;

import java.util.List;

public interface IBanqueMetier {

    void addClient(Client client);
    List<Client> getClients();
    List<Client> searchClientsByKeyword(String keyword);

    void addEmploye(Employe e);
    List<Employe> getEmployes();

    void addGroupe(Groupe g);
    void addEmployeToGroupe(String codeEmp, String codeGrp);
    List<Groupe> getGroupes();
    List<Employe> getEmployesByGroupe(String codeGrp);

    void addCompte(Compte c);
    Compte getCompte(String codeCompte);
    List<Compte> getComptesByClient(String codeClient);
    List<Compte> getComptesByEmploye(String codeEmploye);

    void addOperation(Operation op);
    List<Operation> getOperations(String codeCompte);
    void verser(String codeCompte, double montant, String codeEmploye);
    void retirer(String codeCompte, double montant, String codeEmploye);
    void virement(String cpte1, String cpte2, double montant, String codeEmploye);
}
