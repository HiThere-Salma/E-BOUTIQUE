package com.banque.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.banque.metier.entities.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class BanqueDAOImpl implements IBanqueDAO {

    @PersistenceContext
    private EntityManager em;

    // Clients
    public void addClient(Client client) {
        em.persist(client);
    }

    public List<Client> getClients() {
        return em.createQuery("from Client", Client.class).getResultList();
    }

    public List<Client> searchClientsByKeyword(String keyword) {
        return em.createQuery("from Client c where c.nom like :x", Client.class)
                .setParameter("x", "%" + keyword + "%")
                .getResultList();
    }

    // Employés
    public void addEmploye(Employe e) {
        em.persist(e);
    }

    public List<Employe> getEmployes() {
        return em.createQuery("from Employe", Employe.class).getResultList();
    }

    // Groupes
    public void addGroupe(Groupe g) {
        em.persist(g);
    }

    public void addEmployeToGroupe(String codeEmp, String codeGrp) {
        Employe e = em.find(Employe.class, codeEmp);
        Groupe g = em.find(Groupe.class, codeGrp);
        g.getEmployes().add(e);
        e.getGroupes().add(g);
    }

    public List<Groupe> getGroupes() {
        return em.createQuery("from Groupe", Groupe.class).getResultList();
    }

    public List<Employe> getEmployesByGroupe(String codeGrp) {
        Groupe g = em.find(Groupe.class, codeGrp);
        return new ArrayList<>(g.getEmployes());
    }

    // Comptes
    public void addCompte(Compte c) {
        em.persist(c);
    }

    public Compte getCompte(String codeCompte) {
        return em.find(Compte.class, codeCompte);
    }

    public List<Compte> getComptesByClient(String codeClient) {
        return em.createQuery("from Compte c where c.client.code = :x", Compte.class)
                .setParameter("x", codeClient)
                .getResultList();
    }

    public List<Compte> getComptesByEmploye(String codeEmploye) {
        return em.createQuery("from Compte c where c.employe.code = :x", Compte.class)
                .setParameter("x", codeEmploye)
                .getResultList();
    }

    // Opérations
    public void addOperation(Operation op) {
        em.persist(op);
    }

    public List<Operation> getOperations(String codeCompte) {
        return em.createQuery("from Operation o where o.compte.numero = :x", Operation.class)
                .setParameter("x", codeCompte)
                .getResultList();
    }

    public void verser(String codeCompte, double montant, String codeEmploye) {
        Compte c = getCompte(codeCompte);
        Employe e = em.find(Employe.class, codeEmploye);
        Versement v = new Versement(new java.util.Date(), montant, c, e);
        em.persist(v);
        c.setSolde(c.getSolde() + montant);
    }

    public void retirer(String codeCompte, double montant, String codeEmploye) {
        Compte c = getCompte(codeCompte);
        Employe e = em.find(Employe.class, codeEmploye);
        Retrait r = new Retrait(new java.util.Date(), montant, c, e);
        em.persist(r);
        c.setSolde(c.getSolde() - montant);
    }

    public void virement(String cpte1, String cpte2, double montant, String codeEmploye) {
        retirer(cpte1, montant, codeEmploye);
        verser(cpte2, montant, codeEmploye);
    }
}
