package com.banque.controller;

import com.banque.metier.IBanqueMetier;
import com.banque.metier.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BanqueController {

    @Autowired
    private IBanqueMetier metier;

    @GetMapping("/clients")
    public String afficherClients(Model model) {
        List<Client> clients = metier.getClients();
        model.addAttribute("clients", clients);
        return "clients"; // va vers clients.jsp
    }

    @PostMapping("/clients/add")
    public String ajouterClient(@RequestParam String code, @RequestParam String nom) {
        metier.addClient(new Client(code, nom));
        return "redirect:/clients";
    }
    @GetMapping("/comptes")
    public String afficherComptes(Model model) {
        List<Compte> comptes = metier.getComptesByClient("C001"); // test avec un client connu
        model.addAttribute("comptes", comptes);
        return "comptes";
    }

    @PostMapping("/comptes/add")
    public String ajouterCompte(@RequestParam String numero,
                                @RequestParam double solde,
                                @RequestParam String type,
                                @RequestParam String codeClient,
                                @RequestParam String codeEmploye,
                                @RequestParam(required = false) Double taux,
                                @RequestParam(required = false) Double decouvert) {

        Client client = new Client();
        client.setCode(codeClient);
        Employe employe = new Employe();
        employe.setCode(codeEmploye);

        Compte compte;
        if (type.equals("CC")) {
            compte = new CompteCourant(numero, solde, new java.util.Date(), client, employe, decouvert != null ? decouvert : 0);
        } else {
            compte = new CompteEpargne(numero, solde, new java.util.Date(), client, employe, taux != null ? taux : 0);
        }

        metier.addCompte(compte);
        return "redirect:/comptes";
    }
    @GetMapping("/operations")
    public String afficherOperations(Model model) {
        List<Compte> comptes = metier.getComptesByClient("C001"); // exemple test
        model.addAttribute("comptes", comptes);
        return "operations";
    }

    @PostMapping("/operations/add")
    public String effectuerOperation(@RequestParam String type,
                                     @RequestParam String codeCompte,
                                     @RequestParam double montant,
                                     @RequestParam(required = false) String codeCompte2,
                                     @RequestParam String codeEmploye) {

        if (type.equals("versement")) {
            metier.verser(codeCompte, montant, codeEmploye);
        } else if (type.equals("retrait")) {
            metier.retirer(codeCompte, montant, codeEmploye);
        } else if (type.equals("virement")) {
            metier.virement(codeCompte, codeCompte2, montant, codeEmploye);
        }

        return "redirect:/operations";
    }
    @GetMapping("/operations/{code}")
    public String afficherHistorique(@PathVariable String code, Model model) {
        List<Operation> operations = metier.getOperations(code);
        model.addAttribute("operations", operations);
        model.addAttribute("codeCompte", code);
        return "historique";
    }

}
