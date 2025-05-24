package com.banque.metier;

import com.banque.dao.IBanqueDAO;
import com.banque.metier.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BanqueMetierImpl implements IBanqueMetier {

    @Autowired
    private IBanqueDAO dao;

    public void addClient(Client client) {
        dao.addClient(client);
    }

    public List<Client> getClients() {
        return dao.getClients();
    }

    public List<Client> searchClientsByKeyword(String keyword) {
        return dao.searchClientsByKeyword(keyword);
    }

    public void addEmploye(Employe e) {
        dao.addEmploye(e);
    }

    public List<Employe> getEmployes() {
        return dao.getEmployes();
    }

    public void addGroupe(Groupe g) {
        dao.addGroupe(g);
    }

    public void addEmployeToGroupe(String codeEmp, String codeGrp) {
        dao.addEmployeToGroupe(codeEmp, codeGrp);
    }

    public List<Groupe> getGroupes() {
        return dao.getGroupes();
    }

    public List<Employe> getEmployesByGroupe(String codeGrp) {
        return dao.getEmployesByGroupe(codeGrp);
    }

    public void addCompte(Compte c) {
        dao.addCompte(c);
    }

    public Compte getCompte(String codeCompte) {
        return dao.getCompte(codeCompte);
    }

    public List<Compte> getComptesByClient(String codeClient) {
        return dao.getComptesByClient(codeClient);
    }

    public List<Compte> getComptesByEmploye(String codeEmploye) {
        return dao.getComptesByEmploye(codeEmploye);
    }

    public void addOperation(Operation op) {
        dao.addOperation(op);
    }

    public List<Operation> getOperations(String codeCompte) {
        return dao.getOperations(codeCompte);
    }

    public void verser(String codeCompte, double montant, String codeEmploye) {
        dao.verser(codeCompte, montant, codeEmploye);
    }

    public void retirer(String codeCompte, double montant, String codeEmploye) {
        dao.retirer(codeCompte, montant, codeEmploye);
    }

    public void virement(String cpte1, String cpte2, double montant, String codeEmploye) {
        dao.virement(cpte1, cpte2, montant, codeEmploye);
    }
}
