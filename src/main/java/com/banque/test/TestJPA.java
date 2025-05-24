package com.banque.test;

import com.banque.metier.IBanqueMetier;
import com.banque.metier.entities.Employe;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJPA {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("WEB-INF/spring/root-context.xml");

        IBanqueMetier metier = context.getBean(IBanqueMetier.class);



        //Créatoin d un employe
        Employe e = new Employe("E001", "Nadia");
        metier.addEmploye(e);

        System.out.println("✅ Client et employe ajouté avec succès !");
    }
}
