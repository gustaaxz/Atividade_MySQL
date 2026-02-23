package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SistemaDAO {
    public void salvarCliente(Cliente cliente) throws SQLException {
        String command = """
                INSERT INTO Cliente
                (id, nome, cpf_cnpj, endereco, cidade, estado)
                VALUES
                (?,?,?,?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)) {
            stmt.setInt(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getCpf_cnpj());
            stmt.setString(4, cliente.getEndereco());
            stmt.setString(5, cliente.getCidade());
            stmt.setString(6, cliente.getEstado());
            stmt.executeUpdate();
        }
    }

    public void salvarMotorista(Motorista motorista) throws SQLException {
        String command = """
                INSERT INTO Motorista
                (id, nome, cnh, veiculo, cidade_base)
                VALUES
                (?,?,?,?,?)
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)) {
            stmt.setInt(1, motorista.getId());
            stmt.setString(2, motorista.getNome());
            stmt.setString(3, motorista.getCnh());
            stmt.setString(4, motorista.getVeiculo());
            stmt.setString(5, motorista.getCidadebase());
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

    public void criarPedido (Pedido pedido) throws SQLException {
        String command = """
                INSERT INTO Pedido
                (id, cliente_id, data_pedido, volume_m3, peso_kg, statusPedido)
                VALUES
                (?,?,?,?,?,?)
                """;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setInt(1, pedido.getId());
            stmt.setInt(2, pedido.getCliente_id());

            stmt.setString(3, pedido.getData_pedido());

            stmt.setString(4, pedido.getVolume_m3());
            stmt.setString(5, pedido.getPeso_kg());
            stmt.setString(6, pedido.getStatusPedido());
            stmt.executeUpdate();
        }
    }
}
