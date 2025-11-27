package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:omintrix.db";
    private static Connection conn;

    public static Connection getConn() {
        if (conn == null) init();
        return conn;
    }

    public static void init() {
        try {
            conn = DriverManager.getConnection(URL);
            try (Statement st = conn.createStatement()) {
                st.execute("""
                    CREATE TABLE IF NOT EXISTS portador (
                      nome TEXT PRIMARY KEY,
                      descricao TEXT,
                      idade INTEGER
                    );
                """);
                st.execute("""
                    CREATE TABLE IF NOT EXISTS alien (
                      nome TEXT PRIMARY KEY,
                      raca TEXT,
                      dna INTEGER
                    );
                """);
                st.execute("""
                    CREATE TABLE IF NOT EXISTS relogio (
                      nome TEXT PRIMARY KEY,
                      cor TEXT,
                      versao INTEGER
                    );
                """);
            }
            System.out.println("Tabelas verificadas/criadas com sucesso.");
        } catch (Exception e) {
            throw new RuntimeException("Erro inic DB: " + e.getMessage(), e);
        }
    }
}