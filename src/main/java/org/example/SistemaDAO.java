package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public void excluirCliente(String cpf) throws SQLException {
        // 1. Primeiro buscamos o ID do cliente usando o CPF
        String sqlBuscaId = """
               SELECT id FROM Cliente WHERE cpf_cnpj = ?
               """;

        int clienteId = -1;

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmtBusca = conn.prepareStatement(sqlBuscaId)) {

            stmtBusca.setString(1, cpf);
            var rs = stmtBusca.executeQuery();

            if (rs.next()) {
                clienteId = rs.getInt("id");
            }
        }

        // 2. Se o cliente existir (id != -1), apagamos primeiro os pedidos e depois o cliente
        if (clienteId != -1) {
            try (Connection conn = Conexao.conectar()) {
                // Deletar pedidos
                String sqlDelPedidos = "DELETE FROM Pedido WHERE cliente_id = ?";
                try (PreparedStatement stmtPed = conn.prepareStatement(sqlDelPedidos)) {
                    stmtPed.setInt(1, clienteId);
                    stmtPed.executeUpdate();
                }

                // Deletar o cliente
                String sqlDelCliente = "DELETE FROM Cliente WHERE id = ?";
                try (PreparedStatement stmtCli = conn.prepareStatement(sqlDelCliente)) {
                    stmtCli.setInt(1, clienteId);
                    stmtCli.executeUpdate();
                }
            }
        } else {
            throw new SQLException("Cliente não encontrado com o CPF informado.");
        }
    }

    public void criarPedido (Pedido pedido) throws SQLException {
        String command = """
                INSERT INTO Pedido
                (cliente_id, data_pedido, volume_m3, peso_kg, statusPedido)
                VALUES
                (?,?,?,?,?);
                """;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setInt(1, pedido.getCliente_id());
            stmt.setObject(2, pedido.getData_pedido());
            stmt.setDouble(3, Double.parseDouble(pedido.getVolume_m3()));
            stmt.setDouble(4, Double.parseDouble(pedido.getPeso_kg()));
            stmt.setString(5, pedido.getStatusPedido());
            stmt.executeUpdate();
        }
    }

    public void registrarEventoEntrega(HistoricoEntrega historicoEntrega) throws SQLException {
        String command = """
                INSERT INTO HistoricoEntrega
                (id, entrega_id, data_evento, descricao)
                VALUES
                (?,?,?,?);
                """;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setInt(1, historicoEntrega.getId());
            stmt.setInt(2, historicoEntrega.getEntrega_id());
            stmt.setObject(3, historicoEntrega.getData_evento());
            stmt.setString(4, historicoEntrega.getDescricao());
            stmt.executeUpdate();
        }
    }

    public void atribuirPedidoMotorista(AtribuirPedidoMotorista atribuirPedidoMotorista) throws SQLException {
        String command = """
                INSERT INTO Entrega
                (id, pedido_id, motorista_id, data_saida, data_entrega, statusEntrega)
                VALUES
                (?,?,?,?,?,?);
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setInt(1, atribuirPedidoMotorista.getId());
            stmt.setInt(2, atribuirPedidoMotorista.getPedido_id());
            stmt.setInt(3, atribuirPedidoMotorista.getMotorista_id());
            stmt.setObject(4, atribuirPedidoMotorista.getData_saida());
            stmt.setObject(5, atribuirPedidoMotorista.getData_entrega());
            stmt.setString(6, atribuirPedidoMotorista.getStatusEntrega());
            stmt.executeUpdate();
        }
    }

    public void buscarPedidoPorCpf(BuscarPedidoPorDoc buscarPedidoPorDoc) throws SQLException{
        String command = """
                SELECT Pedido.*, Cliente.cpf_cnpj
                FROM Pedido
                INNER JOIN Cliente ON Pedido.cliente_id = Cliente.id
                WHERE Cliente.cpf_cnpj = ?
                """;
        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setString(1, buscarPedidoPorDoc.getCliente_cpfcnpj());

            try(ResultSet rs = stmt.executeQuery()) {
                while(rs.next()){
                    int idPedido = rs.getInt("id");
                    String status = rs.getString("statusPedido");

                    System.out.println("Foi encontrado no CPF selecionado o ID do pedido: \nID: " + idPedido + " | Status: " + status);
                }
            }
        }
    }

    public void excluirEntrega(Entrega entrega) throws SQLException {
        String command = """
                DELETE FROM Pedido WHERE id = ?;
                """;

        try(Connection conn = Conexao.conectar();
            PreparedStatement stmt = conn.prepareStatement(command)){
            stmt.setInt(1, entrega.getId());
            stmt.executeUpdate();
        } catch (SQLException e){
            System.out.println("Erro ao excluir a entrega desejada!");
            e.printStackTrace();
        }
    }




}
