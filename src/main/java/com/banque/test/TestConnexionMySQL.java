package com.banque.test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnexionMySQL {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/gestion_banque",
                    "root",
                    "P@ssw0rd__20"
            );
            System.out.println("✅ Connexion réussie à MySQL !");
            conn.close();
        } catch (Exception e) {
            System.err.println("❌ Erreur de connexion : " + e.getMessage());
        }
    }
}
