package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SistemaLE {
    public void salvarCliente(Cliente cliente) throws SQLException {
        String command = """
                INSERT INTO Cliente
                (id, nome, cpf_cnpj, endereco, cidade, estado)
                VALUES
                (?,?,?,?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf_cnpj());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCidade());
            stmt.setString(6, cliente.getEstado());
            stmt.executeUpdate();
        }

    }

    public void excluirCliente(int idExclusao) throws SQLException {
        String command = """
                DELETE FROM cliente WHERE id = ?;
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)){

            stmt.setInt(1, idExclusao);
            stmt.executeUpdate();
        }
    }

}
