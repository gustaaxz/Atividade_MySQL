package org.example;

import java.sql.Connection;
import java.sql.SQLException;

public class SistemaDAO {
    private Connection conn;

    public SistemaDAO() {
        try {
            this.conn = Conexao.conectar();
            System.out.println("Conectado com Sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
        }
    }
}